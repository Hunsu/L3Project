/**
 * 
 */
package individu;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * The Class Element.
 *
 * @author  meradi
 */
public class Element implements IElement, Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The nom. @uml.property  name="nom" */
	private String nom;                                                      //le nom de l'element
	
	/** The vie. @uml.property  name="vie" */
	private int vie;                                                         //le nombre de vies de l'element
	
	/** The elements connus. @uml.property  name="elementsConnus" @uml.associationEnd  multiplicity="(0 -1)" elementType="java.lang.Integer" */
	private ArrayList<Integer> elementsConnus = new ArrayList<Integer>();    //les references des elements avec lesquels on a joue
	
	/** The image. @uml.property  name="image" */
	protected String image;
	
	/**
	 * Constructeur.
	 *
	 * @param nom le nom de l'element a creer
	 * le nombre de vie est par defaut initialise a 1
	 */
	public Element(String nom){
		this.nom = nom;
		this.vie = 1;
	}
	
	/**
	 * Constructeur.
	 *
	 * @param nom le nom le l'element a creer
	 * @param vie le nombre de vies initiales
	 */
	public Element(String nom, int vie) {
		this.nom = nom;
		this.vie = vie;
	}

	/**
	 * Gets the nom.
	 *
	 * @return the nom
	 * @uml.property  name="nom"
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Gets the vie.
	 *
	 * @return the vie
	 * @uml.property  name="vie"
	 */
	public int getVie() {
		return this.vie;
	}

	/**
	 * Sets the vie.
	 *
	 * @param vie the new vie
	 * @uml.property  name="vie"
	 */
	public void setVie(int vie){
		this.vie = vie;
	}
	
	/**
	 * Gets the elements connus.
	 *
	 * @return the elements connus
	 * @uml.property  name="elementsConnus"
	 */
	public ArrayList<Integer> getElementsConnus() {
		return this.elementsConnus;
	}

	/* (non-Javadoc)
	 * @see individu.IElement#ajouterConnu(int)
	 */
	public void ajouterConnu(int ref) {
		elementsConnus.add(ref);		
	}
	
	/**
	 * Gets the image.
	 *
	 * @return the image
	 * @uml.property  name="image"
	 */
	public String getImage(){
		return this.image;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return this.getNom()+"["+this.getVie()+"]";
	}

}
