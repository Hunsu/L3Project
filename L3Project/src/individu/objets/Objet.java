package individu.objets;

import individu.Element;

import java.io.Serializable;

/**
 * The Class Objet.
 */
public class Objet extends Element implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The boost a. @uml.property  name="boostA" */
	protected int boostA;
	
	/** The boost d. @uml.property  name="boostD" */
	protected int boostD;
	
	/** The boost v. @uml.property  name="boostV" */
	protected int boostV;
	
	/**
	 * Instantiates a new objet.
	 *
	 * @param name the name
	 */
	public Objet(String name){
		super(name);
		setVie(1);
	}
	
	/**
	 * Gets the boost a.
	 *
	 * @return the boost a
	 * @uml.property  name="boostA"
	 */
	public int getBoostA() {
		return boostA;
	}
	
	/**
	 * Gets the boost d.
	 *
	 * @return the boost d
	 * @uml.property  name="boostD"
	 */
	public int getBoostD() {
		return boostD;
	}
	
	/**
	 * Gets the boost v.
	 *
	 * @return the boost v
	 * @uml.property  name="boostV"
	 */
	public int getBoostV(){
		return boostV;
	}
}
