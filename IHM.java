import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class IHM extends JFrame{

	private static final long serialVersionUID = 1L;

	static int n=12;
	
	private JPanel menu=new JPanel(new CardLayout());
	private JPanel carte;
	private String MENUPIRATE="Menu Pirate";
	private String MENUFANTOME="Menu Fantome";
	private String MENUPRINCIPAL="Menu Principal";
	
	public IHM(){

		super("BigPirate");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(980,760));
		this.setLayout(new BorderLayout());
		
		//Representation du plateau
		carte=new Carte();
		this.getContentPane().add(carte,BorderLayout.CENTER);
		
		//Ajout du menu principal
		VueMenuPrincipal menuPrincipal=new VueMenuPrincipal();
		menu.add(menuPrincipal,MENUPRINCIPAL);
				
		this.getContentPane().add(menu,BorderLayout.WEST);
		
		this.printVue(MENUPRINCIPAL);
		this.setVisible(true);
	}
	
	/**
	 * Remise a zéro de l'IHM et initialisation avec les paramètres du systeme
	 */
	public void resetIHM(){
		this.getContentPane().removeAll();
		carte=new Carte();
		this.getContentPane().add(carte,BorderLayout.CENTER);
		
		//Création des vues des moussaillons
		VueMoussaillon tabVueMoussaillon[] = new VueMoussaillon[Systeme.getSystem().getNb_moussaillon()];
		
		for(int i=0;i<Systeme.getSystem().getNb_moussaillon();i++){
			tabVueMoussaillon[i]=new VueMoussaillon(Systeme.getSystem().getCollection_personnage()[i+2]);
			menu.add(tabVueMoussaillon[i], "Menu Moussaillon "+(i+1));
		}

		//Création des vues du pirate et fantome
		VuePirate menuPirate=new VuePirate(Systeme.getSystem().getCollection_personnage()[0]);
		VueFantome menuFantome=new VueFantome(Systeme.getSystem().getCollection_personnage()[1]);
		VueMenuPrincipal menuPrincipal=new VueMenuPrincipal();
				
		menu.add(menuPirate, MENUPIRATE);
		menu.add(menuFantome, MENUFANTOME);
		menu.add(menuPrincipal,MENUPRINCIPAL);
		
		this.getContentPane().add(menu,BorderLayout.WEST);
		
		this.printVue(MENUPRINCIPAL);
	}
	
	/**
	 * Cette methode affiche simplement la vue désirée sur l'IHM en changeant le CardLayout menu
	 * @see VueJoueur
	 * 
	 * @param vue 
	 */
	public void printVue(String vue){
		((CardLayout) menu.getLayout()).show(menu,vue);
	}
}
