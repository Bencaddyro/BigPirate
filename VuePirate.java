import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class VuePirate extends VueJoueur{

	
	
	public VuePirate(){
		super();
		this.add(new JLabel("Menu Pirate"),BorderLayout.EAST);
	}
		
	
	
	
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
