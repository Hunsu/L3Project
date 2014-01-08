package interaction;

import java.rmi.Remote;
import java.rmi.RemoteException;

import serveur.Arene;

public abstract class Duel {
	
	/**
	 * @uml.property  name="arene"
	 * @uml.associationEnd  
	 */
	private Arene arene;          //l'arene sur laquelle le jeu a lieu
	/**
	 * @uml.property  name="refAttaquant"
	 * @uml.associationEnd  
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
	public Duel(Arene arene, Remote refAttaquant, Remote refDefenseur) throws RemoteException{
		this.arene = arene;
		this.refAttaquant = refAttaquant;
		this.refDefenseur = refDefenseur;
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
