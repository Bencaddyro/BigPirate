import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class VueFantome extends VueJoueur{
	public VueFantome(Personnage p){
		super(p);
		this.add(new JLabel("Menu Fantome"));
	}
}
