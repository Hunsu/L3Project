package individu.objets;

public class Gear extends Objet {
	
	private static final long serialVersionUID = 1L;
	
	public Gear(String name, String image, int boostA, int boostD, int durabilite, int boostV){
		super(name);
		this.image = image;
		this.boostA=boostA;
		this.boostD=boostD;
		this.boostV=boostV;
		this.setVie(durabilite);
	}
	
	
	
}
