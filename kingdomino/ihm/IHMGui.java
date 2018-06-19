/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_tut_2018.kingdomino.ihm;
import javax.swing.*;

/**
 *
 * @author labbeh
 */
public class IHMGui extends JFrame
{
    public IHMGui()
    {
        this.setTitle("Kingdomino");
        this.setSize(800,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setVisible(true);
    }
    
    public static void main(String[] args)
    {
        IHMGui ihm = new IHMGui();
    }
}
