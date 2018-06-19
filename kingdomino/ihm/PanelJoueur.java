/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_tut_2018.kingdomino.ihm;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.ArrayList;
import utilitaires.Clavier;
/**
 *
 * @author labbeh
 */
public class PanelJoueur extends JPanel
{
    private final int MARGE_HAUTE = 20;
    private final int MARGE_GD    = 30; // GD = gauche droite
    //private JButton[][] tabBtnsTuiles;
    private static final int DIMENSION_CASE = 145;
    private static final int TAILLE_PLATEAU = PanelJoueur.DIMENSION_CASE*5;
    
    private ArrayList<ImageTuile> alTuiles;
    
    
    
    private String nomFich = "imgs/tuileDepart.gif";
    private BufferedImage image;// = Toolkit.getDefaultToolkit().getImage(nomFich);
    
    
    public PanelJoueur()
    {
        this.alTuiles = new ArrayList<ImageTuile>();
        this.alTuiles.add(new ImageTuile("tuile40.gif"));
        //this.setLayout(new GridLayout(5,5));
        
        //MediaTracker track = new MediaTracker(this);
        //track.addImage(this.image, 0);
         //super();
                /*try
                {
                    image = ImageIO.read(new File(this.nomFich));
                }
                catch(IOException e)
                {
                    image = null;
                    e.printStackTrace();
                }*/
        
        /*try{ track.waitForID(0);}
        catch(InterruptedException evt){}*/
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        AffineTransform old = g2d.getTransform();
        
        int strWdth;
        
        // temporaire
        g2d.translate(MARGE_GD,MARGE_HAUTE);

        g2d.fillRect(- MARGE_GD, - MARGE_HAUTE, 2000, 20);
        g2d.fillRect(- MARGE_GD, - MARGE_HAUTE, MARGE_GD, 2000);
        g2d.fillRect(- MARGE_GD, 145*5, 2000, 2000);
        g2d.fillRect(145*5, - MARGE_HAUTE, 2000, 2000);
        g2d.setColor(Color.GRAY); // couleur du texte des graduations

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
        
        // cadre
        g2d.drawRect(0, 0, PanelJoueur.DIMENSION_CASE*5, PanelJoueur.DIMENSION_CASE*5);
        // quadrillage
        for(int cpt=0; cpt<5; cpt++)
            g2d.drawLine(0,145*5, 145*5, 145*5);
    
        g2d.drawImage(this.alTuiles.get(0).getImage(), 50, 50, null);
        g2d.rotate((Math.PI/2), 50, 50);
        g2d.setTransform(old);
    }
    
    // main pour tests sur le panel
    public static void main(String[] args)
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(PanelJoueur.TAILLE_PLATEAU+30, PanelJoueur.TAILLE_PLATEAU+30);
        
        PanelJoueur p = new PanelJoueur();
        f.add(p);
        
        //f.pack();
        f.setVisible(true);
    }
    
    /*public void setImage(int numTuile, int lig, int col)
    {
        this.tabBtnsTuiles[lig][col].setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("imgs/tuile" +numTuile+ ".gif"))));
    }*/
}
