package org.objets;

public class Shield extends Gear{
	
private static final long serialVersionUID = 1L;
	
	public Shield (String nom,String image,int boostA, int boostB, int durabilite)
	{
		super(nom,image,boostA,boostB,durabilite,-3);
	}

}
