/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_tut_2018.kingdomino;

import projet_tut_2018.kingdomino.metier.*;
import projet_tut_2018.kingdomino.ihm.*;

/**
 *
 * @author labbeh
 */
public class Controleur
{
    private IHMGuiV2 ihm;
    
    private Joueur[] tabJoueur;
    private Domino[] tabDomino;
    
    private int      joueurCourant;
    private Pioche   pioche       ;
    
    public Controleur(String nomJ1, String nomJ2)
    {
        this.pioche = new Pioche();
        this.pioche.initPioche();
        this.tabDomino = new Domino[4];
        
        this.tabJoueur     = new Joueur[]{new Joueur(nomJ1, "bleu"), new Joueur(nomJ2, "rouge")};
        this.joueurCourant = 0;
        
        //j = new JeuV2();
        //j.jouer();
        this.initPioche();
        this.ihm = new IHMGuiV2(this);
    }
    
    public String getNomJoueur    (int num){ return this.tabJoueur[num].getNom                   (); }
    public String getNomJoueurCourant    (){ return this.tabJoueur[this.joueurCourant].getNom    (); }
    public String getCouleurJoueurCourant(){ return this.tabJoueur[this.joueurCourant].getCouleur(); }
    public int    getNumJoueurCourant    (){ return this.joueurCourant                             ; }
    public Joueur getJoueurCourant       (){ return this.tabJoueur[this.joueurCourant]             ; }
    
    public void initPioche()
    {
        for(int cpt=0; cpt<this.tabDomino.length; cpt++)
            this.tabDomino[cpt] = this.pioche.piocher();
    }
    public String getNomImage(int num)
    {
        return this.tabDomino[num].getImage();
    }
    
    public void poserTuile()
    {
        int x = this.ihm.getPosX();
        int y = this.ihm.getPosY();
        int xOrientation = 0;
        int yOrientation = 0;
        char sens = 'b';
                
        int indice = this.ihm.getDernierClique();
        int nbCouronnes;
        
        //Biome = 
        String biome1 = this.tabDomino[indice].getBiome1().getImage();
        String biome2 = this.tabDomino[indice].getBiome2().getImage();

        
        this.ihm.poserTuile(biome1, x, y);
        this.ihm.poserTuile(biome2, (x + xOrientation), (y+yOrientation));
        
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
        Controleur c = new Controleur("labbeh", "beaumontn");
        
        
    }
}
