package individu.objets;

/**
 * The Class Crystal.
 */
public class Crystal extends Items {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new crystal.
	 *
	 * @param name the name
	 * @param image the image
	 * @param classe the classe
	 */
	public Crystal(String name, String image,char classe){
		
		super(name,image,0,0,0,classe);
		init(classe);
	}
	
	/**
	 * Instantiates a new crystal.
	 *
	 * @param nom the nom
	 * @param classe the classe
	 */
	public Crystal (String nom,char classe)
	{
		super(nom,"",0,0,0,classe);
		init(classe);
	}
	
	/**
	 * Inits the.
	 *
	 * @param classe the classe
	 */
	private void init(char classe){
		
		switch(classe){
		
		case 'A':
			this.setBoostA(20);
			this.image = "image/Items/Power Crystal.jpg";
			break;
			
		case 'B':
			this.setBoostD(20);
			this.image = "image/Items/Defence Crystal.jpg";
			break;
			
		case 'C':
			this.setBoostV(20);
			this.image = "image/Items/Speed Crystal.jpg";
			break;
			
		case 'S':
			this.image = "image/Items/Classe S Crystal.jpg";
			this.setBoostA(30);
			this.setBoostD(30);
			this.setBoostV(40);
			break;
			
		default:
			break;
		}
		
	}

}
