package individu;

import org.objets.Hammer;

public class Dwarf extends Element {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Dwarf(String name, String image, int argent){
		super(name,image,argent,8);
		this.setAttaque(40);
		this.setDefense(4);
		this.setVitesse(30);
		this.addObjet(new Hammer("DHammer","image",30,10,20));
	}

	
}