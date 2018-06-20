/**
 * @author Lechanoine,Levallois,Beaumont,Lebosse,Labbe,Dupont
 * @date 20/06/2018
 * @version 1.0
 */
package Santorini.ihm;

import javax.swing.*;
import java.awt.*;
import Santorini.Controleur;


public class IHMGui extends JFrame
{
    private PanelPlateau plateau;
    private PanelInfos   infos  ;
    private Controleur ctrl;
    
    /**
     * Permet l'affichage de la fenêtre de jeu
     * @param ctrl Controleur de l'application
     */
    public IHMGui(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(250, 250);
        
        this.plateau = new PanelPlateau(this.ctrl);
        this.infos   = new PanelInfos  ();
        
        this.add(this.infos, BorderLayout.NORTH);
        this.add(this.plateau, BorderLayout.CENTER);
        
        this.setVisible(true);
    }
    
    /**
     * Permet de récuperer les boutons de la fenêtre
     * @return 
     */
    public PanelPlateau getPlateau(){return this.plateau;}
    
    /**
     * 
     * @return 
     */
    public PanelInfos   getInfo()   {return this.infos;}
    
    /**
     * 
     * @param url
     * @param posLig
     * @param posCol 
     */
    public void setImage     (String url, int posLig, int posCol){this.plateau.setImage(url, posLig, posCol);}
    
    /**
     * 
     * @param numJoueur 
     */
    public void changerJoueur(int numJoueur                     ){this.infos.changerJoueur(numJoueur)       ;}
    
    public static void main(String[] args)
    {
        IHMGui ihm = new IHMGui(null);
        ihm.changerJoueur(2);
    }
}
