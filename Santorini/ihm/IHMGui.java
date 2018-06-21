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
    public IHMGui(Controleur ctrl, String J1, String J2)
    {
        this.ctrl = ctrl;
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 1050);
        this.setResizable(false);
        
        this.plateau = new PanelPlateau(this.ctrl, this);
        this.infos   = new PanelInfos  (J1, J2);
        
        this.add(this.infos, BorderLayout.NORTH);
        this.add(this.plateau, BorderLayout.CENTER);
        
        this.setVisible(true);
    }
    
    /**
     * Permet de renvoyer l'objet PanelPlateau
     * @return 
     */
    public PanelPlateau getPlateau(){return this.plateau;}
    
    /**
     * Permet de récupérer le nom des joueurs
     * @return 
     */
    public PanelInfos   getInfo()   {return this.infos;}
    
    /**
     * Permet de mettre une image choisie à l'endroit passer en paramètre
     * @param url Location de l'image
     * @param posLig Position de l'image sur la ligne
     * @param posCol Position de l'image sur la colonne
     */
    public void setImage     (String url, int posLig, int posCol){this.plateau.setImage(url, posLig, posCol);}
    
    /**
     * Permet de passer d'un joueur à l'autre
     * @param numJoueur 
     */
    public void changerJoueur(int numJoueur                     ){this.infos.changerJoueur(numJoueur)       ;}
}
