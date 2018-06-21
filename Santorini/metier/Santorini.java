/**
 * @author Lechanoine,Levallois,Beaumont,Lebosse,Labbe,Dupont
 * @date 18/06/2018
 * @version 1.0
 */
package Santorini.metier;

import java.util.Scanner;

public class Santorini 
{
    public static void main (String[] arg)
    {   
        /*-------------------*/
        /*     VARIABLES     */
        /*-------------------*/
        
        final int NB_BATISSEUR = 2;
        final int NB_JOUEUR    = 2;
        
        /*-------------------*/
        /*     VARIABLES     */
        /*-------------------*/
        
        boolean choixNomValide;
        boolean positionValide;
        boolean choixBatValide;
        boolean choixDepValide;
        boolean choixConValide;
        String choixConstruction;
        String choixDeplacement;
        String tourJoueur;
        String[] ensNom;
        String position;
        int choixBatisseur;
        int ligne  ;
        int colonne;
        int nbTour ;
        
        Plateau grilleJeu;
        
        Scanner clavier = new Scanner(System.in);                               // Initialisation du scanner pour lire les entrées clavier
        
        /*-------------------*/
        /*       DEBUT       */
        /*-------------------*/
        
        System.out.println("____________________________________________________________");
        System.out.println(                                                              );
        System.out.println("           Bienvenus pour une partie de Santorini !         ");
        System.out.println("____________________________________________________________");
        System.out.println("                Une création du groupe n°7 !                ");
        System.out.println("      ______________________________________________        ");
        System.out.println("          Veuillez vous rendre ici pour les règle :         ");
        System.out.println("                     https://lc.cx/mXYt                     ");
        System.out.println("(Cette version ne prend pas en compte les différents dieux) ");
        System.out.println("____________________________________________________________");
        System.out.println(                                                              );
        
        
        
        /*------------------------------------------*/
        /*Initialisation des joueurs avec leurs noms*/
        /*------------------------------------------*/
       
        ensNom = new String[NB_JOUEUR];
        
        for (int cpt = 0; cpt < NB_JOUEUR; cpt++)
        {
            System.out.println(                                                          );
            System.out.print  ("Joueur "+ (cpt+1) +" veuillez entrer votre nom :  "      );
            
            do
            {
                choixNomValide = false;
                ensNom[cpt] = clavier.nextLine();
                
                if( ensNom[cpt].length() > 0 )  choixNomValide = true;
                else System.out.print( "Veuillez entrer au moins un caractere et faites en sorte que les "
                                      + "premiers caracteres soit different ! :  "                        );
                
                
            }while( !choixNomValide );
            
        }
        
        /*-----------------------------------------------*/
        /*Initialisation et affichage de la grille de jeu*/
        /*-----------------------------------------------*/
        
        System.out.println();    
        grilleJeu = new Plateau(ensNom[0], ensNom[1]);
        
        for (int cptJoueur = 0; cptJoueur < NB_JOUEUR; cptJoueur++)                                         // Positionnement des batisseurs
        {
            for (int cptBatisseur = 0; cptBatisseur < NB_BATISSEUR; cptBatisseur++) 
            {
                System.out.println(grilleJeu.toString());   // On affiche la grille de jeu
                System.out.println(                                                                                        );   // Demande de la saisie de la position
                System.out.print  ( ensNom[cptJoueur] +", ou voulez-vous placer votre batisseur n°"+ (cptBatisseur+1) +" ?");
                System.out.print  ("(Veuillez saisir une case sous la forme Lettre,Chiffre) :  "                           );

                positionValide = false;
                do                                                                                                              // Vérification de la saisie
                {
                    position = clavier.nextLine();

                    if( position.length() >= 3 && Character.toUpperCase(position.charAt(0))-'A' >= 0 && Character.toUpperCase(position.charAt(0))-'A' < 5 
                        && Character.getNumericValue(position.charAt(2)) - 1 >= 0 && Character.getNumericValue(position.charAt(2)) - 1 < 5                ) 
                    {
                        ligne   = Character.toUpperCase(position.charAt(0))-'A'     ;
                        colonne = Character.getNumericValue(position.charAt(2)) - 1 ;
                         
                        if(grilleJeu.getJoueur(cptJoueur).initBatisseur(cptBatisseur, ligne, colonne)) positionValide = true;
                        
                        
                    }
                    if(!positionValide)System.out.print("Saisie invalide ! veuillez choisir une case disponible "
                                                        + "et à votre portee ! :  "                               );
                    
                }while(!positionValide);
            }
            
        }
        
        
        
        /*--------------------------------------------------*/
        /*Affichage de la grille et Initialisation des tours*/
        /*--------------------------------------------------*/
        
        System.out.println(grilleJeu.toString());
        nbTour = 0;
        
        
        
        /*-------------------------------------*/
        /*Deroulement du tour de chaque joueurs*/
        /*-------------------------------------*/
        
        while( !grilleJeu.aGagne() && grilleJeu.estBloque() == null )          
        {   
            
            
            /*----------------------------*/
            /*Selection du joueur qui joue*/
            /*----------------------------*/
            
            tourJoueur = ensNom[nbTour%2];
            
            
            
            /*-----------------------------*/
            /*Choix du batisseur a deplacer*/
            /*-----------------------------*/
            
            System.out.println();
            System.out.print(tourJoueur +", veuillez choisir un batisseur a deplacer (1 ou 2) :  ");
            choixBatisseur = 0;
            
            
            choixBatValide = false;
            do
            {   
                boolean correcte  = false;
                
                try{
                    choixBatisseur = Integer.parseInt(clavier.next());
                    correcte = true;
                }
                catch(NumberFormatException evt){
                    System.out.println("Veuillez saisir un nombre entier ! : ");
                }
                
                if( (choixBatisseur == 1 || choixBatisseur == 2) && correcte) 
                {
                    if( grilleJeu.deplacementDispo(grilleJeu.getJoueur(nbTour%2).getBatisseur(choixBatisseur)).size() == 0 )
                        System.out.println("Le batisseur "+ choixBatisseur +" est bloque ! Veuillez selectionner l'autre !");
                    else
                        choixBatValide = true;
                        System.out.println(grilleJeu.deplacementDispo(grilleJeu.getJoueur(nbTour%2).getBatisseur(choixBatisseur)).size());
                }
                
                if( !choixBatValide ) System.out.print("Veuillez selectionner le batisseur 1 ou 2 ! :  ");
                
            }while( !choixBatValide );
            
            
            
            
            /*-------------------------------------*/
            /*  Choix de la direction du batisseur */
            /*-------------------------------------*/
            
            clavier.nextLine();
            System.out.println();
            System.out.print(tourJoueur +",ou souhaitez vous déplacer votre batisseur ?  ");
            int nbDeplDispo = grilleJeu.deplacementDispo(grilleJeu.getJoueur(nbTour%2).getBatisseur(choixBatisseur)).size();
            System.out.print("Les deplacement possibles sont : ");
            System.out.println(grilleJeu.deplacementDispo(grilleJeu.getJoueur(nbTour%2).getBatisseur(choixBatisseur)).subList(0, nbDeplDispo));
            
            choixDepValide = false;
            do                                                                                                              // Verification de la validite du choix
            {
                choixDeplacement = clavier.nextLine().toUpperCase();
                
                if( grilleJeu.deplacementDispo(grilleJeu.getJoueur(nbTour%2).getBatisseur(choixBatisseur)).contains(choixDeplacement)) 
                    if( grilleJeu.getJoueur(nbTour%2).deplacement(choixBatisseur, choixDeplacement))
                        choixDepValide = true;
                    
                
                if( !choixDepValide ) System.out.print("Veuillez choisir un deplacement possible ! :  ");
                
                
            } while( !choixDepValide );
            
            System.out.println(grilleJeu.toString());
            
            
            
            /*-------------------------------------*/
            /*Choix de la direction de construction*/
            /*-------------------------------------*/
            
            System.out.println();
            
            if( !grilleJeu.aGagne() && grilleJeu.estBloque() == null) 
            {
                System.out.println();
                System.out.print(tourJoueur +", ou souhaitez vous construire un batiment (N,S,E,O,NE,SO,..) ? :  ");
            }

            choixConValide = false;
            while( !choixConValide && !grilleJeu.aGagne() && grilleJeu.estBloque() == null )
            {
                choixConstruction = clavier.nextLine().toUpperCase();
                System.out.println();
                
                if( choixConstruction.equals("N") || choixConstruction.equals("S") || choixConstruction.equals("E") || choixConstruction.equals("O") || 
                    choixConstruction.equals("NE") || choixConstruction.equals("NO") || choixConstruction.equals("SE") || choixConstruction.equals("SO")) 
                    if( grilleJeu.placerBloc(choixConstruction, nbTour%2, choixBatisseur)) choixConValide = true;
                    
                
                if( !choixConValide )  System.out.print("Veuillez choisir un emplacement de construction valide ! :  ");
                
                
            }
            
            System.out.println(grilleJeu.toString());
            nbTour++;
            
        }
                
        /*----------------*/
        /*Fin de la partie*/
        /*----------------*/
        
        System.out.println(                                                                 );
        System.out.println(                                                                 ); 
        
        if(grilleJeu.estBloque() == null) System.out.println("        Bravo a toi "+ grilleJeu.getJoueur((nbTour-1)%2).getNom() +" !"  );
        else System.out.println("        Bravo a toi "+ grilleJeu.getJoueur((nbTour)%2).getNom() +" !"  );
        
        System.out.println("        Tu as remporte cette partie de Santorini ! "            );
        System.out.println("_______________________________________________________________");
        System.out.println(                                                                 );
        System.out.println("            N'hesite pas a relancer une partie ;) "             );
        System.out.println("_______________________________________________________________");
        
    }
}