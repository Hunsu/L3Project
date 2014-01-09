package individu.personnages;


/**
 * The Class Mage.
 */
public class Mage extends Personnage {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new mage.
	 *
	 * @param name the name
	 * @param image the image
	 */
	public Mage(String name,String image){
		super(name,image,10,90,60,20);
		
	}
	
	/**
	 * Instantiates a new mage.
	 *
	 * @param name the name
	 */
	public Mage(String name){
		super(name,"image/Players/Black Mage.jpg",10,90,60,20);
	}

}
