/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_tut_2018.kingdomino.ihm;

import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author labbeh
 */
public class PanelJoueur extends JPanel
{
    private JButton[][] tabBtnsTuiles;
    
    
    public PanelJoueur()
    {
        this.setLayout(new GridLayout(5,5));
        
        this.tabBtnsTuiles = new JButton[5][5];
        
        for(int cptLig=0; cptLig<this.tabBtnsTuiles.length; cptLig++)
            for(int cptCol=0; cptCol<this.tabBtnsTuiles.length; cptCol++)
            {
                this.tabBtnsTuiles[cptLig][cptCol] = new JButton();
                this.setImage(48, cptLig, cptCol);
                this.add(this.tabBtnsTuiles[cptLig][cptCol]);
            }
    }
    
    public void setImage(int numTuile, int lig, int col)
    {
        this.tabBtnsTuiles[lig][col].setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("imgs/tuile" +numTuile+ ".gif"))));
    }
}
