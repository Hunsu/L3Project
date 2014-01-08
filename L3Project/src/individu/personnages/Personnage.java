package individu.personnages;

import individu.Element;
import individu.ICombattant;
import individu.objets.Objet;

import java.util.ArrayList;

public class Personnage extends Element implements ICombattant{
	
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property  name="vitesse"
	 */
	private int vitesse;
	/**
	 * @uml.property  name="attaque"
	 */
	private int attaque;
	/**
	 * @uml.property  name="defense"
	 */
	private int defense;
	/**
	 * @uml.property  name="argent"
	 */
	private int argent;
	/**
	 * @uml.property  name="equipements"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="individu.Objet"
	 */
	ArrayList<Objet> equipements;
	/**
	 * @uml.property  name="referencesEquipements"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="java.lang.Integer"
	 */
	private ArrayList<Integer> referencesEquipements; 	
	
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
	
	public void gagner(int a){
		this.argent+=a;
	}
	
	public void perdre(int a){
		this.argent-=a;
	}
	
	public void ramasser(int ref){
		this.referencesEquipements.add(ref);
	}
	
	public void addObjet(Objet objet){
		this.equipements.add(objet);
	}
	
	public void addRef(int ref){
		this.referencesEquipements.add(ref);
	}
	
	/**
	 * @return
	 * @uml.property  name="attaque"
	 */
	public int getAttaque(){
		return attaque;
	}
	
	/**
	 * @return
	 * @uml.property  name="defense"
	 */
	public int getDefense(){
		return defense;
	}
	
	/**
	 * @return
	 * @uml.property  name="argent"
	 */
	public int getArgent(){
		return argent;
	}
	
	/**
	 * @return
	 * @uml.property  name="vitesse"
	 */
	public int getVitesse() {
		return vitesse;
	}
	
	/**
	 * @param attaque
	 * @uml.property  name="attaque"
	 */
	public void setAttaque(int attaque){
		this.attaque =attaque;
	}

	/**
	 * @param defense
	 * @uml.property  name="defense"
	 */
	public void setDefense(int defense){
		this.defense = defense;
	}
	
	/**
	 * @param argent
	 * @uml.property  name="argent"
	 */
	public void setArgent(int argent){
		this.argent = argent;
	}
	
	/**
	 * @param vitesse
	 * @uml.property  name="vitesse"
	 */
	public void setVitesse(int vitesse){
		this.vitesse = vitesse;
	}

}
