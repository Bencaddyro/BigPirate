import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;


public abstract class Personnage extends Observable {
	protected Case position;
	protected Des de; 
	protected String path;
	
	protected Boolean vivant = true;
	private Set<Observer> observers = new HashSet<Observer>();
	
	protected int nbDeplacementRestant;
	protected boolean delance;
	protected int score;
	
	

	//----------------------------------------------------------------------------------------------------------------------------------------
	//GETTER and SETTER
	//----------------------------------------------------------------------------------------------------------------------------------------
	public int getNbDeplacementRestant() {
		return nbDeplacementRestant;
	}
	
	public boolean getDelance() {
		return delance;
	}
	
	public int getScore() {
		return score;
	}
	public void setPosition(Case case1) {
		position=case1;
	}
	public String getPath() {
		return path;
	}
	public Boolean isVivant(){
		return vivant;
	}
	public Case getPosition() {
		return position;
	}
	
	
	
	/**
	 * Le systeme signal au joueur par cette methode que c'est son tour
	 */
	public void aToiDeJouer(){
		delance=false;
		nbDeplacementRestant=0;
		score=0;
		notifyObservers();
	}

	
	public void notifyObservers(){
		for (Observer o: this.observers){
			o.update(this,this);
		}
	}
	
	public void registerObserver(Observer obs){
		observers.add(obs);
	}

	/**
	 * Methode permettant d'indiquer a un personnage sont déplacement effectif
	 * @param new_case
	 */
	public void bouge(Case new_case)
	{
		// Dire à  l'ancienne case que le personnage n'est plus dessus
		(this.getPosition()).removePersonnage(this);
		// Dire à  la nouvelle case que le personnage est dessus
		new_case.addPersonnage(this);
		// Dire au personnage sur qu'elle case il est
		position=new_case;
		nbDeplacementRestant--;
	}
	

	public void lancerDe() {
		if(!delance){
			score=this.de.lancerDe();
			nbDeplacementRestant=score;
			delance=true;
			notifyObservers();
		}
	}

	/**
	 * Cette methode indique si la case en parametre est valide pour ce personnage
	 * @param new_case
	 * @return boolean
	 */
	public boolean estValide(Case new_case) {
		return true;
	}


	

}
