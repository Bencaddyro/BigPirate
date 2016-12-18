import java.util.AbstractCollection;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import javax.swing.JPanel;



public abstract class Case extends Observable {

	protected String path;
	protected Integer x;
	protected Integer y;
	protected AbstractCollection<Tresor> inventaire;
	protected AbstractCollection<Personnage> equipage;
	Set<Observer> observers = new HashSet<Observer>();
	
	Case(Integer _x, Integer _y){
		x=_x;
		y=_y;
		inventaire=new HashSet<Tresor>();
		equipage=new HashSet<Personnage>();
	}
	public String getPath(){
		return path;
	}
	public Integer getX() {
		return x;
	}
	public Integer getY() {
		return y;
	}
	public AbstractCollection<Personnage> getEquipage() {
		return equipage;
	}
	public AbstractCollection<Tresor> getInventaire() {
		return inventaire;
	}
	
	public Boolean estValide(){
		return false;
	}
	public Boolean cocotierInter(){
		return false;
	}
	public Boolean cocotierExt(){
		return false;
	}
	public Boolean barque(){
		return false;
	}
	public Tresor tresorPresent(){
		if(inventaire.isEmpty()){
			return null;
		}
		else{
			return inventaire.iterator().next();
		}
	}
	public Personnage personnagePresent(){
		if(equipage.isEmpty()){
			return null;
		}
		else{
			return equipage.iterator().next();
		}
	}
	public void addPersonnage(Personnage p){
		equipage.add(p);
		notifyObservers();
	}
	public void addTresor(Tresor t){
		inventaire.add(t);
		notifyObservers();
	}
	public void removePersonnage(Personnage p){
		equipage.remove(p);
		notifyObservers();
	}
	public void removeTresor(Tresor t){
		inventaire.remove(t);
		notifyObservers();
	}
	public Moussaillon moussaillonPresent() {
		Personnage perso = this.personnagePresent();
		if (perso != null)
		{
			if (perso.getClass() == Moussaillon.class)
			{
				return (Moussaillon) perso;
			}
		}
		return null;
	}
	
	public void notifyObservers(){
		for (Observer o: this.observers){
			o.update(this,this);
		}
	}
	
	public void registerObserver(Observer obs){
		observers.add(obs);
	}
	public void reset() {
		inventaire=new HashSet<Tresor>();
		equipage=new HashSet<Personnage>();
		observers = new HashSet<Observer>();
	}
	
}

