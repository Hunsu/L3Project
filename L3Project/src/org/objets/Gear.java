package org.objets;

public class Gear extends Objet {
	
	private static final long serialVersionUID = 1L;
	private int durabilite;
	
	public Gear(String name, String image, int boostA, int boostB,int durabilite, int vitesse){
		super(name,image,boostA,boostB,vitesse);
		this.durabilite=durabilite;
	}
	
	public int getDurablite(){
		return this.durabilite;
	}

}
