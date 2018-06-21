package projet_tut_2018.kingdomino.metier;

/**
 * Class Biome
 * @author  BEAUMONT, LECHANOINE, LEBOSSE, DUPONT, LEVALLOIS, LABBE 
 * @date    18/06/2018
 * @version 3.0
 *
*/

abstract class Biome
{
	protected int point;
	private String couleur;
	
/**
 *Constructeur de Biome
 *
 *@param point : le nombre de point du biome (couronnes)
*/
	public Biome(int point){this.point=point;}

	public Biome(){this.point = -1;}

	public abstract String getCouleur();
	public         int    getPoint(){return this.point;}
	
	public String toString()
	{
		if (this.point == -1){return "rien";}
		return String.format("%2s", this.getCouleur()) + this.point ; }


}
