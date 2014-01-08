package interaction;

import java.rmi.Remote;
import java.rmi.RemoteException;

import controle.IConsole;

import serveur.Arene;

public class DuelBasic implements IDuel {

	/**
	 * @uml.property  name="arene"
	 * @uml.associationEnd  
	 */
	private Arene arene;          //l'arene sur laquelle le jeu a lieu
	/**
	 * @uml.property  name="refAttaquant"
	 */
	private Remote refAttaquant;  //la reference de l'attaquant
	/**
	 * @uml.property  name="refDefenseur"
	 */
	private Remote refDefenseur;  //la reference du defenseur
	
	/**
	 * Constructeur
	 * @param arene l'arene du jeu
	 * @param refAttaquant la reference de l'attaquant
	 * @param refDefenseur la reference du defenseur
	 * @throws RemoteException
	 */
	public DuelBasic(Arene arene, Remote refAttaquant, Remote refDefenseur) throws RemoteException{
		this.arene = arene;
		this.refAttaquant = refAttaquant;
		this.refDefenseur = refDefenseur;
	}

	/**
	 * Realise le combat 
	 */
	public int realiserCombat() throws RemoteException {
		Remote ratt = this.getRefAttaquant();
		IConsole catt = (IConsole) ratt;
		int vieAtt = catt.getElement().getVie();
		
		Remote rdef = this.getRefDefenseur();	
		IConsole cdef = (IConsole) rdef;
		int vieDef = cdef.getElement().getVie();
		
		if(vieAtt < vieDef)
			catt.perdreVie(1);
		else
			cdef.perdreVie(1);
		
		return 0;
	}


	/**
	 * @return
	 * @throws RemoteException
	 * @uml.property  name="refAttaquant"
	 */
	public Remote getRefAttaquant() throws RemoteException {
		return refAttaquant;
	}

	/**
	 * @return
	 * @throws RemoteException
	 * @uml.property  name="refDefenseur"
	 */
	public Remote getRefDefenseur() throws RemoteException {
		return refDefenseur;
	}

}
