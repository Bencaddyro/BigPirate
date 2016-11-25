

public class Fantome extends Personnage {
	private Case[][] zone_de_deplacement;
	
	public Fantome()
	{
		de = new Des3();
		path ="src/fantome.png";
		zone_de_deplacement = new Case[7][4];
	}

	//------------------------------------------------------------------------------------------------------------------
	//Initialisation de la zone de déplacement du fantôme
	//------------------------------------------------------------------------------------------------------------------
	//TODO: zoneDeplacement
	public  void zoneDeplacement()
	{
		int score = de.lancerDe();
		this.initZoneDeplacement();
		
		int pos_x = this.zone_de_deplacement[3][0].getX();
		int pos_y = this.zone_de_deplacement[3][0].getY();
		
		this.zone_de_deplacement[2][0] = Systeme.getGrille()[pos_x -1][pos_y];
		this.zone_de_deplacement[4][0] = Systeme.getGrille()[pos_x +1][pos_y];
		this.zone_de_deplacement[3][1] = Systeme.getGrille()[pos_x][pos_y + 1];
		
		if (score >= 2 )
		{
			this.zone_de_deplacement[1][0] = Systeme.getGrille()[pos_x - 2][pos_y];
			this.zone_de_deplacement[5][0] = Systeme.getGrille()[pos_x + 2][pos_y];
			this.zone_de_deplacement[2][1] = Systeme.getGrille()[pos_x - 1][pos_y + 1];
			this.zone_de_deplacement[4][1] = Systeme.getGrille()[pos_x + 1][pos_y + 1];
			this.zone_de_deplacement[3][2] = Systeme.getGrille()[pos_x][pos_y + 2];
		}
		
		if (score == 3)
		{
			this.zone_de_deplacement[0][0] = Systeme.getGrille()[pos_x - 3][pos_y];
			this.zone_de_deplacement[6][0] = Systeme.getGrille()[pos_x + 3][pos_y];
			this.zone_de_deplacement[1][1] = Systeme.getGrille()[pos_x - 2][pos_y + 1];
			this.zone_de_deplacement[5][1] = Systeme.getGrille()[pos_x + 2][pos_y + 1];
			this.zone_de_deplacement[2][2] = Systeme.getGrille()[pos_x - 1][pos_y + 2];
			this.zone_de_deplacement[4][2] = Systeme.getGrille()[pos_x + 1][pos_y + 2];
			this.zone_de_deplacement[3][3] = Systeme.getGrille()[pos_x][pos_y + 3];
		}	
	}
	
	public void initZoneDeplacement()
	{
		//intialisation du tableau à null dans chaque case
		for (int i = 0;i < 7; i++)
		{
			for (int j = 0; i < 4; i++)
			{
				zone_de_deplacement[i][j] = null;
			}
		}	
		// On place le fantôme au centre du tableau
		this.zone_de_deplacement[3][0] = this.getPosition();
	}
	

	
	
	//TODO: poursuitMoussaillon
	
	
	
	//TODO: seDeplace
	
}
