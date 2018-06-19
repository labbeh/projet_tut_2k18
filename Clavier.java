package utilitaires;

import java.util.Scanner;

/**
 * Décrivez votre classe Clavier ici.
 *
 * @author labbeh
 * @version 1.2
 */
public class Clavier
{
    private static Scanner sc = new Scanner(System.in);
    
    public static String lireString()
    {
        return sc.nextLine();
    }
    
    public static boolean lireboolean()
    {
        boolean bRet = false;
        boolean bOk  = false;
        
        String saisie;
        
        while(!bOk)
        {
            saisie = lireString().toLowerCase();
            switch(saisie)
            {
                case "true" : bRet = true ; bOk = true; break;
                case "false": bRet = false; bOk = true; break;
                
                default     : System.out.println("Erreur de saisie: choix possibles [true/false]");
            }
        }
        
        return bRet;
    }
    
    public static char lirechar()
    {
        char    cRet   = ' '  ;
        boolean bOk    = false;
        
        String saisie;
        
        while(!bOk)
        {
            saisie = lireString();
            if(saisie.length() > 0)
            {
                cRet = saisie.charAt(0);
                bOk = true;
            }
            else
            {
                System.out.println("Erreur: veuillez saisir un caractère");
            }
        }
        return cRet;
    }
    
    public static int lireint()
    {
        int     iRet = 0    ;
        boolean bOk  = false;
        
        while(!bOk)
        {
            try{
                iRet = Integer.parseInt(lireString());
                bOk = true;
            }
            catch(NumberFormatException evt){
                System.out.println("Erreur: saisir un nombre entier");
            }
        }
        return iRet;
    }
    
    public static double liredouble()
    {
        double  dRet = 0    ;
        boolean bOk  = false;
        
        while(!bOk)
        {
            try{
                dRet = Double.parseDouble(lireString());
                bOk = true;
            }
            catch(NumberFormatException evt){
                System.out.println("Erreur: saisir un double");
            }
        }
        return dRet;
    }
    
    public static double lirefloat()
    {
        double  fRet = 0    ;
        boolean bOk  = false;
        
        while(!bOk)
        {
            try{
                fRet = Float.parseFloat(lireString());
                bOk = true;
            }
            catch(NumberFormatException evt){
                System.out.println("Erreur: saisir un float");
            }
        }
        return fRet;
    }
    
    public static short lireshort()
    {
        short   shRet = 0    ;
        boolean bOk   = false;
        
        while(!bOk)
        {
            try{
                shRet = Short.parseShort(lireString());
                bOk = true;
            }
            catch(NumberFormatException evt){
                System.out.println("Erreur: saisir un short");
            }
        }
        return shRet;
    }
    
    public static long lirelong()
    {
        long    lRet = 0    ;
        boolean bOk  = false;
        
        while(!bOk)
        {
            try{
                lRet = Long.parseLong(lireString());
                bOk = true;
            }
            catch(NumberFormatException evt){
                System.out.println("Erreur: saisir un long");
            }
        }
        return lRet;
    }
    
    public static byte lirebyte()
    {
        byte    byRet = 0    ;
        boolean bOk   = false;
        
        while(!bOk)
        {
            try{
                byRet = Byte.parseByte(lireString());
                bOk   = true;
            }
            catch(NumberFormatException evt){
                System.out.println("Erreur: saisir un byte");
            }
        }
        return byRet;
    }
    
    private Clavier(){}
}
