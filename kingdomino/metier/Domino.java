/**
 * Class Domino
 * @author  BEAUMONT, LECHANOINE, LEBOSSE, DUPONT, LEVALLOIS, LABBE 
 * @date    18/06/2018
 * @version 3.0
 *
*/

public class Domino
{
	private static int numDominoStk = 2;

	private int     numDomino;    
	private Biome   biome1;        
	private Biome   biome2;
	private Boolean asRoi;     

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
		this.asRoi  = false;
	}

/**
 * Constructeur à un paramètre de Domino sert excluvivement au Chateau
 * @param biome1 : biome Chateau
 * @param numDomino : initialisé à 1 car première crate du jeu
*/

	public Domino(Biome biome1)
	{
		this.biome1 = biome1;
		this.numDomino = 1;
	}

	public int getNumDomino(){return this.numDomino;}
	public boolean asRoi(){return this.asRoi;}

/**
 *Instancie l'attribut asRoi
 *
 *si asRoi est true set en false, si asRoi est false set en true
*/
	public void setAsRoi()
	{
		if (this.asRoi == false){this.asRoi = true;}
		if (this.asRoi == true ){this.asRoi = false;}
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
