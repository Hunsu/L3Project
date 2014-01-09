package individu.objets;

/**
 * The Class Bow.
 */
public class Bow extends Gear{
	
/** The Constant serialVersionUID. */
private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new bow.
	 *
	 * @param nom le nom de l'objet
	 * @param image son image
	 * @param boostA the boost a
	 * @param boostB the boost b
	 * @param durabilite sa durabilite
	 */
	public Bow (String nom,String image,int boostA, int boostB, int durabilite)
	{
		super(nom,image,boostA,boostB,durabilite,0);
	}
	
	/**
	 * Instantiates a new bow.
	 *
	 * @param nom the nom
	 * @param boostA the boost a
	 * @param boostB the boost b
	 * @param durabilite sa durabilite
	 */
	public Bow (String nom,int boostA, int boostB, int durabilite)
	{
		super(nom,"image/Items/Elfen Bow.png",boostA,boostB,durabilite,0);
	}

}
