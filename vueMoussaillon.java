import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class vueMoussaillon extends JPanel implements Observer {

	Systeme syst;
	
	JPanel entrerCocotier= new JPanel(new BorderLayout());
	JButton eCocotier=new JButton("Entrer Cocotier");
	
	JPanel carteCocotier= new JPanel(new BorderLayout());
	JButton cCocotier=new JButton("Carte Cocotier");
	JLabel nbCocotier=new JLabel("");
	
	JPanel cartePerroquet= new JPanel(new BorderLayout());
	JButton cPerroquet=new JButton("Carte Perroquet");
	JLabel nbPerroquet = new JLabel("");
	
	JPanel tresor= new JPanel(new BorderLayout());
	JButton lTresor=new JButton("Lacher trésor");
	JLabel inventaire = new JLabel("");
	
	public vueMoussaillon(String name, final Systeme syst){
		super(new GridLayout(1,2));		
		this.syst=syst;
		
		tresor.add(lTresor,BorderLayout.NORTH);
		tresor.add(inventaire,BorderLayout.CENTER);
		this.add(tresor);

		entrerCocotier.add(eCocotier,BorderLayout.NORTH);
		this.add(entrerCocotier);
				
		carteCocotier.add(cCocotier,BorderLayout.NORTH);
		carteCocotier.add(nbCocotier,BorderLayout.CENTER);
		
		this.add(carteCocotier);
				
		cartePerroquet.add(cPerroquet,BorderLayout.NORTH);
		cartePerroquet.add(nbPerroquet,BorderLayout.CENTER);
		
		this.add(cartePerroquet);
		
		eCocotier.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				((Moussaillon) syst.getPersonnageCourant()).entrerCocotier();
	    			}
	    		}		
	    	);
			
		cCocotier.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				((Moussaillon) syst.getPersonnageCourant()).carteCocotier();
	    			}
	    		}		
	    	);
			
		cPerroquet.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				((Moussaillon) syst.getPersonnageCourant()).cartePerroquet();
	    			}
	    		}		
	    	);
		
		lTresor.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				((Moussaillon) syst.getPersonnageCourant()).lacherTresor();
	    			}
	    		}		
	    	);
	}
	public void update(Observable arg0, Object arg1) {
		System.out.println("Je me fait notifier !");
		nbCocotier.setText(""+((Moussaillon)arg0).getCollectionCocotier().size());
		nbPerroquet.setText(""+((Moussaillon)arg0).getCollectionPerroquet().size());
		if(((Moussaillon)arg0).getMyTresor()==null){
			inventaire.setText("Tu n'as pas de trésor");
		}else{
			inventaire.setText("Tu a un trésor, vite au bato !");
		}
		
	}
	
}
