package org.objets;

public class Bow extends Gear{
	
private static final long serialVersionUID = 1L;
	
	public Bow (String nom,String image,int boostA, int boostB, int durabilite)
	{
		super(nom,image,boostA,boostB,durabilite,0);
	}

}
