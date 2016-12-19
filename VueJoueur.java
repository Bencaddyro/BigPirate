import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;


public abstract class VueJoueur extends JPanel implements Observer{

	
	private CroixDirection croix = new CroixDirection();
	private LancementDe lancement = new LancementDe();
	
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
		
		p.registerObserver(lancement);

	}


	public void update(Observable o, Object arg) {
		
	}
		
}
