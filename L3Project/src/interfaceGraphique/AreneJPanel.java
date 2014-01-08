package interfaceGraphique;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import serveur.IArene;

public class AreneJPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property  name="jta"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextArea jta;

	/**
	 * @author   meradi
	 */
	enum State {
		/**
		 * @uml.property  name="iNIT"
		 * @uml.associationEnd  
		 */
		INIT, /**
		 * @uml.property  name="pLAYING"
		 * @uml.associationEnd  
		 */
		PLAYING
	};

	/**
	 * @uml.property  name="state"
	 * @uml.associationEnd  
	 */
	private State state = State.INIT; // etat de l'interface
	/**
	 * @uml.property  name="serveur"
	 */
	private Remote serveur;
	/**
	 * @uml.property  name="cnxError"
	 */
	private boolean cnxError = false; // erreur de connexion
	/*
	 * liste de tous les elements connectes a l'interface
	 */
	/**
	 * @uml.property  name="world"
	 */
	private ArrayList<VueElement> world = new ArrayList<VueElement>();

	private static final int port = 5099; // port par defaut pour communiquer
	// avec le serveur RMI
	/**
	 * @uml.property  name="connection"
	 */
	private Thread connection = null; // thread de connexion au serveur

	// Conteneur qui affiche l'arene de jeu
	AreneJPanel(JTextArea jta) {
		this.jta = jta;
	}

	public void paintComponent(Graphics g) {
		// affiche l'arene comme un rectangle
		Rectangle rect = this.getBounds();

		// si la connexion est en cours ou il y a une erreur
		if ((state == State.INIT) || (cnxError)) {
			Font of = g.getFont();
			g.setFont(new Font("Arial", Font.BOLD, 20));
			// affiche le message correspondant
			if (!cnxError)
				g.drawString("Connexion en cours sur le serveur Arene...", 20,
						rect.height - 20);
			else
				g.drawString("Erreur de connexion !", 20, rect.height - 20);
			g.setFont(of);

			// verifie si la connexion a ete realisee - isAlive (Thread)==true
			// si on est en cours de connexion
			if ((connection != null) && (!connection.isAlive())) {
				// affiche le message correspondant
				if (!cnxError)
					jta.append("ok !");
				else
					jta.append("erreur !");
				// mets a jour l'etat de l'arene
				state = State.PLAYING;
				// remets la connexion a null pour une autre execution
				connection = null;
			}
		} else {
			try {
				/*File back = new File("image/back.jpeg");
				BufferedImage backgroundImage = ImageIO.read(back);
				g.drawImage(backgroundImage, 0, 0, getWidth(),getHeight(), null);*/
				// mets a jour la liste des elements en vie sur l'arene
				world = ((IArene) serveur).getWorld();

				int  cx, cy;
				String dial;

				// reinitialise l'affichage de l'arene
				jta.setText("");

				// pour chaque element en vie sur l'arene
				for (VueElement s : world) {
					// recupere sa reference
					//ref = s.getRef();

					//Random r = new Random(ref);

					// recupere les coordonnes de l'element
					cx = s.getPoint().x * rect.width / 100;
					cy = s.getPoint().y * rect.height / 100;

					// construis un oval aux coordonnes cx,cy de taille 8 x 8
					File file = new File(s.getControleur().getElement().getImage());
					if(!file.canRead())
					{
						System.out.println("Name : " + file.getAbsolutePath()+file.exists() + s.getControleur().getElement().getImage());
						continue;
					}
					BufferedImage image = ImageIO.read(file);
					g.drawImage(image, cx, cy, this);

					// recupere les phrases dites par l'element
					dial = (s.getPhrase() == null) ? "" : " : " + s.getPhrase();

					// affiche au dessus du point ses informations
					g.drawString(s.afficher(), cx + 10, cy);

					// affiche dans la fenetre a cote ses informations
					jta.append(s.afficher() + dial + "\n");
					// affiche l'heure courante
					g.setColor(Color.BLACK);
					g.drawString(DateFormat.getTimeInstance()
							.format(new Date()), rect.width - 60, 20);
				}

			} catch (RemoteException e) {
				// en cas de deconnexion ou erreur du serveur
				// remets l'etat de l'arene a jour
				state = State.INIT;
				// affiche un dialog avec le message d'erreur
				JOptionPane.showMessageDialog(this,
						"Erreur de connection !\nRaison : " + e.getMessage(),
						"Message", JOptionPane.ERROR_MESSAGE);
				cnxError = true;
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Lance une connexion au serveur dans un thread separe
	 */
	public void connect() {
		connection = new Thread() {
			public void run() {
				try {
					serveur = Naming.lookup("rmi://localhost:" + port
							+ "/Arene");
				} catch (Exception e) {
					cnxError = true;
					JOptionPane
							.showMessageDialog(
									null,
									"Impossible de se connecter au serveur Arene:"
											+ port
											+ " !\n(le serveur ne doit pas etre actif...)\nRaison : "
											+ e.getMessage(), "Message",
									JOptionPane.ERROR_MESSAGE);
				}
			}
		};
		connection.start();
	}

}