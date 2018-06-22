/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package projet_tut_2018;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
/**
 *
 * @author labbeh
 */
public abstract class Fenetre extends JFrame
{
    public Fenetre(String title)
    {
        this.setTitle(title);
        this.setLocation(100,100     );
        this.setSize    (820,700     );
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
            
        if(System.getProperty("os.name").equals("Mac OS X"))
        {
            try
            {
                UIManager.setLookAndFeel(new MetalLookAndFeel());
            }
             catch(UnsupportedLookAndFeelException e){ e.printStackTrace(); }
        }
    }
}
