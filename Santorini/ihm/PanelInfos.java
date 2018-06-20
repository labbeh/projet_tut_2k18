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
public class PanelInfos extends JPanel
{
    private static final String JOUEUR1 = "Joueur 1";
    private static final String JOUEUR2 = "Joueur 2";
    
    private JLabel lbJoueur1;
    private JLabel lbJoueur2;
    
    public PanelInfos()
    {
        this.setLayout(new BorderLayout());
        
        this.lbJoueur1 = new JLabel();
        this.lbJoueur2 = new JLabel();
        
        this.lbJoueur1.setText(PanelInfos.JOUEUR1);
        this.lbJoueur2.setText(PanelInfos.JOUEUR2);
        
        this.add(this.lbJoueur1, BorderLayout.WEST);
        this.add(this.lbJoueur2, BorderLayout.EAST);
    }
    
    public void changerJoueur(int numJoueur)
    {
        if(numJoueur == 1)
        {
            this.lbJoueur1.setText("<html><h3>" +PanelInfos.JOUEUR1+ "</h3></html>");
            this.lbJoueur2.setText(PanelInfos.JOUEUR2);
        }
        else
        {
            this.lbJoueur2.setText("<html><h3>" +PanelInfos.JOUEUR2+ "</h3></html>");
            this.lbJoueur1.setText(PanelInfos.JOUEUR1);
        }
    }
}
