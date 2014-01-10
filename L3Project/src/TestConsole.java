import individu.objets.Crystal;
import individu.personnages.Assassin;

import java.rmi.RemoteException;
import java.util.Random;

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
         * the arguments
         * @throws RemoteException
         * the remote exception
         */
        public static void main(String[] args) throws RemoteException {
                Crystal babar = new Crystal("dagger", 'S');
                Assassin tueur = new Assassin("lars");

                Random r = new Random();
                //new Console(babar, r.nextInt(100), r.nextInt(100));
                 new Console(tueur,r.nextInt(100), r.nextInt(100));

        }

}