/**
 * Class Chateau
 * @author  BEAUMONT, LECHANOINE, LEBOSSE, DUPONT, LEVALLOIS, LABBE 
 * @date    18/06/2018
 * @version 3.0
 *
*/

public class Chateau extends Biome
{
	private static final String COULEUR = "Chateau (gris)";
	public Chateau(int point){super(point);}
	public String getCouleur(){return Chateau.COULEUR;}
}