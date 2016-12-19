
public class Grotte extends Case {

	Grotte(Integer _x, Integer _y) {
		super(_x, _y);
		path="img/grotte.png";
	}
	
	public Boolean estValide(){
		return true;
	}
}
