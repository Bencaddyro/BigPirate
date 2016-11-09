
public class Barque extends Case{

	Barque(Integer _x,Integer _y, Integer nbMoussaillon){
		super(_x,_y);
		path="src/barque.png";
		Integer i;
		for(i=0;i<nbMoussaillon;i++){
			equipage.add(new Moussaillon());
		}
	}
	public Boolean estValide(){
		return true;
	}
	
}
