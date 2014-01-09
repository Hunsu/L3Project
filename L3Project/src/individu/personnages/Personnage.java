package individu.personnages;

import individu.Element;
import individu.ICombattant;
import individu.objets.Objet;

import java.util.ArrayList;

/**
 * The Class Personnage.
 */
public class Personnage extends Element implements ICombattant{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The vitesse. @uml.property  name="vitesse" */
	private int vitesse;
	
	/** The attaque. @uml.property  name="attaque" */
	private int attaque;
	
	/** The defense. @uml.property  name="defense" */
	private int defense;
	
	/** The argent. @uml.property  name="argent" */
	private int argent;
	
	/** The equipements. @uml.property  name="equipements" @uml.associationEnd  multiplicity="(0 -1)" elementType="individu.Objet" */
	ArrayList<Objet> equipements;
	
	/** The references equipements. @uml.property  name="referencesEquipements" @uml.associationEnd  multiplicity="(0 -1)" elementType="java.lang.Integer" */
	private ArrayList<Integer> referencesEquipements; 	
	
	/**
	 * Instantiates a new personnage.
	 *
	 * @param nom the nom
	 * @param image the image
	 * @param vie the vie
	 * @param attaque the attaque
	 * @param defence the defence
	 * @param vitesse the vitesse
	 */
	public Personnage(String nom,String image, int vie,int attaque,int defence,int vitesse){
		super(nom,vie);
		this.attaque=attaque;
		this.defense=defence;
		this.vitesse=vitesse;
		this.image=image;
		this.argent=100;
		referencesEquipements = new ArrayList<Integer>();
        equipements = new ArrayList<Objet>();
	}
	
	/* (non-Javadoc)
	 * @see individu.ICombattant#gagner(int)
	 */
	public void gagner(int a){
		this.argent+=a;
	}
	
	/* (non-Javadoc)
	 * @see individu.ICombattant#perdre(int)
	 */
	public void perdre(int a){
		this.argent-=a;
	}
	
	/* (non-Javadoc)
	 * @see individu.ICombattant#ramasser(int)
	 */
	public void ramasser(int ref){
		this.referencesEquipements.add(ref);
	}
	
	/**
	 * Adds the objet.
	 *
	 * @param objet the objet
	 */
	public void addObjet(Objet objet){
		this.equipements.add(objet);
	}
	
	/**
	 * Adds the ref.
	 *
	 * @param ref the ref
	 */
	public void addRef(int ref){
		this.referencesEquipements.add(ref);
	}
	
	/**
	 * Gets the attaque.
	 *
	 * @return the attaque
	 * @uml.property  name="attaque"
	 */
	public int getAttaque(){
		return attaque;
	}
	
	/**
	 * Gets the defense.
	 *
	 * @return the defense
	 * @uml.property  name="defense"
	 */
	public int getDefense(){
		return defense;
	}
	
	/**
	 * Gets the argent.
	 *
	 * @return the argent
	 * @uml.property  name="argent"
	 */
	public int getArgent(){
		return argent;
	}
	
	/**
	 * Gets the vitesse.
	 *
	 * @return the vitesse
	 * @uml.property  name="vitesse"
	 */
	public int getVitesse() {
		return vitesse;
	}
	
	/**
	 * Sets the attaque.
	 *
	 * @param attaque the new attaque
	 * @uml.property  name="attaque"
	 */
	public void setAttaque(int attaque){
		this.attaque =attaque;
	}

	/**
	 * Sets the defense.
	 *
	 * @param defense the new defense
	 * @uml.property  name="defense"
	 */
	public void setDefense(int defense){
		this.defense = defense;
	}
	
	/**
	 * Sets the argent.
	 *
	 * @param argent the new argent
	 * @uml.property  name="argent"
	 */
	public void setArgent(int argent){
		this.argent = argent;
	}
	
	/**
	 * Sets the vitesse.
	 *
	 * @param vitesse the new vitesse
	 * @uml.property  name="vitesse"
	 */
	public void setVitesse(int vitesse){
		this.vitesse = vitesse;
	}

}
