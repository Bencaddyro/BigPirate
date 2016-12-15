import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;


public class CroixDirection extends JPanel {
	
	
	private JButton haut=new JButton("Haut");
	private JButton bas=new JButton("Bas");
	private JButton droite=new JButton("Droite");
	private JButton gauche=new JButton("Gauche");
	private JPanel direction =new JPanel(new BorderLayout());
	
	
	public CroixDirection(){
		super(new BorderLayout());
		
		this.add(droite, BorderLayout.EAST);
		this.add(gauche, BorderLayout.WEST);
		this.add(bas, BorderLayout.SOUTH);
		this.add(haut, BorderLayout.NORTH);
		
		gauche.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				Systeme.getSystem().deplacement("gauche");
	    				//nbDeplacementRestant.setText(syst.getNbDeplacementRestant()+" déplacements restants");
	    			}
	    		}		
	    	);
		droite.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				Systeme.getSystem().deplacement("droite");
	    				//nbDeplacementRestant.setText(syst.getNbDeplacementRestant()+" déplacements restants");
	    			}
	    		}		
	    	);
		bas.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				//fonction de deplacement
	    				Systeme.getSystem().deplacement("bas");
	    				//nbDeplacementRestant.setText(syst.getNbDeplacementRestant()+" déplacements restants");
	    				
	    			}
	    		}		
	    	);
	
		haut.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				//fonction de deplacement
	    				Systeme.getSystem().deplacement("haut");
	    				//nbDeplacementRestant.setText(syst.getNbDeplacementRestant()+" déplacements restants");
	    				
	    			}
	    		}		
	    	);
	}
	
	
	
	
}