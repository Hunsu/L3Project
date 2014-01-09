package individu.objets;

/**
 * The Class Sword.
 */
public class Sword extends Gear {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new sword.
	 *
	 * @param nom the nom
	 * @param image the image
	 * @param boostA the boost a
	 * @param boostB the boost b
	 * @param durabilite the durabilite
	 */
	public Sword (String nom,String image,int boostA, int boostB, int durabilite)
	{
		super(nom,image,boostA,boostB,durabilite,0);
	}
	
	/**
	 * Instantiates a new sword.
	 *
	 * @param nom the nom
	 * @param boostA the boost a
	 * @param boostB the boost b
	 * @param durabilite the durabilite
	 */
	public Sword (String nom,int boostA, int boostB, int durabilite)
	{
		super(nom,"image/Items/Military Long Sword.jpg",boostA,boostB,durabilite,0);
	}

}
