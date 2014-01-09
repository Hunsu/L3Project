package interaction;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * The Interface IDuel.
 *
 * @author  meradi
 */
public interface  IDuel {
	
	/**
	 * Realise le combat entre deux personnages.
	 *
	 * @return the int
	 * @throws RemoteException the remote exception
	 */
	public int realiserCombat() throws RemoteException; 
	
	/**
	 * Renvoie la reference de l'attaquant connue par le serveur.
	 *
	 * @return the ref attaquant
	 * @throws RemoteException the remote exception
	 * @uml.property  name="refAttaquant"
	 */
	public Remote getRefAttaquant() throws RemoteException;
	
	/**
	 * Renvoie la reference du defenseur connue patr le serveur.
	 *
	 * @return the ref defenseur
	 * @throws RemoteException the remote exception
	 * @uml.property  name="refDefenseur"
	 */
	public Remote getRefDefenseur() throws RemoteException;
	
	
	
}
