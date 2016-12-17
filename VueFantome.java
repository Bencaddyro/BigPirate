
import javax.swing.JLabel;

public class VueFantome extends VueJoueur{
	public VueFantome(Personnage p){
		super(p);
		this.add(new JLabel("Menu Fantome"));
	}
}
