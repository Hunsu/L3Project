package individu;


public class Mercenary extends Personnage {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Mercenary(String name, String image){
		super(name,image,5,70,60,30);
		this.addObjet(new Sword("Long Sword","",30,10,50));
		
	}
	
	public Mercenary(String name){
		super(name,"image/Players/Mercenary.jpeg",5,70,60,30);
	}

}