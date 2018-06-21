/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Santorini.ihm;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Hugo
 */
public class BoutonCase extends JButton
{
    private int posLig;
    private int posCol;
    
    /**
     * Creer un bouton et prend sa position
     * @param posLig Position Horizontal
     * @param posCol Position Vertical
     */
    public BoutonCase(int posLig, int posCol, String image)
    {
        super();
        
        try {
            Image img = ImageIO.read(getClass().getResource(image));
            this.setIcon(new ImageIcon(img));
        } catch (Exception ex) {}
         
        this.setBorderPainted(false);
        this.posLig = posLig;
        this.posCol = posCol;
    }
    
    /**
     * Accesseur Ligne
     * @return La ligne du bouton
     */
    public int getPosLig(){ return this.posLig; }
    /**
     * Accesseur Colonne
     * @return La colonne du bouton
     */
    public int getPosCol(){ return this.posCol; }

    private Icon getResource(String ihmfond_1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
