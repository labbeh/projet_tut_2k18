/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_tut_2018;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author labbeh
 */
public class LanceurGraphique extends JFrame implements ActionListener, ItemListener
{
    private static final String[] TYPE_JEU = new String[]{"Kingdomino", "Santorini"};
    
    private JLabel labImage;
    
    private JComboBox choixJeu;
    
    private JPanel  panelBtn  ;
    private JButton btnValider;
    
    public LanceurGraphique()
    {
        this.setTitle("Sélection du jeu" );
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.choixJeu = new JComboBox(LanceurGraphique.TYPE_JEU);
        
        this.panelBtn   = new JPanel (         );
        this.btnValider = new JButton("Valider");
        this.labImage   = new JLabel (         );
        
        // ajout du bouton à son panel
        this.panelBtn.add(this.btnValider);
        
        // ajout des écouteurs
        this.btnValider.addActionListener(this);
        this.choixJeu.addActionListener(this);
        
        // ajout des éléments à la fenêtre
        this.add(this.choixJeu, BorderLayout.NORTH);
        this.add(this.labImage, BorderLayout.CENTER);
        this.add(this.panelBtn, BorderLayout.SOUTH);
        
        this.setImage("./kingLogo.jpg");
        this.pack();
        this.setVisible(true);
    }
    
    private void setImage(String urlImage)
    {
        ImageIcon image = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource(urlImage)));
        this.labImage.setIcon(image);
    }
    
    public static void main(String[] args)
    {
        LanceurGraphique lg = new LanceurGraphique();
    }

    @Override
    public void actionPerformed(ActionEvent evt)
    {
        if(this.choixJeu.getSelectedItem().equals(LanceurGraphique.TYPE_JEU[0]))
            this.setImage("kingLogo.jpg");
        else
            this.setImage("santoLogo.jpg");
    }

    @Override
    public void itemStateChanged(ItemEvent evt)
    {
        
    }
}
