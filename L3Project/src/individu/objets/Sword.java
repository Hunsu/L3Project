package individu.objets;

public class Sword extends Gear {
	
	private static final long serialVersionUID = 1L;
	
	public Sword (String nom,String image,int boostA, int boostB, int durabilite)
	{
		super(nom,image,boostA,boostB,durabilite,0);
	}
	
	public Sword (String nom,int boostA, int boostB, int durabilite)
	{
		super(nom,"image/Items/Military Long Sword.jpg",boostA,boostB,durabilite,0);
	}

}
