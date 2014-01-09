package individu.objets;

/**
 * The Class Gear.
 */
public class Gear extends Objet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new gear.
	 *
	 * @param name the name
	 * @param image the image
	 * @param boostA the boost a
	 * @param boostD the boost d
	 * @param durabilite the durabilite
	 * @param boostV the boost v
	 */
	public Gear(String name, String image, int boostA, int boostD, int durabilite, int boostV){
		super(name);
		this.image = image;
		this.boostA=boostA;
		this.boostD=boostD;
		this.boostV=boostV;
		this.setVie(durabilite);
	}
	
	
	
}
