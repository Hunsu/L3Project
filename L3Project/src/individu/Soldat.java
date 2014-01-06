package individu;


public class Soldat extends Personnage {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Soldat(String name, String image, int argent){
		super(name,image,argent);
		this.setAttaque(80);
		this.setDefense(60);
		this.setVitesse(30);
	}

}