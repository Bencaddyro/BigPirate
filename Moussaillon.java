import java.util.AbstractCollection;
import java.util.HashSet;



public class Moussaillon extends Personnage {
	
	private AbstractCollection<Cocotier> collectionCocotier=new HashSet();
	private AbstractCollection<Perroquet> collectionPerroquet=new HashSet();;
	private static int[][] tab={{5,4,3},{3,2,1}};
	private Case historique;
	private Boolean perroquet;
	
	public Moussaillon(Integer nbMoussaillon){
			
		for(int i=0;i<tab[0][nbMoussaillon-1];i++){
			this.collectionCocotier.add(new Cocotier());
		}
		for(int i=0;i<tab[1][nbMoussaillon-1];i++){
			this.collectionPerroquet.add(new Perroquet());
		}
		path="src/moussaillon.png";
	}
	
	public void bouge(Case new_case){
		historique=this.getPosition();
		super.bouge(new_case);
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
		
	}
	
	public void aToiDeJouer(){
		perroquet=false;
		historique=null;		
	}
	
	public void cartePerroquet(){
		if(collectionPerroquet.isEmpty()){
			System.out.println("utilisation carte perroquet alors que yan a pu ! #fungenieur");
		}
		else{
			collectionPerroquet.remove(collectionPerroquet.iterator().next());
			perroquet=true;
		}
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
		
	}


}
