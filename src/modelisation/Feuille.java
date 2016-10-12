/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelisation;

import java.util.ArrayList;

/**
 *
 * @author Manon
 */
public class Feuille<E extends Comparable> extends Noeud<E> {

    private ArrayList valeurs;			//Tableau de références vers les objets de la base de donnée.

    public Feuille(NoeudN<E> pere, modelisation.Noeud<E> voisin, ArrayList<E> clefs, ArrayList valeurs, int ordre) {
        this.pere = pere;
        this.voisin = voisin;
        this.clefs = clefs;
        this.valeurs = valeurs;
		this.ordre = ordre;
    }
    
    public Feuille(NoeudN<E> pere, int ordre){
        this.pere = pere;
        this.ordre = ordre;
    }

    public ArrayList getValeurs() {
        return valeurs;
    }

    public void setValeurs(ArrayList valeurs) {
        this.valeurs = valeurs;
    }

    @Override
    public Feuille find(E cle) {
        return this;
    }

    @Override
    public void addIn(E cle, Object valeur) {
        int pos = findPos(cle);
        E cle2 = null;
        Object valeur2 = null;
        for (int i = pos; i < clefs.size(); i++) {
            cle2 = clefs.get(i);
            valeur2 = valeurs.get(i);
            clefs.set(i, cle);
            valeurs.set(i, valeur);
            cle = cle2;
            valeur = valeur2;
        }
    }
    
        public String valeursToString(){
        String n = "[";
        for (int i = 0; i < valeurs.size(); i++) {
            n = n + valeurs.get(i) + " ";
        }
        return n + "]";
    }

    @Override
    public String toString (){
		StringBuffer s = new StringBuffer((clefs.size()*clefs.get(0).toString().length()+2)*(valeurs.size()+1)+2);
		s.append(this.clefsToString());
		s.append("[");
		for(Object elt: valeurs){
			s.append(elt.toString());
		}
		s.append("]");
        return s.toString();
    }
}
