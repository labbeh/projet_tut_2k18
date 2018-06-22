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
import java.awt.geom.AffineTransform;
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
        this.repaint();
    }
	
    public void paintComponent(Graphics g)
    {
	super.paintComponent(g);
	Graphics2D g2d = (Graphics2D)g;
        
        // graduations
       /* AffineTransform old = g2d.getTransform();
        
        int strWdth;
        
        // temporaire
        g2d.translate(MARGE_GD,MARGE_HAUTE);

        g2d.fillRect(- MARGE_GD, - MARGE_HAUTE, 2000, 20);
        g2d.fillRect(- MARGE_GD, - MARGE_HAUTE, MARGE_GD, 2000);
        g2d.fillRect(- MARGE_GD, 145*5, 2000, 2000);
        g2d.fillRect(145*5, - MARGE_HAUTE, 2000, 2000);
        //g2d.setColor(Color.BLACK); // couleur du texte des graduations

        for (int cpt=0; cpt<=145*5; cpt+=10)
        {
            if (cpt % 50 == 0)
            {
                strWdth = g2d.getFontMetrics().stringWidth("" + cpt);
                g2d.drawString("" + cpt, cpt - strWdth / 2, -6);
                g2d.drawLine(cpt, -4, cpt, 0);
            }
            g2d.drawLine(cpt, -2, cpt, 0);
        }

        for (int cpt=0; cpt<=145*5; cpt+=10)
        {
            if (cpt % 50 == 0)
            {
                strWdth = g.getFontMetrics().stringWidth("" + cpt);
                g2d.drawString("" + cpt, - strWdth - 4, cpt + 3);
                g2d.drawLine(0, cpt, -4, cpt);
            }
            g2d.drawLine(0, cpt, -2, cpt);
        }
	// fin graduations*/
        
	g2d.setColor(Color.BLACK);
		
	//Création des lignes ET des colonnes
	for(int i=0;i<=5; i++)
	{
            g2d.drawLine(0,i*50,250,i*50);
            g2d.drawLine(i*50,0,i*50,250);
	}
		
	// Affichage du chateau initial	
	g2d.drawImage(Visu.TUILE_DEPART,0,0,Visu.TAILLE,Visu.TAILLE,this);
        
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
