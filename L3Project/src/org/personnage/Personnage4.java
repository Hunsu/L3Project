package org.personnage;

import org.objets.Objet;

public class Personnage4 extends Personnage {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Personnage4(String name, String image){
		super(name,image);
		init();
	}

	private void init() {
		this.setArgent(100);
		this.setAttaque(40);
		this.setDefense(4);
		this.addObjet(new Objet("Har","image",20));
		
	}
	

}