import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class VueCase extends JPanel implements Observer{

	private static final long serialVersionUID = 1L;
	private BufferedImage image;
    private Case c;

	public VueCase(Case c){
		super();
		this.c=c;
		try {
            image = ImageIO.read(getClass().getResource(c.getPath()));

        } catch (IOException ioe) {
            System.out.println("Impossible d'ouvrir l'image");
        }		
	}
	/**
	 * Surcharge de paintComponent, pour permettre la superposition des différentes images de personnage
	 */
	public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image,0,0,this);
        if(!c.getInventaire().isEmpty()){
        	BufferedImage imageTresor=null;
        		try {
        			imageTresor = ImageIO.read(getClass().getResource(c.getInventaire().iterator().next().getPath()));
        		} catch (IOException ioe) {
        			System.out.println("Impossible d'ouvrir l'image");
	            }
        	g.drawImage(imageTresor,0,0,this);
        }

        if(!c.getEquipage().isEmpty()){
        	BufferedImage imageEquipage=null;
        	Iterator<Personnage> it=c.getEquipage().iterator();
        	for(int i=0;i<c.getEquipage().size();i++){        	
	    		try {
	                imageEquipage = ImageIO.read(getClass().getResource(it.next().getPath()));
	            } catch (IOException ioe) {
	            	System.out.println("Impossible d'ouvrir l'image");
	            }
	    		g.drawImage(imageEquipage,0,0,this);
    		}
        }
    }
	
	/**
	 * On signal un changement dans le Container et on le re-affiche
	 */
	public void update(Observable o, Object arg) {
		this.repaint();
	}
}
