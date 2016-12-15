
public class Tresor {

	private String path = "src/tresor.png";
	
	public void retourGrotte(){
		Systeme.getSystem().getGrille()[4][8].addTresor(this);
	}

	public String getPath() {
		return path;
	}

	public void teleportation() {
		Case cible=null;
		int i,j;
		do{
			i=(int)Math.random()*12;
			j=(int)Math.random()*12;
			cible=Systeme.getSystem().getGrille()[i][j];
		}while(!cible.estValide());
		
		cible.addTresor(this);
		
	}
}
