package individu;

import org.objets.Bow;

public class Elf extends Element {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Elf(String name, String image, int argent){
		super(name,image,argent,15);
		this.setAttaque(90);
		this.setDefense(10);
		this.setVitesse(40);
		this.addObjet(new Bow("Elfen Bow","image",20,0,40));
	}

	
}
