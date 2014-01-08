package individu;

public class Dagger extends Gear{

	private static final long serialVersionUID = 1L;
	
	public Dagger (String nom,String image,int boostA, int boostB, int durabilite)
	{
		super(nom,image,boostA,boostB,durabilite,0);
	}
	
	public Dagger (String nom,int boostA, int boostB, int durabilite)
	{
		super(nom,"image/Items/Stiletto.png",boostA,boostB,durabilite,0);
	}

}
