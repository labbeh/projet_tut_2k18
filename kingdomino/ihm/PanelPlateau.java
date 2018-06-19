/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_tut_2018.kingdomino.ihm;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.*;
/**
 *
 * @author labbeh
 */
public class PanelPlateau extends JPanel
{
    private JPanel panelCol1;
    private JPanel panelCol2;
    
    private JButton[][] tabBtns;
    
    
    public PanelPlateau()
    {
        this.setLayout(new GridLayout(1,2));
        //ImageIcon image = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource(urlImage)));
        
        this.panelCol1 = new JPanel(new GridLayout(4,1));
        this.panelCol2 = new JPanel(new GridLayout(4,1));
        
        // a terme, piochage aléatoire
        this.panelCol1.add(new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("imgs/tuile28.gif")))));
        this.panelCol1.add(new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("imgs/tuile29.gif")))));
        this.panelCol1.add(new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("imgs/tuile30.gif")))));
        this.panelCol1.add(new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("imgs/tuile31.gif")))));
        
        // ajout des elts au panel
        this.add(this.panelCol1);
        this.add(this.panelCol2);
        
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    }
}
