/**
 * @author Lechanoine,Levallois,Beaumont,Lebosse,Labbe,Dupont
 * @date 20/06/2018
 * @version 1.0
 */

package Santorini;
import Santorini.metier.*;
import Santorini.ihm.*;


public class Controleur 
{
    Plateau grilleJeu;
    IHMGui ihm;
    private int nbTour;
    private Batisseur choixBat;
    private boolean choixBatValide;
    
    public Controleur(String J1, String J2)
    {
        grilleJeu = new Plateau(J1, J2);
        ihm = new IHMGui(this);
        System.out.println( "Joueur ou voulez-vous placer votre batisseur ?");
        
    }
    public boolean initBatisseur(int nbBatisseur ,int ligBoutton, int colBoutton)
    {
        
        
        
        int nbJoueur = 0;
        if(nbBatisseur > 1){nbJoueur = 1;}
        if(grilleJeu.getJoueur(nbJoueur).initBatisseur(nbBatisseur % 2, ligBoutton, colBoutton))return true;
        else              
            System.out.println("Saisie invalide ! veuillez choisir une case disponible "
                              + "et à votre portee ! :  "                               );
        return false;
    }
    public void ChoixBat(int ligBoutton, int colBoutton)
    {
        for(int cpt = 0; cpt < grilleJeu.getJoueur(nbTour%2).getNbBatisseur() ; cpt ++)
        {
            if(grilleJeu.getJoueur(nbTour%2).getBatisseur(cpt + 1).getPos() == ((ligBoutton * 10) + colBoutton))
            {
                this.choixBat = grilleJeu.getJoueur(nbTour%2).getBatisseur(cpt + 1);
                if(grilleJeu.estBloqueUnitaire(this.choixBat))
                    System.out.println("Ce batisseur ne peut pas ce deplacer veuillez en selectionne un autre");
                else
                    System.out.println("Selectionner la case ou vous voulez allez");
            }
            else
                System.out.println("Veuillez cliquer sur un de vos batisseurs");
        }
    }
    public void deplacement(int ligBoutton, int colBoutton)
    {
        
        
        
        
    }
    public void construction(int ligBoutton, int colBoutton)
    {
        
        System.out.println("Selectionner la case ou vous voulez construire");
    }
    public void jeu(int phase)
    {
        System.out.println("Selectionner un batisseur");
               
    }    
        //initBatisseur(cptBatisseur, ligne, colonne)) positionValide = true;  //poser les batt
        
        
        
        
        /*-------------------------------------*/
        /*Deroulement du tour de chaque joueurs*/
        /*-------------------------------------*/
        
        //while( !grilleJeu.aGagne() && grilleJeu.estBloque() == null )          
        //{
            
            
            /*----------------------------*/
            /*Selection du joueur qui joue*/
            /*----------------------------*/
            
            //tourJoueur = ensNom[nbTour%2];
            
            
            
            /*-----------------------------*/
            /*Choix du batisseur a deplacer*/           //AVEC DES CLICS
            /*-----------------------------*/
            
                
                  
    
            /*-------------------------------------*/
            /*  Choix de la direction du batisseur */          //AVEC DES CLICS
            /*-------------------------------------*/
            
            //grilleJeu.getJoueur(nbTour%2).deplacement(choixBatisseur, choixDeplacement)
                    
                
                
            
            /*-------------------------------------*/
            /*Choix de la direction de construction*/
            /*-------------------------------------*/
            
            //grilleJeu.placerBloc(choixConstruction, nbTour%2, choixBatisseur)
            
        //}       
        /*----------------*/
        /*Fin de la partie*/
        /*----------------*/
        
        
        //if(grilleJeu.estBloque() == null) System.out.println("        Bravo a toi "+ grilleJeu.getJoueur((nbTour-1)%2).getNom() +" !"  );
        //else System.out.println("        Bravo a toi "+ grilleJeu.getJoueur((nbTour)%2).getNom() +" !"  );
    
        
    
    public static void main(String[] arg) 
    {
        new Controleur("Alban", "Theo");
    }
    
}
