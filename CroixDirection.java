import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class CroixDirection extends JPanel {
	
	private JButton haut=new JButton(new ImageIcon("src/up-arrow.png"));
	private JButton bas=new JButton(new ImageIcon("src/bottom-arrow.png"));
	private JButton droite=new JButton(new ImageIcon("src/right-arrow.png"));
	private JButton gauche=new JButton(new ImageIcon("src/left-arrow.png"));
	
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
	    			}
	    		}		
	    	);
		droite.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				Systeme.getSystem().deplacement("droite");
	    			}
	    		}		
	    	);
		bas.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				Systeme.getSystem().deplacement("bas");
	    			}
	    		}		
	    	);
	
		haut.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				Systeme.getSystem().deplacement("haut");
	    			}
	    		}		
	    	);
	}
}
