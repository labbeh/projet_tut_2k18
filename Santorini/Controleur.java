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
    private int nbTour = 0;
    private Batisseur choixBat;
    private boolean choixBatValide;
    
    public Controleur(String J1, String J2)
    {
        grilleJeu = new Plateau(J1, J2);
        ihm = new IHMGui(this, J1, J2);
        System.out.println(grilleJeu.getJoueur(nbTour%2).getNom() + " ou voulez-vous placer votre batisseur n°1 ?");
        
    }
    
    public Joueur aGagne()
    {
        if(grilleJeu.aGagne()) return grilleJeu.getJoueur((nbTour-1)%2);
        if( grilleJeu.estBloque() != null) return grilleJeu.estBloque();
        
        return null;
    }
    
    public String getJoueur (int numJoueur){return grilleJeu.getJoueur(numJoueur).getNom();}
    public String getJoueurAct(){return grilleJeu.getJoueur(nbTour%2).getNom();}
    public Batisseur initBatisseur(int nbBatisseur ,int ligBoutton, int colBoutton)
    {
        int nbJoueur = 0;
        if(nbBatisseur > 1){nbJoueur = 1;}
        if(grilleJeu.getJoueur(nbJoueur).initBatisseur(nbBatisseur % 2, ligBoutton, colBoutton))
        {
            if(nbBatisseur == 3) System.out.println("\n" + getJoueurAct() + " veuillez choisir un batisseur a deplacer");
            return grilleJeu.getJoueur(nbJoueur).getBatisseur((nbBatisseur % 2) + 1);
        }
        else              
            System.out.println("Saisie invalide ! veuillez choisir une case disponible "
                              + "et à votre portee ! :  "                               );
        return null;
    }
    public Batisseur ChoixBat(int ligBoutton, int colBoutton)
    {
        
        int nbRatee = 0;
        for(int cpt = 0; cpt < grilleJeu.getJoueur(nbTour%2).getNbBatisseur() ; cpt ++)
        {
            if(grilleJeu.getJoueur(nbTour%2).getBatisseur(cpt + 1).getPos() == ((ligBoutton * 10) + colBoutton))
            {
                this.choixBat = grilleJeu.getJoueur(nbTour%2).getBatisseur(cpt + 1);
                if(grilleJeu.deplacementDispo(this.choixBat).size() == 0) System.out.println("Ce batisseur ne peut pas ce deplacer veuillez en selectionne un autre");
                else
                {
                    System.out.println("\n" + getJoueurAct() + " ou souhaitez vous déplacer votre batisseur");
                    int nbDeplDispo = grilleJeu.deplacementDispo(this.choixBat).size();
                    System.out.print("\nLes deplacement possibles sont : ");
                    System.out.println(grilleJeu.deplacementDispo(this.choixBat).subList(0, nbDeplDispo));
                    return this.choixBat;
                }
            }
            else
                nbRatee ++;
        }
        if(nbRatee == 2) System.out.print("\nErreur de selection ! Veuillez selectionnez un batisseur");
        return null;
    }
    public boolean deplacement(int ligBoutton, int colBoutton, Batisseur choixBatisseur, String direction)
    {
        if(direction != null)
        {
            if(grilleJeu.deplacementDispo(choixBatisseur).contains(direction))
            {
                grilleJeu.getJoueur(nbTour%2).deplacement(Integer.parseInt(choixBatisseur.getId().substring(1)), direction);
                System.out.println("\n" + getJoueurAct() + " ou souhaitez vous construire un batiment");
                return true;
            }
            else System.out.print("\nVeuillez choisir un deplacement possible ! :  ");
        }
        else{System.out.print("\nVeuillez choisir un deplacement possible ! : ");}
        return false;
    }
    public boolean construction(int ligBoutton, int colBoutton, Batisseur choixBatisseur, String direction)
    {
        if(direction != null)
        {
            if( grilleJeu.placerBloc(direction, nbTour%2, 1))
            {
                this.nbTour ++;
                System.out.println("\n" + getJoueurAct() + " veuillez choisir un batisseur a deplacer");
                return true;
            }
            else System.out.print("\nVeuillez choisir un emplacement de construction valide ! :  ");
        }
        else{System.out.print("\nVeuillez choisir un emplacement de construction valide ! :  ");}
        return false;
    }
    public String getDeplacement(int ligBoutton, int colBoutton, Batisseur choixBatisseur)
    {
        String depla = "";
        
        int distLigne = Math.abs(ligBoutton - choixBatisseur.getLigne());
        int distColonne = Math.abs(colBoutton - choixBatisseur.getColonne());
        
        if(distLigne <= 1 && distColonne <= 1)
        {
            switch(choixBatisseur.getLigne() - ligBoutton)
            {
                case -1 : depla += "N";
                    break;
                case  1 : depla += "S";
                    break;
            }
            switch(choixBatisseur.getColonne() - colBoutton)
            {
                case -1 : depla += "O";
                    break;
                case  1 : depla += "E";
                    break;
            }
        }
        else depla = null;
        return depla;
    }       
    
    public static void main(String[] arg) 
    {
        new Controleur("Alban", "Theo");
    }
    
}
