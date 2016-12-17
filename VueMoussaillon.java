import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class VueMoussaillon extends VueJoueur {

	
	JPanel entrerCocotier= new JPanel(new BorderLayout());
	JButton eCocotier=new JButton(new ImageIcon("src/in.png"));
	
	JPanel carteCocotier= new JPanel(new BorderLayout());
	JButton cCocotier=new JButton("Carte Cocotier");
	JLabel nbCocotier=new JLabel("");
	
	JPanel cartePerroquet= new JPanel(new BorderLayout());
	JButton cPerroquet=new JButton(new ImageIcon("src/perroquet1.png"));
	JLabel nbPerroquet = new JLabel("");
	
	JPanel tresor= new JPanel(new BorderLayout());
	JButton lTresor=new JButton("Lacher trésor");
	JLabel inventaire = new JLabel("");
	
	
	
	
	public VueMoussaillon(Personnage m){
		super(m);		
	
		m.registerObserver(this);
		
		entrerCocotier.add(eCocotier,BorderLayout.NORTH);
		this.add(entrerCocotier);
				
		carteCocotier.add(cCocotier,BorderLayout.NORTH);
		carteCocotier.add(nbCocotier,BorderLayout.CENTER);
		
		this.add(carteCocotier);
				
		cartePerroquet.add(cPerroquet,BorderLayout.NORTH);
		cartePerroquet.add(nbPerroquet,BorderLayout.CENTER);
		
		this.add(cartePerroquet);
		
		tresor.add(lTresor,BorderLayout.NORTH);
		tresor.add(inventaire,BorderLayout.CENTER);
		this.add(tresor);
		
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
		nbCocotier.setText(""+((Moussaillon)arg0).getCollectionCocotier().size());
		nbPerroquet.setText(""+((Moussaillon)arg0).getCollectionPerroquet().size());
		
		if(((Moussaillon)arg0).getPerroquet()){
			cPerroquet.setIcon(new ImageIcon("src/perroquet2.png"));
		}else{
			cPerroquet.setIcon(new ImageIcon("src/perroquet1.png"));
		}
		
		
		if(((Moussaillon)arg0).getMyTresor()==null){
			inventaire.setIcon(new ImageIcon("src/coffrecross.png"));
		}else{
			inventaire.setIcon(new ImageIcon("src/coffrecheck.png"));
		}
		
	}
	
}
