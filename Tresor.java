
public class Tresor {

	private String path = "img/tresor.png";
	
	/**
	 * Renvoi le trésor a la Grotte
	 */
	public void retourGrotte(){
		Systeme.getGrille()[4][8].addTresor(this);
	}

	public String getPath() {
		return path;
	}

	/**
	 * renvoie le trésor sur la carte aléatoirement
	 */
	public void teleportation() {
		Case cible=null;
		int i,j;
		do{//recherche d'une destination valide
			i=(int)(Math.random()*12);
			j=(int)(Math.random()*12);
			cible=Systeme.getGrille()[i][j];
		}while(!(cible instanceof Chemin));
		
		cible.addTresor(this);
	}
}
