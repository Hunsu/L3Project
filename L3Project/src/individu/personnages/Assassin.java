package individu.personnages;


/**
 * The Class Assassin.
 */
public class Assassin extends Personnage {
	
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new assassin.
	 *
	 * @param name the name
	 * @param image the image
	 */
	public Assassin(String name, String image){
		super(name,image,5,120,50,30);
	}
	
	/**
	 * Instantiates a new assassin.
	 *
	 * @param name the name
	 */
	public Assassin(String name){
		super(name,"image/Players/Assassin.jpeg",5,80,50,60);
	}
	

}