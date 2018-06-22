package projet_tut_2018.kingdomino.metier;

/**
 * Class Prairie
 * @author  BEAUMONT, LECHANOINE, LEBOSSE, DUPONT, LEVALLOIS, LABBE 
 * @date    18/06/2018
 * @version 3.0
 *
*/

public class Prairie extends Biome
{
	//public static final String COULEUR = "Prairie (Vert)";
	public static final String IMAGE = "prairie";
	public Prairie(int point){super(point);}
	public String getImage(){return Prairie.IMAGE;}
}
