import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


public class VueMoussaillon extends VueJoueur {

	
	private JButton eCocotier=new JButton(new ImageIcon("src/img/in.png"));
	
	private JButton cCocotier=new JButton("Cocotier");
	private JLabel nbCocotier=new JLabel("");
	
	private JButton cPerroquet=new JButton(new ImageIcon("src/img/perroquet1.png"));
	private JLabel nbPerroquet = new JLabel("");
	
	private JButton lTresor=new JButton("Lacher");
	private JLabel inventaire = new JLabel("");
	
	private JButton finDuTour=new JButton("Fin ");
	
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
	    				//action de se cacher dans un cocotier
	    				((Moussaillon) Systeme.getSystem().getPersonnageCourant()).entrerCocotier();
	    			}
	    		}		
	    	);
			
		cCocotier.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				//action d'utiliser une carte cocotier
	    				((Moussaillon) Systeme.getSystem().getPersonnageCourant()).carteCocotier();
	    			}
	    		}		
	    	);
			
		cPerroquet.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				//action d'utiliser une carte perroquet
	    				((Moussaillon) Systeme.getSystem().getPersonnageCourant()).cartePerroquet();
	    			}
	    		}		
	    	);
		
		lTresor.addActionListener(
	    		new ActionListener(){
	    			//action de lacher le trésor
	    			public void actionPerformed(ActionEvent e){
	    				((Moussaillon) Systeme.getSystem().getPersonnageCourant()).lacherTresor();
	    			}
	    		}		
	    	);
		
		finDuTour.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				//action de passer son tour
	    				Systeme.getSystem().finDeTour();
	    			}
	    		}		
	    	);
	}
	public void update(Observable arg0, Object arg1) {
		super.update(arg0,arg1);
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		//on met a jour le nombre de carte cocotier et de carte perroquet
		nbCocotier.setText(""+((Moussaillon)arg0).getCollectionCocotier().size());
		nbPerroquet.setText(""+((Moussaillon)arg0).getCollectionPerroquet().size());
		
		
		//l'option de rentrer dans un cocotier n'est disponible que si le moussaillon est sur une case cocotier exterieur
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
			this.remove(nbCocotier);
		}		
		
		if(((Moussaillon)arg0).getPerroquet()){
			cPerroquet.setIcon(new ImageIcon("src/img/perroquet2.png"));
		}else{
			cPerroquet.setIcon(new ImageIcon("src/img/perroquet1.png"));
		}
		
		if(((Moussaillon)arg0).getCollectionPerroquet().isEmpty()){
			this.remove(cPerroquet);
			this.remove(nbPerroquet);			
		}

		
		if(((Moussaillon)arg0).getMyTresor()==null){
			inventaire.setIcon(new ImageIcon("src/img/coffrecross.png"));
			this.remove(lTresor);
		}else{
			inventaire.setIcon(new ImageIcon("src/img/coffrecheck.png"));
			c.gridx=0;
			c.gridy=7;
			c.gridwidth = 1;
			c.gridheight = 1;
			this.add(lTresor,c);
		}
		
	}
	
}
