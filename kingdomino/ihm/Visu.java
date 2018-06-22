/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_tut_2018.kingdomino.ihm;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

import java.util.ArrayList;

/**
 *
 * @author labbeh
 */

public class Visu extends JPanel
{
    private static final int   TAILLE       = 50                                                            ;
    private static final Image TUILE_DEPART = Toolkit.getDefaultToolkit().getImage( "imgs/tuileDepart.gif" );
    
    private final int MARGE_HAUTE = 8;
    private final int MARGE_GD    = 8; // GD = gauche droite
    
    private ArrayList<ImageTuile> alTuiles;
    
    public Visu()
    {
        this.alTuiles = new ArrayList<ImageTuile>();
    }
    
    public void poserTuile(String url, int x, int y)
    {
        this.alTuiles.add(new ImageTuile(url, x, y));
    }
	
    public void paintComponent(Graphics g)
    {
	super.paintComponent(g);
	Graphics2D g2d = (Graphics2D)g;
        
        
	g2d.setColor(Color.BLACK);
		
	//Création des lignes ET des colonnes
	for(int i=0;i<=5; i++)
	{
            g2d.drawLine(0,i*50,250,i*50);
            g2d.drawLine(i*50,0,i*50,250);
	}
		
	// Affichage du chateau initial	
	g2d.drawImage(Visu.TUILE_DEPART,100,100,Visu.TAILLE,Visu.TAILLE,this);
        
        // Affichage de toutes les autres tuiles
        for(int cpt=0; cpt<this.alTuiles.size(); cpt++)
            g2d.drawImage(this.alTuiles.get(cpt).getImage(),
                          this.alTuiles.get(cpt).getPosX() ,
                          this.alTuiles.get(cpt).getPosY() ,
                          Visu.TAILLE, Visu.TAILLE         ,
                          this
                         );
    }
}