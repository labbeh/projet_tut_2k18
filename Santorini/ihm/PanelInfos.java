/**
 * @author Lechanoine,Levallois,Beaumont,Lebosse,Labbe,Dupont
 * @date 20/06/2018
 * @version 1.0
 */
package Santorini.ihm;

import javax.swing.*;
import java.awt.*;


public class PanelInfos extends JPanel
{
    private static final String JOUEUR1 = "Joueur 1";
    private static final String JOUEUR2 = "Joueur 2";
    
    private JLabel lbJoueur1;
    private JLabel lbJoueur2;
    
    /**
     * Permet l'affichage du nom des joueurs en haut de la fenêtre
     */
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
    
    /**
     * Permet de mettre en évidence (avec une couleur) le joueur qui doit jouer
     * @param numJoueur numéro du joueur à mettre en évidence
     */
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
