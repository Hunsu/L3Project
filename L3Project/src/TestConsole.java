import java.rmi.RemoteException;

import org.objets.Objet;

import individu.Elf;
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
		Objet babar = new Objet("Babar","image/Kenny.png",100, 0);
		Elf elf1 = new Elf("Babar","image/Kenny.png",100);
		Elf elf2 = new Elf("Babar","image/Kenny.png",100);
		Elf elf3 = new Elf("Babar","image/Kenny.png",100);
		Elf elf4 = new Elf("Babar","image/Kenny.png",100);
		Elf elf5 = new Elf("Babar","image/Kenny.png",100);
		Elf elf6 = new Elf("Babar","image/Kenny.png",100);

		//Random r = new Random();
		new Console(babar, 40, 40);
		/*new Console(elf1, 14, 40);
		new Console(elf2, 4, 40);
		new Console(elf3,50, 40);
		new Console(elf4, 45, 40);
		new Console(elf5, 40, 10);
		new Console(elf6, 40, 49);*/
	}

}
