import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public abstract class VueJoueur extends JPanel implements Observer{


	
	JPanel croix = new CroixDirection();
	JPanel lancement = new LancementDe();
	JButton finDuTour=new JButton("Fin du tour");


	
	
	public VueJoueur() {
		super(new BorderLayout());
		
		this.add(croix,BorderLayout.WEST);
		this.add(lancement,BorderLayout.CENTER);
		this.add(finDuTour,BorderLayout.SOUTH);
		
		finDuTour.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				System.out.println("Fin du tour de " + Systeme.getSystem().getPersonnageCourant().toString());
	    				Systeme.getSystem().finDeTour();
	    			}
	    		}		
	    	);
	}


	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
		
}
