/**
 * Class Joueur
 * @author  BEAUMONT, LECHANOINE, LEBOSSE, DUPONT, LEVALLOIS, LABBE 
 * @date    18/06/2018
 * @version 3.0
 *
*/

public class Joueur
{

	private String  couleur;
	private int     nbDomino;
	private Plateau plateau;

/**
 *Constructeur de Joueur 
 *
 *@param couleur : le joueur est identifié par une couleur
 *@param nbDomino : nombre de Domino que le Joueur a placé
 *@param plateau : plateau du joueur initialisé a null
*/

	public Joueur(String couleur)
	{
		this.couleur  = couleur;
		this.nbDomino = 0; 
		this.plateau  = null;
	}

/**
 *Instancie un plateau à un joueur
 *
 *@param plateau 
 *            Le nouveau plateau du Joueur
*/
	public void ajouterPlateau(Plateau plateau)
	{
		this.plateau = plateau;
	}

	public String  getCouleur() {return this.couleur;}
	public int     getNbDomino(){return this.nbDomino;}
	public Plateau getPlateau() {return this.plateau;}
	public int     getNbRoi()   {return this.nbRoi;}

/**
 *Incrémente le nombre de Domino du Joueur
 *
 *@return retourne vrai si le nombre de Domino ne dépasse pas 12
 */

	public boolean ajouterDomino()

	{					
		if ( nbDomino > 12 ) return false;
		this.nbDomino++;
		return true;
	}

    public String  toString()
    {
    	String s = " couleur : "          + String.format ("%10s", this.couleur)  + "  " +
    	           " Nombre de Domino : " + String.format ("%2d",  this.nbDomino) + "  " +
    	           " plateau : "  +        plateau.toString()                      + "  ";
    	return s; 
    }


}
