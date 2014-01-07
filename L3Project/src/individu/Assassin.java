package individu;


public class Assassin extends Personnage {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Assassin(String name, String image, int argent){
		super(name,image,argent,4);
		this.setAttaque(120);
		this.setDefense(50);
		this.setVitesse(30);
	}
	

}