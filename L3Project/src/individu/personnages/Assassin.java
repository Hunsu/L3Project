package individu.personnages;


public class Assassin extends Personnage {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Assassin(String name, String image){
		super(name,image,5,120,50,30);
	}
	
	public Assassin(String name){
		super(name,"image/Players/Assassin.jpeg",5,80,50,60);
	}
	

}