/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_tut_2018.kingdomino;

import projet_tut_2018.kingdomino.metier.*;
import projet_tut_2018.kingdomino.ihm.*;

import java.util.ArrayList;
/**
 *
 * @author labbeh
 */
public class Controleur
{
    private IHMGuiV2 ihm;
    //private Jeu      jeu;
    
    private Joueur[] tabJoueur;
    //private Domino[] tabDomino;
    
    private int      joueurCourant;
    private Pioche     pioche;
    
    public Controleur(String nomJ1, String nomJ2)
    {
        this.pioche = new Pioche();
        this.pioche.initPioche();

        this.tabJoueur     = new Joueur[]{ new Joueur(nomJ1, "rouge"), new Joueur(nomJ2, "bleu") };
        this.joueurCourant = 0;
        
        this.ihm = new IHMGuiV2(this);
    }
    
    public String getNomJoueur    (int num){ return this.tabJoueur[num].getNom                   (); }
    public String getNomJoueurCourant    (){ return this.tabJoueur[this.joueurCourant].getNom    (); }
    public String getCouleurJoueurCourant(){ return this.tabJoueur[this.joueurCourant].getCouleur(); }
    public int    getNumJoueurCourant    (){ return this.joueurCourant                             ; }
    
    public String getNomImage(int num){ return this.pioche.piocher().getImage(); }
    
    public void poserTuile()
    {
        int x = this.ihm.getPosX();
        int y = this.ihm.getPosY();
        
        
        String biome = new String();
        
        this.ihm.poserTuile(biome, x, y);
        this.changerJoueur();
        
    }
    
    public void changerJoueur()
    {
        if(this.joueurCourant == 0) this.joueurCourant = 1;
        else                        this.joueurCourant = 0;
        
        this.refresh();
    }
    
    public void refresh(){this.ihm.refresh();}
    
    public static void main(String[] args)
    {
        Controleur c = new Controleur("labbeh", "le pivert");
        System.out.println(c.getNomJoueurCourant());
        
        java.util.Scanner sc = new java.util.Scanner(System.in);
        sc.nextLine();
        
        c.changerJoueur();
        //c.refresh();
    }
}
