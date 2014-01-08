package interaction;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Random;

import controle.IConsole;
import serveur.Arene;

public class LuckyNumber extends Duel{
	
	public LuckyNumber(Arene arene, Remote refAttaquant, Remote refDefenseur) throws RemoteException{
		
		super(arene,refAttaquant,refDefenseur);
	}

	public int realiserCombat() throws RemoteException {
		
		Remote ratt = this.getRefAttaquant();
		IConsole catt = (IConsole) ratt;
		
		Remote rdef = this.getRefDefenseur();	
		IConsole cdef = (IConsole) rdef;
		
		if(catt.getElement().getElementsConnus().contains(rdef)){
			return 0;
		}
		else{
			//catt.ajouterConnu(rdef);
			//cdef.ajouterConnu(ratt);
		}
		
		Random rand= new Random();
		int lNumber = rand.nextInt();
		int attNumber = rand.nextInt();
		int defNumber = rand.nextInt();
		
		if(Math.abs(lNumber-attNumber)>Math.abs(lNumber-defNumber)){
			
			cdef.perdreVie(1);
			return 0;
		}
		if(Math.abs(lNumber-attNumber)==Math.abs(lNumber-defNumber)){

			return 0;
		}
		else{

			catt.perdreVie(1);
			return 0;
		}
		
		
	}

}
