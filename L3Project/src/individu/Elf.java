package individu;


public class Elf extends Personnage {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Elf(String name, String image, int argent){
		super(name,image,argent,12);
		this.setAttaque(50);
		this.setDefense(10);
		this.setVitesse(30);
	}

	
}
