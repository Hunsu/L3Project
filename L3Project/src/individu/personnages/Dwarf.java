package individu.personnages;

import individu.objets.Hammer;


/**
 * The Class Dwarf.
 */
public class Dwarf extends Personnage {
	
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new dwarf.
	 *
	 * @param name the name
	 * @param image the image
	 */
	public Dwarf(String name, String image){
		super(name,image,8,40,90,20);
		this.addObjet(new Hammer("DHammer","",30,10,20));
	}
	
	/**
	 * Instantiates a new dwarf.
	 *
	 * @param name the name
	 */
	public Dwarf(String name){
		super(name,"image/Players/Dwarf A.jpeg",8,40,90,20);
	}
	

	
}