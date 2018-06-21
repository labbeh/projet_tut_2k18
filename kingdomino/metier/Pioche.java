package projet_tut_2018.kingdomino.metier;

/**
 * Class Pioche
 * @author  BEAUMONT, LECHANOINE, LEBOSSE, DUPONT, LEVALLOIS, LABBE 
 * @date    18/06/2018
 * @version 3.0
 *
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class Pioche
{

	private static String listDomino = "L0L0:L0L0:P0P0:P0P0:D0D0:C0F0:C0L0:C0C0:C0C0" +
									   ":F0F0:F0F0:F0F0:L0L0:C1D0:C1M0:F1C0:F1C0:F1C0" +
									   ":F1C0:F1L0:C0P0:C0D0:F0L0:F0C0:C1F0:C1L0:C1P0" +
									   ":C0P1:L0P1:C0D1:P0D1:M1C0:C0P2:L0P2:F1P0:L1C0" +
									   ":L1C0:L1F0:L1F0:L1F0:L1F0:C0D2:P0D2:M2C0:D0M2" +
									   ":D0M2:C0M3:C0M3";


	private ArrayList<Domino> ens;

	public Pioche()
	{
		ens = new ArrayList<Domino>();

		this.initPioche(); 
	}

	public void initPioche()
	{


		/* Constitution de la Pioche */
		/* ------------------------- */

		Scanner sc = new Scanner(listDomino);
		sc.useDelimiter("\n|:");
		String enreg = "";

		while (sc.hasNext())
		{
			     enreg = sc.next();
			char typeG = enreg.charAt(0);
			int pointG = enreg.charAt(1) - '0';
			char typeD = enreg.charAt(2);
			int pointD = enreg.charAt(3) - '0';
			Biome biomeG = null;
			Biome biomeD = null;
			switch(typeG)
			{
				case 'F': 
					biomeG = new Foret(pointG);   
					break;                         
				case 'C':                           
					biomeG = new Champs(pointG);    
					break;                          
				case 'L':                           
					biomeG = new Lac(pointG);
					break;
				case 'D':
					biomeG = new Marais(pointG);
					break;
				case 'P':
					biomeG = new Prairie(pointG);
					break;
				case 'M':
					biomeG = new Mine(pointG);
					break;
			}
			switch(typeD)
			{
				case 'F': 
					biomeD = new Foret(pointD);
					break;
				case 'C':
					biomeD = new Champs(pointD);
					break;
				case 'L':
					biomeD = new Lac(pointD);
					break;
				case 'D':
					biomeD = new Marais(pointD);
					break;
				case 'P':
					biomeD = new Prairie(pointD);
					break;
				case 'M':
					biomeD = new Mine(pointD);
					break;
			}
			ens.add(new Domino(biomeG, biomeD));
		}
		sc.close();


		/* Mélange de la Pioche */
		/* -------------------- */

		ens = this.melanger(ens);
	}

/**
 * Retourne une Arraylist mélangée
 *
 *@return une nouvelle ArrayList<Domino> mélangée de 24 éléments
 */

	public ArrayList<Domino> melanger(ArrayList<Domino> listeDepart)
	{
 
		ArrayList<Domino> nouvelle = new ArrayList<Domino>(listeDepart);
		Collections.shuffle(nouvelle); 
		nouvelle.subList(0,23); 
		return nouvelle;
	} 

/**
 * Retourne un Domino
 *
 *@return un Domino de la pioche
 */

	public Domino piocher()
	{
		if ( ens.size()>0)
			return ens.remove(0);
		else
			return null;
	}

	public boolean estVide()
	{
		return ens.isEmpty();
	}

	public String toString()
	{
		String s = "";
		for (int cpt = 0; cpt< ens.size();cpt++)
		{
			s+= ens.get(cpt).toString();
			s+= "\n";
		}
		return s;
	}



}