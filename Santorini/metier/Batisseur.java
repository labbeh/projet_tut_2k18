package Santorini.metier;

public class Batisseur {
    
    /*-------------------*/
    /*     CONSTANTES    */
    /*-------------------*/
    
    private final static int TAILLE_GRILLE = 5;
    
    /*-------------------*/
    /*     ATTRIBUTS     */
    /*-------------------*/
    
    static String[][] grilleBat = new String[TAILLE_GRILLE][TAILLE_GRILLE];
    private Plateau plateau;
    private String id;
    private int posLigne  ;
    private int posColonne;
    boolean depla = false;
    
    /*-------------------*/
    /*   CONSTRUCTEUR    */
    /*-------------------*/
    
    public Batisseur(String id ,Plateau plateau)
    {
        this.plateau = plateau;
        this.id = id;
    }
    
    /*-------------------*/
    /*     METHODES      */
    /*-------------------*/
    
    public boolean deplacement(String direction)
    {
        boolean reussite = false;
        int tmpLigne     = this.posLigne;
        int tmpColonne   = this.posColonne;
        
        switch (direction)
        {
            case "N"  : tmpLigne   --; 
                break;
            case "NE" : tmpLigne   --;
                        tmpColonne ++;
                break;
            case "NO" : tmpLigne   --;
                        tmpColonne --;
                break;
            case "E"  : tmpColonne ++;
                break;
            case "O"  : tmpColonne --;
                break;
            case "S"  : tmpLigne   ++;
                break;
            case "SE" : tmpLigne   ++;
                        tmpColonne ++;
                break;
            case "SO" : tmpLigne   ++;
                        tmpColonne --;
                break;
        }
        
        boolean montee = false;
        
        if(tmpLigne >= 0 && tmpLigne <= 4 && tmpColonne >= 0 && tmpColonne <= 4)
        {
            if(plateau.getHauteur(tmpLigne, tmpColonne) - plateau.getHauteur(this.posLigne, this.posColonne) ==  1 && 
               plateau.getHauteur(tmpLigne, tmpColonne) != 4 || 
               plateau.getHauteur(tmpLigne, tmpColonne) - plateau.getHauteur(this.posLigne, this.posColonne) ==  0    ){}
            else if(plateau.getHauteur(tmpLigne, tmpColonne) < plateau.getHauteur(this.posLigne, this.posColonne)){}
            else
            {
                tmpLigne = -1;
                tmpColonne = -1;
            }
        }
        this.depla = true;
        
        return setPos(tmpLigne, tmpColonne);
    }
    
    
    public boolean setPos(int tmpLigne, int tmpColonne)
    {
        boolean reussite    = false;
        boolean bati        = false;
        boolean hauteur     = false;
        
        if(tmpLigne >= 0 && tmpLigne <= 4 && tmpColonne >= 0 && tmpColonne <= 4)
        {
            if(Batisseur.grilleBat[tmpLigne][tmpColonne] == null)                                                   {bati = true;}
            if(plateau.getHauteur(tmpLigne, tmpColonne) >= 0 && plateau.getHauteur(tmpLigne, tmpColonne) <= 3)      {hauteur = true;}
        }
        
        if( bati && hauteur)
        {
            reussite = true;
            
            if(depla)
            {
                Batisseur.grilleBat[this.posLigne][this.posColonne] = null;
                this.depla = false;
            }
            
            this.posLigne   = tmpLigne  ;
            this.posColonne = tmpColonne;
            
            Batisseur.grilleBat[this.posLigne][this.posColonne] = this.id;
        }
        
        return reussite;
    }
   
    /*-------------------*/
    /*    ACCESSEURS     */
    /*-------------------*/
    
    public int getLigne  () {return this.posLigne;                         }
    public int getColonne() {return this.posColonne;                       }
    public int getPos    () {return (this.posLigne * 10) + this.posColonne;}
    
}

