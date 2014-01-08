package individu;

import java.io.Serializable;

public class Objet extends Element implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property  name="boostA"
	 */
	protected int boostA;
	/**
	 * @uml.property  name="boostD"
	 */
	protected int boostD;
	/**
	 * @uml.property  name="boostV"
	 */
	protected int boostV;
	
	public Objet(String name){
		super(name);
		setVie(1);
	}
	
	/**
	 * @return
	 * @uml.property  name="boostA"
	 */
	public int getBoostA() {
		return boostA;
	}
	
	/**
	 * @return
	 * @uml.property  name="boostD"
	 */
	public int getBoostD() {
		return boostD;
	}
	
	/**
	 * @return
	 * @uml.property  name="boostV"
	 */
	public int getBoostV(){
		return boostV;
	}
}
