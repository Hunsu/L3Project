package interaction;

import individu.personnages.Personnage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Random;

import serveur.Arene;
import controle.IConsole;

/**
 * The Class FaceOff.
 */
public class FaceOff extends Duel implements IDuel{

	/**
	 * Instantiates a new face off.
	 *
	 * @param arene the arene
	 * @param refAttaquant the ref attaquant
	 * @param refDefenseur the ref defenseur
	 * @throws RemoteException the remote exception
	 */
	public FaceOff (Arene arene, Remote refAttaquant, Remote refDefenseur) throws RemoteException{

		super(arene,refAttaquant,refDefenseur);
	}

	/**
	 * Offence.
	 *
	 * @param p1 the p1
	 * @param p2 the p2
	 * @return the int
	 */
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

	/* (non-Javadoc)
	 * @see interaction.IDuel#realiserCombat()
	 */
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
		int round = 100;

		while(round > 100){
			round--;
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
