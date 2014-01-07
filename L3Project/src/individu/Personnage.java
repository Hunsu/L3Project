package individu;

import java.io.Serializable;
import java.util.ArrayList;

import org.objets.Objet;

public abstract class Personnage extends Element implements Serializable, ICombattant{
	
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
	ArrayList<Integer> Referencesequipements;
	ArrayList<Objet> equipements;
	private ArrayList<Integer> personnagesConnus = new ArrayList<Integer>(); 

	public Personnage(String name, String image, int argent,int vie) {
		super(name,image);
		this.image = image;
		this.argent=argent;
		this.vie = vie;
		Referencesequipements = new ArrayList<Integer>();
		equipements = new ArrayList<Objet>();
		
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
	
	public void ramasser(int ref) {
		this.Referencesequipements.add(ref);
		
	}
	
	public void perdre(int s){
		this.argent -= s;
		if(s <0)
			argent = 0;
	}
	
	public void gagner(int s){
		this.argent += s;
	}
	
	public void addObject(Objet objet){
		this.equipements.add(objet);
	}
	
	

}
