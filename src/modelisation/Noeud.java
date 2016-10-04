<<<<<<< HEAD

package modelisation;

import java.util.ArrayList;

/**
 *
 * @author Nicolas & Manon
 * @param <E>
 * 
 */

/*Ceci est la classe qui représente chaque Noeud de l'arbre,
	la racine est définie comme un Noeud dont le père est null,
	les feuilles sont définies par un Noeud dont les fils sont tous null,
	L'ordre de l'arbre détermine la taille des tableaux fils, clefs et valeurs.*/
public class Noeud <E extends Comparable>{

	private Noeud<E> pere;		//Noeud présent au dessus du Noeud dans lequel on se trouve (utile pour les algorithmes de recherche), la racine n'en a pas.
	private Noeud<E> voisin;	//Noeud présent à droite du Noeud dans lequel on se trouve (utile pour la fusion et la recherche par intervalle).
	private Noeud<E>[] fils;	//Noeuds liés au Noeud dans lequel on se trouve (sa taille est égale à Arbre.ordre+1).
	private E[] clefs;			//Tableau de clefs permettant le classement dans l'arbre (sa taille est égale à Arbre.ordre)
	private Object[] valeurs;			//Tableau de références vers les objets de la base de donnée.
	
	//Constructeur premettant de prendre en compte toutes les informations possible pour créer directement le Noeud désiré.
	public Noeud(Noeud<E> pere, Noeud<E>[] fils, E[] clefs, Noeud<E> voisin, Object[] valeurs) {
		this.pere = pere;
		this.fils = fils;
		this.clefs = clefs;
		this.voisin = voisin;
		this.valeurs = valeurs;
	}
	
	//Constructeur prenant en paramètre le Noeud père et l'ordre de l'arbre, on crée donc un Noeud avec potentiellement un père dans l'arbre et des tableaux de la bonne taille sans contenu
	public Noeud(Noeud<E> pere,int ordre) {
		this.pere = pere;																//On donne la valeur du père.
		
		//Il est impossible de créer directement des tableaux d'éléments génériques avec une taille définie à l'avance en java, on utilise donc des ArrayList que l'on convertira en tableaux après.
		ArrayList<Noeud<E>> listNoeud = new ArrayList<Noeud<E>>();	//On crée une liste de Noeuds vide (taille 0).
		ArrayList<E> listClefs = new ArrayList<E>();					//On crée une liste d'objets comparables (taille 0).
		ArrayList listValeurs = new ArrayList();	
		for (int i = 0; i < ordre; i++) {listNoeud.add(null);listClefs.add(null);listValeurs.add(null);}		//On modifie la taille des listes en ajoutant des éléments null.
		listNoeud.add(null);
		
		this.fils = ((Noeud<E>[])(listNoeud).toArray());						//On transforme la liste ainsi créée en tableau des bons éléments et de la bonne taille pour les fils.
		this.clefs = ((E[])(listClefs).toArray());								//On transforme la liste ainsi créée en tableau des bons éléments et de la bonne taille pour les clefs.
		this.valeurs = ((Object[])(listValeurs).toArray());
		this.voisin=null;																//Par défaut le Noeud n'a pas de voisin de droite, on pourra modifier cela en insérant le Noeud dans l'arbre.
	}

	//Accesseurs
	public Noeud<E> getPere() {
		return pere;
	}

	public void setPere(Noeud<E> pere) {
		this.pere = pere;
	}

	public Noeud<E>[] getFils() {
		return fils;
	}

	public void setFils(Noeud<E>[] fils) {
		this.fils = fils;
	}

	public Object[] getValeurs() {
		return valeurs;
	}

	public void setValeurs(Object[] valeurs) {
		this.valeurs = valeurs;
	}

	public Noeud<E> getVoisin() {
		return voisin;
	}

	public void setVoisin(Noeud<E> voisin) {
		this.voisin = voisin;
	}

	public Comparable[] getClefs() {
		return clefs;
	}

	public void setClefs(E[] clefs) {
		this.clefs = clefs;
	}
        
        
        
        public Boolean isRacine(){ //Fonction qui va permettre de tester si le Noeud est ue racine
            return pere==null;
        }
        
        public Boolean isFeuille(){ //Vérifie si le Noeud est une feuille
            for(Noeud<E> elt:fils){
				if(elt!=null){return false;}
			}
			return true;
        }
		
		public int valueNbr(){
			int nbr = 0;
			for(Comparable elt:clefs){
				if(elt!=null){nbr++;}
				else{return nbr;}
			}
			return nbr;
		}
	
}
=======

package modelisation;

import java.util.ArrayList;

/**
 *
 * @author Nicolas & Manon
 * @param <Comparable>
 */

/*Ceci est la classe qui représente chaque Noeud de l'arbre,
	la racine est définie comme un Noeud dont le père est null,
	les feuilles sont définies par un Noeud dont les fils sont tous null,
	L'ordre de l'arbre détermine la taille des tableaux fils, clefs et valeurs.*/
public class Noeud <Comparable>{

	private Noeud<Comparable> pere;		//Noeud présent au dessus du Noeud dans lequel on se trouve (utile pour les algorithmes de recherche), la racine n'en a pas.
	private Noeud<Comparable> voisin;	//Noeud présent à droite du Noeud dans lequel on se trouve (utile pour la fusion et la recherche par intervalle).
	private Noeud<Comparable>[] fils;	//Noeuds liés au Noeud dans lequel on se trouve (sa taille est égale à Arbre.ordre+1).
	private Comparable[] clefs;			//Tableau de clefs permettant le classement dans l'arbre (sa taille est égale à Arbre.ordre)
	private Object[] valeurs;			//Tableau de références vers les objets de la base de donnée.
	
	//Constructeur premettant de prendre en compte toutes les informations possible pour créer directement le Noeud désiré.
	public Noeud(Noeud<Comparable> pere, Noeud<Comparable>[] fils, Comparable[] clefs, Noeud<Comparable> voisin, Object[] valeurs) {
		this.pere = pere;
		this.fils = fils;
		this.clefs = clefs;
		this.voisin = voisin;
		this.valeurs = valeurs;
	}
	
	//Constructeur prenant en paramètre le Noeud père et l'ordre de l'arbre, on crée donc un Noeud avec potentiellement un père dans l'arbre et des tableaux de la bonne taille sans contenu
	public Noeud(Noeud<Comparable> pere,int ordre) {
		this.pere = pere;																//On donne la valeur du père.
		
		//Il est impossible de créer directement des tableaux d'éléments génériques avec une taille définie à l'avance en java, on utilise donc des ArrayList que l'on convertira en tableaux après.
		ArrayList<Noeud<Comparable>> listNoeud = new ArrayList<Noeud<Comparable>>();	//On crée une liste de Noeuds vide (taille 0).
		ArrayList<Comparable> listClefs = new ArrayList<Comparable>();					//On crée une liste d'objets comparables (taille 0).
		for (int i = 0; i < ordre; i++) {listNoeud.add(null);listClefs.add(null);}		//On modifie la taille des listes en ajoutant des éléments null.
		listNoeud.add(null);
		
		this.fils = ((Noeud<Comparable>[])(listNoeud).toArray());						//On transforme la liste ainsi créée en tableau des bons éléments et de la bonne taille pour les fils.
		this.clefs = ((Comparable[])(listClefs).toArray());								//On transforme la liste ainsi créée en tableau des bons éléments et de la bonne taille pour les clefs.
		this.voisin=null;																//Par défaut le Noeud n'a pas de voisin de droite, on pourra modifier cela en insérant le Noeud dans l'arbre.
	}
        
	//Accesseurs
	public Noeud<Comparable> getPere() {
		return pere;
	}

	public void setPere(Noeud<Comparable> pere) {
		this.pere = pere;
	}

	public Noeud<Comparable>[] getFils() {
		return fils;
	}

	public void setFils(Noeud<Comparable>[] fils) {
		this.fils = fils;
	}

	public Object[] getValeurs() {
		return valeurs;
	}

	public void setValeurs(Object[] valeurs) {
		this.valeurs = valeurs;
	}

	public Noeud<Comparable> getVoisin() {
		return voisin;
	}

	public void setVoisin(Noeud<Comparable> voisin) {
		this.voisin = voisin;
	}

	public Comparable[] getClefs() {
		return clefs;
	}

	public void setClefs(Comparable[] clefs) {
		this.clefs = clefs;
	}
        
        
        
        public Boolean isRacine(){ //Fonction qui va permettre de tester rapidement 
            return this.pere == null;
        }
        
        public Boolean isFeuille(){
            return true;
        }
        public void insérer(Comparable ajout, Object val){
            if ( this.isFeuille() && this.isRacine()){
                
            }
        }

	
}
>>>>>>> refs/remotes/origin/master
