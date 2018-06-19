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
	private char[][]    tabJeu;
	private ArrayList<Domino>  tuilePiochee;
	private ArrayList<Domino>  tuileJouees;
	private ArrayList<Integer> arrayRoi;

/**
 *La pioche du jeu 
 *
 *@see Pioche 
 */
	private Pioche     pioche;

/**
 *Les Joueur du jeu
 *
 *@see Joueur 
 */
	private Joueur[] tabJoueur;

	private int      JoueurCourant;

/**
 *Constructeur de Plateau
 *
 *@param tuilePiochée  : tuiles piochées dans la pioche
 *@param tuileJouée    : tuiles utilisées durant la partie
 *@param tabJoueur     : tableau de joueur initialisé à 2 joueur
 *@param tabJeu        : tableau de caractère servant à l'affichage CUI 
 */

	public Plateau()
	{

		this.tuileJouees  = new ArrayList<Domino>();
		this.pioche = new Pioche();

		this.tabJoueur = new Joueur[2];
		this.JoueurCourant = 0;
		this.tabJeu = new char[5][5];

	}

/**
 *Initialisation de l'affichage du plateau et du chateau (premiere carte de jeu)
 *
 *@return un booleen, vrai si le chateau à été placé dans le plateau, faux s il est en dehors 
*/

	public boolean initPlateau()
	{
		for (int cptLig = 0; cptLig < this.tabJeu.length;cptLig++)
			for (int cptCol = 0; cptCol < this.tabJeu.length; cptCol++)
				tabJeu[cptLig][cptCol]=' ';

		Scanner in  = new Scanner(System.in);
		System.out.print("placez le chateau : (ligne:colonne)");
		String str  = in.nextLine();
		int ligne   = str.charAt(0);
		int colonne = str.charAt(1);

		if (ligne >= 5 || ligne < 0){return false;}
		if (colonne >= 5 || colonne < 0){return false;}
		tabJeu[ligne][colonne] = 'C';
		this.tuileJouees.add(new Domino(new Chateau(0)));

		in.close();
		return true;
	}

/**
 *Déroulement du jeu 
 *
 *@
*/

	public void Jouer()
	{
		this.tuilePiochee = new ArrayList<Domino>();

		this.joueur[0] = new Joueur("bleu");
		this.joueur[1] = new Joueur("rouge");

		this.arrayRoi = new ArrayList<Integer>();
		this.arrayRoi.add(0);
		this.arrayRoi.add(0);
		this.arrayRoi.add(1);
		this.arrayRoi.add(1);

		Collections.shuffle(this.arrayRoi);

		while ( ! pioche.estVide() )
		{
			this.manche();




			return true;
		}
	}

	public void manche()
	{
		this.piocherCarte();
		for (int cpt = 0; cpt < arrayRoi.size();cpt++) 
		{
			joueurCourant = arrayRoi.get(cpt)%2;
			do
			{
				Scanner in = new Scanner(System.in);
				System.out.print("placez votre roi sur une tuile : (choix 1,2,3 ou 4)" );
				String str  = in.nextLine();
				int choix   = str.charAt(0);
		    }
			while ( choix > 0 && choix <= 4 && ! this.tuilePiochee.get(choix).asRoi() )
			this.tuilePiochee.get(choix).setAsRoi();
			this.Joueur[joueurCourant] 
			//il faut : 
			// 1. gerer le choix des tuile ( parmi les 4 tuiles disponibles) + verif
			// 2. gerer l'enregistrement de la carte dans une ArrayList
			// 3. gerer le placement de la carte
		}
	}

/**
 *Remplis l'ArrayList de quatre Domino
 *
 *@return un booleen, vrai si les carte on été pioché, faux si l'une d'entre elle est nulle
*/

	public boolean piocherCarte()
	{
		for (int nbTuile = 0; nbTuile < 4;nbTuile++)
		{

			Domino dominoJeu = pioche.piocher();
			if (dominoJeu == null){return false;}
			dominoJeu.toString();
			this.tuilePiochee.add(dominoJeu);


		}
		return true;
	}

	public String toString()
	{
		String s ="";
		for (int cptLig = 0; cptLig < this.tabJeu.length;cptLig++)
			for (int cptCol = 0; cptCol < this.tabJeu.length; cptCol++)
				s+=(tabJeu[cptLig][cptCol]);
		return s;
	}
}