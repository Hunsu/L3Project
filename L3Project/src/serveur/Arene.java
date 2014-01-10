package serveur;

import individu.Element;
import interaction.Duel;
import interaction.DuelBasic;
import interaction.FaceOff;
import interaction.LuckyNumber;
import interaction.Shifumi;
import interfaceGraphique.VueElement;

import java.awt.Point;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;

import controle.IConsole;
import utilitaires.UtilitaireConsole;

/**
 * Le serveur ou se connectent les Consoles en RMI. En localhost pour l'instant
 *
 */
public class Arene extends UnicastRemoteObject implements IArene, Runnable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The port. @uml.property  name="port" */
	private int port; // port a utiliser pour la connexion

	/** The compteur. @uml.property  name="compteur" */
	private int compteur = 0; // nombre d'elements connectes au serveur

	/** The elements. @uml.property  name="elements" @uml.associationEnd  qualifier="r:java.rmi.Remote interfaceGraphique.VueElement" */
	private Hashtable<Remote, VueElement> elements = null; // elements connectes
															// au serveur

	/**
															 * Constructeur.
															 *
															 * @param port le port de connexion
															 * @throws Exception the exception
															 */
	public Arene(int port) throws Exception {
		super();
		this.port = port;
		Naming.rebind("rmi://localhost:" + port + "/Arene", this);
		elements = new Hashtable<Remote, VueElement>();
		new Thread(this).start();
	}

	/**
	 * Fournit une reference (entiere) pour un nouvel element dans l'arene,
	 * compte les elements la synchro permet de garantir l'acces e un seul
	 * thread a la fois au compteur++.
	 *
	 * @return reference (entiere) utilisee pour rmi, compter les elements
	 * @throws RemoteException the remote exception
	 */
	public synchronized int allocateRef() throws RemoteException {
		compteur++;
		return compteur;
	}

	/**
	 * boucle principale du thread serveur.
	 */
	public void run() {
		TimeoutOp to;
		while (true) {
			try {
				synchronized (this) { // on verouille le serveur durant un tour
										// de jeu -> pas de
										// connexion/deconnexion
					// a cet instant, pour chaque client connecte, on verifie
					// s'il est en vie
					for (Enumeration<Remote> enu = elements.keys(); enu
							.hasMoreElements();) {
						// boucle de jeu
						Remote r = enu.nextElement();
						to = new TimeoutOp(r);
						to.join(1000);
						if (to.isAlive()) {
							to = null;
							System.out
									.println("Depassement du temps (client ne+"
											+ elements.get(r).getRef() + ") !");
							elements.remove(r);
							((IConsole) r)
									.shutDown("Presence sur l'arene trop long. Degage !");
						} else {
							Element elem = ((IConsole) r).getElement();

							if (elem.getVie() <= 0) {
								System.out.println(elem.getNom()
										+ " est mort...");
								elements.remove(r);
								((IConsole) r).shutDown("Vous etes mort...");
							}
						}
					}
				}
				Thread.sleep(1000); // dormir 'au plus' 1 seconde (difference
									// temps execution est 1sec.) pour permettre
									// connexion/deconnexion des qconsoles
			} catch (Exception e) {
				e.getMessage();
			}
		}
	}

	/**
	 * Associe ("connecte") la representation d'un element en y associant un
	 * Remote, ajoute la representation d'un element dans l'arene * la synchro
	 * permet de garantir qu'on ne fait pas de nouvelle connection pdt un tour
	 * de jeu.
	 *
	 * @param s vue (representation) de l'element
	 * @throws RemoteException the remote exception
	 */
	public synchronized void connect(VueElement s) throws RemoteException {
		try {
			Remote r = Naming.lookup("rmi://localhost:" + port + "/Console"
					+ s.getRef());
			elements.put(r, s);
		} catch (Exception e) {
			System.out.println("Erreur lors de la connexion d'un client (ref="
					+ s.getRef() + ") :");
			e.printStackTrace();
		}

	}

	/**
	 * appele par l'IHM pour afficher une representation de l'arene via RMI, on
	 * envoie une copie (serialisee) du monde.
	 *
	 * @return the world
	 * @throws RemoteException the remote exception
	 */
	public ArrayList<VueElement> getWorld() throws RemoteException {
		ArrayList<VueElement> aux = new ArrayList<VueElement>();
		for (VueElement s : elements.values()) {
			aux.add(s);
		}
		return aux;
	}

	/**
	 * Liste des reference des voisins et leurs coordonnees a partir d'une
	 * position.
	 *
	 * @param pos the pos
	 * @param ref the ref
	 * @return the hashtable
	 * @throws RemoteException the remote exception
	 */
	public Hashtable<Integer, VueElement> voisins(Point pos, int ref)
			throws RemoteException {
		// Hashtable<Integer, Point> aux=new Hashtable<Integer, Point>();

		Hashtable<Integer, VueElement> aux = new Hashtable<Integer, VueElement>();

		for (VueElement s : elements.values()) {
			if (((UtilitaireConsole.distanceChebyshev(s.getPoint(), pos)) < 10)
					& (s.getRef() != ref)) {
				// aux.put(s.getRef(),new Point(s.getPoint().x,s.getPoint().y));
				// //on cree un nouveau point
				aux.put(s.getRef(), s);
			}
		}
		return aux;
	}

	/**
	 * Classe permettant de lancer une execution du client (run) dans un thread
	 * separe, pour pouvoir limiter son temps d'execution via un join(timeout).
	 */
	public class TimeoutOp extends Thread {

		/** The r. */
		private Remote r;

		/**
		 * Instantiates a new timeout op.
		 *
		 * @param r the r
		 */
		TimeoutOp(Remote r) {
			this.r = r;
			start();
		}

		/* (non-Javadoc)
		 * @see java.lang.Thread#run()
		 */
		public void run() {
			try {
				((IConsole) r).run(); // on lance une execution
				elements.put(r, ((IConsole) r).update()); // maj du serveur ac
															// les infos du
															// client, pourquoi
															// clonage ??
				if (elements.get(r).getTTL() == 0) {
					elements.remove(r);
					((IConsole) r)
							.shutDown("Vous etes reste trop longtemps dans l'arene, vous etes elimine !");
				}

			} catch (Exception e) {
				// les exceptions sont inhibees ici, que ce soit une
				// deconnection du client ou autre
				// en cas d'erreur, le client ne sera plus jamais execute
				e.printStackTrace();
				elements.remove(r);
			}
		}
	}

	/**
	 * Renvoie le nombre de clients connectes.
	 *
	 * @return the int
	 */
	public int countClients() {
		return elements.size();
	}

	/* (non-Javadoc)
	 * @see serveur.IArene#interaction(int, int)
	 */
	public void interaction(int ref, int ref2) throws RemoteException {
		try {
			// recupere l'attaquant et le defenseur
			Remote attaquant = Naming.lookup("rmi://localhost:" + port
					+ "/Console" + ref);
			Remote defenseur = Naming.lookup("rmi://localhost:" + port
					+ "/Console" + ref2);

			// cree le duel

			Random r = new Random();
			Duel jeux = null;
			int jeu = r.nextInt(4);
			System.out.print("jeu : "+jeu+"\n");
			switch(jeu){
			case 0 :
				DuelBasic duel = new DuelBasic(this, (IConsole) attaquant,
						(IConsole) defenseur);
				duel.realiserCombat();
				break;
			case 1 :
				jeux = new FaceOff(this,(IConsole) attaquant,(IConsole) defenseur);
				jeux.realiserCombat();
				break;
			case 2 :
				jeux = new LuckyNumber(this,(IConsole) attaquant,(IConsole) defenseur);
				jeux.realiserCombat();
				break;
			case 3 :
				jeux = new Shifumi(this,(IConsole) attaquant,(IConsole) defenseur);
				jeux.realiserCombat();
				break;
				default:
					break;
			}


			// ajout les elements avec lesquels on a joue dans la liste des
			// elements connus
			((IConsole) attaquant).ajouterConnu(ref2);
			((IConsole) defenseur).ajouterConnu(ref);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see serveur.IArene#ramasser(int, int)
	 */
	public void ramasser(int ref1, int ref2) throws RemoteException {
		//recupere l'attaquant et le defenseur
	     Remote combattant;
		try {
			combattant = Naming.lookup("rmi://localhost:" + port +"/Console"+ref1);
			Remote objet = Naming.lookup("rmi://localhost:" + port + "/Console"+ref2);
			//tester l'objet avant de le ramasser...
	    	 ((IConsole) combattant).ramasserObjet((IConsole)objet);

		    	 //mets a jour l'etat de l'objet comme ramasse
	    	 ((IConsole) objet).perdreVie(1);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

	/**
	 * Supprime un element de la liste des elements connectes au serveur.
	 *
	 * @param elem l'element a enlever
	 */
	public void supprimerElement(Remote elem) {
		this.elements.remove(elem);
	}

}
