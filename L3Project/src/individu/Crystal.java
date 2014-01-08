package individu;

public class Crystal extends Items {
	
	private static final long serialVersionUID = 1L;
	
	public Crystal(String name, String image,char classe){
		
		super(name,image,0,0,0,classe);
		init(classe);
	}
	
	public Crystal (String nom,char classe)
	{
		super(nom,"",0,0,0,classe);
		init(classe);
	}
	
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
