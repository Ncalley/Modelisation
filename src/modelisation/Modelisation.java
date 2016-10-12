package modelisation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
//operrin@loria.fr
/**
 *
 * @author Nicolas & Manon
 */
public class Modelisation {

    public static void main(String[] args) throws Exception {
        JOptionPane fenOrdre = new JOptionPane();
        String ordreS = fenOrdre.showInputDialog(null, "Quel est l'ordre de l'arbre ?", "Ordre de l'arbre", JOptionPane.QUESTION_MESSAGE);
        int ordre = 0;
        if (ordreS.matches("\\d*")) {
            ordre = Integer.parseInt(ordreS);
        } else {
            ordre = 3; //par default 
            JOptionPane fenPrb = new JOptionPane();
            fenPrb.showMessageDialog(null, "Le nombre entré n'était pas correct par default il est défini à 3", "Attention", JOptionPane.WARNING_MESSAGE);
        }

        Arbre a = new Arbre(ordre); //on crée un arbre clé valeur
        String entree = "";
        
        
        //On va lire le fichier
        try {
            File fichier = new File("C:\\Users\\Manon\\Documents\\GitHub\\Modelisation\\src\\modelisation\\Test.txt"); 
            BufferedReader line = new BufferedReader(new FileReader(fichier)); //METTRE ICI LE FICHIER
            String ligne ="";
            
            try{
                ligne = line.readLine();
                
                while (ligne != null){
                    System.out.print(ligne);
                    traitement(ligne,a); //traitement va prendre la ligne la séparer et ajouter la clé et la valeur à l'arbre
                    ligne = line.readLine();
                }
                
                line.close();
                
            }
            catch(IOException e){
                
            }
        }
        catch (FileNotFoundException e){
            
        }
        
        
        

    }
    
    public static void traitement(String ligne, Arbre a){
        String cle ="";
        String val ="";
        int i = ligne.lastIndexOf("|");
        if (i != -1){
            cle = ligne.substring(0, i);
            val = ligne.substring(i+1, ligne.length());
            
            if (cle.matches("\\d*")){ //on test si cle est l'int ou si c'est val
                //si cle est un int alors val est un String donc on ajoute a l'arbre
                a.add(Integer.parseInt(cle),val);
            }
            else{
                if (val.matches("\\d*")){ //on test si cle est l'int ou si c'est val
                    //si val est un int alors int est un String donc on ajoute a l'arbre
                    a.add(cle,Integer.parseInt(val));
                    
                }
                else{
                    System.out.print("Probleme pas de int");
                }
            }
        }
        else {
            System.out.print("Probleme pas de |");
        }
    }



}
