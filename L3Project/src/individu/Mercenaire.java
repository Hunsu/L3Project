package individu;

import org.objets.Objet;

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
		this.addObjet(new Objet("Har","image",20,30));
		
	}

}