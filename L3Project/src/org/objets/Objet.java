package org.objets;

import java.io.Serializable;

public class Objet implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String image;
	private int boostA;
	private int boostD;
	
	public Objet(String name,String image, int attaque, int defence){
		this.name = name;
		this.image = image;
		this.boostA= attaque;
		this.boostD= defence;
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
}
