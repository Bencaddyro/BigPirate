import java.util.AbstractCollection;
import java.util.HashSet;



public abstract class Case {

	protected String path;
	protected Integer x;
	protected Integer y;
	protected AbstractCollection<Tresor> inventaire;
	protected AbstractCollection<Personnage> equipage;
	
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
	}
	public void addTresor(Tresor t){
		inventaire.add(t);
	}
	public void removePersonnage(Personnage p){
		equipage.remove(p);
	}
	public void removeTresor(Tresor t){
		inventaire.remove(t);
	}
	public Moussaillon moussaillonPresent() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
