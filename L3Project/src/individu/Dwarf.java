package individu;

import org.objets.Objet;

public class Dwarf extends Personnage {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Dwarf(String name, String image, int argent){
		super(name,image,argent);
		this.setAttaque(40);
		this.setDefense(4);
		this.setVitesse(30);
		this.addObjet(new Objet("Har","image",20,30));
	}

	
}