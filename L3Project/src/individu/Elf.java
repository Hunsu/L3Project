package individu;

import org.objets.Objet;

public class Elf extends Personnage {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Elf(String name, String image, int argent){
		super(name,image,argent);
		this.setAttaque(50);
		this.setDefense(10);
		this.setVitesse(30);
		this.addObjet(new Objet("Har","image",20,30));
	}

	
}
