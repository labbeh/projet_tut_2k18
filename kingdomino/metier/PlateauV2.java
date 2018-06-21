package projet_tut_2018.kingdomino.metier;

/**
 * Class Plateau
 * @author  BEAUMONT, LECHANOINE, LEBOSSE, DUPONT, LEVALLOIS, LABBE 
 * @date    18/06/2018
 * @version 3.0
 *
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class PlateauV2
{
	private Biome[][]          tabJeu;
	private ArrayList<Domino>  tuileJouees;


/**
 *Constructeur de Plateau
 *
 *@param tuileJouée    : tuiles utilisées durant la partie
 *@param tabJeu        : tableau de caractère servant à l'affichage CUI 
 */

	public PlateauV2()
	{

		this.tuileJouees  = new ArrayList<Domino>();

		this.tabJeu = new Biome[5][5];

	}

/**
 *Initialisation de l'affichage du plateau et du chateau (premiere carte de jeu)
 *
 *@return un booleen, vrai si le chateau à été placé dans le plateau, faux s il est en dehors 
*/

	public boolean initPlateau()
	{


		Scanner in  = new Scanner(System.in);
		System.out.print("placez le chateau : (ligne:colonne)");
		String str  = in.nextLine();
		if (str.length() != 2 || !Character.isDigit(str.charAt(0)) || ! Character.isDigit(str.charAt(1)) ){return false;}
			int ligne   = (int) str.charAt(0) - '0' -1;
			int colonne = (int) str.charAt(1) - '0' -1;

		System.out.println("check");

		if (ligne > 5 || ligne < 0){return false;}
		if (colonne > 5 || colonne < 0){return false;}

		System.out.println("check");

		this.tuileJouees.add( new Domino(new Chateau(0)));
		tabJeu[ligne][colonne] = this.tuileJouees.get(0).getBiome1();
		System.out.println("check");

		System.out.println(this.tuileJouees.get(0).toString());



		//in.close();
		return true;

	}

	public boolean estOccupe(int ligne, int colonne)
	{
		if (ligne < 0 || ligne > 4)        {return false;}
		if (colonne < 0 || colonne > 4 )   {return false;}
		if (tabJeu[ligne][colonne] == null){return false;}
		return true;
	}

	public boolean estCompatible(int ligneG, int colonneG, int ligneD, int colonneD, Biome biomeG, Biome biomeD, char sens)
	{
		boolean bOk = false;

		int tmpLigneG = ligneG;
		int tmpColonneG = colonneG;
		int tmpLigneD = ligneD;
		int tmpColonneD = colonneD;

		for(int cptLigneG = ligneG - 1 ; cptLigneG < ligneG + 1 ; cptLigneG += 2)
			try{
				if(biomeG.equals(tabJeu[cptLigneG][colonneG]) || this.tuileJouees.get(0).getBiome1().equals(tabJeu[cptLigneG][colonneG])){bOk = true;}
			}catch(ArrayIndexOutOfBoundsException e){}

		for(int cptColonneG = colonneG - 1 ; cptColonneG < colonneG + 1 ; cptColonneG += 2)
			try{
				if(biomeG.equals(tabJeu[ligneG][cptColonneG]) || this.tuileJouees.get(0).getBiome1().equals(tabJeu[ligneG][cptColonneG])){bOk = true;}
			}catch(ArrayIndexOutOfBoundsException e){}

		for(int cptLigneD = ligneD - 1 ; cptLigneD < ligneD + 1 ; cptLigneD += 2)
			try{
				if(biomeD.equals(tabJeu[cptLigneD][colonneD]) || this.tuileJouees.get(0).getBiome1().equals(tabJeu[cptLigneD][colonneD])){bOk = true;}
			}catch(ArrayIndexOutOfBoundsException e){}

		for(int cptColonneD = colonneD - 1 ; cptColonneD < colonneD + 1 ; cptColonneD += 2)
			try{
				if(biomeD.equals(tabJeu[ligneD][cptColonneD]) || this.tuileJouees.get(0).getBiome1().equals(tabJeu[ligneD][cptColonneD])){bOk = true;}
			}catch(ArrayIndexOutOfBoundsException e){}

		return bOk;
	}

	public  boolean placerDomino(int ligne, int colonne, Domino domino, char sens)
	{
		int ligne2 = 0;
		int colonne2 = 0;

		Biome biomeG = domino.getBiome1();
		Biome biomeD = domino.getBiome2();

		System.out.println(biomeD.toString());

		if (estOccupe(ligne, colonne)){return false;}

		if (sens == 'N' && estOccupe(ligne - 1, colonne))return false;
		if (sens == 'N' )ligne2-=1;
		if (sens == 'E' && estOccupe(ligne, colonne + 1))return false;
		if (sens == 'E' )colonne2+=1;
		if (sens == 'S' && estOccupe(ligne + 1, colonne))return false;
		if (sens == 'S' )ligne2+=1;
		if (sens == '0' && estOccupe(ligne, colonne - 1))return false;
		if (sens == '0' )colonne2-=1;

		if (biomeG == biomeD)
		{
			if (sens == 'N' || sens == 'S')
				ligne2 = -1;
			if (sens == 'E' || sens == 'O')
				colonne2 = 1;
		}
		System.out.println("V2" + ligne + "  " + colonne + "  " + ligne2 + "  " + colonne2 );	
		ligne2 = ligne + ligne2;
		colonne2 = colonne + colonne2;

		if ( ! this.estCompatible(ligne, colonne, ligne2, colonne2, biomeG, biomeD, sens)){return false;}
		System.out.println("V3" + ligne + "  " + colonne + "  " + ligne2 + "  " + colonne2 );		
		tabJeu[ligne][colonne] = biomeG;
		tabJeu[ligne2][colonne2] = biomeD;
		System.out.println(tabJeu[ligne2][colonne2]);
		this.tuileJouees.add(domino);
		return true;
	}

	public String toString()
	{
		String n = "        01         02         03         04         05     "+"\n";
		String l = "   +----------+----------+----------+----------+----------+"+"\n";
		String m = "   |          |          |          |          |          |"+"\n";
		String s =  "\n" + n + l;

		for(int i = 0; i < 5; i++)
		{
			s += m + "0"+(i+1)+" |";

			for(int j = 0; j < 5; j++)
			{
				if (tabJeu[i][j] != null)
				{	
					s += tabJeu[i][j].toString()+"|";
				}
				else
					s += "          |";
			}

			s += "\n" + m + l;
		}
		s += n;
		

		return s;
	}


}