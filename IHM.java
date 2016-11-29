
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IHM extends JFrame{
	static int n=12;
	final JPanel menu=new JPanel(new CardLayout());
	final static String MENUMOUSSAILLON1="Menu Moussaillon 1";
	final static String MENUMOUSSAILLON2="Menu Moussaillon 2";
	final static String MENUMOUSSAILLON3="Menu Moussaillon 3";
	final static String MENUPIRATE="Menu Pirate";
	final static String MENUFANTOME="Menu Fantome";
	JPanel machin;
	Systeme syst;
	
	public IHM(final Systeme syst){

		super("BigPirate");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(800,800));
		this.setLayout(new BorderLayout());
		this.syst=syst;
		machin=new Carte(syst);
		
		
		this.getContentPane().add(machin,BorderLayout.CENTER);
				
		
		JPanel bottom=new JPanel(new BorderLayout());
		JPanel direction =new JPanel(new BorderLayout());
		final JPanel de=new JPanel(new BorderLayout());
		JButton finDuTour=new JButton("Fin du tour");
		
		//Déclaration des vues/menus
		vueMoussaillon menuMoussaillon1=new vueMoussaillon("Moussaillon1",syst);
		vueMoussaillon menuMoussaillon2=new vueMoussaillon("Moussaillon2",syst);
		vueMoussaillon menuMoussaillon3=new vueMoussaillon("Moussaillon3",syst);
		JPanel menuPirate=new JPanel();
		JPanel menuFantome=new JPanel();
		
		
		JLabel text =new JLabel("Menu info & kotopo kotopo");


		JButton lancerDe=new JButton("Lance le dé!");
		de.add(lancerDe,BorderLayout.NORTH);
		final JLabel resultDe=new JLabel("En attente du résultat");
		de.add(resultDe,BorderLayout.CENTER);
		
		menuPirate.add(new JLabel("Menu Pirate"));
		menuFantome.add(new JLabel("Menu Fantome"));
		
		menu.add(menuMoussaillon1, MENUMOUSSAILLON1);
		menu.add(menuMoussaillon2, MENUMOUSSAILLON2);
		menu.add(menuMoussaillon3, MENUMOUSSAILLON3);
		menu.add(menuPirate, MENUPIRATE);
		menu.add(menuFantome, MENUFANTOME);
		
		JButton haut=new JButton("Haut"),bas=new JButton("Bas"),droite=new JButton("Droite"),gauche=new JButton("Gauche");
		
		direction.add(droite, BorderLayout.EAST);
		direction.add(gauche, BorderLayout.WEST);
		direction.add(bas, BorderLayout.SOUTH);
		direction.add(haut, BorderLayout.NORTH);
		
		bottom.add(direction, BorderLayout.WEST);
		bottom.add(menu, BorderLayout.EAST);
		bottom.add(de,BorderLayout.CENTER);
		bottom.add(finDuTour,BorderLayout.SOUTH);
		
		gauche.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				//fonction de deplacement
	    				//((CardLayout) menu.getLayout()).next(menu);
	    				syst.deplacement("gauche");
	    			}
	    		}		
	    	);
		droite.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				//fonction de deplacement
	    				//CardLayout cl = (CardLayout)(menu.getLayout());
	    				//cl.first(menu);
	    				syst.deplacement("droite");
	    			}
	    		}		
	    	);
		bas.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				//fonction de deplacement
	    				syst.deplacement("bas");
	    				
	    			}
	    		}		
	    	);

		haut.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				//fonction de deplacement
	    				syst.deplacement("haut");
	    				
	    			}
	    		}		
	    	);
		lancerDe.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				//fonction de deplacement
	    				syst.getPersonnageCourant().lancerDe();
	    			}
	    		}		
	    	);

		finDuTour.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent e){
	    				//fonction de deplacement
	    				System.out.println("Fin du tour de " + syst.getPersonnageCourant().toString());
	    				syst.finDeTour();
	    			}
	    		}		
	    	);
		

		
		this.getContentPane().add(bottom,BorderLayout.SOUTH);		
		this.setVisible(true);
	}
	
	public void printVue(String vue){
		((CardLayout) menu.getLayout()).show(menu,vue);
	}

	public void maj(){
		this.remove(machin);
		machin=new Carte(syst);
		this.getContentPane().add(machin,BorderLayout.CENTER);
		this.validate();
		System.out.println("Maj IHM");
	}
}
