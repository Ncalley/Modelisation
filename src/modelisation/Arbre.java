<<<<<<< HEAD

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
public class Arbre <E extends Comparable>{
	
	
	private int ordre;					//Il s'agit de l'ordre de l'arbre
	private Noeud<E> racine;

	public Arbre(int ordre) throws Exception{
		if(ordre<2){throw new Exception("L'arbre ne peut pas avoir un ordre négatif");}
		this.ordre = ordre;
		this.racine = null;
	}

	public int getOrdre() {
		return ordre;
	}

	public Noeud getRacine() {
		return racine;
	}
        
    public void afficher(){
            
    }

	public void add(Noeud<E> n){
		
	}
	
	public void remove(Noeud<E> n){
		
	}
}
=======

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
public class Arbre <Comparable>{
	
	
	private int ordre;					//Il s'agit de l'ordre de l'arbre
	private Noeud<Comparable> racine;

	public Arbre(int ordre) throws Exception{
		if(ordre<2){throw new Exception("L'arbre ne peut pas avoir un ordre négatif");}
		this.ordre = ordre;
		this.racine = null;
	}

	public int getOrdre() {
		return ordre;
	}

	public Noeud<Comparable> getRacine() {
		return racine;
	}
        
        public void afficher(){
            //a|(a,1)(b,2);(c,3)(d,4)]
        }

	
}
>>>>>>> refs/remotes/origin/master
