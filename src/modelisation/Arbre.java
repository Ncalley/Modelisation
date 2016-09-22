/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelisation;

/**
 * @version beta 0.1
 * @author Nicolas
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

	
}
