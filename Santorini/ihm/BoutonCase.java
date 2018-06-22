/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Santorini.ihm;

import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author 
 */
public class BoutonCase extends JButton
{
    private int posLig;
    private int posCol;
    private int hauteur = 0;
    private String image;
    private String imageBase;
    
    /**
     * Creer un bouton et prend sa position
     * @param posLig Position Horizontal
     * @param posCol Position Vertical
     */
    public BoutonCase(int posLig, int posCol, String image)
    {
        super();
        this.image = image;
        this.imageBase = image;
        try {
            Image img = ImageIO.read(getClass().getResource("image/" + image + ".png"));
            this.setIcon(new ImageIcon(img));
        } catch (Exception ex) {}
         
        this.setBorderPainted(false);
        this.posLig = posLig;
        this.posCol = posCol;
    }
    public void etageSupp()
    {
        this.hauteur ++;
        this.image = "etage_" + this.hauteur;
        this.imageBase = this.image;
        setImage();
    }
    public void etageInf()
    {
        this.hauteur --;
        this.image = "etage_" + this.hauteur;
        this.imageBase = this.image;
        setImage();
    }
    public void setPerso(String couleur)
    {
        String lowerCouleur =  String.valueOf(couleur.charAt(0)).toLowerCase();
        this.image = this.image + "_p_" + lowerCouleur;
        setImage();
    }
    public void imageBase()
    {
        this.image = this.imageBase;
        setImage();
    }
    public void setImage()
    {
        try {
            Image img = ImageIO.read(getClass().getResource("image/" + this.image + ".png"));
            this.setIcon(new ImageIcon(img));
        } catch (Exception ex) {}
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
