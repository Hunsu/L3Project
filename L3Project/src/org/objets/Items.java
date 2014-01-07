package org.objets;

public class Items extends Objet{
	
	private static final long serialVersionUID = 1L;
	private char classe;
	
	public Items(String name, String image, int boostA, int boostB, int vitesse, char classe){
		super(name,image,boostA,boostB,vitesse);
		this.classe=classe;
	}
	
	public char getClasse(){
		return this.classe;
	}
	
	public void setBoostA(int boostA){
		this.setBoostA(boostA);
	}
	
	public void setBoostD(int boostD){
		this.setBoostD(boostD);
	}
	
	public void setBoostV(int boostV){
		this.setBoostV(boostV);
	}

}
