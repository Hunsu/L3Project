package individu.personnages;

import individu.objets.Sword;


/**
 * The Class Mercenary.
 */
public class Mercenary extends Personnage {
	
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new mercenary.
	 *
	 * @param name the name
	 * @param image the image
	 */
	public Mercenary(String name, String image){
		super(name,image,5,70,60,30);
		this.addObjet(new Sword("Long Sword","",30,10,50));
		
	}
	
	/**
	 * Instantiates a new mercenary.
	 *
	 * @param name the name
	 */
	public Mercenary(String name){
		super(name,"image/Players/Mercenary.jpeg",5,70,60,30);
	}

}