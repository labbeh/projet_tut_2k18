/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_tut_2018.kingdomino.ihm;

import java.io.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
/**
 *
 * @author labbeh
 */
public class ImageTuile
{   
    private String nom;
    
    private int posX;
    private int posY;
    
    public ImageTuile(String nom)
    {
        this.nom  = nom ;
        this.posX = 0   ;
        this.posY = 0   ;
    }
    
    public BufferedImage getImage()
    {
        BufferedImage bffImgRet;
        try
        {
            bffImgRet = ImageIO.read(new File("imgs/" +this.nom));
        }
        catch(IOException e)
        {
            bffImgRet = null;
            e.printStackTrace();
        }
        return bffImgRet;
    }
    
    // MODIFICATEURS
    public void setPosX(int x){ this.posX = x; }
    public void setPosY(int y){ this.posY = y; }
    
    //ACCESSEURS
    public int getPosX(){ return this.posX; }
    public int getPosY(){ return this.posY; }
}
