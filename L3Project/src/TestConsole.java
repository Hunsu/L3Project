import java.rmi.RemoteException;

import org.personnage.Personnage1;

import controle.Console;

/**
 * Test de la Console avec un Element qui s'ajoute a l'Arene (apres lancement Arene et IHM). A lancer en plusieurs exemplaires.
 */
public class TestConsole {

	/**
	 * @param args
	 * @throws RemoteException 
	 */
	public static void main(String[] args) throws RemoteException {
		Personnage1 babar = new Personnage1("Babar","image/Kenny.png");

		//Random r = new Random();
		new Console(babar, 40, 40);
	}

}
