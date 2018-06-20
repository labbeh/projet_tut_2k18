/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Santorini.ihm;

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
    public BoutonCase(int posLig, int posCol)
    {
        super();
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
}
