package individu;

import org.objets.Dagger;;

public class Assassin extends Element {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Assassin(String name, String image, int argent){
		super(name,image,argent,5);
		this.setAttaque(80);
		this.setDefense(50);
		this.setVitesse(60);
		this.addObjet(new Dagger("Stiletto","image",20,30,10));
	}
	

}