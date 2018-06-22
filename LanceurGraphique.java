/**
 * @author Lechanoine,Levallois,Beaumont,Lebosse,Labbe,Dupont
 * @date 20/06/2018
 * @version 1.0
 */

//package projet_tut_2018;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class LanceurGraphique extends JFrame implements ActionListener, ListSelectionListener
{
    private static final String[] TYPE_JEU = new String[]{"Kingdomino", "Santorini"};
    
    private JLabel labImage ;
    private JLabel msgErreur;
    
    private JList<String> choixJeu;
    
    private JTextField tfJ1;
    private JTextField tfJ2;
    
    private JPanel panelBouton ;
    private JPanel  panelBtn;
    //private JPanel  panelNom;
    
    private JButton btnValider;
    private JButton btnRegle;
    
    /**
     * Fenêtre de lancement qui permet à l'utilisateur de choisir le jeu ainsi que de saisir le nom des deux joueurs
     */
    public LanceurGraphique()
    {
        this.setTitle("Sélection du jeu" );
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.setSize(630, 520);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.choixJeu = new JList<>(LanceurGraphique.TYPE_JEU);
        this.choixJeu.setSelectedIndex(0);
        
        this.panelBtn   = new JPanel (         );
        
        this.btnValider = new JButton("Commencer le Jeu");
        this.btnRegle = new JButton("Regle du jeu");
        
        this.labImage  = new JLabel    ();
        this.msgErreur = new JLabel    ();
        this.tfJ1      = new JTextField();
        this.tfJ2      = new JTextField();
        
        // panel contenant la saisie des noms de joueurs ainsi que le bouton valider
        this.panelBtn.setLayout(new BorderLayout());
        
        JPanel panelTf = new JPanel(new GridLayout(3,4));
        this.panelBouton = new JPanel();
        panelTf.add(new JLabel("Joueur 1: "));
        panelTf.add(this.tfJ1);
        
        panelTf.add(new JLabel("Joueur 2: "));
        panelTf.add(this.tfJ2);
        
        panelTf.add(this.msgErreur);
        
        this.panelBouton.add(btnValider);
        this.panelBouton.add(btnRegle);
        this.panelBtn.add(panelTf, BorderLayout.CENTER);
        this.panelBtn.add(panelBouton, BorderLayout.SOUTH);
        
        
        this.add(this.panelBtn, BorderLayout.SOUTH);
        
        // ajout des écouteurs
        this.btnValider.addActionListener(this);
        this.btnRegle.addActionListener(this);
        this.choixJeu.addListSelectionListener(this);
        
        // ajout des éléments à la fenêtre
        this.add(this.choixJeu, BorderLayout.NORTH);
        this.add(this.labImage, BorderLayout.CENTER);
        
        this.setImage("kingLogo.jpg");
        this.setVisible(true);
    }
    
    /**
     * Permet l'affichage d'image suivant le jeu sélectionné 
     * @param urlImage location de l'image
     */
    private void setImage(String urlImage)
    {
        ImageIcon image = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource(urlImage)));
        this.labImage.setIcon(image);
    }
    
    public static void main(String[] args)
    {
        LanceurGraphique lg = new LanceurGraphique();
    }

    /**
     * Permet de récupérer le nom des deux joueurs 
     * @param evt Evénement du actionListener
     */
    @Override
    public void actionPerformed(ActionEvent evt)
    {
        String lien = "";
        if(this.choixJeu.getSelectedValue().equals(LanceurGraphique.TYPE_JEU[0]))
            lien = "https://lc.cx/mBF3";
        else
            lien = "https://lc.cx/mXYt";
        if (evt.getSource()== this.btnRegle)
        {
            if(Desktop.isDesktopSupported())
            {
                    if(Desktop.getDesktop().isSupported(Desktop.Action.BROWSE))
                    {
                            URI uri;
                            try {
                                    uri = new URI(lien);
                                    Desktop.getDesktop().browse(uri);
                            } catch (URISyntaxException arg0) {
                                    arg0.printStackTrace();
                            } catch (IOException arg0) {
                                    arg0.printStackTrace();
                            }
                    }
            }  
        }
        else
        {
            if(this.tfJ1.getText().equals("") || this.tfJ2.getText().equals(""))
            {
                this.msgErreur.setForeground(Color.RED);
                this.msgErreur.setText("ERREUR: veuillez saisir les noms des deux joueurs");
            }
            else
            {
                this.msgErreur.setText("");
                this.setVisible(false);
                if(this.choixJeu.getSelectedValue().equals(LanceurGraphique.TYPE_JEU[0]))
                    new     kingdomino.Controleur(this.tfJ1.getText(), this.tfJ2.getText());
                else
                    new Santorini.Controleur(this.tfJ1.getText(), this.tfJ2.getText());

            }
        }
        
    }

    /**
     * Permet de savoir le jeu sélectionné par l'utilisateur 
     * @param evt Evénement du actionListenerEvénement
     */
    @Override
    public void valueChanged(ListSelectionEvent evt)
    {
        if(this.choixJeu.getSelectedValue().equals(LanceurGraphique.TYPE_JEU[0]))
            this.setImage("kingLogo.jpg");
        else
            this.setImage("santoLogo.jpg");
    }
}