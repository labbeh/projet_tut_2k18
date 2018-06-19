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

	public abstract String getCouleur();
	
	public String toString() { return String.format("%10s", this.getCouleur()) +  " a " + this.point + " "; }


}
