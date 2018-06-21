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
	protected int point = -1;
	private String couleur;
	
/**
 *Constructeur de Biome
 *
 *@param point : le nombre de point du biome (couronnes)
*/
	public Biome(int point){this.point=point;}

	public         int    getPoint(){return this.point;}

	public   String       getCouronne()
	{
		if (this.point == 1 ){return "une_couronne";}
		if (this.point == 2 ){return "deux_couronne";}
		if (this.point == 3 ){return "trois_couronne";}
		return null; 
	}

	public boolean equals(Biome biome){if(biome != null) return this.getImage().equals(biome.getImage());
										return false;}

	public abstract String getImage();
	
	public String toString()
	{
		if (this.getPoint() == -1){return "rien";}
		return "   " + String.format("%5s", this.getImage()) + String.format("%02d", this.point) ; }

}
