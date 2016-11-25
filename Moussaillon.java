import java.util.AbstractCollection;
import java.util.HashSet;



public class Moussaillon extends Personnage {
	
	private AbstractCollection<Cocotier> collectionCocotier=new HashSet();
	private AbstractCollection<Perroquet> collectionPerroquet=new HashSet();;
	private static int[][] tab={{5,4,3},{3,2,1}};
	
	public Moussaillon(Integer nbMoussaillon){
			
		for(int i=0;i<tab[0][nbMoussaillon-1];i++){
			this.collectionCocotier.add(new Cocotier());
		}
		for(int i=0;i<tab[1][nbMoussaillon-1];i++){
			this.collectionPerroquet.add(new Perroquet());
		}
		path="src/moussaillon.png";
	}
	
	
	
	public void aToiDeJouer(){
		
		
		
		
	}
	
	public void cartePerroquet(){
		if(collectionPerroquet.isEmpty()){
			System.out.println("utilisation carte perroquet alors que yan a pu ! #fungenieur");
		}
		else{
			collectionPerroquet.remove(collectionPerroquet.iterator().next());
		}
	}
	
	public void carteCocotier(){
		if(collectionCocotier.isEmpty()){
			System.out.println("utilisation carte cocotier alors que yan a pu ! #fungenieur");
		}
		else{
			collectionCocotier.remove(collectionCocotier.iterator().next());
		}
	}


}
