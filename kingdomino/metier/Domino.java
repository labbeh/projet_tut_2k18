package projet_tut_2018.kingdomino.metier;
/**
 * Class Domino
 * @author  BEAUMONT, LECHANOINE, LEBOSSE, DUPONT, LEVALLOIS, LABBE 
 * @date    18/06/2018
 * @version 3.0
 *
*/

public class Domino
{
	private static int numDominoStk = 1;

	private int     numDomino;    
	private Biome   biome1;        
	private Biome   biome2;
	private char    sens;   
	private Roi     roi;

/** 
 * Constructeur à deux paramètre de Domino
 * 
 * @param biome1 : biome de la partie gauche du Domino
 * @param biome2 : biome de la partie Droite du Domino
 * @param numDomino : numéro auto-incrémenté identifiant le domino
 * @param asRoi     : boolean initilisé a false pour indiquer la disponibilié de la carte
 * @see   Biome  
 */
	
	public Domino(Biome biome1, Biome biome2)
	{
		this.biome1 = biome1;
		this.biome2 = biome2;
		this.numDomino = Domino.numDominoStk++;
		this.sens   = 'N';
		this.roi    =  null;

	}

/**
 * Constructeur à un paramètre de Domino sert excluvivement au Chateau
 * @param biome1 : biome Chateau
 * @param numDomino : initialisé à 1 car première crate du jeu
*/

	public Domino(Biome biome1)
	{
		this.biome1 = biome1;
		this.numDomino = 0;
	}

	public char  getSens(){return this.sens;}
	public Biome getBiome1(){return this.biome1;}
	public Biome getBiome2(){return this.biome2;}
	public Roi   getRoi()   {return this.roi;}
	public int getNumDomino(){return this.numDomino;}

	public void  setRoi(Roi roi){this.roi = roi;}
	public String  getImage()
	{
		if ( this.numDomino == 0)
			return "tuileDepart.gif";
		else
			return "tuile" + this.numDomino;
	}

	public void setSens()
	{
		if (this.sens == 'N' ){this.sens = 'E';}
		if (this.sens == 'E' ){this.sens = 'S';}
		if (this.sens == 'S' ){this.sens = 'O';}
		if (this.sens == 'O' ){this.sens = 'N';}
	}
	
	public String toString()
	{
		String s ="";
		if (biome1 != null)
			s+= biome1.toString();
		if (biome2 != null)
			s+= biome2.toString();

		return s;
	}
}