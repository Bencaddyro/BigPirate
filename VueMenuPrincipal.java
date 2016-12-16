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
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		
		this.add(lancerPartie);
		this.add(label_nb_joueurs);
		this.add(nb_joueurs);
		
	}

	
	public void update(Observable o, Object arg) {
		
	}

}