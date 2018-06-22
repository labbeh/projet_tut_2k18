package projet_tut_2018.kingdomino.metier;
/**
 * Class Champs
 * @author  BEAUMONT, LECHANOINE, LEBOSSE, DUPONT, LEVALLOIS, LABBE 
 * @date    18/06/2018
 * @version 3.0
 *
*/

public class Champs extends Biome
{
	public static final String IMAGE = "champs";
	public Champs(int point){super(point);}
	public String getImage()
	{
		if (this.point == 0)return Champs.IMAGE;
		else   return Champs.IMAGE+this.point;
	}
}