package interaction;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Random;

import controle.IConsole;
import serveur.Arene;

/**
 * The Class Shifumi.
 */
public class Shifumi extends Duel{
	
	/**
	 * The Enum Hands.
	 *
	 * @author   meradi
	 */
	enum Hands{
/** The pierre. @uml.property  name="pIERRE" @uml.associationEnd */
	PIERRE,
/** The ciseaux. @uml.property  name="cISEAUX" @uml.associationEnd */
	CISEAUX,
/** The feuille. @uml.property  name="fEUILLE" @uml.associationEnd */
	FEUILLE}
	
/**
 * Instantiates a new shifumi.
 *
 * @param arene the arene
 * @param refAttaquant the ref attaquant
 * @param refDefenseur the ref defenseur
 * @throws RemoteException the remote exception
 */
public Shifumi(Arene arene, Remote refAttaquant, Remote refDefenseur) throws RemoteException{
		
		super(arene,refAttaquant,refDefenseur);
	}

/**
 * Jouer un tour.
 *
 * @return the string
 */
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

/**
 * Arbitrer.
 *
 * @param c1 the c1
 * @param c2 the c2
 * @return the int
 */
public int arbitrer(String c1,String c2){
	
	if((Hands.valueOf(c1).compareTo(Hands.PIERRE)==0 && Hands.valueOf(c2).compareTo(Hands.FEUILLE)==0)){
			return 1;
	}
	if((Hands.valueOf(c2).compareTo(Hands.PIERRE)==0 && Hands.valueOf(c1).compareTo(Hands.FEUILLE)==0)){
			return -1;
	}
	
	return(Hands.valueOf(c1).compareTo(Hands.valueOf(c2)));
}

	/**
	 * Realiser combat.
	 *
	 * @return the int
	 * @throws RemoteException the remote exception
	 */
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
