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

	public Biome[][] getTabJeu(){return this.tabJeu;}
	public Biome     getBiome(int indLig,int indCol){return tabJeu[indLig][indCol];}
	public void      setTab(Biome[][] tab){this.tabJeu = tab;}

	/*--------------methodes tests---------------*/
	/*-------------------------------------------*/

	public Plateau getTabTest()
	{
		Biome[][] tabTest = new Biome[5][5];

		tabTest[0][0] = new Chateau(0); 
		tabTest[0][1] = new Champs(2);
		tabTest[0][2] = new Champs(0);
		tabTest[0][3] = new Champs(0);
		tabTest[0][4] = new Lac(0);
		tabTest[1][0] = new Champs(0);
		tabTest[1][1] = new Champs(0);
		tabTest[1][2] = new	Mine (3);
		tabTest[1][3] = new Mine (0);
		tabTest[1][4] = new Marais(0);
		tabTest[2][0] = new Champs(0);
		tabTest[2][1] = new Champs(0);
		tabTest[2][2] = new Champs(0);
		tabTest[2][3] = new Marais(0);
		tabTest[2][4] = new Marais(0);
		tabTest[3][0] = new Mine(0);
		tabTest[3][1] = new Mine(0);
		tabTest[3][2] = new Marais(0);
		tabTest[3][3] = new Marais(2);
		tabTest[3][4] = new Marais(0);
		tabTest[4][0] = new Lac(0);
		tabTest[4][1] = new Lac(1);
		tabTest[4][2] = new Lac(0);
		tabTest[4][3] = new Champs(0);
		tabTest[4][4] = new Champs(1);

		Plateau pl = new Plateau();
		pl.setTab(tabTest);


		return pl;

	}

/**
 *Initialisation de l'affichage du plateau et du chateau (premiere carte de jeu)
 *
 *@return un booleen, vrai si le chateau à été placé dans le plateau, faux s il est en dehors 
*/


	public boolean initPlateau()
	{




		this.tuileJouees.add( new Domino(new Chateau(0)));
		tabJeu[2][2] = this.tuileJouees.get(0).getBiome1();

		System.out.println(this.tuileJouees.get(0).toString());



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

		for(int cptLigneG = ligneG - 1 ; cptLigneG <= ligneG + 1 ; cptLigneG += 2)
			try{
				if(biomeG.equals(tabJeu[cptLigneG][colonneG]) || this.tuileJouees.get(0).getBiome1().equals(tabJeu[cptLigneG][colonneG])){bOk = true;}
			}catch(ArrayIndexOutOfBoundsException e){}

		for(int cptColonneG = colonneG - 1 ; cptColonneG <= colonneG + 1 ; cptColonneG += 2)
			try{
				if(biomeG.equals(tabJeu[ligneG][cptColonneG]) || this.tuileJouees.get(0).getBiome1().equals(tabJeu[ligneG][cptColonneG])){bOk = true;}
			}catch(ArrayIndexOutOfBoundsException e){}

		for(int cptLigneD = ligneD - 1 ; cptLigneD <= ligneD + 1 ; cptLigneD += 2)
			try{
				if(biomeD.equals(tabJeu[cptLigneD][colonneD]) || this.tuileJouees.get(0).getBiome1().equals(tabJeu[cptLigneD][colonneD])){bOk = true;}
			}catch(ArrayIndexOutOfBoundsException e){}

		for(int cptColonneD = colonneD - 1 ; cptColonneD <= colonneD + 1 ; cptColonneD += 2)
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

		ligne2 = ligne + ligne2;
		colonne2 = colonne + colonne2;

		if ( ! this.estCompatible(ligne, colonne, ligne2, colonne2, biomeG, biomeD, sens)){return false;}
	
		tabJeu[ligne][colonne] = biomeG;
		tabJeu[ligne2][colonne2] = biomeD;

		this.tuileJouees.add(domino);
		return true;
	}

	/*public boolean plateauBloque()
	{
		boolean bOk = true;
		for(int i = 0; i<this.tabJeu.length;i++)
			for(int j = 0;i<this.tabJeu.length;j++)
				if(tabJeu[i][j] == null)
				{
					int iTemp = i;int jTemp = j;
					for(int iT = iTemp - 1 ; iT <= iTemp + 1 ; iT += 2)
					try{
						if(tabJeu[i][j] == tabJeu[iTemp][j]){bOk = false;}
					}catch(ArrayIndexOutOfBoundsException e){}
					for(int jT = jTemp - 1 ; jT <= jTemp + 1 ; jT += 2)
					try{
						if(tabJeu[i][j] == tabJeu[i][jTemp]){bOk = false;}
					}catch(ArrayIndexOutOfBoundsException e){}
				}
		return bOk;*/


	

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