package individu;

import java.io.Serializable;
import java.util.ArrayList;

import org.objets.Objet;

public abstract class Personnage implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int vitesse;
	private int attaque;
	private int defense;
	private int argent;
	private String image;
	private int vie;
	ArrayList<Objet> equipements;
	private ArrayList<Integer> personnagesConnus = new ArrayList<Integer>(); 

	public Personnage(String name, String image, int argent) {
		this.name = name;
		this.image = image;
		this.argent=argent;
		vie = 1;
		equipements = new ArrayList<Objet>();
		
	}
	
	public void addObjet(Objet objet){
		this.equipements.add(objet);
	}
	
	public String getName(){
		return name;
	}
	
	public int getAttaque(){
		return attaque;
	}
	
	public int getDefense(){
		return defense;
	}
	
	public int getArgent(){
		return argent;
	}
	
	public String getImage(){
		return this.image;
	}
	
	public int getVie() {
		return vie;
	}
	
	public int getVitesse() {
		return vitesse;
	}
	
	
	public void setAttaque(int attaque){
		this.attaque =attaque;
	}

	public void setDefense(int defense){
		this.defense = defense;
	}
	
	public void setArgent(int argent){
		this.argent = argent;
	}


	public void setVie(int vie){
		this.vie = vie;
	}
	
	
	public void setVitesse(int vitesse){
		this.vitesse = vitesse;
	}


	public void ajouterConnu(int ref) {
		personnagesConnus.add(ref);
		
	}
	
	public String toString(){
		return this.getName()+"["+this.getVie()+"]";
	}
	
	

}