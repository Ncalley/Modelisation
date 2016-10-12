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

    private Object[] valeurs;			//Tableau de références vers les objets de la base de donnée.

    public Feuille(NoeudN<E> pere, modelisation.Noeud<E> voisin, E[] clefs, Object[] valeurs) {
        this.pere = pere;
        this.voisin = voisin;
        this.clefs = clefs;
        this.valeurs = valeurs;
    }

    public Feuille(NoeudN<E> pere, int ordre) {
        this.pere = pere;																//On donne la valeur du père.

        //Il est impossible de créer directement des tableaux d'éléments génériques avec une taille définie à l'avance en java, on utilise donc des ArrayList que l'on convertira en tableaux après.
        ArrayList<Noeud<E>> listNoeud = new ArrayList<Noeud<E>>();	//On crée une liste de Noeuds vide (taille 0).
        ArrayList<E> listClefs = new ArrayList<E>();					//On crée une liste d'objets comparables (taille 0).
        ArrayList listValeurs = new ArrayList();
        for (int i = 0; i < ordre; i++) {
            listNoeud.add(null);
            listClefs.add(null);
            listValeurs.add(null);
        }		//On modifie la taille des listes en ajoutant des éléments null.
        listNoeud.add(null);

        this.clefs = ((E[]) (listClefs).toArray());								//On transforme la liste ainsi créée en tableau des bons éléments et de la bonne taille pour les clefs.
        this.valeurs = ((Object[]) (listValeurs).toArray());
        this.voisin = null;
    }

    public Object[] getValeurs() {
        return valeurs;
    }

    public void setValeurs(Object[] valeurs) {
        this.valeurs = valeurs;
    }

    @Override
    public Feuille find(E cle) {
        return this;
    }

    public void addIn(E cle, Object valeur) {
        int pos = findPos(cle);
        E cle2 = null;
        Object valeur2 = null;
        for (int i = pos; i < clefs.length; i++) {
            cle2 = clefs[i];
            valeur2 = valeurs[i];
            clefs[i] = cle;
            valeurs[i] = valeur;
            cle = cle2;
            valeur = valeur2;
        }
    }

    @Override
    public String toString (){
        //return getPere().toString + clefsToString() + valeurToString() 
        return "";
    }
    
}
