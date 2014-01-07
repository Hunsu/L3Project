package org.objets;

public class Hammer extends Gear{
	
private static final long serialVersionUID = 1L;
	
	public Hammer (String nom,String image,int boostA, int boostB, int durabilite)
	{
		super(nom,image,boostA,boostB,durabilite,-5);
	}

}
