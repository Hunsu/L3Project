package individu;

import org.objets.Sword;

public class Soldier extends Personnage {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Soldier(String name, String image, int argent){
		super(name,image,argent,5);
		this.setAttaque(80);
		this.setDefense(60);
		this.setVitesse(40);
		this.addObject(new Sword("Military Long Sword","image",40,10,50));
	}

}