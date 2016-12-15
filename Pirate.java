import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



public class Pirate extends Personnage {
	
	private Case historique;
	
	public Pirate(){
		path="src/pirate.png";
		this.de=new Des6();
	}

	public boolean estValide(Case destination){
		if (this.historique==destination){
			System.out.println("Ne reviens pas sur tes pas !");
			return false;
		}
		else{
			return true;
		}
	}
	
	public void bouge(Case new_case){
		this.historique=getPosition();
		super.bouge(new_case);
		
		//Interactions
		
		Iterator<Personnage> itPerso = getPosition().getEquipage().iterator();
		System.out.println("nb perso sur la case : "+this.getPosition().getEquipage().size());
		for(int i=0;i<getPosition().getEquipage().size();i++){
			Personnage mecSurLaCase=itPerso.next();
			if (mecSurLaCase instanceof Moussaillon){
				((Moussaillon) mecSurLaCase).meurs();
				System.out.println("Meurs " + mecSurLaCase.toString() + " !");
				
			}
		}

		Iterator<Tresor> itTresor = getPosition().getInventaire().iterator();
		System.out.println("nb trésor sur la case : "+this.getPosition().getInventaire().size());
		for(int i=0;i<this.getPosition().getInventaire().size();i++){
			Tresor tresorSurLaCase=getPosition().getInventaire().iterator().next();
			tresorSurLaCase.retourGrotte();
			System.out.println("Trésor " + tresorSurLaCase.toString() + " attrappé !");
				
		}
	}
}
