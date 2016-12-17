import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


public abstract class VueJoueur extends JPanel implements Observer{

	
	CroixDirection croix = new CroixDirection();
	LancementDe lancement = new LancementDe();
	JButton finDuTour=new JButton("Fin ");


	
	
	public VueJoueur(Personnage p) {
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		c.gridx=0;
		c.gridy=0;
		
		c.gridwidth = 2;
		c.gridheight = 2;
		c.anchor=GridBagConstraints.PAGE_START;
		this.add(croix,c);
		
		c.gridx=0;
		c.gridy=2;
		
		c.gridwidth = 2;
		c.gridheight = 1;
		c.anchor=GridBagConstraints.PAGE_START;
		this.add(lancement,c);
		
		
		
		c.gridx=0;
		c.gridy=8;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.anchor=GridBagConstraints.PAGE_END;
		this.add(finDuTour,c);
		
		p.registerObserver(lancement);
		
		finDuTour.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				Systeme.getSystem().finDeTour();
	    			}
	    		}		
	    	);
	}


	public void update(Observable o, Object arg) {
		
	}
		
}
