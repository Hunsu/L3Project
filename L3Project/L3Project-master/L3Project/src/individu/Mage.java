package individu;


public class Mage extends Element {
	
	private static final long serialVersionUID = 1L;
	
	public Mage(String name,String image,int argent){
		super(name,image,argent,10);
		this.setAttaque(90);
		this.setDefense(60);
		this.setVitesse(20);
	}

}
