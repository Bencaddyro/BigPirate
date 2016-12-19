import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class CroixDirection extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JButton haut=new JButton(new ImageIcon(getClass().getResource("img/up-arrow.png")));
	private JButton bas=new JButton(new ImageIcon(getClass().getResource("img/bottom-arrow.png")));
	private JButton droite=new JButton(new ImageIcon(getClass().getResource("img/right-arrow.png")));
	private JButton gauche=new JButton(new ImageIcon(getClass().getResource("img/left-arrow.png")));
	
	public CroixDirection(){
		super(new GridBagLayout());		
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		c.gridx=2;
		c.gridy=1;
		c.gridwidth = 1;
		c.gridheight = 1;
		this.add(droite,c);
		c.gridx=0;
		c.gridy=1;
		c.gridwidth = 1;
		c.gridheight = 1;
		this.add(gauche,c);
		c.gridx=1;
		c.gridy=2;
		c.gridwidth = 1;
		c.gridheight = 1;
		this.add(bas,c);
		c.gridx=1;
		c.gridy=0;
		c.gridwidth = 1;
		c.gridheight = 1;
		this.add(haut,c);
		
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
