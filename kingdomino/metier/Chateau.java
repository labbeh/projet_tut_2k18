package projet_tut_2018.kingdomino.metier;
/**
 * Class Chateau
 * @author  BEAUMONT, LECHANOINE, LEBOSSE, DUPONT, LEVALLOIS, LABBE 
 * @date    18/06/2018
 * @version 3.0
 *
*/

public class Chateau extends Biome
{
	public static final String IMAGE = "tuileDepart";
	public Chateau(int point){super(point);}
	public String getImage(){return Chateau.IMAGE;}
}