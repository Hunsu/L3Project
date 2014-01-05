package org.personnage;

import java.io.Serializable;
import java.util.ArrayList;

import org.objets.Objet;

public abstract class Personnage implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int attaque;
	private int defense;
	private int argent;
	private String image;
	private int vie;
	ArrayList<Objet> equipements;
	private ArrayList<Integer> elementsConnus = new ArrayList<Integer>(); 

	public Personnage(String name, String image) {
		this.name = name;
		this.image = image;
		vie = 1;
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
	
	public void addObjet(Objet objet){
		this.equipements.add(objet);
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
	
	public int getVie() {
		return vie;
	}


	public void ajouterConnu(int ref) {
		elementsConnus.add(ref);
		
	}
	
	public String toString(){
		return this.getName()+"["+this.getVie()+"]";
	}
	
	

}
