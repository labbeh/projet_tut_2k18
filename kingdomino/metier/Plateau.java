package projet_tut_2018.kingdomino.metier;
/**
 * Class Plateau
 * @author  BEAUMONT, LECHANOINE, LEBOSSE, DUPONT, LEVALLOIS, LABBE 
 * @date    18/06/2018
 * @version 3.0
 *
*/

import java.util.ArrayList;
//import java.util.Scanner;
import java.util.Collections;

public class Plateau
{
	private Biome[][]          tabJeu;
	private ArrayList<Domino>  tuileJouees;


/**
 *Constructeur de Plateau
 *
 *@param tuileJouée    : tuiles utilisées durant la partie
 *@param tabJeu        : tableau de caractère servant à l'affichage CUI 
 */

	public Plateau()
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
		//Scanner in  = new Scanner(System.in);
		System.out.print("placez le chateau : (ligne:colonne)");
		String str  = "44";
		if (str.length() != 2 || !Character.isDigit(str.charAt(0)) || ! Character.isDigit(str.charAt(1)) ){return false;}
			int ligne   = (int) str.charAt(0) - '0';
			int colonne = (int) str.charAt(1) - '0';

		System.out.println("check");

		if (ligne >= 5 || ligne < 0){return false;}
		if (colonne >= 5 || colonne < 0){return false;}

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

	public boolean estCompatible(int ligne, int colonne, int ligne2, int colonne2, Domino domino, char sens)
	{
		boolean bOk = false;
		if(domino.getBiome1() != domino.getBiome2())
		{
			if( ligne+1 < 4  && tabJeu[ligne+1][colonne] == domino.getBiome1() || tabJeu[ligne+1][colonne] == this.tuileJouees.get(0).getBiome1()){bOk = true;}
			if(colonne+1 < 4 && tabJeu[ligne][colonne+1] == domino.getBiome1() || tabJeu[ligne][colonne+1] == this.tuileJouees.get(0).getBiome1()){bOk = true;}
			if( ligne-1 > 0  && tabJeu[ligne-1][colonne] == domino.getBiome1() || tabJeu[ligne-1][colonne] == this.tuileJouees.get(0).getBiome1()){bOk = true;}
			if(colonne-1 > 0 && tabJeu[ligne][colonne-1] == domino.getBiome1() || tabJeu[ligne][colonne-1] == this.tuileJouees.get(0).getBiome1()){bOk = true;}
	
			if( ligne2+1 < 4 && tabJeu[ligne2+1][colonne2] == domino.getBiome2() || tabJeu[ligne2+1][colonne2] == this.tuileJouees.get(0).getBiome1()){bOk = true;}
			if(colonne2+1< 4 && tabJeu[ligne2][colonne2+1] == domino.getBiome2() || tabJeu[ligne2][colonne2+1] == this.tuileJouees.get(0).getBiome1()){bOk = true;}
			if( ligne2-1 > 0 && tabJeu[ligne2-1][colonne2] == domino.getBiome2() || tabJeu[ligne2-1][colonne2] == this.tuileJouees.get(0).getBiome1()){bOk = true;}
			if(colonne2-1> 0 && tabJeu[ligne2][colonne2-1] == domino.getBiome2() || tabJeu[ligne2][colonne2-1] == this.tuileJouees.get(0).getBiome1()){bOk = true;}
		}
		else 
		{
			if (sens == 'N' || sens == 'S')
			{
				if(colonne+1 < 4 && tabJeu[ligne][colonne+1] == domino.getBiome1() || tabJeu[ligne][colonne+1] == this.tuileJouees.get(0).getBiome1()){bOk = true;}
				if( ligne-1 > 0  && tabJeu[ligne-1][colonne] == domino.getBiome1() || tabJeu[ligne-1][colonne] == this.tuileJouees.get(0).getBiome1()){bOk = true;}
				if(colonne-1 > 0 && tabJeu[ligne][colonne-1] == domino.getBiome1() || tabJeu[ligne][colonne-1] == this.tuileJouees.get(0).getBiome1()){bOk = true;}
	
				if( ligne2+1 < 4 && tabJeu[ligne2+1][colonne2] == domino.getBiome2() || tabJeu[ligne2+1][colonne2] == this.tuileJouees.get(0).getBiome1()){bOk = true;}
				if(colonne2+1< 4 && tabJeu[ligne2][colonne2+1] == domino.getBiome2() || tabJeu[ligne2][colonne2+1] == this.tuileJouees.get(0).getBiome1()){bOk = true;}
				if(colonne2-1> 0 && tabJeu[ligne2][colonne2-1] == domino.getBiome2() || tabJeu[ligne2][colonne2-1] == this.tuileJouees.get(0).getBiome1()){bOk = true;}
			}
			else
			{
				if( ligne+1 < 4  && tabJeu[ligne+1][colonne] == domino.getBiome1() || tabJeu[ligne+1][colonne] == this.tuileJouees.get(0).getBiome1()){bOk = true;}
				if( ligne-1 > 0  && tabJeu[ligne-1][colonne] == domino.getBiome1() || tabJeu[ligne-1][colonne] == this.tuileJouees.get(0).getBiome1()){bOk = true;}
				if(colonne-1 > 0 && tabJeu[ligne][colonne-1] == domino.getBiome1() || tabJeu[ligne][colonne-1] == this.tuileJouees.get(0).getBiome1()){bOk = true;}
	
				if( ligne2+1 < 4 && tabJeu[ligne2+1][colonne2] == domino.getBiome2() || tabJeu[ligne2+1][colonne2] == this.tuileJouees.get(0).getBiome1()){bOk = true;}
				if(colonne2+1< 4 && tabJeu[ligne2][colonne2+1] == domino.getBiome2() || tabJeu[ligne2][colonne2+1] == this.tuileJouees.get(0).getBiome1()){bOk = true;}
				if( ligne2-1 > 0 && tabJeu[ligne2-1][colonne2] == domino.getBiome2() || tabJeu[ligne2-1][colonne2] == this.tuileJouees.get(0).getBiome1()){bOk = true;}
			}
		}
		return bOk;
	}

	public  boolean placerDomino(int ligne, int colonne, Domino domino, char sens )
	{
		int ligne2 = 0;
		int colonne2 = 0;
		if (estOccupe(ligne, colonne)){return false;}

		if (sens == 'N' && estOccupe(ligne - 1, colonne)){return false;}
		else {--ligne2;}
		if (sens == 'E' && estOccupe(ligne, colonne + 1)){return false;}
		else {++colonne2;}
		if (sens == 'S' && estOccupe(ligne + 1, colonne)){return false;}
		else{++ligne2;}
		if (sens == '0' && estOccupe(ligne, colonne - 1)){return false;}
		else{--colonne2;}

		if (domino.getBiome1() == domino.getBiome2())
		{
			if (sens == 'N' || sens == 'S')
				ligne2 = -1;
			if (sens == 'E' || sens == 'O')
				colonne2 = 1;
		}


		if ( this.tuileJouees.size() == 1)
		{
			tabJeu[ligne][colonne] = domino.getBiome1();
			tabJeu[ligne+ligne2][colonne+colonne2] = domino.getBiome2();
			this.tuileJouees.add(domino);
			return true;
		}
		else
		{
			if ( ! this.estCompatible(ligne, colonne, ligne2, colonne2, domino, sens)){return false;}
			tabJeu[ligne][colonne] = domino.getBiome1();
			tabJeu[ligne2][colonne2] = domino.getBiome2();
			this.tuileJouees.add(domino);
			return true;
		}
	}

	public String toString()
	{
		String s =
		"+----------+----------+----------+----------+----------+"+"\n"+
		"|          |          |          |          |          |"+"\n"+
		"|   "+tabJeu[0][0].toString()+"   |   "+tabJeu[0][1].toString()+"   |   "+tabJeu[0][2].toString()+"   |   "+tabJeu[0][3].toString()+"   |   "+tabJeu[0][4].toString()+"   |"+"\n"+
		"|          |          |          |          |          |"+"\n"+
		"+----------+----------+----------+----------+----------+"+"\n"+
		"|          |          |          |          |          |"+"\n"+
		"|   "+tabJeu[1][0].toString()+"   |   "+tabJeu[1][1].toString()+"   |   "+tabJeu[1][2].toString()+"   |   "+tabJeu[1][3].toString()+"   |   "+tabJeu[1][4].toString()+"   |"+"\n"+
		"|          |          |          |          |          |"+"\n"+
		"+----------+----------+----------+----------+----------+"+"\n"+
		"|          |          |          |          |          |"+"\n"+
		"|   "+tabJeu[2][0].toString()+"   |   "+tabJeu[2][1].toString()+"   |   "+tabJeu[2][2].toString()+"   |   "+tabJeu[2][3].toString()+"   |   "+tabJeu[2][4].toString()+"   |"+"\n"+
		"|          |          |          |          |          |"+"\n"+
		"+----------+----------+----------+----------+----------+"+"\n"+
		"|          |          |          |          |          |"+"\n"+
		"|   "+tabJeu[3][0].toString()+"   |   "+tabJeu[3][1].toString()+"   |   "+tabJeu[3][2].toString()+"   |   "+tabJeu[3][3].toString()+"   |   "+tabJeu[3][4].toString()+"   |"+"\n"+
		"|          |          |          |          |          |"+"\n"+
		"+----------+----------+----------+----------+----------+"+"\n"+
		"|          |          |          |          |          |"+"\n"+
		"|   "+tabJeu[4][0].toString()+"   |   "+tabJeu[4][1].toString()+"   |   "+tabJeu[4][2].toString()+"   |   "+tabJeu[4][3].toString()+"   |   "+tabJeu[4][4].toString()+"   |"+"\n"+
		"|          |          |          |          |          |"+"\n"+
		"+----------+----------+----------+----------+----------+"+"\n";

		return s;
	}


}