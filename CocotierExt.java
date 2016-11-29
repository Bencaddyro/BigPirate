
public class CocotierExt extends Case {

	Case coco;
	
	CocotierExt(Integer _x, Integer _y,Case _coco) {
		super(_x, _y);
		coco=_coco;
		path="src/cocotierext.png";
		((CocotierInter)_coco).setExtCoco(this);
	}
	public Boolean estValide(){
		return true;
	}
	public Boolean cocotierExt(){
		return true;
	}
	
	public Case getCoco(){
		return coco;
	}
}
