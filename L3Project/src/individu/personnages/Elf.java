package individu.personnages;

import individu.objets.Bow;


/**
 * The Class Elf.
 */
public class Elf extends Personnage {
	
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new elf.
	 *
	 * @param name the name
	 * @param image the image
	 */
	public Elf(String name, String image){
		super(name,image,15,90,10,40);
		this.addObjet(new Bow("Elfen Bow","image",20,0,40));
	}
	
	
	/**
	 * Instantiates a new elf.
	 *
	 * @param name the name
	 */
	public Elf(String name){
		super(name,"image/Players/Elf A.jpeg",15,90,10,40);
	}
	
}
