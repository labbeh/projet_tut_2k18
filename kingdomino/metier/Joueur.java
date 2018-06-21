package projet_tut_2018.kingdomino.metier;

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
	private String  nom;
	private Roi[]   tabRoi;
	private int	nbRoi = 0;

/**
 *Constructeur de Joueur 
 *
 *@param couleur : le joueur est identifié par une couleur
 *@param nbDomino : nombre de Domino que le Joueur a placé
 *@param plateau : plateau du joueur initialisé a null
*/

	public Joueur(String nom, String couleur)
	{
		this.couleur  = couleur;
		this.nbDomino = 0; 
		this.plateau  = null;
		this.nom      = nom;

		this.tabRoi    = new Roi[2];

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
	public Roi     creerRoi()	{return this.tabRoi[this.nbRoi++] = new Roi(this);}
	public void    resetRoi()   
	{
		this.tabRoi[0] = null;
		this.tabRoi[1] = null;
		this.nbRoi = 0;
	}
	public String  getCouleur() {return this.couleur;}
	public int     getNbDomino(){return this.nbDomino;}
	public Plateau getPlateau() {return this.plateau;}
	public String  getNom()     {return this.nom;}
	public Roi     getRoi(int ind) {return this.tabRoi[ind];}

	public void    setNom(String nom)     {this.nom = nom;}


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
