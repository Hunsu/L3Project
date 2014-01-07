package individu;


public class Dwarf extends Personnage {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Dwarf(String name, String image, int argent){
		super(name,image,argent,9);
		this.setAttaque(40);
		this.setDefense(4);
		this.setVitesse(30);
	}

	
}