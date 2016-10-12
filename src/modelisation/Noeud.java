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
public abstract class Noeud<E extends Comparable> {

    public NoeudN<E> pere;		//Noeud présent au dessus du Noeud dans lequel on se trouve (utile pour les algorithmes de recherche), la racine n'en a pas.
    public Noeud<E> voisin;	//Noeud présent à droite du Noeud dans lequel on se trouve (utile pour la fusion et la recherche par intervalle).
    public E[] clefs;

    public NoeudN<E> getPere() {
        return pere;
    }

    public void setPere(NoeudN<E> pere) {
        this.pere = pere;
    }

    public Noeud<E> getVoisin() {
        return voisin;
    }

    public void setVoisin(Noeud<E> voisin) {
        this.voisin = voisin;
    }

    public E[] getClefs() {
        return clefs;
    }

    public void setClefs(E[] clefs) {
        this.clefs = clefs;
    }

    public int valueNbr() {
        int nbr = 0;
        for (Comparable elt : clefs) {
            if (elt != null) {
                nbr++;
            } else {
                return nbr;
            }
        }
        return nbr;
    }

    public boolean contains(E cle) {
        for (E elt : clefs) {
            if (cle.equals(elt)) {
                return true;
            }
        }
        return false;
    }

    public abstract Feuille find(E cle);

    public int findIn(E cle) {
        for (int i = 0; i < clefs.length; i++) {
            if (cle.equals(clefs[i])) {
                return i;
            }
        }
        return -1;
    }

    public int findPos(E cle) {
        for (int i = 0; i < clefs.length; i++) {
            if (clefs[i] == null || cle.compareTo(clefs[i]) > 0) {
                return i;
            }
        }
        return clefs.length;
    }
    
    public boolean isRacine() {
        return (this.pere == null);
    }
    
    public abstract String toString();
    public abstract void addIn(E cle, Object valeur);
    
    public String clefsToString(){
        String n = "(";
        for (int i = 0; i < clefs.length; i++) {
            n = n + clefs[i] + " ";
        }
        return n + ")";
    }
       
}
