package projet_tut_2018.kingdomino.metier;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Jeu
{

	private ArrayList<Domino>  tuilePiochee;
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

	private int      joueurCourant;

	public Jeu()
	{
		this.pioche = new Pioche();

		this.tabJoueur = new Joueur[2];
		this.joueurCourant = 0;
	}

	public Joueur getJoueur(int indiceJoueur){return this.tabJoueur[indiceJoueur];}
	public int    getJoueurCourant()         {return this.joueurCourant;}



	/**
 *Déroulement du jeu 
 *
 *@
*/

	public void jouer()
	{
		this.tuilePiochee = new ArrayList<Domino>();

		this.tabJoueur[0] = new Joueur("bleu");
		this.tabJoueur[0].ajouterPlateau(new Plateau());
		this.tabJoueur[1] = new Joueur("rouge");
		this.tabJoueur[1].ajouterPlateau(new Plateau());

		boolean bOk = false;

		do bOk = this.tabJoueur[0].getPlateau().initPlateau();
		while( ! bOk );

		do bOk = this.tabJoueur[1].getPlateau().initPlateau();
		while( ! bOk );		


		for (int nbJoueur = 0; nbJoueur < tabJoueur.length; nbJoueur++)
		{
			Scanner in = new Scanner(System.in);
			System.out.print("Joueur " + nbJoueur + " saisissez votre nom : " );
			String str  = in.nextLine();
			this.tabJoueur[nbJoueur].setNom(str);
		}

		this.arrayRoi = new ArrayList<Integer>();
		this.arrayRoi.add(0);
		this.arrayRoi.add(0);
		this.arrayRoi.add(1);
		this.arrayRoi.add(1);

		Collections.shuffle(this.arrayRoi);

		while ( !pioche.estVide() )
		{
			this.initManche();




		}
	}

	public void initManche()
	{
		this.piocherCarte();
		int choix = -1;

		Domino tuileUtil = null;
		int x = -1;
		int y = -1;
		char s = 'c';
		boolean bOk =false;


		for (int tourManche = 0; tourManche < this.arrayRoi.size(); tourManche++)
		{
			joueurCourant = this.arrayRoi.get(tourManche);
			String str = null;

			do
			{
				Scanner in  = new Scanner(System.in);
				System.out.print(tabJoueur[joueurCourant].getNom() + " choisi la carte : (1/2/3/4) :");
				str  = in.nextLine();

				try{
					choix = Integer.parseInt(str) - 1;
					if ( choix < 0 || choix > 3 )
						System.out.println("saisir un chiffre valide");
				}
				catch(Exception e){System.out.println("veuillez saisir un entier");}
			}
			while ( choix < 0 || choix > 3 || this.tuilePiochee.get(choix).getRoi() != null);

							System.out.print(this.tuilePiochee.size());
							System.out.print(choix);

			str = " ";


			this.tuilePiochee.get(choix).setRoi(this.tabJoueur[joueurCourant].creerRoi());
			tuileUtil = this.tuilePiochee.get(choix);
			System.out.println(tuileUtil.toString());

			System.out.println(this.tabJoueur[joueurCourant].getPlateau().toString());

			while(!bOk || (str.length()!= 3 || x < 0 || x > 4|| y < 0 || y > 4  || s != 'N' && s != 'O' && s != 'S' && s != 'E' ))
			{
				Scanner in  = new Scanner(System.in);
				System.out.print(tabJoueur[joueurCourant].getNom() + " choisi la place : (x,y,sens) :");
				str  = in.nextLine();

				try{
					x = ((int) str.charAt(0) - '0' )-1  ;
					y = ((int) str.charAt(1) - '0' )-1  ;
					s = str.charAt(2);
				}
				catch(Exception e){System.out.println("saisir quelque chose de valide");}
				bOk = tabJoueur[joueurCourant].getPlateau().placerDomino(x,y,tuileUtil,s);
				if (this.tuilePiochee.isEmpty()){bOk = true;}
			}		 


			System.out.println(x + " " +y+ " " +s );


							System.out.println(this.tuilePiochee.get(choix).toString());
							System.out.println(this.tuilePiochee.get(choix).getRoi());
		}
		this.tuilePiochee.clear();
		this.tabJoueur[0].resetRoi();
		this.tabJoueur[1].resetRoi();


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
			if (pioche.estVide()){return false;}
			this.tuilePiochee.add(pioche.piocher());
			System.out.println(this.tuilePiochee.get(nbTuile).toString());

		}
		return true;
	}

	public static void main (String[]a)
	{
		Jeu j = new Jeu();
		j.jouer();
		System.out.println("mon sac est fait");


	}
}