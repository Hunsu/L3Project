package individu;


public class Mercenaire extends Personnage {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Mercenaire(String name, String image, int argent){
		super(name,image,argent);
		this.setAttaque(90);
		this.setDefense(60);
		this.setVitesse(30);
		
	}

	

}