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

    protected NoeudN<E> pere;		//Noeud présent au dessus du Noeud dans lequel on se trouve (utile pour les algorithmes de recherche), la racine n'en a pas.
    protected Noeud<E> voisin;	//Noeud présent à droite du Noeud dans lequel on se trouve (utile pour la fusion et la recherche par intervalle).
    protected ArrayList<E> clefs;
    protected int ordre;

	public int getOrdre() {
		return ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}
	

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

    public ArrayList<E> getClefs() {
        return clefs;
    }

    public void setClefs(ArrayList<E> clefs) {
        this.clefs = clefs;
    }

    public int valueNbr() { 
        int nbr = 0;
        for (E elt : this.getClefs()) {
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
        for (int i = 0; i < clefs.size(); i++) {
            if (cle.equals(clefs.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public int findPos(E cle) {
        for (int i = 0; i < clefs.size(); i++) {
            if (clefs.get(i) == null || cle.compareTo(clefs.get(i)) > 0) {
                return i;
            }
        }
        return clefs.size();
    }
    
    public boolean isRacine() {
        return (this.pere == null);
    }
    
    public abstract String toString();
    public abstract void addIn(E cle, Object valeur);
    
	//renvoie un résultat de type (5,6,8,10)
    public String clefsToString(){
        StringBuffer n = new StringBuffer(clefs.size()*clefs.get(0).toString().length()+2);
		n.append("(");
        for (int i = 0; i < clefs.size()-1; i++) {
            n.append(clefs.get(i) + ",");
        }
		n.append(clefs.get(clefs.size()-1));
		n.append(")");
        return n.toString();
    }
    
    public void remove(E cle){
        //
    }
       
}
