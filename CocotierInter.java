
public class CocotierInter extends Case {

	private Case extCoco;
	
	CocotierInter(Integer _x, Integer _y) {
		super(_x, _y);
		path="img/cocotierinter.png";
	}
	public void setExtCoco(Case extCoco) {
		this.extCoco = extCoco;
	}
	public Case getExtCoco() {
		return extCoco;
	}
	
	public Boolean estValide(){
		return false;
	}
	public Boolean cocotierInter(){
		return true;
	}

}
