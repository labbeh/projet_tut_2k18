package projet_tut_2018.kingdomino.metier;

/**
 * Class Desert
 * @author  BEAUMONT, LECHANOINE, LEBOSSE, DUPONT, LEVALLOIS, LABBE 
 * @date    18/06/2018
 * @version 3.0
 *
*/

public class Desert extends Biome
{
	//public static final String COULEUR = "Desert (Marron)";
	public static final String COULEUR = "D ";
	public Desert(int point){super(point);}
	public String getCouleur(){return Desert.COULEUR;}
}
