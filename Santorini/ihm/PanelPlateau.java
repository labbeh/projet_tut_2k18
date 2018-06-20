/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Santorini.ihm;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author labbeh
 */
public class PanelPlateau extends JPanel
{
    private static final int NB_CASES = 5;
    
    private JButton[][] cases;
    
    public PanelPlateau()
    {
        this.setLayout(new GridLayout(PanelPlateau.NB_CASES,PanelPlateau.NB_CASES));
        
        this.cases = new JButton[PanelPlateau.NB_CASES][PanelPlateau.NB_CASES];
        
        for(int cptLig=0; cptLig<this.cases.length; cptLig++)
            for(int cptCol=0; cptCol<this.cases.length; cptCol++)
            {
                this.cases[cptLig][cptCol] = new JButton();
                this.add(this.cases[cptLig][cptCol]);
            }
    }
    
    public void setImage(String url, int posLig, int posCol)
    {
        this.cases[posLig][posCol].setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource(url))));
    }
}
