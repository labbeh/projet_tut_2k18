/**
 * @author Lechanoine,Levallois,Beaumont,Lebosse,Labbe,Dupont
 * @date 18/06/2018
 * @version 1.0
 */
package Santorini.metier;

import java.util.ArrayList;

public class Joueur 
{
    /*-------------------*/
    /*     CONSTANTES    */
    /*-------------------*/

    private final int NB_BATISSEUR = 2 ;
    private static final String[] ENSCOULEUR = new String[]{"Bleu" , "Gris", "Blanc"};
    private static int NBJOUEUR = 0;

    
    /*-------------------*/
    /*     ATTRIBUT      */
    /*-------------------*/
    
    private static int compteurBatisseur;
    private Batisseur[] ensBatisseur;
    private final String nom;
    private Plateau plateau;
    private String couleur;
    
    /*-------------------*/
    /*   CONSTRUCTEUR    */
    /*-------------------*/
    
    /**
     * Creer un Joueur
     * @param nom du joueur
     * @param plateau donne l'acces au plateau aux Joueurs
     */
    public Joueur(String nom, Plateau plateau)
    {
        this.nom = nom;
        this.plateau = plateau;
        this.ensBatisseur = new Batisseur[NB_BATISSEUR];
        this.couleur = Joueur.ENSCOULEUR[Joueur.NBJOUEUR++];
        
        for (int cpt = 0; cpt < 2; cpt++) 
        {
            String id = "" + this.couleur.charAt(0) + (cpt + 1);
            ensBatisseur[cpt] = new Batisseur(id ,this.plateau, this);
            Joueur.compteurBatisseur++;  
        }
    }
    
    /*-------------------*/
    /*     METHODES      */
    /*-------------------*/
    
    /**
     * Permet de d'assigne un Batisseur au joueur et le placer sur la grille
     * @param numeroBatisseur explicite
     * @param ligne la ligne ou placer le Batisseur
     * @param colonne la colonne ou placer le Batisseur
     * @return Si la creation du Batisseur a reussi
     */
    public boolean initBatisseur(int numeroBatisseur, int ligne, int colonne)
    {
        return this.ensBatisseur[numeroBatisseur].setPos(ligne, colonne);
    }
    
    /**
     * Deplace le batisseur choisie
     * @param numeroBatisseur le batisseur choisie
     * @param direction la direction de deplacement
     * @return si le deplacement a reussi
     */
    
    public boolean deplacement(int numeroBatisseur ,String direction)
    {
        boolean reussite = false; 
        int tmpLigne     = this.ensBatisseur[numeroBatisseur - 1].getLigne();            //creation de valeur temporaire pour les test
        int tmpColonne   = this.ensBatisseur[numeroBatisseur - 1].getColonne();
        
        
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
        this.ensBatisseur[numeroBatisseur - 1].setDeplacement(true);
        return this.ensBatisseur[numeroBatisseur - 1].setPos(tmpLigne, tmpColonne);
    }
    
    /*-------------------*/
    /*     ACCESSEURS    */
    /*-------------------*/
    
    /**
     * Accesseur Batisseur
     * @param choisie un des batisseur du joueur
     * @return le batiseur choisie
     */
    public Batisseur getBatisseur(int numBatisseur){return this.ensBatisseur[numBatisseur - 1];}
    /**
     * Accesseur Nom
     * @return le nom du Batisseur
     */
    public String    getNom      ()                {return this.nom;}
    /**
     * Accesseur Couleur
     * @return la couleur du joueur 
     */
    public String getCouleur(){return this.couleur;}
    /**
     * Accesseur nombre batisseur
     * @return Le nombre max de Batisseur
     */
    public int getNbBatisseur()
    {
        return this.NB_BATISSEUR;
    }
}
