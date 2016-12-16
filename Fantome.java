public class Fantome extends Personnage {
	private Case[][] zone_de_deplacement;
	private int nb_deplacement_fantome;
	private int position_dans_la_zone_x;
	private int position_dans_la_zone_y;

	public Fantome() {
		de = new Des3();
		path = "src/fantome.png";
		zone_de_deplacement = new Case[7][7];
	}

	// ------------------------------------------------------------------------------------------------------------------
	// GET and SET
	// ------------------------------------------------------------------------------------------------------------------
	public Case[][] getZone_de_deplacement() {
		return zone_de_deplacement;
	}

	public void setZone_de_deplacement(Case[][] zone_de_deplacement) {
		this.zone_de_deplacement = zone_de_deplacement;
	}

	public int getNb_deplacement_fantome() {
		return nb_deplacement_fantome;
	}

	public void setNb_deplacement_fantome(int nb_deplacement_fantome) {
		this.nb_deplacement_fantome = nb_deplacement_fantome;
	}

	public int getPosition_dans_la_zone_x() {
		return position_dans_la_zone_x;
	}

	public void setPosition_dans_la_zone_x(int position_dans_la_zone_x) {
		this.position_dans_la_zone_x = position_dans_la_zone_x;
	}

	public int getPosition_dans_la_zone_y() {
		return position_dans_la_zone_y;
	}

	public void setPosition_dans_la_zone_y(int position_dans_la_zone_y) {
		this.position_dans_la_zone_y = position_dans_la_zone_y;
	}

	// ------------------------------------------------------------------------------------------------------------------
	// Mise à jour du nombre de déplacement du fantôme
	// ------------------------------------------------------------------------------------------------------------------
	public void majNbDeplacement(Case futur_case) {
		System.out.println("nbdep : " + this.getNb_deplacement_fantome());
		int pos_x = this.getPosition().getX();
		System.out.println("posx : " + pos_x);
		int pos_y = this.getPosition().getY();
		System.out.println("posy : " + pos_y);
		int futur_pos_x = futur_case.getX();
		System.out.println("newposx : " + futur_pos_x);
		int futur_pos_y = futur_case.getY();
		System.out.println("newposy : " + futur_pos_y);
		int new_deplacement = this.getNb_deplacement_fantome()
				- (Math.abs(futur_pos_x - pos_x) + Math
						.abs(futur_pos_y - pos_y));
		System.out.println("majNbDeplacement nbdep : " + new_deplacement);
		this.setNb_deplacement_fantome(new_deplacement);
	}

	// ------------------------------------------------------------------------------------------------------------------
	// Tour de jeu du fantôme
	// ------------------------------------------------------------------------------------------------------------------
	public void aToiDeJouer() {
		System.out.println("Tour du fantôme");
		// création de la zone déplacement du fantôme + lancé de dé
		this.zoneDeplacement();
		System.out.println("zone de déplacement intitilisé");
			
		// recherche du moussaillon dans la zone de déplacement par le fantôme + déplacement
		Moussaillon moussaillon_victime = this.rechercheMoussaillon();
		this.poursuit(moussaillon_victime);

		System.out.println("nb déplacement restant après recherche du moussaillon : "+this.getNb_deplacement_fantome());
		System.out.println("recherche et déplacement fait");
		// S'il lui reste un deplacement possible il l'effectue
		if (this.getNb_deplacement_fantome() > 0) 
			{
			this.seDeplaceAleatoirement();
			System.out.println("nb déplacement restant : "+this.getNb_deplacement_fantome());
			System.out.println("déplacement fait");
			}
		System.out.println("nb déplacement restant : "+this.getNb_deplacement_fantome());
		Systeme.getSystem().finDeTour();
	}

	// ------------------------------------------------------------------------------------------------------------------
	// Zone de déplacement du fantôme
	// ------------------------------------------------------------------------------------------------------------------
	// TODO: zoneDeplacement
	public void zoneDeplacement() {
		this.setNb_deplacement_fantome(de.lancerDe());
		this.initZoneDeplacement();

		// Coordonnée du fantôme sur la carte
		int pos_x_fantome = this.getPosition().getX();
		int pos_y_fantome = this.getPosition().getY();

		this.deplacementScore1(this.getPosition_dans_la_zone_x(),
				this.getPosition_dans_la_zone_y(), pos_x_fantome, pos_y_fantome);

		if (getNb_deplacement_fantome() >= 2) {
			this.deplacementScore2(this.getPosition_dans_la_zone_x(),
					this.getPosition_dans_la_zone_y(), pos_x_fantome,
					pos_y_fantome);
		}

		if (getNb_deplacement_fantome() == 3) {
			this.deplacementScore3(this.getPosition_dans_la_zone_x(),
					this.getPosition_dans_la_zone_y(), pos_x_fantome,
					pos_y_fantome);
		}
		
	}

	// ------------------------------------------------------------------------------------------------------------------
	// Initialisation de la zone de déplacement du fantôme
	// ------------------------------------------------------------------------------------------------------------------
	public void initZoneDeplacement() {
		// intialisation du tableau à null dans chaque case
		for (int i = 0; i < 7; i++) {
			for (int j = 0; i < 7; i++) {
				zone_de_deplacement[i][j] = null;
			}
		}
		// On place le fantôme au centre du tableau
		this.zone_de_deplacement[3][3] = this.getPosition();
		this.setPosition_dans_la_zone_x(3);
		this.setPosition_dans_la_zone_y(3);
	}

	// ------------------------------------------------------------------------------------------------------------------
	// Mise à jour de la zone de déplacement du fantôme dans le cas ou aucun mousssaillon n'a été trouvé
	// ------------------------------------------------------------------------------------------------------------------
	public void majZoneDeDeplacement() {
		int n = this.getNb_deplacement_fantome();
		this.initZoneDeplacement();
					
		// Coordonnée du fantôme sur la carte
		int pos_x_fantome = this.getPosition().getX();
		int pos_y_fantome = this.getPosition().getY();
		int x = this.getPosition_dans_la_zone_x();
		int y = this.getPosition_dans_la_zone_y();	
		
		if (n == 1) this.deplacementScore1(x, y, pos_x_fantome, pos_y_fantome);
		if (n == 2) this.deplacementScore2(x, y, pos_x_fantome, pos_y_fantome);
		if (n == 3) this.deplacementScore3(x, y, pos_x_fantome, pos_y_fantome);
		
		System.out.println("nb déplacement restant : "+this.getNb_deplacement_fantome());
		System.out.println("Ap nouvelle maj zonne de depl");
		for (int i = 0; i < 7; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				if(this.zone_de_deplacement[i][j] != null) System.out.println("["+i+"]["+j+"]");
			}
		}
	}

	
	// ------------------------------------------------------------------------------------------------------------------
	// Déplacements possible du fantôme en fonction du score du dé
	// ------------------------------------------------------------------------------------------------------------------
	// Déplacement pour un score de dé de 1
	public void deplacementScore1(int x, int y, int pos_x, int pos_y) {
		if (pos_x - 1 >= 0)
			this.zone_de_deplacement[x - 1][y] = Systeme.getSystem()
					.getGrille()[pos_x - 1][pos_y];
		if (pos_x + 1 <= 11)
			this.zone_de_deplacement[x + 1][y] = Systeme.getSystem()
					.getGrille()[pos_x + 1][pos_y];
		if (pos_y + 1 <= 11)
			this.zone_de_deplacement[x][y + 1] = Systeme.getSystem()
					.getGrille()[pos_x][pos_y + 1];
		if (pos_y - 1 >= 0)
			this.zone_de_deplacement[x][y - 1] = Systeme.getSystem()
					.getGrille()[pos_x][pos_y - 1];
	}

	// Déplacement pour un score de dé de 2 (doit être ajouté au déplacement
	// pour un score de dé de 1)
	public void deplacementScore2(int x, int y, int pos_x, int pos_y) {
		if (pos_x - 2 >= 0)	this.zone_de_deplacement[x - 2][y] = Systeme.getSystem().getGrille()[pos_x - 2][pos_y];
		if (pos_x + 2 <= 11) this.zone_de_deplacement[x + 2][y] = Systeme.getSystem().getGrille()[pos_x + 2][pos_y];

		if (pos_x - 1 >= 0) {
			if (pos_y + 1 <= 11)
				this.zone_de_deplacement[x - 1][y + 1] = Systeme.getSystem()
						.getGrille()[pos_x - 1][pos_y + 1];
			if (pos_y - 1 >= 0)
				this.zone_de_deplacement[x - 1][y - 1] = Systeme.getSystem()
						.getGrille()[pos_x - 1][pos_y - 1];
		}

		if (pos_x + 1 <= 11) {
			if (pos_y + 1 <= 11)
				this.zone_de_deplacement[x + 1][y + 1] = Systeme.getSystem()
						.getGrille()[pos_x + 1][pos_y + 1];
			if (pos_y - 1 >= 0)
				this.zone_de_deplacement[x + 1][y - 1] = Systeme.getSystem()
						.getGrille()[pos_x + 1][pos_y - 1];
		}

		if (pos_y - 2 >= 0)
			this.zone_de_deplacement[x][y - 2] = Systeme.getSystem()
					.getGrille()[pos_x][pos_y - 2];
		if (pos_y + 2 <= 11)
			this.zone_de_deplacement[x][y + 2] = Systeme.getSystem()
					.getGrille()[pos_x][pos_y + 2];
	}

	// Déplacement pour un score de dé de 3 (doit être ajouté au déplacement
	// pour un score de dé de 1 et de 2)
	public void deplacementScore3(int x, int y, int pos_x, int pos_y) {
		if (pos_x - 3 >= 0)
			this.zone_de_deplacement[x - 3][y] = Systeme.getSystem()
					.getGrille()[pos_x - 3][pos_y];
		if (pos_x + 3 <= 11)
			this.zone_de_deplacement[x + 3][y] = Systeme.getSystem()
					.getGrille()[pos_x + 3][pos_y];

		if (pos_x - 2 >= 0) {
			if (pos_y + 1 <= 11)
				this.zone_de_deplacement[x - 2][y + 1] = Systeme.getSystem()
						.getGrille()[pos_x - 2][pos_y + 1];
			if (pos_y - 1 >= 0)
				this.zone_de_deplacement[x - 2][y - 1] = Systeme.getSystem()
						.getGrille()[pos_x - 2][pos_y - 1];
		}

		if (pos_x + 2 <= 11) {
			if (pos_y + 1 <= 11)
				this.zone_de_deplacement[x + 2][y + 1] = Systeme.getSystem()
						.getGrille()[pos_x + 2][pos_y + 1];
			if (pos_y - 1 >= 0)
				this.zone_de_deplacement[x + 2][y - 1] = Systeme.getSystem()
						.getGrille()[pos_x + 2][pos_y - 1];
		}

		if (pos_x - 1 >= 0) {
			if (pos_y + 2 <= 11)
				this.zone_de_deplacement[x - 1][y + 2] = Systeme.getSystem()
						.getGrille()[pos_x - 1][pos_y + 2];
			if (pos_y - 2 >= 0)
				this.zone_de_deplacement[x - 1][y - 2] = Systeme.getSystem()
						.getGrille()[pos_x - 1][pos_y - 2];
		}

		if (pos_x + 1 <= 11) {
			if (pos_y + 2 <= 11)
				this.zone_de_deplacement[x + 1][y + 2] = Systeme.getSystem()
						.getGrille()[pos_x + 1][pos_y + 2];
			if (pos_y - 2 >= 0)
				this.zone_de_deplacement[x + 1][y - 2] = Systeme.getSystem()
						.getGrille()[pos_x + 1][pos_y - 2];
		}

		if (pos_y + 3 <= 11)
			this.zone_de_deplacement[x][y + 3] = Systeme.getSystem()
					.getGrille()[pos_x][pos_y + 3];
		if (pos_y - 3 >= 0)
			this.zone_de_deplacement[x][y - 3] = Systeme.getSystem()
					.getGrille()[pos_x][pos_y - 3];
	}

	// ------------------------------------------------------------------------------------------------------------------
	// Recherche d'un moussaillon dans la zone de déplacement
	// ------------------------------------------------------------------------------------------------------------------
	public Moussaillon rechercheMoussaillon() {
		// Parcourt de la zone de déplacement du fantôme
		Moussaillon moussaillon_victime = null;
		
		// Recherche de moussaillon
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				
				// On ne s'interresse que au cases "pleines" du tableau et celles ou n'est pas le fantôme
				if ((this.zone_de_deplacement[i][j] != null)
						&& (this.zone_de_deplacement[i][j] != this.getPosition())){
					moussaillon_victime = this.zone_de_deplacement[i][j].moussaillonPresent();
					// Si un moussaillon est présent sur la case il le retourne
					if (moussaillon_victime != null) {
						System.out.println("Moussaillon trouvé");
						return moussaillon_victime;
					}
				}
			}
		}
		return null;
		
	}
	
	// ------------------------------------------------------------------------------------------------------------------
	// Poursuite du moussailloon par le fantôme
	// ------------------------------------------------------------------------------------------------------------------
	private void poursuit(Moussaillon moussaillon) {
		if(moussaillon != null)
		{
			this.majNbDeplacement(moussaillon.getPosition());
			this.bouge(moussaillon.getPosition());
			// on ne permet pas au fantôme de revenir sur ses pas
			this.zone_de_deplacement[this.getPosition_dans_la_zone_x()]
					[this.getPosition_dans_la_zone_y()] = null;
			moussaillon.bouh();
		}
		System.out.println("poursuit nb depl : " +this.getNb_deplacement_fantome());
		if(this.getNb_deplacement_fantome() > 0) this.majZoneDeDeplacement();
	}
	

	// ------------------------------------------------------------------------------------------------------------------
	// Déplacement aléatoire du fantôme
	// ------------------------------------------------------------------------------------------------------------------
	private void seDeplaceAleatoirement() {
		int pos_x = this.getPosition_dans_la_zone_x();
		int pos_y = this.getPosition_dans_la_zone_y();

		// Génération d'une position aléatoire dans la zone de déplacement
		// autorisé
		int random_x;
		int random_y;
		boolean meme_position;
		//boolean deplacement1case;
		//do {
			do {
				random_x = (int) (Math.random() * 4) - 1;
				random_y = (int) (Math.random() * 4) - 1;
				meme_position = (this.zone_de_deplacement[pos_x + random_x][pos_y + random_y] 
						== this.getPosition());
				// On vériffie que le fantôme ne se déplace que de une case
				//deplacement1case = ((random_x == 1 && random_y == 1)
					//	|| (random_x == -1 && random_y == -1)
					//	|| (random_x == 1 && random_y == -1) || (random_x == -1 && random_y == 1));
			} while ((this.zone_de_deplacement[pos_x + random_x][pos_y
					+ random_y] == null)
					|| (meme_position)); //|| (deplacement1case));

			// Mise à jour du nombre déplacement restant
			this.majNbDeplacement(this.zone_de_deplacement[pos_x + random_x][pos_y
					+ random_y]);
			// Déplacement d'une case
			this.bouge(this.zone_de_deplacement[pos_x + random_x][pos_y
					+ random_y]);
			// On ne permet pas au fantôme de revenir sur ses pas
			this.zone_de_deplacement[pos_x][pos_y] = null;
			this.setPosition_dans_la_zone_x(pos_x + random_x);
			this.setPosition_dans_la_zone_y(pos_y + random_y);
		//} while (this.getNb_deplacement_fantome() > 0);
	}

}
