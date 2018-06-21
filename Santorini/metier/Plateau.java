/**
 * @author Lechanoine,Levallois,Beaumont,Lebosse,Labbe,Dupont
 * @date 18/06/2018
 * @version 1.0
 */
package Santorini.metier;

import java.util.Scanner;
import java.util.ArrayList;

public class Plateau 
{

    /*-------------------*/
    /*     CONSTANTES    */
    /*-------------------*/
        
    private final int NB_COLONNE   = 5;
    private final int NB_LIGNE     = 5;
    private final int NB_JOUEUR    = 2;
    private final int NB_BATISSEUR = 2;
        
    /*-------------------*/
    /*     ATTRIBUTS     */
    /*-------------------*/
        
    private int[][]  grilleJeu;  
    private Joueur[] ensJoueur;
        
    /*-------------------*/
    /*   CONSTRUCTEUR    */
    /*-------------------*/
    
    /**
     * Creer le plateau de jeu
     * @param joueur1 Nom du joueur 1
     * @param joueur2 Nom du joueur 2
     */
    public Plateau(String joueur1, String joueur2)                                                      // Initialisation de la grille de jeu
    {
        this.grilleJeu = new int[this.NB_LIGNE][this.NB_COLONNE];
        this.ensJoueur = new Joueur[NB_JOUEUR];
        
        this.ensJoueur[0] = new Joueur(joueur1, this);
        this.ensJoueur[1] = new Joueur(joueur2, this);
        
        this.grilleJeu[2][1] = 0;                           //permet de mettre en 2/1 la taille 0 a la tour
    }
    
    /*-------------------*/
    /*     METHODES      */
    /*-------------------*/  
    
    /**
     * Place un bloc avec le Batisseur chosie et la direction chosie  
     * @param direction direction ou est placer le bloc
     * @param joueur Le Joueur choisie
     * @param bati Le Batisseur choisie
     * @return Si on a pu placer le bloc ou non
     */ 
    
    public boolean placerBloc(String direction ,int joueur ,int bati)                                   //Place un bloc en en fonction de la direction et du batisseur selectionné
    {
        boolean resultat = false;
        Batisseur batisseur = ensJoueur[joueur].getBatisseur(bati);
        
        int tmpLigne     = batisseur.getLigne()  ;
        int tmpColonne   = batisseur.getColonne();
        
        switch (direction)
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
        
        if(tmpLigne >= 0 && tmpLigne <= 4 && tmpColonne >= 0 && tmpColonne <= 4 && (batisseur.grilleBat[tmpLigne][tmpColonne] == null))
        {
            if(this.grilleJeu[tmpLigne][tmpColonne] < 4)
            {
                this.grilleJeu[tmpLigne][tmpColonne] ++;
                resultat = true;
            }
        }
        
        return resultat;
    }
    
    public ArrayList<String> deplacementDispo(Batisseur batisseur)
    {
        String grilleBat[][]  = this.ensJoueur[1].getBatisseur(2).grilleBat;
        
        ArrayList<String> aDepl = new ArrayList<String>();
        
        int colonne =  batisseur.getColonne();
        int ligne =  batisseur.getLigne();
        int hauteur =  this.grilleJeu[ligne][colonne];
        
        String direction = "";    
        
        for (int cptLigne = (ligne-1); cptLigne <= (ligne+1); cptLigne++)
            for (int cptColonne = (colonne-1); cptColonne <= (colonne+1); cptColonne++)
                try
                {
                    if(this.grilleJeu[cptLigne][cptColonne] - hauteur <= 1 && hauteur < 4 && grilleBat[cptLigne][cptColonne] == null)
                    {
                        switch( ligne - cptLigne )
                        {
                            case -1 : direction += "N";
                                     break;
                            case 1  : direction += "S";
                                     break;
                        }
                        switch( colonne - cptColonne)
                        {
                            case -1 : direction += "O";
                                     break;
                            case 1  : direction += "E";
                                     break;
                        }
                        if( direction != "")
                            aDepl.add(direction);  
                        direction = "";
                    }
                }catch(ArrayIndexOutOfBoundsException evt){}
        
        return aDepl;
    } 
        
    
    
    /**
     * Test si le Batisseur chosie est bloque
     * @param batisseur le batissuer choisie
     * @return vrai si le Batisseur est bloque
     */
    /*public boolean estBloqueUnitaire(Batisseur batisseur)
    {
        String grilleBat[][]  = this.ensJoueur[1].getBatisseur(2).grilleBat;
        int ligne =  batisseur.getLigne();
        int colonne =  batisseur.getColonne();
        int hauteur =  this.grilleJeu[ligne][colonne];
        int sortiePossible = 0;
            
        
        for (int cptLigne = (ligne-1); cptLigne <= (ligne+1); cptLigne++)
        {
            for (int cptColonne = (colonne-1); cptColonne <= (colonne+1); cptColonne++)
            {
                try{
                    if(this.grilleJeu[cptLigne][cptColonne] - hauteur <= 1 && grilleBat[cptLigne][cptColonne] == null)
                    {
                        sortiePossible ++;
                    }
                }catch(ArrayIndexOutOfBoundsException evt){}
            }
        }
        
        if(sortiePossible >= 1) return false;
        return true;
    }*/
    /**
     * Test si un des joueur est totalement bloquer et donc si un joueur a gagne
     * @return Le joueur non bloquer/Gagnagnt
     */
    public Joueur estBloque()
    {
        if(deplacementDispo(this.ensJoueur[0].getBatisseur(1)).size() == 0 && deplacementDispo(this.ensJoueur[0].getBatisseur(2)).size() == 0) return this.ensJoueur[1];
        
        if(deplacementDispo(this.ensJoueur[1].getBatisseur(1)).size() == 0 && deplacementDispo(this.ensJoueur[1].getBatisseur(2)).size() == 0) return this.ensJoueur[0];
        
        return null;        
    }
    /**
     * Test pour tout les Batiseur si il ont gagner
     * @return Vrai si un des batisseur a gagner
     */
    public boolean aGagne()
    {
        for( int cptJoueur = 0; cptJoueur < NB_JOUEUR; cptJoueur++) 
        {
            for( int cptBatisseur = 0; cptBatisseur < NB_BATISSEUR; cptBatisseur++) 
            {
                Batisseur batisseur = ensJoueur[cptJoueur].getBatisseur(cptBatisseur+1);
                
                if( grilleJeu[batisseur.getLigne()][batisseur.getColonne()] == 3 ) return true;
            }
        }
        return false;
    }
    /**
     * Fusion du tableau de Batisseur et d'etage
     * @return Le tableau fusionner
     */
    public String[][] fusionTab()
    {
        String grilleAffi[][] = new String[this.grilleJeu.length][this.grilleJeu.length];
        String grilleBat[][]  = this.ensJoueur[0].getBatisseur(1).grilleBat;
        int grilleJeu[][] = this.grilleJeu;
        
        for (int cptLigne = 0; cptLigne < grilleAffi.length; cptLigne++)
        {
            for (int cptColonne = 0; cptColonne < grilleAffi[0].length; cptColonne++)
            {
                if(grilleBat[cptLigne][cptColonne] != null)
                {
                    grilleAffi[cptLigne][cptColonne] = "" + grilleBat[cptLigne][cptColonne] + "," + grilleJeu[cptLigne][cptColonne];
                }
                else
                {
                    grilleAffi[cptLigne][cptColonne] = "" + grilleJeu[cptLigne][cptColonne];
                }
            }
        }
        
        return grilleAffi;
    }
    
    
    /*-------------------*/
    /*    ACCESSEURS     */
    /*-------------------*/
    
    /**
     * Accesseur Hauteur
     * @param lig
     * @param col
     * @return 
     */
    public int getHauteur  (int lig, int col){return this.grilleJeu[lig][col]; }
    /**
     * Accesseur nombre de ligne
     * @return Le nombre de ligne
     */
    public int getNbLig    ()                {return this.grilleJeu.length;    }
    /**
     * Accesseur nombre de colonne
     * @return Le nombre de colonne
     */
    public int getNbCol    ()                {return this.grilleJeu[0].length; }
    /**
     * Accesseur Joueur 
     * @param numJoueur choisie quelle joueur
     * @return Le joueur choisie
     */
    public Joueur getJoueur(int numJoueur)   {return this.ensJoueur[numJoueur];}
    
    
    
    
    /**
     * Affiche le tableau du jeu 
     * @return Le tableau finale
     */
    public String toString()
    {   
        String grilleAffi[][] = fusionTab();
        
        return    "\nLa couleur de " + this.ensJoueur[0].getNom() + " est " + this.ensJoueur[0].getCouleur() 
                + "\nLa couleur de " + this.ensJoueur[1].getNom() + " est " + this.ensJoueur[1].getCouleur()
                + "\n     |  1  |  2  |  3  |  4  |  5  |"
                + "\n_____|_____|_____|_____|_____|_____|"
                + "\n     |     |     |     |     |     |"
                + "\n  A  |"+String.format("%5s", grilleAffi[0][0])+"|"+String.format("%5s", grilleAffi[0][1])+"|"+String.format("%5s", grilleAffi[0][2])+"|"+String.format("%5s", grilleAffi[0][3])+"|"+String.format("%5s", grilleAffi[0][4])+"|"
                + "\n_____|_____|_____|_____|_____|_____|"
                + "\n     |     |     |     |     |     |"
                + "\n  B  |"+String.format("%5s", grilleAffi[1][0])+"|"+String.format("%5s", grilleAffi[1][1])+"|"+String.format("%5s", grilleAffi[1][2])+"|"+String.format("%5s", grilleAffi[1][3])+"|"+String.format("%5s", grilleAffi[1][4])+"|"
                + "\n_____|_____|_____|_____|_____|_____|"
                + "\n     |     |     |     |     |     |"
                + "\n  C  |"+String.format("%5s", grilleAffi[2][0])+"|"+String.format("%5s", grilleAffi[2][1])+"|"+String.format("%5s", grilleAffi[2][2])+"|"+String.format("%5s", grilleAffi[2][3])+"|"+String.format("%5s", grilleAffi[2][4])+"|"
                + "\n_____|_____|_____|_____|_____|_____|"
                + "\n     |     |     |     |     |     |"
                + "\n  D  |"+String.format("%5s", grilleAffi[3][0])+"|"+String.format("%5s", grilleAffi[3][1])+"|"+String.format("%5s", grilleAffi[3][2])+"|"+String.format("%5s", grilleAffi[3][3])+"|"+String.format("%5s", grilleAffi[3][4])+"|"
                + "\n_____|_____|_____|_____|_____|_____|"
                + "\n     |     |     |     |     |     |"
                + "\n  E  |"+String.format("%5s", grilleAffi[4][0])+"|"+String.format("%5s", grilleAffi[4][1])+"|"+String.format("%5s", grilleAffi[4][2])+"|"+String.format("%5s", grilleAffi[4][3])+"|"+String.format("%5s", grilleAffi[4][4])+"|"
                + "\n_____|_____|_____|_____|_____|_____|";
                
    }
    
}