import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.AbstractCollection;
import java.util.HashSet;

import javax.imageio.ImageIO;


public abstract class Case {

	protected String path;
	protected Integer x;
	protected Integer y;
	protected AbstractCollection<Tresor> inventaire;
	protected AbstractCollection<Personnage> equipage;
	
	Case(Integer _x, Integer _y){
		x=_x;
		y=_y;
		inventaire=new HashSet<Tresor>();
		equipage=new HashSet<Personnage>();
	}
	public String getPath(){
		return path;
	}
	public Integer getX() {
		return x;
	}
	public Integer getY() {
		return y;
	}
	public AbstractCollection<Personnage> getEquipage() {
		return equipage;
	}
	public AbstractCollection<Tresor> getInventaire() {
		return inventaire;
	}
	
	public Boolean estValide(){
		return false;
	}
	public Boolean cocotierInter(){
		return false;
	}
	public Boolean cocotierExt(){
		return false;
	}
	public Tresor tresorPresent(){
		if(inventaire.isEmpty()){
			return null;
		}
		else{
			return inventaire.iterator().next();
		}
	}
	public Personnage moussaillonPresent(){
		if(equipage.isEmpty()){
			return null;
		}
		else{
			return equipage.iterator().next();
		}
	}
	
	public static void main(String[] args) {
		try {
			Image img=ImageIO.read(new File ("src/fond.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("houhou");
		}

		
		
	}
	
}
