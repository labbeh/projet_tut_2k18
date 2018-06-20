/**
 * @author Lechanoine,Levallois,Beaumont,Lebosse,Labbe,Dupont
 * @date 20/06/2018
 * @version 1.0
 */

package Santorini;
import Santorini.metier.*;
import Santorini.ihm.*;

/**
 *
 * @author tenoi
 */
public class Controleur 
{
    Plateau grille;
    IHMGui ihm;
    
    public Controleur(String J1, String J2)
    {
        grille = new Plateau(J1, J2);
        ihm = new IHMGui();
        
    }
    
    public static void main(String[] arg) 
    {
        new Controleur("Joueur1","Joueur2");
    }
    
}
