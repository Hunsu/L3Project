package individu;

import org.objets.Sword;

public class Mercenary extends Personnage {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Mercenary(String name, String image, int argent){
		super(name,image,argent,5);
		this.setAttaque(70);
		this.setDefense(60);
		this.setVitesse(30);
		this.addObject(new Sword("Long Sword","image",30,10,50));
		
	}

}