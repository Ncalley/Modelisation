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
 * @param <E>
 */
public class NoeudN<E extends Comparable> extends Noeud<E> {
    

    private Noeud<E>[] fils;	//Noeuds liés au Noeud dans lequel on se trouve (sa taille est égale à Arbre.ordre+1).

    public NoeudN(NoeudN<E> pere, modelisation.Noeud<E> voisin, modelisation.Noeud<E>[] fils, E[] clefs) {
        this.pere = pere;
        this.voisin = voisin;
        this.fils = fils;
        this.clefs = clefs;
    }
    
    public NoeudN(NoeudN<E> pere, int ordre){
        this.pere = pere;																//On donne la valeur du père.

        //Il est impossible de créer directement des tableaux d'éléments génériques avec une taille définie à l'avance en java, on utilise donc des ArrayList que l'on convertira en tableaux après.
        ArrayList<NoeudN<E>> listNoeud = new ArrayList<NoeudN<E>>();	//On crée une liste de Noeuds vide (taille 0).
        ArrayList<E> listClefs = new ArrayList<E>();					//On crée une liste d'objets comparables (taille 0).
        ArrayList listValeurs = new ArrayList();
        for (int i = 0; i < ordre; i++) {
            listNoeud.add(null);
            listClefs.add(null);
            listValeurs.add(null);
        }		//On modifie la taille des listes en ajoutant des éléments null.
        listNoeud.add(null);

       
        this.clefs = ((E[]) (listClefs).toArray());								//On transforme la liste ainsi créée en tableau des bons éléments et de la bonne taille pour les clefs.
        this.voisin = null;
    }

    public Noeud<E>[] getFils() {
        return fils;
    }

    public void setFils(Noeud<E>[] fils) {
        this.fils = fils;
    }
    

    @Override
    public Feuille find(E cle) {
        for (int i = 0; i < clefs.length; i++) {
            if (clefs[i].compareTo(cle) < 0) {
                return fils[i].find(cle);
            }
        }
        return fils[fils.length - 1].find(cle);
        
    }
        
 
    public void addIn(E cle, Object valeur) {
        int pos = findPos(cle);
        E cle2 = null;
        for (int i = pos; i < clefs.length; i++) {
            cle2 = clefs[i];
            clefs[i] = cle;
            cle = cle2;
        }
    }
    
    public void addFils(Noeud fils) { //Meme chose que addIn mais pour les noeuds qui ne sont pas des feuilles
        // int pos = findPos();
        Noeud f = null;
        for (int i = 0; i < clefs.length; i++) {
            f = getFils()[i];
            getFils()[i] = fils;
            fils = f;
        }
    }
    
    public void addMediane(E mediane) {
        int ordre = clefs.length;
        //Premierement le cas le plus simple , il y a de la place pour la nouvelle valeur dans le noeud
        if (this.valueNbr() != ordre) {
            this.addIn(mediane,null); //on ajoute la valeur médiane
        } else { //ensuite dans le cas ou le noeud est plein
            int pos = this.findPos(mediane); //pos va etre egal a la position qu'il devrait avoir
            NoeudN<E> n1 = new NoeudN(this.getPere(), ordre); //on crée deux noeuds qui vont donc remplacer this donc qui auront pour pere this.pere
            NoeudN<E> n2 = new NoeudN(this.getPere(), ordre);
            int midOrdre;
            if (ordre % 2 == 0) { //si l'ordre ets impair (dans notre cas 4 mais nous preferons rester general) on va faire un split 2/3 
                midOrdre = ordre / 2;
            } else {
                midOrdre = ordre - 1 / 2;
            }
            for (int i = 0; i < ordre; i++) {//on va parcourir l'ancien noeud
                if (i < midOrdre) { //quand on est avant la valeur médiane
                    if (pos == i) { //oui je sais c'est pas vraiment opti mais ca marche
                        n1.addIn(mediane,null);
                        if (midOrdre == i) {//dans le cas ou on ajoute la valeur et qu'on est a la fin du split
                            n2.addIn(this.getClefs()[i],null);
                        } else {
                            n1.addIn(this.getClefs()[i],null);
                        }
                    } else {
                        n1.addIn(this.getClefs()[i],null);
                    }

                } else {
                    if (pos == i) {
                        n1.addIn(mediane,null);
                    }
                    n2.addIn(this.getClefs()[i],null);
                }
                n1.setVoisin(n2); //N2 est le voisin de n1
            }
            E med = n2.getClefs()[0];
            if (!this.isRacine()) {
                this.getPere().addFils(n1); //On ajoute les nouveaux fils au pere
                this.getPere().addFils(n2);
                this.getPere().addMediane(med); //on ajoute au pere une nouvelle valeur 
            } else {
                NoeudN pere = new NoeudN(null, ordre);
                pere.addFils(n1);
                pere.addFils(n2);
                pere.getClefs()[0] = med;

            }
        }
    }
    
    @Override
    public String toString (){
        if (this.isRacine()){
            return clefsToString();
        }
        else {
           return getPere().toString() +" - "+ clefsToString();
        }
    }
}
