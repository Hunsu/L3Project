package org.objets;

import individu.Element;

import java.io.Serializable;

public class Objet extends Element implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String image;
	private int boostA;
	private int boostD;
	private int boostV;
	
	public Objet(String name,String image, int attaque, int defence){
		super(name,-1);
		this.name = name;
		this.image = image;
		this.boostA= attaque;
		this.boostD= defence;
		this.boostV = 0;
	}

	public Objet(String name, String image, int boostA, int boostD,
			int vitesse) {
		super(name,image);
		this.boostA = boostA;
		this.boostD = boostD;
		this.boostV = vitesse;
	}

	public String getImage() {
		return image;
	}

	public String getName() {
		return name;
	}

	public int getBoostA() {
		return boostA;
	}
	
	public int getBoostB() {
		return boostD;
	}

	public int getVitesse() {
		return boostV;
	}
}
