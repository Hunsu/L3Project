import java.rmi.RemoteException;

import individu.Crystal;
import individu.Dagger;
import individu.Elf;
import individu.Assassin;
import individu.Sword;
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
		Crystal babar = new Crystal("dagger", 'S');
		Assassin tueur = new Assassin("lars");
		
		//Random r = new Random();
		new Console(babar, 80, 71);
		//new Console(tueur,60,60);
		
	}

}
