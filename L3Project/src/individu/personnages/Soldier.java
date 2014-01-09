package individu.personnages;

import individu.objets.Sword;


/**
 * The Class Soldier.
 */
public class Soldier extends Personnage {
	
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new soldier.
	 *
	 * @param name the name
	 * @param image the image
	 * @param argent the argent
	 */
	public Soldier(String name, String image, int argent){
		super(name,image,5,80,60,40);
		this.addObjet(new Sword("Military Long Sword","image",40,10,50));
	}
	
	/**
	 * Instantiates a new soldier.
	 *
	 * @param name the name
	 */
	public Soldier(String name){
		super(name,"image/Players/Soldier A.jpeg",5,80,60,40);
	}

}