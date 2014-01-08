package individu;


public class Mage extends Personnage {
	
	private static final long serialVersionUID = 1L;
	
	public Mage(String name,String image){
		super(name,image,10,90,60,20);
		
	}
	
	public Mage(String name){
		super(name,"image/Players/Black Mage.jpg",10,90,60,20);
	}

}
