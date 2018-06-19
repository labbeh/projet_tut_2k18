/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_tut_2018.kingdomino.ihm;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author labbeh
 */
public class PanelJoueur extends JPanel
{
    private JButton[][] tabBtnsTuiles;
    private static final int DIMENSION_CASE = 145;
    
    private String nomFich = "IHMGui.java";
    private BufferedImage image;// = Toolkit.getDefaultToolkit().getImage(nomFich);
    
    
    public PanelJoueur()
    {
        //this.setLayout(new GridLayout(5,5));
        
        //MediaTracker track = new MediaTracker(this);
        //track.addImage(this.image, 0);
         //super();
                try
                {
                        image = ImageIO.read(new File(this.nomFich));
                }
                catch(IOException e)
                {
                        image = null;
                        e.printStackTrace();
                }
        
        /*try{ track.waitForID(0);}
        catch(InterruptedException evt){}*/
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        g.drawRect(0, 0, PanelJoueur.DIMENSION_CASE*5, PanelJoueur.DIMENSION_CASE*5);
        g.drawImage(this.image, 50, 100, 100, 50, null);
    }
    
    // main pour tests sur le panel
    public static void main(String[] args)
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 500);
        
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
