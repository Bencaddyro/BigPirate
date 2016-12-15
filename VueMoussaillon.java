import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class VueMoussaillon extends JPanel {

	Systeme syst;
	public VueMoussaillon(String name, final Systeme syst){
		super(new GridLayout(1,2));		
		this.syst=syst;
		
		JPanel entrerCocotier= new JPanel(new BorderLayout());
		JButton eCocotier=new JButton("Entrer Cocotier");
		entrerCocotier.add(eCocotier,BorderLayout.NORTH);
		this.add(entrerCocotier);
		
		JPanel carteCocotier= new JPanel(new BorderLayout());
		JButton cCocotier=new JButton("Carte Cocotier");
		carteCocotier.add(cCocotier,BorderLayout.NORTH);
		carteCocotier.add(new JLabel("3"),BorderLayout.CENTER);
		this.add(carteCocotier);

		JPanel cartePerroquet= new JPanel(new BorderLayout());
		JButton cPerroquet=new JButton("Carte Perroquet");
		cartePerroquet.add(cPerroquet,BorderLayout.NORTH);
		cartePerroquet.add(new JLabel("4"),BorderLayout.CENTER);
		this.add(cartePerroquet);
		
		eCocotier.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				//fonction de deplacement
	    				((Moussaillon) syst.getPersonnageCourant()).entrerCocotier();
	    			}
	    		}		
	    	);
			
		cCocotier.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				//fonction de deplacement
	    				((Moussaillon) syst.getPersonnageCourant()).carteCocotier();
	    			}
	    		}		
	    	);
			
		cPerroquet.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				//fonction de deplacement
	    				((Moussaillon) syst.getPersonnageCourant()).cartePerroquet();
	    			}
	    		}		
	    	);
	}
}
