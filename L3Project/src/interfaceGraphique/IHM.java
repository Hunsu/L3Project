package interfaceGraphique;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class IHM extends JFrame {

	private static final long serialVersionUID = 1L;
	private class AreneJTextArea extends JTextArea {

		private static final long serialVersionUID = 1L;

		AreneJTextArea() {
			super("Connexion...", 10, 10);
			setEditable(false);
		}
	}

	/**
	 * @uml.property  name="arene"
	 * @uml.associationEnd  
	 */
	private AreneJPanel arene = null;

	public IHM() {
		Toolkit kit = Toolkit.getDefaultToolkit();

		// personnalise et positionne la fenetre par rapport a l'ecran
		Dimension size = kit.getScreenSize();
		setSize(size.width / 2, size.height / 2);
		setLocation(size.width, size.height / 4);
		// setResizable(false);

		// cree un titre de la fenetre
		setTitle("IHM - Arene / UPS - Projet Prog");

		// ajout une operation si le bouton de fermeture de la fenetre est
		// clique
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ajout d'une action pour arreter l'execution de l'interface graphique
		Action exitAction = new AbstractAction("Quitter") {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent ae) {
				System.exit(0);
			}
		};

		Action aboutAction = new AbstractAction("A propos") {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent ae) {
				JOptionPane.showMessageDialog(null,
						"Arene\nInspiree des TP de L3");
			}
		};

		// creation d'un menu Fichier avec deux options - quitter et a propos
		JMenuBar m = new JMenuBar();
		JMenu file = new JMenu("Fichier");
		file.add(aboutAction);
		file.add(exitAction);
		m.add(file);
		setJMenuBar(m);

		// ajout de l'arene dans la fenetre
		
		
		AreneJTextArea ajta = new AreneJTextArea();
		arene = new AreneJPanel(ajta);
		getContentPane().add(arene);
		setVisible(true);

		// Fenetre qui affiche les messages des console
		JFrame jf = new JFrame();
		jf.setSize(size.width / 4, size.height / 4);
		jf.setLocation(size.width * 3 / 5, size.height / 10);
		jf.getContentPane().add(new JScrollPane(ajta));
		jf.setTitle("Asteroide325 - Console");
		jf.setVisible(true);
	}

	public void connect() {
		if(arene != null)
			arene.connect();
		
	}

	
}
