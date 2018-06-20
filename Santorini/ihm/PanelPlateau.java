/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Santorini.ihm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import Santorini.Controleur;

/**
 *
 * @author labbeh
 */
public class PanelPlateau extends JPanel
{
    private Controleur ctrl;
    private static final int NB_CASES = 5;
    
    private BouttonCase[][] cases;
    
    public PanelPlateau(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.setLayout(new GridLayout(PanelPlateau.NB_CASES,PanelPlateau.NB_CASES));
        
        this.cases = new BouttonCase[PanelPlateau.NB_CASES][PanelPlateau.NB_CASES];
        
        for(int cptLig=0; cptLig<this.cases.length; cptLig++)
            for(int cptCol=0; cptCol<this.cases.length; cptCol++)
            {
                this.cases[cptLig][cptCol] = new BouttonCase(cptLig,cptCol);
                this.add(this.cases[cptLig][cptCol]);
            }
    }
    public JButton getBouton(int posLig, int posCol){return this.cases[posLig][posCol];}
    public void setImage(String url, int posLig, int posCol)
    {
        this.cases[posLig][posCol].setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource(url))));
    }
    public void actionPerformed(ActionEvent evt)
    {
        BouttonCase btn = (BouttonCase)evt.getSource();
        ctrl.setColBoutton(btn.getPosCol());
        ctrl.setLigBoutton(btn.getPosLig());
    }
}
