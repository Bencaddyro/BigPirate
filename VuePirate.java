
public class VuePirate extends VueJoueur{

	private static final long serialVersionUID = 1L;

	public VuePirate(Personnage p){
		super(p);
		p.registerObserver(this);
	}
}
