
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
	
	JPanel menu=new JPanel(new CardLayout());
	JPanel carte;
	String MENUMOUSSAILLON1="Menu Moussaillon 1";
	String MENUMOUSSAILLON2="Menu Moussaillon 2";
	String MENUMOUSSAILLON3="Menu Moussaillon 3";
	String MENUPIRATE="Menu Pirate";
	String MENUFANTOME="Menu Fantome";
	String MENUPRINCIPAL="Menu Principal";
	
	public IHM(){

		super("BigPirate");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(1000,800));
		this.setLayout(new BorderLayout());
		
		//interface visualisation plateau
		carte=new Carte();
		this.getContentPane().add(carte,BorderLayout.CENTER);
				
		
		//Déclaration des vues/menus
		VueMoussaillon menuMoussaillon1=new VueMoussaillon(Systeme.getSystem().getCollection_personnage()[2]);
		VueMoussaillon menuMoussaillon2=new VueMoussaillon(Systeme.getSystem().getCollection_personnage()[3]);
		VueMoussaillon menuMoussaillon3=new VueMoussaillon(Systeme.getSystem().getCollection_personnage()[4]);
		

		
		VuePirate menuPirate=new VuePirate(Systeme.getSystem().getCollection_personnage()[0]);
		VueFantome menuFantome=new VueFantome(Systeme.getSystem().getCollection_personnage()[1]);
		VueMenuPrincipal menuPrincipal=new VueMenuPrincipal();
		
		Systeme.getSystem().getCollection_personnage()[0].registerObserver(menuPirate);
		Systeme.getSystem().getCollection_personnage()[1].registerObserver(menuFantome);
		
		
		//interface commande des joueurs
		
		
		menu.add(menuMoussaillon1, MENUMOUSSAILLON1);
		menu.add(menuMoussaillon2, MENUMOUSSAILLON2);
		menu.add(menuMoussaillon3, MENUMOUSSAILLON3);
		menu.add(menuPirate, MENUPIRATE);
		menu.add(menuFantome, MENUFANTOME);
		menu.add(menuPrincipal,MENUPRINCIPAL);
		
		
		
		this.getContentPane().add(menu,BorderLayout.WEST);		
		this.setVisible(true);
	}
	
	public void printVue(String vue){
		((CardLayout) menu.getLayout()).show(menu,vue);
	}


}
