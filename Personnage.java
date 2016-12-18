import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;


public class Personnage extends Observable {
	protected Case position;
	protected Des de; 
	protected String path;
	
	protected Boolean vivant = true;
	Set<Observer> observers = new HashSet<Observer>();
	
	protected int nbDeplacementRestant;
	protected boolean delance;
	protected int score;
	
	public int getNbDeplacementRestant() {
		return nbDeplacementRestant;
	}
	
	public boolean getDelance() {
		return delance;
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int i){
		this.score=i;
	}
	
	public String getPath() {
		return path;
	}
	
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
		//System.out.println("ON notify !");
	}
	public void registerObserver(Observer obs){
		observers.add(obs);
	}

	//Bouge
	public void bouge(Case new_case)
	{
		// Dire à  l'ancienne case que le personnage n'est plus dessus
		(this.getPosition()).removePersonnage(this);
		// Dire à  la nouvelle case que le personnage est dessus
		new_case.addPersonnage(this);
		// Dire au personnage sur qu'elle case il est
		this.setPosition(new_case);
		nbDeplacementRestant--;
	}
	
	//----------------------------------------------------------------------------------------------------------------------------------------
	//GETTER and SETTER
	//----------------------------------------------------------------------------------------------------------------------------------------
	public Boolean isVivant(){
		return vivant;
	}
	
	public Case getPosition() {
		return position;
	}
	public void setPosition(Case position) {
		this.position = position;
	}

	public void lancerDe() {
		if(!delance){
			score=this.de.lancerDe();
			nbDeplacementRestant=score;
			delance=true;
			notifyObservers();
		}
	}

	public boolean estValide(Case new_case) {
		return true;
	}

}
