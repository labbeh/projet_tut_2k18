/**
 * Class Mine
 * @author  BEAUMONT, LECHANOINE, LEBOSSE, DUPONT, LEVALLOIS, LABBE 
 * @date    18/06/2018
 * @version 3.0
 *
*/

public class Mine extends Biome
{
	public static final String COULEUR = "Mine (Noir)";
	public Mine(int point){super(point);}
	public String getCouleur(){return Mine.COULEUR;}
}