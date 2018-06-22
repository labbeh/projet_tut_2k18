/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_tut_2018.kingdomino.ihm;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author labbeh
 */

public class VisuV2 extends JPanel
{
    private static final int   TAILLE       = 50                                                            ;
    private static final Image TUILE_DEPART = Toolkit.getDefaultToolkit().getImage( "imgs/tuileDepart.gif" );
    
    private ArrayList<ImageTuile> alTuiles;
    private JLabel[][] cases;
    
    public VisuV2()
    {
        this.alTuiles = new ArrayList<ImageTuile>();
        this.setLayout(new GridLayout(5,5));
        
        this.cases = new JLabel[5][5];
        
        for(int cptLig=0; cptLig<this.cases.length; cptLig++)
            for(int cptCol=0; cptCol<this.cases.length; cptCol++)
            {
                this.cases[cptLig][cptCol] = new JLabel();
                this.add(this.cases[cptLig][cptCol]);
            }
                
        this.cases[3][3].setIcon(new ImageIcon( Toolkit.getDefaultToolkit().getImage( "imgs/tuileDepart.gif" )));
    }
    
    public void poserTuile(String url, int x, int y)
    {
        this.alTuiles.add(new ImageTuile(url, x, y));
    }
}