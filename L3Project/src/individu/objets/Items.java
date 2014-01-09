package individu.objets;

/**
 * The Class Items.
 */
public class Items extends Objet{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The classe. @uml.property  name="classe" */
	private char classe;
	
	/**
	 * Instantiates a new items.
	 *
	 * @param name the name
	 * @param image the image
	 * @param boostA the boost a
	 * @param boostD the boost d
	 * @param boostV the boost v
	 * @param classe the classe
	 */
	public Items(String name, String image, int boostA, int boostD, int boostV, char classe){
		super(name);
		this.boostA=boostA;
		this.boostD=boostD;
		this.boostV=boostV;
		this.image=image;
		this.classe=classe;
	}
	
	/**
	 * Gets the classe.
	 *
	 * @return the classe
	 * @uml.property  name="classe"
	 */
	public char getClasse(){
		return this.classe;
	}
	
	/**
	 * Sets the boost a.
	 *
	 * @param boostA the new boost a
	 */
	public void setBoostA(int boostA){
		this.boostA=boostA;
	}
	
	/**
	 * Sets the boost d.
	 *
	 * @param boostD the new boost d
	 */
	public void setBoostD(int boostD){
		this.boostD=boostD;
	}
	
	/**
	 * Sets the boost v.
	 *
	 * @param boostV the new boost v
	 */
	public void setBoostV(int boostV){
		this.boostV=boostV;
	}

}
