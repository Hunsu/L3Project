package controle;

import individu.Element;
import individu.objets.Objet;
import individu.personnages.Personnage;
import interfaceGraphique.VueElement;

import java.awt.Point;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;

import serveur.IArene;
import utilitaires.UtilitaireConsole;

/**
 * 
 * Se connecte au serveur avec un Element et sa VueElement.
 * "run" permet a l'Element/VueElement de se deplacer
 *
 */
public class Console extends UnicastRemoteObject implements IConsole {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The Constant port. */
	private static final int port=5099;	              //port par defaut pour communiquer avec le serveur RMI
	
	/** The serveur. @uml.property  name="serveur" */
	private Remote serveur = null;                    //le serveur avec lequel le controleur communique
	
	/** The ve. @uml.property  name="ve" @uml.associationEnd */
	private VueElement ve = null;                     //la vue de l'element (pour l'interface graphique)
	
	/** The elem. @uml.property  name="elem" @uml.associationEnd */
	private Element elem = null;                      //l'element pour lequel le controleur est cree
	
	/** The voisins. @uml.property  name="voisins" @uml.associationEnd  qualifier="valueOf:java.lang.Integer interfaceGraphique.VueElement" */
	private Hashtable<Integer,VueElement> voisins;    //les vues des voisins sur l'interface graphique
	
	/** The point errance. @uml.property  name="pointErrance" */
	private Point pointErrance;                       //le point ou aller errer
	
	/** The ref rmi. @uml.property  name="refRMI" */
	private int refRMI;                               //la reference (entiere) attribuee par le serveur a la connexion
	
	
	/**
	 * Constructeur.
	 *
	 * @param elem l'element pour lequel le controleur est cree
	 * @param dx la position initiale de l'element sur l'ordonnee (interface graphique)
	 * @param dy la position initiale de l'element sur l'abscisse (interface graphique)
	 * @throws RemoteException the remote exception
	 */
	public Console(Element elem, int dx, int dy) throws RemoteException {
		 //appel au constructeur de la super-classe -> il peut etre implicite
		super();
		try{
			//initialisation de l'element pour lequel le controleur est cree
			this.elem=elem;
			
			//Creation de la position initiale de la vue de l'element sur l'interface graphique
			Point pos = new Point(dx,dy);
			
			//initialisation des voisins (vide avant la connexion)
			voisins = new Hashtable<Integer,VueElement>();
			
			//preparation connexion au serveur
			//handshake/enregistrement RMI
			serveur=Naming.lookup("rmi://localhost:"+port+"/Arene");
			serveur.toString();
			
			//initialisation de la reference du controleur sur le serveur
			this.refRMI=((IArene) serveur).allocateRef();
			Naming.rebind("rmi://localhost:"+port+"/Console"+refRMI,this);
			
			//initialisation de la vue sur l'element
			ve=new VueElement(refRMI, pos, this, "Atterrissage...");
						
			//connexion au serveur
			((IArene) serveur).connect(ve);
			
			//affiche message si succes
			System.out.println("Console connectee ["+refRMI+"]");
 		} catch (Exception e) {
  			System.out.println("Erreur : la console n'a pa pu etre creee !\nCause : "+e.getCause());
  			e.printStackTrace();
 		}
	}


	/**
	 * Permet au serveur de faire "jouer" un tour a l'element.
	 * Calcule ses voisins (donnes par le serveur), cherche le plus proche, s'il est a proximite, lance l'interaction sinon se dirige vers lui (s'il existe un plus proche)
	 * Cette methode est execute chaque seconde
	 *
	 * @throws RemoteException the remote exception
	 */
	public void run() throws RemoteException {
		if(this.elem instanceof Objet)
			return;
		//decremente sa duree de vie
		ve.decrTTL(); 
			
		//mets a jour ses voisins 
		voisins = ((IArene) serveur).voisins(ve.getPoint(),refRMI);	
			
		//Hashtable<Integer,VueElement> voisinsInconnus = extraireInconnus(voisins);
		
		//extraire les éléemnents avec lequels on a pas encore joué 
		//C'est pour éviter de joué avec le même élément plusieurs fois
		Hashtable<Integer,VueElement> refsInconnus = new Hashtable<Integer,VueElement>();
		for(Integer ref : voisins.keySet()){
			if(!elem.getElementsConnus().contains(ref))
				refsInconnus.put(ref, voisins.get(ref));
		}
		// Recherche du plus proche, sinon errer
		HashMap<Integer, HashMap<Integer,VueElement>> resultat = Strategie.chercherElementProche(ve, refsInconnus);
		int distPlusProche = resultat.keySet().iterator().next();
		int refPlusProche =  resultat.get(distPlusProche).keySet().iterator().next();
		VueElement cible = resultat.get(distPlusProche).get(refPlusProche);
		IConsole console = null;
		if(cible != null)
			console = cible.getControleur();
		
		//si le plus proche est a proximite
		if (distPlusProche<=1) { 
			//si l'élément est un personnage
			if(console != null && console.getElement() instanceof Personnage){
				//jeu
				parler("Je joue avec "+refPlusProche);
				//on ajoute le personnage à liste des éléments connus
				ajouterConnu(refPlusProche);
				//on lance l'interaction
				((IArene) serveur).interaction(refRMI, refPlusProche);
			} else{ //il s'agit d'un objet
				//ramasser
				parler("Je ramasse l'objet "+refPlusProche);
				ramasserObjet(console);
				((IArene) serveur).ramasser(refRMI, refPlusProche);
			}
			
				
	
		}
		//sinon
		else { //l'element courant se deplace vers le plus proche (s'il existe) sinon il erre
			if (refPlusProche!=0) {
				parler("Je me dirige vers "+refPlusProche);
			}
			else 
				parler("J'erre..."); 
			
			seDirigerVers(refPlusProche);	
		}
	}
	
	/**
	 * Deplace ce sujet d'une case en direction du sujet dont la reference est donnee en parametre.
	 *
	 * @param ref la reference de l'element cible
	 */
	public void seDirigerVers(int ref) {
		Point pvers;
		
		//si la cible est l'element meme, il reste sur place
		if (ref==ve.getRef()) return;

		//s'il n'y a pas de reference la plus proche
		if (ref==0) {
			//si le point ou l'element se trouve est le point d'errance precedemment defini
			if ((pointErrance!=null) && (pointErrance.equals(ve.getPoint()))) { 
				//le point d'errance est reinitialise
				pointErrance=null;
			}
			if (pointErrance==null) {
				//initialisation aleatoire
				Random r=new Random();
				pointErrance=new Point(r.nextInt(100), r.nextInt(100));
			}
			//la cible devient le nouveau point d'errance
			pvers=pointErrance;
		} 
		//sinon la cible devient le point sur lequel se trouve l'element le plus proche
		else {
			pvers=voisins.get(ref).getPoint();
		}
		
		//si l'element n'existe plus (cas posible: deconnexion du serveur), le point reste sur place
		if (pvers==null) return;
		
		//calcule la direction pour atteindre la ref (+1/-1 par rapport a la position courante)
		int dx=(int) (pvers.getX()-ve.getPoint().x);
		if (dx!=0)	
			dx=dx/Math.abs(dx);
		int dy=(int) (pvers.getY()-ve.getPoint().y);
		if (dy!=0)  
			dy=dy/Math.abs(dy);
		
		//instancie le point destination
		Point dest = new Point(ve.getPoint().x+dx,ve.getPoint().y+dy);
		
		//si le point destination est libre
		if (UtilitaireConsole.caseVide(dest,voisins)) {		
			//l'element courant se deplace
			ve.setPoint(dest);
		} 
		else {
			//cherche la case libre la plus proche dans la direction de la cible
			Point top = UtilitaireConsole.meilleurPoint(ve.getPoint(),dest,voisins);
			//deplace l'element courant sur celle-la
			ve.setPoint(top);
		}
	}

	/**
	 * Appelle par le serveur pour faire la MAJ du sujet.
	 *
	 * @return La vue de l'élément
	 * @throws RemoteException 
	 */
	public VueElement update() throws RemoteException {
		VueElement aux=(VueElement) ve.clone();
		aux.setPhrase(ve.getPhrase()); 
		return aux;
	}

	/**
	 * Deconnexion du controleur du serveur.
	 *
	 * @param cause le message à afficher comme cause de la deconnexion
	 * @throws RemoteException 
	 */
	public void shutDown(String cause) throws RemoteException {
		System.out.println("Console "+refRMI+" deconnectee : "+cause);
		System.exit(1);
	}

	/** 
	 * @see controle.IConsole#getElement()
	 */
	public Element getElement() throws RemoteException {
		return elem;
	}
	
	/** 
	 * @see controle.IConsole#getVueElement()
	 */
	public VueElement getVueElement() throws RemoteException {
		return ve;
	}
	
	/**
	 * @see controle.IConsole#parler(java.lang.String)
	 */
	public void parler(String s) throws RemoteException {
		ve.setPhrase(s);	
	}
	

	/**
	 * @see controle.IConsole#perdreVie(int)
	 */
	public void perdreVie(int viePerdue) throws RemoteException {
		this.elem.setVie(this.elem.getVie()-viePerdue);
		System.out.println("Ouch, j'ai perdu " + viePerdue + " points de vie. Il me reste " + this.elem.getVie() + " points de vie.");		
	}
	
	/**
	 * @see controle.IConsole#ramasserObjet(controle.IConsole)
	 */
	public void ramasserObjet(IConsole objet) throws RemoteException {
		objet.getVueElement().setTTL(0);
		((Personnage) elem).addObjet((Objet) objet.getElement());
	}
	
	/**
	 * @see controle.IConsole#afficher()
	 */
	public String afficher() throws RemoteException{
		return this.elem.toString();
	}

	/**
	 * Ajout l'element dans la liste des elements connus (combattants et equipements).
	 *
	 * @param ref l'element a ajouter
	 * @throws RemoteException the remote exception
	 */
	public void ajouterConnu(int ref) throws RemoteException {
		elem.ajouterConnu(ref);
	}
		
}
