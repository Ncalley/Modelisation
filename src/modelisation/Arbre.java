package modelisation;

/**
 * @version beta 0.1
 * @author Nicolas & Manon
 * @param <Comparable>
 */

/*Il s'agit de l'arbre B+ demandé par l'énoncé,
	il contient des références vers les objets de la base de donnée,
	ces objets sont triées par clé dans l'arbre et les clés doivent donc être comparables par définition,
	l'ordre de l'arbre est donnée par l'utilisateur et déterminera la construction de l'arbre ainsi que la stratégie de split.*/
public class Arbre<E extends Comparable> {

    private int ordre;					//Il s'agit de l'ordre de l'arbre
    private Noeud<E> racine;

    public Arbre(int ordre) throws Exception {
        if (ordre < 2) {
            throw new Exception("L'arbre ne peut pas avoir un ordre inférieur à 2");
        }
        this.ordre = ordre;
        this.racine = null;
    }

    public int getOrdre() {
        return ordre;
    }

    public Noeud getRacine() {
        return racine;
    }

    public void add(E cle, Object valeur) {
        Feuille n = racine.find(cle); // on trouve a quel endroit la valeur clé doit etre insérer
        if (n.findPos(cle) == -1) {
                internalAdd(n,cle,valeur); //donc dans la feuille
        }

    }

    /*Si racine on arrête de chercher
	ce qu'elle doit faire:
		- si*/
    private void internalAdd(Feuille<E> n, E cle, Object valeur) {
       //On commence l'insertion donc on ets forcément dans une feuille
            if (n.valueNbr() != ordre) { // si le noeud n'est pas plain on ajoute simplement grace à la methode addIn
                n.addIn(cle, valeur);
            } 
            else { //si le noeud est plein 
                int pos = n.findPos(cle); //pos va etre egal a la position qu'il devrait avoir
                Feuille<E> n1 = new Feuille<E>(n.getPere(), ordre); //on crée deux noeuds qui vont donc remplacer n donc qui auraont pour pere le pere de n
                Feuille<E> n2 = new Feuille<E>(n.getPere(), ordre);
                int midOrdre;
                if (ordre % 2 == 0) { //si l'ordre ets impair (dans notre cas 4 mais nous preferons rester general) on va faire un split 2/3 
                    midOrdre = ordre / 2;
                } else {
                    midOrdre = ordre - 1 / 2;
                }
                for (int i = 0; i < ordre; i++) {//on va parcourir l'ancien noeud
                    if (i < midOrdre) { //quand on est avant la valeur médiane
                        if (pos == i) { //oui je sais c'est pas vraiment opti mais ca marche
                            n1.addIn(cle, valeur);
                            if (midOrdre == i) {//dans le cas ou on ajoute la valeur et qu'on est a la fin du split
                                n2.addIn(n.getClefs()[i], n.getValeurs()[i]);
                            } else {
                                n1.addIn(n.getClefs()[i], n.getValeurs()[i]);
                            }
                        } else {
                            n1.addIn(n.getClefs()[i], n.getValeurs()[i]);
                        }

                    } else {
                        if (pos == i) {
                            n1.addIn(cle, valeur);
                        }
                        n2.addIn(n.getClefs()[i], n.getValeurs()[i]);

                    }
                    n1.setVoisin(n2); //N2 est le voisin de n1
                }
                E mediane = n2.getClefs()[0];
                if (!n.isRacine()) {
                    n.getPere().addFils(n1); //On ajoute les nouveaux fils au pere
                    n.getPere().addFils(n2);
                    n.getPere().addMediane(mediane); //on ajoute au pere une nouvelle valeur 
                } else {
                    NoeudN pere = new NoeudN(null, ordre);
                    pere.addFils(n1);
                    pere.addFils(n2);
                    pere.getClefs()[0] = mediane;
                }

            }

    }
    
    public Feuille rechercheFirstF(){
        
    }
 
    public String afficher() {
        String aff ="";
        //on va cehrcher la première feuille 
        //et tant que la prochaine existe (voisins existe) afficher tout
        

       return aff;
    }
}
