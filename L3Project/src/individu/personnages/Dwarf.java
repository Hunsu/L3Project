package individu.personnages;

import individu.objets.Hammer;


public class Dwarf extends Personnage {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Dwarf(String name, String image){
		super(name,image,8,40,90,20);
		this.addObjet(new Hammer("DHammer","",30,10,20));
	}
	
	public Dwarf(String name){
		super(name,"image/Players/Dwarf A.jpeg",8,40,90,20);
	}
	

	
}