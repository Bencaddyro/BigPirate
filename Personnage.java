
public class Personnage {
	
	protected Des de;
	protected String path;
	protected Case case_perso;
	
	
	
	
	public String getPath() {
		return path;
	}
	
	public void aToiDeJouer(){}
	
	public void setCasePerso(Case c)
	{
		this.case_perso = c;
	}

	public Case getCasePerso()
	{
	return this.case_perso;
	}
}
