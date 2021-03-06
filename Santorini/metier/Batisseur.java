/**
 * @author Lechanoine,Levallois,Beaumont,Lebosse,Labbe,Dupont
 * @date 18/06/2018
 * @version 1.0
 */
package Santorini.metier;

import java.util.ArrayList;

public class Batisseur {
    
    /*-------------------*/
    /*     CONSTANTES    */
    /*-------------------*/
    
    private final static int TAILLE_GRILLE = 5;
    
    /*-------------------*/
    /*     ATTRIBUTS     */
    /*-------------------*/
    
    static String[][] grilleBat = new String[TAILLE_GRILLE][TAILLE_GRILLE];
    private int posLigne   ;
    private int posColonne ;
    private Plateau plateau;
    boolean depla = false;
    private String id;
    private Joueur joueur;
    
    /*-------------------*/
    /*   CONSTRUCTEUR    */
    /*-------------------*/
    
    /**
     * Creer un Batisseur
     * @param id permet de representer le Batisseur
     * @param plateau donne l'acces au plateau aux Batisseur
     */
    public Batisseur(String id ,Plateau plateau , Joueur joueur)
    {
        this.plateau = plateau;
        this.id = id;
        this.joueur = joueur;
    }
    
    /*-------------------*/
    /*     METHODES      */
    /*-------------------*/
    
    /**
     * Permet de tester si l'emplacement a la direction demandé est disponible si oui bouge le batisseur
     * @param direction permet de choisir la direction de mouvement au format (N,NE,NO,E,O,S,SE,SO)
     * @return 
     */
    public boolean deplacement(String direction)
    {
        boolean reussite = false; 
        int tmpLigne     = this.posLigne;            //creation de valeur temporaire pour les test
        int tmpColonne   = this.posColonne;
        
        
        switch (direction)                            //chagement des valeur par rapport au choix du joueur
        {
            case "N"  : tmpLigne   --; 
                break;
            case "NE" : tmpLigne   --;
                        tmpColonne ++;
                break;
            case "NO" : tmpLigne   --;
                        tmpColonne --;
                break;
            case "E"  : tmpColonne ++;
                break;
            case "O"  : tmpColonne --;
                break;
            case "S"  : tmpLigne   ++;
                break;
            case "SE" : tmpLigne   ++;
                        tmpColonne ++;
                break;
            case "SO" : tmpLigne   ++;
                        tmpColonne --;
                break;
        }
        
        return setPos(tmpLigne, tmpColonne);
    }
    public void setDeplacement(boolean depla){this.depla = depla;}
    /**
     * permet de tester si la position est disponible et si oui affecte le batiseur sur la position
     * @param tmpLigne est la ligne de la position a tester
     * @param tmpColonne est la colone de a pisition a tester
     * @return renvoie si la position a ete affecte ou non
     */
    public boolean setPos(int tmpLigne, int tmpColonne) 
    {
        boolean reussite    = false;
        boolean bati        = false;
        boolean hauteur     = false;
        
        if(tmpLigne >= 0 && tmpLigne <= 4 && tmpColonne >= 0 && tmpColonne <= 4)
        {
            if(Batisseur.grilleBat[tmpLigne][tmpColonne] == null)                                                   {bati = true;}
            if(plateau.getHauteur(tmpLigne, tmpColonne) >= 0 && plateau.getHauteur(tmpLigne, tmpColonne) <= 3)      {hauteur = true;}
        }
        
        if( bati && hauteur)
        {
            reussite = true;
            
            if(depla)
            {
                Batisseur.grilleBat[this.posLigne][this.posColonne] = null;
                this.depla = false;
            }
            
            this.posLigne   = tmpLigne  ;
            this.posColonne = tmpColonne;
            
            Batisseur.grilleBat[this.posLigne][this.posColonne] = this.id;
        }
        this.depla = false;
        return reussite;
    }
   
    /*-------------------*/
    /*    ACCESSEURS     */
    /*-------------------*/
    
    /**
     * Accesseur Ligne
     * @return la ligne du Batisseur
     */
    public int getLigne  () {return this.posLigne;                         }
    /**
     * Accesseur Colonne
     * @return la colone du Batisseur
     */
    public int getColonne() {return this.posColonne;                       }
    /**
     * Accesseur hauteur
     * @return la hauteur du Batisseur
     */
    public int getPos    () {return (this.posLigne * 10) + this.posColonne;}
    
    public String getId  () {return this.id;}
    
    public  Joueur getJoueur() {return this.joueur;}
    
}

