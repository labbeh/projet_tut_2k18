package Santorini.metier;

public class Joueur 
{
    /*-------------------*/
    /*     CONSTANTES    */
    /*-------------------*/

    private static final char[] ID_POSSIBLE = {'A','A','B','B'};
    private final int NB_BATISSEUR          = 2                ;
    
    /*-------------------*/
    /*     ATTRIBUT      */
    /*-------------------*/
    
    private static int compteurBatisseur;
    private final String nom;
    private Batisseur[] ensBatisseur;
    private Plateau plateau;
    
    /*-------------------*/
    /*   CONSTRUCTEUR    */
    /*-------------------*/
    
    public Joueur(String nom, Plateau plateau)
    {
        this.nom = nom;
        this.plateau = plateau;
        this.ensBatisseur = new Batisseur[NB_BATISSEUR];
        
        for (int cpt = 0; cpt < 2; cpt++) 
        {
            String id = "" + this.nom.charAt(0) + (cpt + 1);
            ensBatisseur[cpt] = new Batisseur(id ,this.plateau);
            Joueur.compteurBatisseur++;  
        }
        
    }
    
    public boolean initBatisseur(int numeroBatisseur, int ligne, int colonne)
    {
        return this.ensBatisseur[numeroBatisseur].setPos(ligne, colonne);
    }
    public Batisseur getBatisseur(int numBatisseur){return this.ensBatisseur[numBatisseur - 1];}
    public String getNom(){return this.nom;}
    
    public boolean deplacement(int numeroBatisseur, String direction)
    {
        return this.ensBatisseur[numeroBatisseur - 1].deplacement(direction);
        
    }
}
