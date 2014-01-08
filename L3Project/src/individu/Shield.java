package individu;

public class Shield extends Gear{
	
private static final long serialVersionUID = 1L;
	
	public Shield (String nom,String image,int boostA, int boostB, int durabilite)
	{
		super(nom,image,boostA,boostB,durabilite,-3);
	}
	
	public Shield (String nom,int boostA, int boostB, int durabilite)
	{
		super(nom,"image/Items/Long Sword.jpg",boostA,boostB,durabilite,0);
	}

}
