package projet_tut_2018.kingdomino.metier;
/**
 * Class Lac
 * @author  BEAUMONT, LECHANOINE, LEBOSSE, DUPONT, LEVALLOIS, LABBE 
 * @date    18/06/2018
 * @version 3.0
 *
*/

public class Lac extends Biome
{
	public static final String IMAGE = "lac";
	public Lac(int point){super(point);}
	public String getImage()
	{
		if (this.point == 0)return Lac.IMAGE;
		else   return Lac.IMAGE+this.point;
	}
}
