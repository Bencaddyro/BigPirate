
public class Personnage {
	private Case position;
	protected Des de; 
	protected String path;
	
	
	
	
	public String getPath() {
		return path;
	}
	
	public void aToiDeJouer(){}


	//Bouge
	public void bouge(Case new_case)
	{
		// Dire à  l'ancienne case que le personnage n'est plus dessus
		(this.getPosition()).removePersonnage(this);
		// Dire à  la nouvelle case que le personnage est dessus
		new_case.addPersonnage(this);
		// Dire au personnage sur qu'elle case il est
		this.setPosition(new_case);
		System.out.println("il a move en "+new_case.getX()+" "+new_case.getY());
	}
	
	//----------------------------------------------------------------------------------------------------------------------------------------
	//GETTER and SETTER
	//----------------------------------------------------------------------------------------------------------------------------------------
	public Case getPosition() {
		return position;
	}
	public void setPosition(Case position) {
		this.position = position;
	}

	public void lancerDe() {
		
	}

}
