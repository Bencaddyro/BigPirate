import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
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

	
	JButton eCocotier=new JButton(new ImageIcon("src/in.png"));
	
	JButton cCocotier=new JButton("Cocotier");
	JLabel nbCocotier=new JLabel("");
	
	JButton cPerroquet=new JButton(new ImageIcon("src/perroquet1.png"));
	JLabel nbPerroquet = new JLabel("");
	
	JButton lTresor=new JButton("Lacher");
	JLabel inventaire = new JLabel("");
	
	JButton finDuTour=new JButton("Fin ");
	
	public VueMoussaillon(Personnage m){
		super(m);		
	
		m.registerObserver(this);
	
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		c.gridx=0;
		c.gridy=5;
		c.gridwidth = 1;
		c.gridheight = 1;
		this.add(cCocotier,c);
		
		c.gridx=1;
		c.gridy=5;
		c.gridwidth = 1;
		c.gridheight = 1;
		this.add(nbCocotier,c);
		
		c.gridx=0;
		c.gridy=6;
		c.gridwidth = 1;
		c.gridheight = 1;
		this.add(cPerroquet,c);
		
		c.gridx=1;
		c.gridy=6;
		c.gridwidth = 1;
		c.gridheight = 1;
		this.add(nbPerroquet,c);
		
		c.gridx=1;
		c.gridy=7;
		c.gridwidth = 1;
		c.gridheight = 1;
		this.add(inventaire,c);
		
		c.gridx=0;
		c.gridy=8;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.anchor=GridBagConstraints.PAGE_END;
		this.add(finDuTour,c);
		
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
		
		finDuTour.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				Systeme.getSystem().finDeTour();
	    			}
	    		}		
	    	);
	}
	public void update(Observable arg0, Object arg1) {
		super.update(arg0,arg1);
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		nbCocotier.setText(""+((Moussaillon)arg0).getCollectionCocotier().size());
		nbPerroquet.setText(""+((Moussaillon)arg0).getCollectionPerroquet().size());
		
		if(!((Moussaillon)arg0).getPosition().cocotierExt()){
			this.remove(eCocotier);
		}else{
			c.gridx=0;
			c.gridy=4;
			c.gridwidth = 1;
			c.gridheight = 1;
			this.add(eCocotier,c);
		}
		

		if(((Moussaillon)arg0).getCollectionCocotier().isEmpty()){
			this.remove(cCocotier);
		}		
		
		if(((Moussaillon)arg0).getPerroquet()){
			cPerroquet.setIcon(new ImageIcon("src/perroquet2.png"));
		}else{
			cPerroquet.setIcon(new ImageIcon("src/perroquet1.png"));
		}
		if(((Moussaillon)arg0).getCollectionPerroquet().isEmpty()){
			this.remove(cPerroquet);
			this.remove(nbPerroquet);			
		}

		
		if(((Moussaillon)arg0).getMyTresor()==null){
			inventaire.setIcon(new ImageIcon("src/coffrecross.png"));
			this.remove(lTresor);
		}else{
			inventaire.setIcon(new ImageIcon("src/coffrecheck.png"));
			c.gridx=0;
			c.gridy=7;
			c.gridwidth = 1;
			c.gridheight = 1;
			this.add(lTresor,c);
		}
		
	}
	
}
