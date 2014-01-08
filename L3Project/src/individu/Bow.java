package individu;

public class Bow extends Gear{
	
private static final long serialVersionUID = 1L;
	
	public Bow (String nom,String image,int boostA, int boostB, int durabilite)
	{
		super(nom,image,boostA,boostB,durabilite,0);
	}
	
	public Bow (String nom,int boostA, int boostB, int durabilite)
	{
		super(nom,"image/Items/Elfen Bow.png",boostA,boostB,durabilite,0);
	}

}
