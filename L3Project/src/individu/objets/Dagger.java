package individu.objets;

/**
 * The Class Dagger.
 */
public class Dagger extends Gear{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new dagger.
	 *
	 * @param nom the nom
	 * @param image the image
	 * @param boostA the boost a
	 * @param boostB the boost b
	 * @param durabilite the durabilite
	 */
	public Dagger (String nom,String image,int boostA, int boostB, int durabilite)
	{
		super(nom,image,boostA,boostB,durabilite,0);
	}
	
	/**
	 * Instantiates a new dagger.
	 *
	 * @param nom the nom
	 * @param boostA the boost a
	 * @param boostB the boost b
	 * @param durabilite the durabilite
	 */
	public Dagger (String nom,int boostA, int boostB, int durabilite)
	{
		super(nom,"image/Items/Stiletto.png",boostA,boostB,durabilite,0);
	}

}
