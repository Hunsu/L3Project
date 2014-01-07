package org.objets;

import java.io.Serializable;

public class Objet implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String image;
	protected int boostA;
	protected int boostD;
	protected int boostV;
	
	public Objet(String name,String image, int attaque, int defence, int vitesse){
		this.name = name;
		this.image = image;
		this.boostA= attaque;
		this.boostD= defence;
		this.boostV=vitesse;
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
	
	public int getBoostD() {
		return boostD;
	}
	
	public int getBoostV(){
		return boostV;
	}
}
