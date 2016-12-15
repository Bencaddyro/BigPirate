import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class VueFantome extends VueJoueur{

	public VueFantome(){
		super();
		this.add(new JLabel("Menu Fantome"),BorderLayout.EAST);
	}
	
	
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
