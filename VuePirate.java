
public class VuePirate extends VueJoueur{

	public VuePirate(Personnage p){
		super(p);
		p.registerObserver(this);
	}
}
