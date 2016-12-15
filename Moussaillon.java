import java.util.AbstractCollection;
import java.util.HashSet;



public class Moussaillon extends Personnage {
	
	private AbstractCollection<Cocotier> collectionCocotier=new HashSet();
	private AbstractCollection<Perroquet> collectionPerroquet=new HashSet();;
	private static int[][] tab={{5,4,3},{3,2,1}};
	private Case historique;
	private Boolean perroquet;
	private Tresor myTresor;
	
	public Moussaillon(Integer nbMoussaillon){
			
		for(int i=0;i<tab[0][nbMoussaillon-1];i++){
			this.collectionCocotier.add(new Cocotier());
		}
		for(int i=0;i<tab[1][nbMoussaillon-1];i++){
			this.collectionPerroquet.add(new Perroquet());
		}
		path="src/moussaillon.png";	
		
		//Partie de Manu, comment il lance un dé si il en a pas ?
		this.de=new Des3();
	}
	
	
	
	//GETTER & SETTER
	
	public Tresor getMyTresor() {
		return myTresor;
	}
	public AbstractCollection<Cocotier> getCollectionCocotier() {
		return collectionCocotier;
	}
	public AbstractCollection<Perroquet> getCollectionPerroquet() {
		return collectionPerroquet;
	}
	
	
	
	
	public void bouge(Case new_case){
		historique=this.getPosition();
		super.bouge(new_case);
		if(this.getPosition().inventaire.size()!=0){
			System.out.println("Prise du trésor !");
			this.myTresor=this.getPosition().inventaire.iterator().next();
			this.getPosition().inventaire.remove(this.myTresor);
		}
		notifyObservers();
	}
	
	
	public boolean estValide(Case new_case){
		return	!(new_case==historique);
	}
	
	public void lancerDe() {
		if(perroquet){
			setScore(2*this.de.lancerDe());
		}
		else{
			setScore(this.de.lancerDe());
		}
		notifyObservers();
	}
	
	public void aToiDeJouer(){
		super.aToiDeJouer();
		perroquet=false;
		historique=null;		
	}
	
	public void meurs(){
		this.getPosition().removePersonnage(this);
		this.lacherTresor();
		this.vivant=false;
		notifyObservers();
	}
	
	public void cartePerroquet(){
		if(collectionPerroquet.isEmpty()){
			System.out.println("utilisation carte perroquet alors que yan a pu ! #fungenieur");
		}
		else{
			collectionPerroquet.remove(collectionPerroquet.iterator().next());
			perroquet=true;
		}
		notifyObservers();
	}
	
	public void carteCocotier(){
		if(this.getPosition().cocotierInter()){
			if(collectionCocotier.isEmpty()){
				System.out.println("utilisation carte cocotier alors que yan a pu ! #fungenieur");
			}
			else{
				collectionCocotier.remove(collectionCocotier.iterator().next());
				Systeme.getSystem().finDeTour();
			}
		}
		else{
			System.out.println("Invalid push button Cocotier, t'es pas sur une case malfrat !");
		}
		notifyObservers();
	}



	public void entrerCocotier() {
		if(this.getPosition().getClass()==CocotierExt.class){
			Case new_case=((CocotierExt)this.getPosition()).getCoco();
			bouge(new_case);
			System.out.println("COCOTIER !");
			Systeme.getSystem().finDeTour();
		}
		else{
			System.out.println("wrong use of entrer cocotier , t'es pas sur un ext cocotier");
		}
		notifyObservers();
		
	}



	public void poursuit() {
		
		
	}

	public void lacherTresor() {
		if(this.myTresor!=null){
			this.getPosition().getInventaire().add(this.myTresor);
		}
		this.myTresor=null;
		notifyObservers();
	}



	public void bouh() {
		System.out.println("bouh !");
		if(myTresor!=null){
			myTresor.teleportation();
		}
		myTresor=null;		
	}


}
