package projet_tut_2018.kingdomino.metier;

//import java.util.Scanner;
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

	/*public void jouer(String nomJ1, String nomJ2)
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


		this.tabJoueur[0].setNom(nomJ1);
                this.tabJoueur[1].setNom(nomJ2);

		this.arrayRoi = new ArrayList<Integer>();
		this.arrayRoi.add(0);
		this.arrayRoi.add(0);
		this.arrayRoi.add(1);
		this.arrayRoi.add(1);

		Collections.shuffle(this.arrayRoi);

		while ( ! pioche.estVide() )
		{
			this.initManche();
		}
	}*/

	public void initManche()
	{
		this.piocherCarte();
		int choix = -1;

		for (int cpt = 0; cpt < 4;cpt++) 
		{
			joueurCourant = arrayRoi.get(cpt)%2;
			int ind = cpt % 2;
			do
			{
				//Scanner in = new Scanner(System.in);
				System.out.print("placez votre roi sur une tuile : (choix 1,2,3 ou 4)" );
				System.out.println("");
				String str  = "1";

				if (str.length() == 1 && Character.isDigit(str.charAt(0)) )
					choix   = Integer.parseInt(str);
				else
				{
					System.out.print("saisissez une autre valeur : ");
					System.out.println("");
				}
				if ( choix < 0 || choix > 4 || this.tuilePiochee.get(choix - 1).getRoi() != null )
				{
					System.out.print("! saisissez une autre valeur !");
					System.out.println("");
				}
		    }
			while ( choix < 0 || choix > 4 || this.tuilePiochee.get(choix - 1).getRoi() != null );
			this.tuilePiochee.get(choix - 1).setRoi(tabJoueur[joueurCourant].getRoi(ind));
			System.out.println("blyat : " + this.tuilePiochee.get(choix -1).getRoi().getNumeroRoi() );
		}

		while(! this.tuilePiochee.isEmpty())
		{


			for (int cpt = 0; cpt < 4;cpt++) 
			{
				//joueurCourant = arrayRoi.get(cpt)%2;
				Domino tuileUtil = this.tuilePiochee.remove(0);
				System.out.println(tuileUtil.toString());
				if (tuileUtil.getRoi().getJoueur() == this.tabJoueur[0])
				{

					int x = -1;
					int y = -1;
					char s = 'b';

					do
					{
						//Scanner in = new Scanner(System.in);
						System.out.print(tabJoueur[0].getPlateau().toString());
						System.out.print(tabJoueur[0].getNom() + " Choisir x,y,sens : ");
						System.out.println(tuileUtil.toString());
						String str  = "10,4,N";



						if (str.length() == 3 && Character.isDigit(str.charAt(0)) && Character.isDigit(str.charAt(1)) && str.charAt(2) == 'N' || str.charAt(2) == 'O' || str.charAt(2) == 'S' || str.charAt(2) == 'E')
						{
							x = (int)str.charAt(0) - '0';
							y = (int)str.charAt(1) - '0';
							s = str.charAt(2);
							boolean bOk = false;

							bOk = tabJoueur[0].getPlateau().placerDomino(x,y,tuileUtil,s);
							System.out.println(bOk);
						}
					}
					while( ! tabJoueur[0].getPlateau().placerDomino(x,y,tuileUtil,s));
				}

				if (tuileUtil.getRoi().getJoueur() == this.tabJoueur[1])
				{
					int x = -1;
					int y = -1;
					char s = 'b';

					do
					{
						//Scanner in = new Scanner(System.in);
						System.out.print(tabJoueur[1].getPlateau().toString());
						System.out.println(tabJoueur[1].getNom() + " Choisir x,y,sens : ");
						System.out.println(tuileUtil.toString());
						String str  = "3,3,S";


						if (str.length() == 3 && Character.isDigit(str.charAt(0)) && Character.isDigit(str.charAt(1)) && str.charAt(2) == 'N' || str.charAt(2) == 'O' || str.charAt(2) == 'S' || str.charAt(2) == 'E')
						{
							x = (int)str.charAt(0) - '0';
							y = (int)str.charAt(1) - '0';
							s = str.charAt(2);
							boolean bOk = false;

							bOk = tabJoueur[1].getPlateau().placerDomino(x,y,tuileUtil,s);
							System.out.println(bOk);
						}
					}
					while( ! tabJoueur[1].getPlateau().placerDomino(x,y,tuileUtil,s));
							
				}
			

				System.out.println("yo");

				//}

			}


			


			//this.arrayRoi.add(cpt, choix - 1);
			//this.Joueur[joueurCourant] 
			//il faut : 
			// 1. gerer le choix des tuile ( parmi les 4 tuiles disponibles) + verif
			// 2. gerer l'enregistrement de la carte dans une ArrayList
			// 3. gerer le placement de la carte
		}
		System.out.print(tabJoueur[0].toString());
		System.out.print(tabJoueur[1].toString());
	}



/**
 *Remplis l'ArrayList de quatre Domino
 *
 *@return un booleen, vrai si les carte on été pioché, faux si l'une d'entre elle est nulle
*/

	public boolean piocherCarte()
	{
		ArrayList<Domino> ArrayTemp = new ArrayList<Domino>();
		for (int nbTuile = 0; nbTuile < 4;nbTuile++)
		{
			if (pioche.estVide()){return false;}
			this.tuilePiochee.add(pioche.piocher());
			System.out.println(this.tuilePiochee.get(nbTuile).toString());

		}
		return true;
	}
}