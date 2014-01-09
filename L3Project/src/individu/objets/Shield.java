package individu.objets;

/**
 * The Class Shield.
 */
public class Shield extends Gear{
	
/** The Constant serialVersionUID. */
private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new shield.
	 *
	 * @param nom the nom
	 * @param image the image
	 * @param boostA the boost a
	 * @param boostB the boost b
	 * @param durabilite the durabilite
	 */
	public Shield (String nom,String image,int boostA, int boostB, int durabilite)
	{
		super(nom,image,boostA,boostB,durabilite,-3);
	}
	
	/**
	 * Instantiates a new shield.
	 *
	 * @param nom the nom
	 * @param boostA the boost a
	 * @param boostB the boost b
	 * @param durabilite the durabilite
	 */
	public Shield (String nom,int boostA, int boostB, int durabilite)
	{
		super(nom,"image/Items/Long Sword.jpg",boostA,boostB,durabilite,0);
	}

}
