import java.util.AbstractCollection;
import java.util.HashSet;



public class Moussaillon extends Personnage {
	
	private AbstractCollection<Cocotier> collectionCocotier=new HashSet<Cocotier>();
	private AbstractCollection<Perroquet> collectionPerroquet=new HashSet<Perroquet>();;
	private static int[][] tab={{5,4,3},{3,2,1}};
	private Case historique;
	private Boolean perroquet=false;
	private Tresor myTresor;
	
	public Moussaillon(Integer nbMoussaillon){
			
		for(int i=0;i<tab[0][nbMoussaillon-1];i++){
			this.collectionCocotier.add(new Cocotier());
		}
		for(int i=0;i<tab[1][nbMoussaillon-1];i++){
			this.collectionPerroquet.add(new Perroquet());
		}
		path="src/moussaillon.png";	

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
	
	public boolean getPerroquet() {
		return perroquet;
	}

	
	
	public void bouge(Case new_case){
		historique=this.getPosition();
		super.bouge(new_case);
		if(this.getPosition().inventaire.size()!=0 && myTresor==null){
			this.myTresor=this.getPosition().inventaire.iterator().next();
			this.getPosition().inventaire.remove(this.myTresor);
		}
		if(nbDeplacementRestant==0 && myTresor==null && !(position instanceof CocotierExt)){
			Systeme.getSystem().finDeTour();
		}
		notifyObservers();		
	}
	
	
	public boolean estValide(Case new_case){
		if(getPosition().cocotierInter()){
			return (new_case==((CocotierInter)getPosition()).getExtCoco());
		}else{
			return	!(new_case==historique);
		}
	}
	
	public void lancerDe() {
		if(!delance){
			if(perroquet){
				setScore(2*this.de.lancerDe());
			}
			else{
				setScore(this.de.lancerDe());
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
	
	public void meurs(){
		this.getPosition().removePersonnage(this);
		this.lacherTresor();
		this.vivant=false;
		notifyObservers();
	}
	
	public void cartePerroquet(){
		if(!collectionPerroquet.isEmpty() && !perroquet && !delance){
			collectionPerroquet.remove(collectionPerroquet.iterator().next());
			perroquet=true;
		}
		notifyObservers();
	}
	
	public void carteCocotier(){
		if(this.getPosition().cocotierInter()){
			if(collectionCocotier.isEmpty()){
			}
			else{
				collectionCocotier.remove(collectionCocotier.iterator().next());
				Systeme.getSystem().finDeTour();
			}
		}
		notifyObservers();
	}



	public void entrerCocotier() {
		if(this.getPosition().getClass()==CocotierExt.class){
			Case new_case=((CocotierExt)this.getPosition()).getCoco();
			bouge(new_case);
			Systeme.getSystem().finDeTour();
		}
		notifyObservers();
		
	}

	public void lacherTresor() {
		if(this.myTresor!=null){
			this.getPosition().addTresor(this.myTresor);
		}
		this.myTresor=null;
		notifyObservers();
	}

	public void bouh() {
		if(myTresor!=null){
			myTresor.teleportation();
		}
		myTresor=null;
		notifyObservers();
	}





}
