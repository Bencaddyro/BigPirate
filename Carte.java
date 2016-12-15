
import java.awt.GridLayout;

import javax.swing.JPanel;


public class Carte extends JPanel {
	
	private int n=12;
	
	
	public Carte(){
		this.setLayout(new GridLayout(n,n));
		VueCase tmp;
		for(int i=n-1;i>-1;i--){
			for(int j=0;j<n;j++){
				tmp=new VueCase(Systeme.getSystem().getGrille()[j][i]);
				this.add(tmp);
				Systeme.getSystem().getGrille()[j][i].registerObserver(tmp);
				}
			}
	}	
}
