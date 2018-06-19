/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_tut_2018.kingdomino.ihm;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;

/**
 *
 * @author labbeh
 */
public class IHMGui extends JFrame
{
    private PanelPlateau plateau  ;
    private PanelJoueur  pltJoueur1;
    private PanelJoueur  pltJoueur2;
    
    private JPanel panelCentre;
    
    public IHMGui()
    {
        
        // Obligatoire pour un affichage correct des JButtons sous Mac os X
        if(System.getProperty("os.name").equals("Mac OS X"))
        {
            try
            {
                UIManager.setLookAndFeel(new MetalLookAndFeel());
            }
            catch(UnsupportedLookAndFeelException e){ e.printStackTrace(); }
        }
        
        this.setTitle("Kingdomino");
        this.setSize(800,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        this.plateau     = new PanelPlateau();
        this.pltJoueur1  = new PanelJoueur ();
        this.pltJoueur2  = new PanelJoueur ();
        this.panelCentre = new JPanel(new FlowLayout());
        
        // ajout des elts à la frame
        this.add(new JPanel().add(new JButton("ok")), BorderLayout.NORTH);
        
        this.panelCentre.add(this.pltJoueur1, FlowLayout.LEFT  );
        this.panelCentre.add(this.plateau   , FlowLayout.CENTER);
        this.panelCentre.add(this.pltJoueur2, FlowLayout.RIGHT );
        
        this.add(this.panelCentre);
        
        this.setVisible(true);
    }
    
    public static void main(String[] args)
    {
        IHMGui ihm = new IHMGui();
    }
}
