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
    private static String joueur1 = "Joueur 1";
    private static String joueur2 = "Joueur 2";
    
    private JLabel lbJoueur1;
    private JLabel lbJoueur2;
    private JLabel lbMsg    ;
    
    /**
     * Permet l'affichage du nom des joueurs en haut de la fenêtre
     */
    public PanelInfos(String nomJ1, String nomJ2)
    {
        PanelInfos.joueur1 = nomJ1;
        PanelInfos.joueur2 = nomJ2;
                
        this.setLayout(new BorderLayout());
        
        this.lbJoueur1 = new JLabel();
        this.lbJoueur2 = new JLabel();
        this.lbMsg     = new JLabel();
        
        this.lbJoueur1.setText(PanelInfos.joueur1);
        this.lbJoueur2.setText(PanelInfos.joueur2);
        
        this.add(this.lbJoueur1, BorderLayout.WEST  );
        this.add(this.lbMsg    , BorderLayout.CENTER);
        this.add(this.lbJoueur2, BorderLayout.EAST  );
        
        this.lbJoueur1.setForeground(Color.BLUE); // new Color(r,g,b)
        this.lbJoueur2.setForeground(Color.RED);
    }
    /**
     * Permet de mettre en évidence (avec une couleur) le joueur qui doit jouer
     * @param numJoueur numéro du joueur à mettre en évidence
     */
    public void changerJoueur(int numJoueur)
    {
        if(numJoueur == 1)
        {
            this.lbJoueur1.setText("<html><h3>" +PanelInfos.joueur1+ "</h3></html>");
            this.lbJoueur2.setText(PanelInfos.joueur2);
        }
        else
        {
            this.lbJoueur2.setText("<html><h3>" +PanelInfos.joueur2+ "</h3></html>");
            this.lbJoueur1.setText(PanelInfos.joueur1);
        }
    }
    
    public void setText(String txt){ this.lbMsg.setText(txt); }
}
