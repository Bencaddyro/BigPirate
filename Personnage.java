
public class Personnage {
	private Case position;
	protected Des de; 
	protected String path;
	
	
	
	
	public String getPath() {
		return path;
	}
	
	public void aToiDeJouer(){}

	
	//----------------------------------------------------------------------------------------------------------------------------------------
	//GETTER and SETTER
	//----------------------------------------------------------------------------------------------------------------------------------------
	public Case getPosition() {
		return position;
	}
	public void setPosition(Case position) {
		this.position = position;
	}

}
