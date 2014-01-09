import interfaceGraphique.IHM;

/**
 * Test de l'interface graphique qui se connecte a l'Arene (apres lancement Arene, avant les Consoles).
 */
public class TestIHM {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		IHM ihm=new IHM();
		ihm.connect();
		//boucle infine, interrompue par l'utilisateur (IHM)
		while(true) {
			try {Thread.sleep(500);} catch (InterruptedException e) {}
			ihm.repaint(); 
		}
	}

}
