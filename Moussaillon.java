import java.util.AbstractCollection;
import java.util.HashSet;


public class Moussaillon extends Personnage {
	
	private AbstractCollection<Cocotier> collectionCocotier=new HashSet<Cocotier>();
	private AbstractCollection<Perroquet> collectionPerroquet=new HashSet<Perroquet>();;
	private static int[][] tab={{5,4,3},{3,2,1}};
	private Case historique;
	private Boolean perroquet=false;
	private Tresor myTresor;
	
	/**
	 * Le constructeur prend en paramètre le nombre final de moussaillons pour donner le nombre correct d'atouts
	 * @param nbMoussaillon
	 */
	public Moussaillon(Integer nbMoussaillon){
		for(int i=0;i<tab[0][nbMoussaillon-1];i++){
			this.collectionCocotier.add(new Cocotier());
		}
		for(int i=0;i<tab[1][nbMoussaillon-1];i++){
			this.collectionPerroquet.add(new Perroquet());
		}
		path="img/moussaillon.png";
		de=new De3();
	}
	
	//----------------------------------------------------------------------------------------------------------------------------------------
	//GETTER and SETTER
	//----------------------------------------------------------------------------------------------------------------------------------------	
	public Tresor getMyTresor() {
		return myTresor;
	}
	public AbstractCollection<Cocotier> getCollectionCocotier() {
		return collectionCocotier;
	}
	public AbstractCollection<Perroquet> getCollectionPerroquet() {
		return collectionPerroquet;
	}
	public boolean getPerroquet() {
		return perroquet;
	}

	/**
	 * Surcharge de la methode bouge permettant au moussaillon de ramasser les trésor et de gagner s'il atteint la barque
	 * @param new_case 
	 */
	public void bouge(Case new_case){
		historique=this.getPosition();
		super.bouge(new_case);
		if(this.getPosition().inventaire.size()!=0 && myTresor==null){
			this.myTresor=this.getPosition().inventaire.iterator().next();
			this.getPosition().inventaire.remove(this.myTresor);
		}
		if(myTresor!=null && getPosition() instanceof Barque){
			Systeme.getSystem().gagne();
		}		
		if(nbDeplacementRestant==0 && myTresor==null && !(position instanceof CocotierExt)){
			Systeme.getSystem().finDeTour();
		}
		notifyObservers();		
	}

	/**
	  * Cette methode test si la case passée en paramètre est valide au vu des derniers déplacements
	  * @param new_case
	  */
	public boolean estValide(Case new_case){
		if(getPosition().cocotierInter()){
			return (new_case==((CocotierInter)getPosition()).getExtCoco());
		}else{
			return	!(new_case==historique);
		}
	}

	/**
	  * On redefini la méthode lancerDe() pour pouvoir inclure les effet d'une éventuelle carte perroquet
	  */
	public void lancerDe() {
		if(!delance){
			if(perroquet){
				score=2*this.de.lancerDe();
			}
			else{
				score=this.de.lancerDe();
			}
			nbDeplacementRestant=score;
			delance=true;
			notifyObservers();
		}
	}

	public void aToiDeJouer(){
		super.aToiDeJouer();
		perroquet=false;
		historique=null;
		notifyObservers();
	}


	/**
	 * Cette methode déclenché par le pirate met fin à la vie du moussaillon 
	 */
	public void meurs(){
		this.getPosition().removePersonnage(this);
		this.lacherTresor();
		this.vivant=false;
		notifyObservers();
	}
	
	/**
	  * Cette methode est appellé lors de l'usage d'une carte perroquet
	  */
	public void cartePerroquet(){
		//on verifie que le personnge n'as pas déja lancé le dés
		if(!collectionPerroquet.isEmpty() && !perroquet && !delance){
			collectionPerroquet.remove(collectionPerroquet.iterator().next());
			perroquet=true;
		}
		notifyObservers();
	}
	
	/**
	  * Cette methode est appellé lors de l'usage d'une carte cocotier
	  */
	public void carteCocotier(){
		//on verifie que le personnage n'a pas commencer a bouger (lancer le dés, utiliser une carte perroquet etc..;
		if(!delance 
				&& !perroquet 
				&& this.getPosition().cocotierInter() 
				&& !collectionCocotier.isEmpty()){
					collectionCocotier.remove(collectionCocotier.iterator().next());
					delance=true;
					nbDeplacementRestant=0;
					Systeme.getSystem().finDeTour();
					notifyObservers();			
		}
	}

	/**
	  * Cette methode fait rentrer le moussaillon dans le cocotier
	  */
	public void entrerCocotier() {
		if(this.getPosition().getClass()==CocotierExt.class){
			Case new_case=((CocotierExt)this.getPosition()).getCoco();
			bouge(new_case);
			nbDeplacementRestant=0;
			Systeme.getSystem().finDeTour();
		}
		notifyObservers();
		
	}

	/**
	  * Cette methode fait lacher le trésor au moussaillon
	  */
	public void lacherTresor() {
		if(!(getPosition() instanceof CocotierInter)){
			if(this.myTresor!=null){
				this.getPosition().addTresor(this.myTresor);
			}
			this.myTresor=null;
			notifyObservers();
		}
	}

	/**
	  * Cette methode indique au moussaillon qu'il s'est fait touché par le fantome
	  */
	public void bouh() {
		if(myTresor!=null){
			myTresor.teleportation();
		}
		myTresor=null;
		notifyObservers();
	}
}
