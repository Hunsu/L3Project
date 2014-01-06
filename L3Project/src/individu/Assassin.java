package individu;

import org.objets.Objet;

public class Assassin extends Personnage {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Assassin(String name, String image, int argent){
		super(name,image,argent);
		this.setAttaque(120);
		this.setDefense(50);
		this.setVitesse(30);
		this.addObjet(new Objet("Har","image",20,30));
	}
	

}