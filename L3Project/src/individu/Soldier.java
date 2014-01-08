package individu;


public class Soldier extends Personnage {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Soldier(String name, String image, int argent){
		super(name,image,5,80,60,40);
		this.addObjet(new Sword("Military Long Sword","image",40,10,50));
	}
	
	public Soldier(String name){
		super(name,"image/Players/Soldier A.jpeg",5,80,60,40);
	}

}