package org.objets;

public class Crystal extends Items {
	
	private static final long serialVersionUID = 1L;
	
	public Crystal(String name, String image,char classe){
		
		super(name,image,0,0,0,classe);
		
		switch(classe){
		
		case 'A':
			this.setBoostA(20);
			break;
			
		case 'B':
			this.setBoostD(20);
			break;
			
		case 'C':
			this.setBoostV(20);
			break;
			
		case 'S':
			this.setBoostA(30);
			this.setBoostD(30);
			this.setBoostV(40);
			break;
			
		default:
			break;
		}
		
	}

}
