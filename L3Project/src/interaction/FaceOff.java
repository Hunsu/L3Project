package interaction;

import java.rmi.Remote;
import java.rmi.RemoteException;
import individu.Personnage;
import java.util.Random;

import controle.IConsole;
import serveur.Arene;

public class FaceOff extends Duel implements IDuel{
	
	public FaceOff (Arene arene, Remote refAttaquant, Remote refDefenseur) throws RemoteException{
		
		super(arene,refAttaquant,refDefenseur);
	}
	
	public int offence(Personnage p1, Personnage p2){
		
		Random rand = new Random();
		int addP1 = rand.nextInt(p1.getVitesse());
		int addP2 = rand.nextInt(p2.getVitesse());
		
		if((p1.getAttaque()+addP1)>(p2.getDefense()+addP2)){
			return 1;
		}
		if((p1.getAttaque()+addP1)==(p2.getDefense()+addP2)){
			return 0;
		}
		else{
			return -1;
		}
			
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
		
		int gagnant;
		Personnage joueur1 = (Personnage)catt.getElement();
		Personnage joueur2 = (Personnage)cdef.getElement();
		
		while(joueur1.getVie()!=0 && joueur2.getVie()!=0){
			
			gagnant = offence(joueur1,joueur2);
			switch(gagnant){
			
			case 1:
				cdef.perdreVie(1);
				break;
			
			case -1:
				catt.perdreVie(1);
				break;
				
			default:
				break;
			}
		}
		
		return 0;
	}
	

}
