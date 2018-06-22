package projet_tut_2018.kingdomino.metier;
/**
 * Class Mine
 * @author  BEAUMONT, LECHANOINE, LEBOSSE, DUPONT, LEVALLOIS, LABBE 
 * @date    18/06/2018
 * @version 3.0
 *
*/

public class Mine extends Biome
{
	public static final String IMAGE = "mine";
	public Mine(int point){super(point);}
	public String getImage()
	{
		if (this.point == 0)return Mine.IMAGE;
		else   return Mine.IMAGE+this.point;
	}
}
