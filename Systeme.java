import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;


public class Systeme extends Observable
{
	private static Case[][] grille;
	private static Personnage[] collection_personnage;
	private static int nb_moussaillon;
	private static int nb_perso;
	private static int suivant; //indique à qui est le tour de jeu
	private IHM ihm;
	
	private static Systeme instance=null;
	private String victoire;//message de victoire
	private Set<Observer> observers = new HashSet<Observer>();
	
	public static Systeme getSystem(){
		if(instance==null){
			instance=new Systeme();
		}
		return instance;
	}
	
	private Systeme(){
		this.initGrille();	
	}
	
	public void notifyObservers(){
		for (Observer o: this.observers){
			o.update(this,this);
		}
	}
	public void registerObserver(Observer obs){
		observers.add(obs);
	}
	
	/**
	 * Cette methode initialise les paramètre du systeme en fonction du nombre de personnage
	 * @param nbperso
	 */
	public static void start(int nbperso){
		nb_moussaillon= nbperso - 2 ;
		nb_perso=nbperso;
		suivant = 2; //le jeu démarre par le tour du premier moussaillon
		
		collection_personnage = new Personnage[nb_perso];
		collection_personnage[0]=new Pirate();
		collection_personnage[1]=new Fantome();
		
		for(int i = 0; i < nb_moussaillon; i++){
			collection_personnage[2+i] = new Moussaillon(nb_moussaillon);
		}
		
		miseEnPlace();
		
		//Annonce que c'est au tour du premier moussaillon de jouer
		
	}
	
	//----------------------------------------------------------------------------------------------------------------------------------------
	//GETTER and SETTER
	//----------------------------------------------------------------------------------------------------------------------------------------
	public static Case[][] getGrille(){
		return grille;
	}
	
	public Personnage[] getCollection_personnage(){
		return collection_personnage;
	}
	
	public Personnage getPersonnageCourant(){
		return collection_personnage[suivant];
	}
	
	public int getNb_moussaillon(){
		return nb_moussaillon;
	}
	
	public IHM getIhm() {
		return ihm;
	}
	
	public String getVictoire() {
		return victoire;
	}

	public void setVicoire(String string) {
		victoire=string;
		notifyObservers();
	}
	
	
	// Initialisation de la grille
	public void initGrille(){
		grille = new Case[12][12];
		for(int i=0;i<12;i++){
			for(int j=0;j<12;j++){
				grille[i][j]=new Chemin(i,j);
			}
		}
		for(int i=2;i<6;i++){
			grille[2][i]= new Jungle(2,i);
			grille[4][i]= new Jungle(4,i);
			grille[5][i]= new Jungle(5,i);
			grille[9][i]= new Jungle(9,i);
		}
		for(int i=0;i<3;i++){
			grille[2][i+7]= new Jungle(2,i+7);
			grille[7][i+2]= new Jungle(7,i+2);
			grille[i+7][8]= new Jungle(i+7,8);
			grille[i+7][9]= new Jungle(i+7,9);
		}
		grille[3][9]= new Jungle(3,9);
		grille[4][7]= new Jungle(4,7);
		grille[5][8]= new Jungle(5,8);
		grille[7][6]= new Jungle(7,6);
		grille[9][7]= new Jungle(9,7);

		grille[4][8]=new Grotte(4,8);
		
		grille[2][4]= new CocotierInter(2,4);
		grille[1][4]= new CocotierExt(1,4,grille[2][4]);
		
		grille[2][9]= new CocotierInter(2,9);
		grille[1][9]= new CocotierExt(1,9,grille[2][9]);
		
		grille[4][3]= new CocotierInter(4,3);
		grille[3][3]= new CocotierExt(3,3,grille[4][3]);

		grille[5][9]= new CocotierInter(5,9);
		grille[5][10]= new CocotierExt(5,10,grille[5][9]);
		
		grille[6][6]= new CocotierInter(6,6);
		grille[6][5]= new CocotierExt(6, 5,grille[6][6]);
		
		grille[8][8]= new CocotierInter(8,8);
		grille[8][7]= new CocotierExt(8, 7,grille[8][8]);
		
		grille[9][9]= new CocotierInter(9,9);
		grille[9][10]= new CocotierExt(9,10,grille[9][9]);

		
		for(int i=0;i<12;i++){
			grille[0][i]=new Mer(0,i);
			grille[11][i]=new Mer(11,i);
			grille[i][0]=new Mer(i,0);
			grille[i][11]=new Mer(i,11);
		}
		
		grille[11][0]= new Barque(11,0);
		grille[10][0]= new Barque(10,0);
		grille[11][1]= new Barque(11,1);
	}
	
	
	//Mise en place des personnages
	public static void miseEnPlace()
	{
		//on efface les traces d'une potentiel partie
		for(int i=0;i<12;i++){
			for(int j=0;j<12;j++){
				grille[i][j].reset();
			}
		}
		
		//Mise en place du pirate  
		grille[4][8].addPersonnage(collection_personnage[0]);
		collection_personnage[0].setPosition(grille[4][8]);
		//Mise en place du fantôme
		grille[10][10].addPersonnage(collection_personnage[1]);
		collection_personnage[1].setPosition(grille[10][10]);
		
		for (int i = 0; i< nb_moussaillon; i++)
		{
			//Ajout des trésorts dans la grotte 
			grille[4][8].addTresor(new Tresor());
			//Ajout des moussaillon dans la barque
			if(i == 0)
			{
				grille[10][0].addPersonnage(collection_personnage[2]);
				collection_personnage[2].setPosition(grille[10][0]);
			}
			if(i == 1)
			{
				grille[11][1].addPersonnage(collection_personnage[3]);
				collection_personnage[3].setPosition(grille[11][1]);
			}
			if(i == 2)
			{
				grille[11][0].addPersonnage(collection_personnage[4]);
				collection_personnage[4].setPosition(grille[11][0]);
			}
		}
	}
	
	
	
	/**
	 * Cette methode est appelee quand un personnage a fini son tour, il permet de donner la main au joueur suivant
	 */
	public void finDeTour()
	{
		if(collection_personnage[suivant].nbDeplacementRestant==0 && collection_personnage[suivant].delance){

			do{
				suivant=((suivant+1)%nb_perso);
			}while(!collection_personnage[suivant].isVivant());		
	
			if(suivant==0){
				ihm.printVue("Menu Pirate");
			}
			if(suivant==1){
				ihm.printVue("Menu Fantome");
			}
			if(suivant==2){
				ihm.printVue("Menu Moussaillon 1");
			}
			if(suivant==3){
				ihm.printVue("Menu Moussaillon 2");
			}
			if(suivant==4){
				ihm.printVue("Menu Moussaillon 3");
			}
			collection_personnage[suivant].aToiDeJouer();
		}
	}
	
	/**
	 * Cette methode est appelee par l'IHM pour déplacer un joueur, on traduit les direction en mouvement relatif
	 * @param direction
	 */
	public void deplacement(String direction)
	{
		//si il rest des déplacement disponible au personnage
		if (getPersonnageCourant().getNbDeplacementRestant() !=0){
			
			// Case indiquant la position du personnage
			Case position = getPersonnageCourant().getPosition();
			int pos_x = position.getX();
			int pos_y = position.getY();
			// Case que l'on localise grace à la direction indiquée 
			Case new_case = position ; 
			if (direction == "haut"){
				new_case = Systeme.getGrille()[pos_x][(pos_y+1)%12];
			}
			if (direction == "bas"){
				new_case = Systeme.getGrille()[pos_x][(pos_y+11)%12];
			}
			if (direction == "gauche"){
				new_case = Systeme.getGrille()[(pos_x+11)%12][pos_y];
			}
			if (direction == "droite"){
				new_case = Systeme.getGrille()[(pos_x+1)%12][pos_y];
			}		
			//vérifier pour pirate et moussailllon que ce déplacement est courant dans le mouvement
			if(new_case.estValide()){
				if(getPersonnageCourant().estValide(new_case)){
					getPersonnageCourant().bouge(new_case);
				}
			}
		}
	}
	
	/**
	 * methode appelee quand un personnage gagne
	 */
	public void gagne(){
		if(collection_personnage[suivant] instanceof Moussaillon){
			victoire="Bravo Moussaillon "+(suivant-1)+", tu a vaincu le Pirate !";
		}else{
			victoire="Bravo Pirate, tu a vaincu tous ces voleurs de moussaillons !";
		}
		System.out.println(victoire);
		notifyObservers();
		ihm.printVue("Menu Principal");
	}

	/**
	 * Cette methode démarre la partie
	 */
	public void debut() {
		ihm.printVue("Menu Moussaillon 1");
		collection_personnage[suivant].aToiDeJouer();
	}

	
	public static void main(String[] args)
	{
		Systeme systeme = Systeme.getSystem();
		Systeme.start(3);
		systeme.ihm=new IHM();
	}
}
	