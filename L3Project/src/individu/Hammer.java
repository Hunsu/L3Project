package individu;

public class Hammer extends Gear{
	
private static final long serialVersionUID = 1L;
	
	public Hammer (String nom,String image,int boostA, int boostD, int durabilite)
	{
		super(nom,image,boostA,boostD,durabilite,-5);
	}
	
	public Hammer (String nom,int boostA, int boostB, int durabilite)
	{
		super(nom,"image/Items/Hammer.png",boostA,boostB,durabilite,0);
	}

}
