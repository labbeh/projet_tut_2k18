package projet_tut_2018.kingdomino.metier;

public class Roi
{
	private static int cpt = 0;

	private Joueur joueur;
	private int numeroRoi;

	public Roi(Joueur joueur)
	{
		
		this.numeroRoi 	= Roi.cpt % 2;
		this.joueur 	= joueur;
		Roi.cpt ++;
	}

	public Joueur getJoueur() { return this.joueur; }
	public int getNumeroRoi() { return this.numeroRoi; }
}