import individu.objets.Crystal;
import individu.personnages.Assassin;

import java.rmi.RemoteException;

import controle.Console;

/**
 * Test de la Console avec un Element qui s'ajoute a l'Arene (apres lancement
 * Arene et IHM). A lancer en plusieurs exemplaires.
 */
public class TestConsole {

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 * @throws RemoteException
	 *             the remote exception
	 */
	public static void main(String[] args) throws RemoteException {
		Crystal babar = new Crystal("dagger", 'S');
		Assassin tueur = new Assassin("lars");

		// Random r = new Random();
		new Console(babar, 80, 71);
		// new Console(tueur,60,60);

	}

}
