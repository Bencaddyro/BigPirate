
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
	String MENUPIRATE="Menu Pirate";
	String MENUFANTOME="Menu Fantome";
	String MENUPRINCIPAL="Menu Principal";
	
	public IHM(){

		super("BigPirate");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(980,760));
		this.setLayout(new BorderLayout());
		
		//interface visualisation plateau
		carte=new Carte();
		this.getContentPane().add(carte,BorderLayout.CENTER);
				

		VueMenuPrincipal menuPrincipal=new VueMenuPrincipal();
				

		menu.add(menuPrincipal,MENUPRINCIPAL);
		
		
		
		this.getContentPane().add(menu,BorderLayout.WEST);
		
		this.printVue(MENUPRINCIPAL);
		
		
		this.setVisible(true);
	}
	
	
	public void resetIHM(){
		this.getContentPane().removeAll();
		carte=new Carte();
		this.getContentPane().add(carte,BorderLayout.CENTER);
		

		VueMoussaillon tabVueMoussaillon[] = new VueMoussaillon[Systeme.getSystem().getNb_moussaillon()];
		
		for(int i=0;i<Systeme.getSystem().getNb_moussaillon();i++){
			tabVueMoussaillon[i]=new VueMoussaillon(Systeme.getSystem().getCollection_personnage()[i+2]);
			menu.add(tabVueMoussaillon[i], "Menu Moussaillon "+(i+1));
		}

		
		VuePirate menuPirate=new VuePirate(Systeme.getSystem().getCollection_personnage()[0]);
		VueFantome menuFantome=new VueFantome(Systeme.getSystem().getCollection_personnage()[1]);
		VueMenuPrincipal menuPrincipal=new VueMenuPrincipal();
				
		//interface commande des joueurs
		
		
		menu.add(menuPirate, MENUPIRATE);
		menu.add(menuFantome, MENUFANTOME);
		menu.add(menuPrincipal,MENUPRINCIPAL);
		
		
		
		this.getContentPane().add(menu,BorderLayout.WEST);
		
		this.printVue(MENUPRINCIPAL);
	}
	
	/**
	 * Cette methode affiche simplement la vue d�sir�e sur l'IHM en changeant le CardLayout menu
	 * @see VueJoueur
	 * 
	 * @param vue 
	 */
	public void printVue(String vue){
		((CardLayout) menu.getLayout()).show(menu,vue);
	}


	public void setVictory(String s) {
		
		
	}


}
