/**
 * @author Lechanoine,Levallois,Beaumont,Lebosse,Labbe,Dupont
 * @date 20/06/2018
 * @version 1.0
 */
package Santorini.ihm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import Santorini.Controleur;
import java.awt.event.ActionListener;


public class PanelPlateau extends JPanel implements ActionListener
{
    private int phase = - 4;
    private int batisseur = 0;
    private Controleur ctrl;
    private static final int NB_CASES = 5;
    private BoutonCase[][] cases;
    
    /**
     * Permet de créer le plateau de boutons 
     * @param ctrl 
     */
    public PanelPlateau(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.setLayout(new GridLayout(PanelPlateau.NB_CASES,PanelPlateau.NB_CASES));
        
        this.cases = new BoutonCase[PanelPlateau.NB_CASES][PanelPlateau.NB_CASES];
        
        for(int cptLig=0; cptLig<this.cases.length; cptLig++)
            for(int cptCol=0; cptCol<this.cases.length; cptCol++)
            {
                this.cases[cptLig][cptCol] = new BoutonCase(cptLig,cptCol);
                this.add(this.cases[cptLig][cptCol]);
                this.cases[cptLig][cptCol].addActionListener(this);
            }
    }
    
    /**
     * 
     * @param posLig
     * @param posCol
     * @return 
     */
    public JButton getBouton(int posLig, int posCol){return this.cases[posLig][posCol];}
    
    /**
     * 
     * @param url
     * @param posLig
     * @param posCol 
     */
    public void setImage(String url, int posLig, int posCol)
    {
        this.cases[posLig][posCol].setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource(url))));
    }
    
    /**
     * 
     * @param evt 
     */
    public void actionPerformed(ActionEvent evt)
    {
        BoutonCase btn = (BoutonCase)evt.getSource();
        
        if (this.phase < 0)
        {
            if(ctrl.initBatisseur(batisseur, btn.getPosLig(), btn.getPosCol()));
                btn.setText( "" + batisseur);
            if(this.phase < -1)System.out.println( "\nJoueur ou voulez-vous placer votre batisseur ?");
            this.phase++;
            this.batisseur++;
            
        }
        if (this.phase % 3 == 0 && this.phase >= 0)
        {
            ctrl.ChoixBat(btn.getPosLig(), btn.getPosCol());
            this.phase++;
        }
        if(this.phase % 3 == 1)
        {
            ctrl.deplacement(btn.getPosLig(), btn.getPosCol());
            this.phase++;
        }
        if(this.phase % 3 == 2)
        {
            ctrl.construction(btn.getPosLig(), btn.getPosCol());
            this.phase++;
        }
    }
}
