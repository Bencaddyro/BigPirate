
public class Grotte extends Case {

	Grotte(Integer _x, Integer _y) {
		super(_x, _y);
		path="src/grotte.png";
	}

	Grotte(Integer _x, Integer _y, Integer tresor){
		super(_x, _y);
		Integer i;
		for(i=0;i<tresor;i++){
			inventaire.add(new Tresor());
		}
	}
	
	public Boolean estValide(){
		return true;
	}
}
