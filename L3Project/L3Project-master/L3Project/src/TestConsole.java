import java.rmi.RemoteException;

import individu.Elf;
//import individu.Assassin;

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
		Elf babar = new Elf("Babar","image/Kenny.png",100);
		//Assassin tueur = new Assassin("lars","image/kenny.png,",200);
		

		//Random r = new Random();
		new Console(babar, 40, 40);
		//new Console(tueur,60,60);
		
	}

}
