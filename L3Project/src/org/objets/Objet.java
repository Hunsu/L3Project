package org.objets;

import java.io.Serializable;

public class Objet implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String image;
	private int force;
	
	public Objet(String name,String image, int force){
		this.name = name;
		this.image = image;
		this.force = force;
	}

	public String getImage() {
		return image;
	}

	public String getName() {
		return name;
	}

	public int getForce() {
		return force;
	}
}
