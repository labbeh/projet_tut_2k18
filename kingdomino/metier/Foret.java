package projet_tut_2018.kingdomino.metier;

/**
 * Class Foret
 * @author  BEAUMONT, LECHANOINE, LEBOSSE, DUPONT, LEVALLOIS, LABBE 
 * @date    18/06/2018
 * @version 3.0
 *
*/

public class Foret extends Biome
{
	//public static final String COULEUR = "Foret (Kaki)";
	public static final String IMAGE = "foret";
	public Foret(int point){super(point);}
	public String getImage(){return Foret.IMAGE;}

}
