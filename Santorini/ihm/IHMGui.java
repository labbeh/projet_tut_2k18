/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_tut_2018.Santorini.ihm;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author labbeh
 */
public class IHMGui extends JFrame
{
    private PanelPlateau plateau;
    private PanelInfos   infos  ;
    
    public IHMGui()
    {
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.plateau = new PanelPlateau();
        this.infos   = new PanelInfos  ();
        
        this.add(this.infos, BorderLayout.NORTH);
        this.add(this.plateau, BorderLayout.CENTER);
        
        this.pack();
        this.setVisible(true);
    }
    
    public void setImage     (String url, int posLig, int posCol){this.plateau.setImage(url, posLig, posCol);}
    public void changerJoueur(int numJoueur                     ){this.infos.changerJoueur(numJoueur)       ;}
    
    public static void main(String[] args)
    {
        IHMGui ihm = new IHMGui();
        ihm.changerJoueur(2);
    }
}
