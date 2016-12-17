import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class VueMenuPrincipal extends JPanel implements Observer {
	JButton lancerPartie=new JButton("Lancez la partie !");
	JTextField nb_joueurs=new JTextField("Entrez le nombre de joueurs");
	JLabel label_nb_joueurs=new JLabel("Nombre de joueurs");

	public VueMenuPrincipal(){
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		c.gridx=0;
		c.gridy=0;
		c.gridwidth = 3;
		c.gridheight =1;
		
		this.add(lancerPartie,c);
		
		c.gridx=0;
		c.gridy=1;
		c.gridwidth = 3;
		c.gridheight =1;
		this.add(label_nb_joueurs,c);
		
		c.gridx=0;
		c.gridy=2;
		c.gridwidth = 3;
		c.gridheight =1;
		this.add(nb_joueurs,c);
		
		
		lancerPartie.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				if(Integer.valueOf(nb_joueurs.getText())>1){
		    				Systeme.start(1+Integer.valueOf(nb_joueurs.getText()));
		    				Systeme.getSystem().setIhm(new IHM());
		    				Systeme.getSystem().debut();
	    				}
	    			}
	    		}		
	    	);
		

		
	}
	
	public void update(Observable o, Object arg) {
		
	}

}