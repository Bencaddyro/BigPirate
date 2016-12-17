import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;



public class Pirate extends Personnage {
	
	private Case historique;
	private int nb_moussaillon_elimine=0;
	
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
		this.historique=getPosition();
		super.bouge(new_case);
		Tresor tresorCourant;
		List<Moussaillon> arrayMoussaillon= new ArrayList<Moussaillon>();
		List<Tresor> arrayTresor= new ArrayList<Tresor>();
		
		//Interactions
		
		Iterator<Personnage> itPerso = getPosition().getEquipage().iterator();
		for(int i=0;i<getPosition().getEquipage().size();i++){
			Personnage mecSurLaCase=itPerso.next();
			if (mecSurLaCase instanceof Moussaillon){
				arrayMoussaillon.add((Moussaillon) mecSurLaCase);
				nb_moussaillon_elimine++;				
			}
		}
		
		for(int i=0;i<arrayMoussaillon.size();i++){
			arrayMoussaillon.get(i).meurs();
		}
		
		if(nb_moussaillon_elimine==Systeme.getSystem().getNb_moussaillon()){
			Systeme.getSystem().gagne();
		}
		
		Iterator<Tresor> itTresor = getPosition().getInventaire().iterator();
		for(int i=0;i<this.getPosition().getInventaire().size();i++){
			Tresor tresorSurLaCase=itTresor.next();
			arrayTresor.add(tresorSurLaCase);
		}

		for(int i=0;i<arrayTresor.size();i++){
			tresorCourant=arrayTresor.get(i);
			getPosition().inventaire.remove(tresorCourant);
			tresorCourant.retourGrotte();
		}
	
		if(nbDeplacementRestant==0){
			Systeme.getSystem().finDeTour();
		}
		notifyObservers();
	
	}
}
