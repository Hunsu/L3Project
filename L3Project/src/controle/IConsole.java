package controle;

import interfaceGraphique.VueElement;

import java.rmi.Remote;
import java.rmi.RemoteException;

import individu.Element;

/**
 * Represente le lien Element - Serveur.
 */
public interface IConsole extends Remote {
	
	/**
	 * Arrete l'execution du controleur (thread).
	 *
	 * @param cause la raison pour laquelle l'arret est demande
	 * @throws RemoteException the remote exception
	 */
	public void shutDown(String cause) throws RemoteException;
	
	/**
	 * Execute le thread de l'element.
	 *
	 * @throws RemoteException the remote exception
	 */
	public void run() throws RemoteException;
	
	/**
	 * Mise a jour de la vue de l'element auquel le controleur est associe.
	 *
	 * @return the vue element
	 * @throws RemoteException the remote exception
	 */
	public VueElement update() throws RemoteException;
	
	/**
	 * Ajout a l'element celui avec lequel il a joue/ qu'il a ramasse.
	 *
	 * @param ref l'element avec lequel l'objet courrant a joue/ramasse
	 * @throws RemoteException the remote exception
	 */
	public void ajouterConnu(int ref) throws RemoteException;
	
	/**
	 * Renvoie l'element associe a la console.
	 *
	 * @return the element
	 * @throws RemoteException the remote exception
	 * @uml.property  name="element"
	 * @uml.associationEnd
	 */
	public Element getElement() throws RemoteException;
	
	/**
	 * Renvoie la vue de l'element associe a la console.
	 *
	 * @return the vue element
	 * @throws RemoteException the remote exception
	 * @uml.property  name="vueElement"
	 * @uml.associationEnd  inverse="ctr:interfaceGraphique.VueElement"
	 */
	public VueElement getVueElement() throws RemoteException;
	
	/**
	 * L'element associe a la vue met a jour sa phrase.
	 *
	 * @param message la nouvelle phrase a communique
	 * @throws RemoteException the remote exception
	 */
	public void parler(String message) throws RemoteException;

	/**
	 * L'element associe au controleur perd des vies.
	 *
	 * @param viePerdue le nombre de vies que l'element perd
	 * @throws RemoteException the remote exception
	 */
	public void perdreVie(int viePerdue) throws RemoteException;
	
	/**
	 * L'element associe au controleur ramasse un objet.
	 *
	 * @param objet l'objet ramasse par l'element
	 * @throws RemoteException the remote exception
	 */
	public void ramasserObjet(IConsole objet) throws RemoteException;
	
	/**
	 * Renvoie l'etat de l'element a afficher sur l'interface graphique.
	 *
	 * @return the string
	 * @throws RemoteException the remote exception
	 */
	public String afficher() throws RemoteException;
}
