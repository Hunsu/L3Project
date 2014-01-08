package interaction;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Random;

import controle.IConsole;
import serveur.Arene;

public class Shifumi extends Duel{
	
	/**
	 * @author   meradi
	 */
	enum Hands{/**
	 * @uml.property  name="pIERRE"
	 * @uml.associationEnd  
	 */
	PIERRE,/**
	 * @uml.property  name="cISEAUX"
	 * @uml.associationEnd  
	 */
	CISEAUX,/**
	 * @uml.property  name="fEUILLE"
	 * @uml.associationEnd  
	 */
	FEUILLE}
	
public Shifumi(Arene arene, Remote refAttaquant, Remote refDefenseur) throws RemoteException{
		
		super(arene,refAttaquant,refDefenseur);
	}

public String jouerUnTour(){
	String temp;
	Random random= new Random();
	switch(random.nextInt(2)+1)
	{
	case 1:
		temp= new String("PIERRE");
		break;
	case 2:
		temp= new String("CISEAUX");
		break;
	case 3:
		temp= new String("FEUILLE");
		break;
	default:
		temp= new String("");
		break;	
	}
	
	return temp;
}

public int arbitrer(String c1,String c2){
	
	if((Hands.valueOf(c1).compareTo(Hands.PIERRE)==0 && Hands.valueOf(c2).compareTo(Hands.FEUILLE)==0)){
			return 1;
	}
	if((Hands.valueOf(c2).compareTo(Hands.PIERRE)==0 && Hands.valueOf(c1).compareTo(Hands.FEUILLE)==0)){
			return -1;
	}
	
	return(Hands.valueOf(c1).compareTo(Hands.valueOf(c2)));
}

	public int realiserCombat() throws RemoteException {
		Remote ratt = this.getRefAttaquant();
		IConsole catt = (IConsole) ratt;
		
		Remote rdef = this.getRefDefenseur();	
		IConsole cdef = (IConsole) rdef;
		
		if(catt.getElement().getElementsConnus().contains(rdef)){
			return 0;
		}
		
		int r = arbitrer(jouerUnTour(),jouerUnTour());
		switch(r){
		
		case 1:
			cdef.perdreVie(1);
			break;
		
		case -1:
			catt.perdreVie(1);
			break;
			
		default:
			break;
		}
		return 0;
	}

}
