package interaction;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author  meradi
 */
public interface  IDuel {
	
	/**
	 * Realise le combat entre deux personnages
	 * @throws RemoteException
	 */
	public int realiserCombat() throws RemoteException; 
	
	/**
	 * Renvoie la reference de l'attaquant connue par le serveur
	 * @throws RemoteException
	 * @uml.property  name="refAttaquant"
	 */
	public Remote getRefAttaquant() throws RemoteException;
	
	/**
	 * Renvoie la reference du defenseur connue patr le serveur
	 * @throws RemoteException
	 * @uml.property  name="refDefenseur"
	 */
	public Remote getRefDefenseur() throws RemoteException;
	
	
	
}
