package projet_tut_2018.kingdomino.metier;
/**
 * Class Biome
 * @author  BEAUMONT, LECHANOINE, LEBOSSE, DUPONT, LEVALLOIS, LABBE 
 * @date    18/06/2018
 * @version 3.0
 *
*/

public abstract class Biome
{
	protected int point = -1;
	private String couleur;
	private static int numBiomeStk = 0;
	private int numBiome; 
	
/**
 *Constructeur de Biome
 *
 *@param point : le nombre de point du biome (couronnes)
*/
	public Biome(int point){this.point=point;
							this.numBiome = numBiomeStk++;}

	public         int    getPoint(){return this.point;}
	public         int    getNum()  {if (this != null)return this.numBiome;return -1;}
	public         Biome  getBiome(){return this;}

	public boolean equals(Biome biome){if(biome != null) return this.getImage().equals(biome.getImage());
										return false;}

	public abstract String getImage();
	
	public String toString()
	{
		if (this.getPoint() == -1){return "rien";}
		return " " + String.format("%7s", this.getImage()) + String.format("%02d", this.point) ; }

}
