package individu;

public class Items extends Objet{
	
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property  name="classe"
	 */
	private char classe;
	
	public Items(String name, String image, int boostA, int boostD, int boostV, char classe){
		super(name);
		this.boostA=boostA;
		this.boostD=boostD;
		this.boostV=boostV;
		this.image=image;
		this.classe=classe;
	}
	
	/**
	 * @return
	 * @uml.property  name="classe"
	 */
	public char getClasse(){
		return this.classe;
	}
	
	public void setBoostA(int boostA){
		this.boostA=boostA;
	}
	
	public void setBoostD(int boostD){
		this.boostD=boostD;
	}
	
	public void setBoostV(int boostV){
		this.boostV=boostV;
	}

}
