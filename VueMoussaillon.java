import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class VueMoussaillon extends VueJoueur {

	JPanel vueMoussaillon = new JPanel();
	
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
	
	
	
	
	public VueMoussaillon(String name){
		super();		
	
		this.add(vueMoussaillon,BorderLayout.EAST);
		entrerCocotier.add(eCocotier,BorderLayout.NORTH);
		vueMoussaillon.add(entrerCocotier);
				
		carteCocotier.add(cCocotier,BorderLayout.NORTH);
		carteCocotier.add(nbCocotier,BorderLayout.CENTER);
		
		vueMoussaillon.add(carteCocotier);
				
		cartePerroquet.add(cPerroquet,BorderLayout.NORTH);
		cartePerroquet.add(nbPerroquet,BorderLayout.CENTER);
		
		vueMoussaillon.add(cartePerroquet);
		
		tresor.add(lTresor,BorderLayout.NORTH);
		tresor.add(inventaire,BorderLayout.CENTER);
		vueMoussaillon.add(tresor);
		
		eCocotier.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				((Moussaillon) Systeme.getSystem().getPersonnageCourant()).entrerCocotier();
	    			}
	    		}		
	    	);
			
		cCocotier.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				((Moussaillon) Systeme.getSystem().getPersonnageCourant()).carteCocotier();
	    			}
	    		}		
	    	);
			
		cPerroquet.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				((Moussaillon) Systeme.getSystem().getPersonnageCourant()).cartePerroquet();
	    			}
	    		}		
	    	);
		
		lTresor.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				((Moussaillon) Systeme.getSystem().getPersonnageCourant()).lacherTresor();
	    			}
	    		}		
	    	);
	}
	public void update(Observable arg0, Object arg1) {
		super.update(arg0,arg1);
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
