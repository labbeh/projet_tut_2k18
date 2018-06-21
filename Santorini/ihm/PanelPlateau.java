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
import Santorini.metier.Batisseur;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class PanelPlateau extends JPanel implements ActionListener
{
    private int phase = - 4;
    private int batisseur = 0;
    private Controleur ctrl;
    private static final int NB_CASES = 5;
    private BoutonCase[][] cases;
    private IHMGui fenetre;
    private Batisseur batActuel;
    private static BoutonCase btnMemoire;
    
    /**
     * Permet de créer le plateau de boutons 
     * @param ctrl 
     * @param IHMGui pour avoir acces
     */
    public PanelPlateau(Controleur ctrl, IHMGui fenetre)
    {
        this.ctrl = ctrl;
        this.setLayout(new GridLayout(PanelPlateau.NB_CASES,PanelPlateau.NB_CASES));
        
        this.cases = new BoutonCase[PanelPlateau.NB_CASES][PanelPlateau.NB_CASES];
        
        for(int cptLig=0; cptLig<this.cases.length; cptLig++)
            for(int cptCol=0; cptCol<this.cases.length; cptCol++)
            {
                String image = "image/fond_" + (int)((Math.random() * (3-0)) + 1) + ".png";
                System.out.println(image);
                this.cases[cptLig][cptCol] = new BoutonCase(cptLig,cptCol,image);
                this.cases[cptLig][cptCol].setPreferredSize(new Dimension(20,20));
                
                this.add(cases[cptLig][cptCol]);
                testSouris(this.cases[cptLig][cptCol]);
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
        this.cases[posLig][posCol].setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("image/" + url))));
    }
    
    /**
     * 
     * @param evt 
     */
    public void actionPerformed(ActionEvent evt)
    {
        BoutonCase btn = (BoutonCase)evt.getSource();
        boolean constru = false;
        String depla = null;
        if(this.phase % 3 > 0) depla = ctrl.getDeplacement(btn.getPosLig(), btn.getPosCol(), this.batActuel);
        
        if(this.phase % 3 == 2)
        {
            if(ctrl.construction(btn.getPosLig(), btn.getPosCol(), this.batActuel, depla))
            {
                this.phase++;
                constru = true;
                btn.etageSupp();
            }
        }
        if(this.phase % 3 == 1)
        {
            if(ctrl.deplacement(btn.getPosLig(), btn.getPosCol(), this.batActuel, depla))
            {
                this.phase++;
                PanelPlateau.btnMemoire.setText(null);
                btn.setText(this.batActuel.getId());
            }
        }
        if (this.phase % 3 == 0 && this.phase >= 0 && !constru)
        {
            this.batActuel = ctrl.ChoixBat(btn.getPosLig(), btn.getPosCol());
            if(this.batActuel != null)
            {
                this.phase++;
                PanelPlateau.btnMemoire = btn;
            }
        }
        if(this.phase < 0)
        {
            Batisseur bati = ctrl.initBatisseur(this.batisseur, btn.getPosLig(), btn.getPosCol());
            
            if(bati != null)
            {
                this.phase++;
                this.batisseur++;
                btn.setText(bati.getId());
            }
            int joueur = this.batisseur - 1;
            if(joueur == 2 ) joueur --;
            if(this.phase <= -1)System.out.println( "\n" + ctrl.getJoueur(joueur) + " ou voulez-vous placer votre batisseur n°" + (this.batisseur % 2 + 1) + " ?");
        }
        if(ctrl.aGagne() != null)
        {
            FrameVictoire plateau = new FrameVictoire(ctrl.aGagne().getNom());
            fenetre.dispose();
        }
    }

    
    public void testSouris(BoutonCase bouton){
        bouton.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e){}

            
            public void mousePressed(MouseEvent e){}

            
            public void mouseReleased(MouseEvent e){}

            
            public void mouseEntered(MouseEvent e){
                
                bouton.setBorder(BorderFactory.createLineBorder(Color.RED));
                bouton.setBorderPainted(true);
            }

            
            public void mouseExited(MouseEvent e)
            {
                 bouton.setBorderPainted(false);
            }

        });
    }
}
