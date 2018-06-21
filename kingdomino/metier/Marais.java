package projet_tut_2018.kingdomino.metier;

/**
 * Class Desert
 * @author  BEAUMONT, LECHANOINE, LEBOSSE, DUPONT, LEVALLOIS, LABBE 
 * @date    18/06/2018
 * @version 3.0
 *
*/

public class Marais extends Biome
{
	//public static final String COULEUR = "Desert (Marron)";
	public static final String IMAGE = "marais";
	public Marais(int point){super(point);}
	public String getImage(){return Marais.IMAGE;}
}
