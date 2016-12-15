import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class LancementDe extends JPanel implements Observer{
	
	JButton lancerDe=new JButton("Lance le dé!");
	JLabel resultDe=new JLabel("En attente du résultat");
	JLabel nbDeplacementRestant=new JLabel("? déplacements restants");
	
	
	public LancementDe() {
		super(new BorderLayout());	
		this.add(lancerDe,BorderLayout.NORTH);		
		this.add(resultDe,BorderLayout.CENTER);
		this.add(nbDeplacementRestant,BorderLayout.SOUTH);
				
		lancerDe.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				//fonction de deplacement
	    				Systeme.getSystem().lancerDe();
	    				resultDe.setText(""+Systeme.getSystem().getPersonnageCourant().getScore());
	    				nbDeplacementRestant.setText(Systeme.getSystem().getNbDeplacementRestant()+" déplacements restants");
	    			}
	    		}		
	    	);
	}
		
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
}
