package individu.personnages;

import individu.objets.Bow;


public class Elf extends Personnage {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Elf(String name, String image){
		super(name,image,15,90,10,40);
		this.addObjet(new Bow("Elfen Bow","image",20,0,40));
	}
	
	
	public Elf(String name){
		super(name,"image/Players/Elf A.jpeg",15,90,10,40);
	}
	
}
