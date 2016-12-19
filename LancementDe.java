import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class LancementDe extends JPanel implements Observer{
	
	private static final long serialVersionUID = 1L;
	private JButton lancerDe=new JButton(new ImageIcon(getClass().getResource("img/dice.png")));
	private JLabel resultDe=new JLabel("En attente du résultat");
	private JLabel nbDeplacementRestant=new JLabel("? déplacements restants");
	
	public LancementDe() {
		super(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		c.gridx=0;
		c.gridy=0;
		c.gridwidth = 1;
		c.gridheight = 2;
		
		this.add(lancerDe,c);
		
		c.gridx=1;
		c.gridy=0;
		c.gridwidth = 1;
		c.gridheight = 1;
		this.add(resultDe,c);
		
		c.gridx=1;
		c.gridy=1;
		c.gridwidth = 1;
		c.gridheight = 1;
		this.add(nbDeplacementRestant,c);
				
		lancerDe.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				//appel de la methode de lancement de dé
	    				Systeme.getSystem().getPersonnageCourant().lancerDe();
	    			}
	    		}		
	    	);
	}
	
	/**
	 * Cette methode met a jour le résultat du dé ainsi que le nombre de déplacement restant
	 */
	public void update(Observable o, Object arg) {
		resultDe.setText("Résultat du dé : "+((Personnage)o).getScore());
		nbDeplacementRestant.setText("Déplacement possible : "+((Personnage)o).getNbDeplacementRestant());
	}
	
}
