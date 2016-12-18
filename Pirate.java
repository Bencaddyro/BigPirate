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

	/**
	 * Prend en param�tre une case et renvoie false si c'est la derni�re case visit�e par le pirate, true sinon.
	 * 
	 * @param destination
	 * @return boolean
	 */
	public boolean estValide(Case destination){
		if (this.historique==destination){
			return false;
		}
		else{
			return true;
		}
	}
	
	/**
	 * Traite le d�placement du Pirate.
	 * On d�finit des it�rateurs sur l'ensemble des personnages sur la case cible ainsi que l'ensemble des tr�sors sur la case cible.
	 * Puis on applique les traitements respectifs � chacun : le pirate attrappe chaque Moussaillon et renvoie � la grotte chaque
	 * tr�sor.
	 * Le pirate finit son tour lorsqu'il n'a plus de d�placements disponibles.
	 * 
	 * @see Personnage#bouge(Case)
	 * @param new_case la case cible
	 * 
	 */
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
		
		if(nb_moussaillon_elimine==Systeme.getSystem().getNb_moussaillon()){ //V�rification de la condition de victoire du pirate
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
