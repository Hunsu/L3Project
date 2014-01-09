package individu.objets;

/**
 * The Class Hammer.
 */
public class Hammer extends Gear{
	
/** The Constant serialVersionUID. */
private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new hammer.
	 *
	 * @param nom the nom
	 * @param image the image
	 * @param boostA the boost a
	 * @param boostD the boost d
	 * @param durabilite the durabilite
	 */
	public Hammer (String nom,String image,int boostA, int boostD, int durabilite)
	{
		super(nom,image,boostA,boostD,durabilite,-5);
	}
	
	/**
	 * Instantiates a new hammer.
	 *
	 * @param nom the nom
	 * @param boostA the boost a
	 * @param boostB the boost b
	 * @param durabilite the durabilite
	 */
	public Hammer (String nom,int boostA, int boostB, int durabilite)
	{
		super(nom,"image/Items/Hammer.png",boostA,boostB,durabilite,0);
	}

}
