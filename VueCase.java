import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class VueCase extends JPanel implements Observer{

	private BufferedImage image;
    private Case c;

	public VueCase(Case c){
		super();
		this.c=c;
		try {
            image = ImageIO.read(new File(c.getPath()));

        } catch (IOException ioe) {
            System.out.println("Could not read in the pic");
            //System.exit(0);
        }		
	}
	
	public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image,0,0,this);
        if(!c.getInventaire().isEmpty()){
        	BufferedImage imageTresor=null;
        		try {
        			imageTresor = ImageIO.read(new File(c.getInventaire().iterator().next().getPath()));
        		} catch (IOException ioe) {
	                System.out.println("Could not read in the pic");
	            }
        	g.drawImage(imageTresor,0,0,this);
        }
        	
		
        if(!c.getEquipage().isEmpty()){
        	BufferedImage imageEquipage=null;
        	Iterator<Personnage> it=c.getEquipage().iterator();
        	for(int i=0;i<c.getEquipage().size();i++){        	
	    		try {
	                imageEquipage = ImageIO.read(new File(it.next().getPath()));
	            } catch (IOException ioe) {
	                System.out.println("Could not read in the pic");
	            }
	    		g.drawImage(imageEquipage,0,0,this);
    		}
        }
    }

	public void update(Observable o, Object arg) {
		this.repaint();
	}
}
