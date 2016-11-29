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
			return false;
		}
		else{
			return true;
		}
	}
	
	public void bouge(Case new_case){
		if (this.estValide(new_case)){
			this.historique=getPosition();
			super.bouge(new_case);
			
			//Interactions
			
			Iterator<Personnage> itPerso = getPosition().getEquipage().iterator();
			for(int i=0;i<getPosition().getEquipage().size();i++){
				System.out.println(""+i);
				Personnage mecSurLaCase=itPerso.next();
				System.out.println(mecSurLaCase.toString());
				if (mecSurLaCase instanceof Moussaillon){
					((Moussaillon) mecSurLaCase).meurs();
					System.out.println("Meurs " + mecSurLaCase.toString() + " !");
					
				}
			}

			Iterator<Tresor> itTresor = getPosition().getInventaire().iterator();
			for(int i=0;i<getPosition().getInventaire().size();i++){
				System.out.println(""+i);
				Tresor tresorSurLaCase=getPosition().getInventaire().iterator().next();
				tresorSurLaCase.retourGrotte();
				System.out.println("Trésor " + tresorSurLaCase.toString() + " attrappé !");
					
			}
		}
		else{
			System.out.println("Ne reviens pas sur tes pas !");
		}
	}
}
