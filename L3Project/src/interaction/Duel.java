package interaction;

import java.rmi.Remote;
import java.rmi.RemoteException;

import serveur.Arene;

/**
 * The Class Duel.
 */
public abstract class Duel {

	/** The arene. @uml.property  name="arene" @uml.associationEnd */
	private Arene arene;          //l'arene sur laquelle le jeu a lieu

	/** The ref attaquant. @uml.property  name="refAttaquant" @uml.associationEnd */
	private Remote refAttaquant;  //la reference de l'attaquant

	/** The ref defenseur. @uml.property  name="refDefenseur" */
	private Remote refDefenseur;  //la reference du defenseur

	/**
	 * Constructeur.
	 *
	 * @param arene l'arene du jeu
	 * @param refAttaquant la reference de l'attaquant
	 * @param refDefenseur la reference du defenseur
	 * @throws RemoteException the remote exception
	 */
	public Duel(Arene arene, Remote refAttaquant, Remote refDefenseur) throws RemoteException{
		this.arene = arene;
		this.refAttaquant = refAttaquant;
		this.refDefenseur = refDefenseur;
	}

	/**
	 * Gets the ref attaquant.
	 *
	 * @return the ref attaquant
	 * @throws RemoteException the remote exception
	 * @uml.property  name="refAttaquant"
	 */
	public Remote getRefAttaquant() throws RemoteException {
		return refAttaquant;
	}

	/**
	 * Gets the ref defenseur.
	 *
	 * @return the ref defenseur
	 * @throws RemoteException the remote exception
	 * @uml.property  name="refDefenseur"
	 */
	public Remote getRefDefenseur() throws RemoteException {
		return refDefenseur;
	}

	public int realiserCombat() throws RemoteException {
		return 0;
	}

}
