/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_tut_2018.kingdomino.ihm;

import projet_tut_2018.kingdomino.Controleur;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.metal.MetalLookAndFeel;

import projet_tut_2018.Fenetre;

/**
 *
 * @author labbeh
 */
public class IHMGuiV2 extends Fenetre implements ActionListener
{
    private Controleur ctrl;
    // ------- PANEL NORD //
    private JPanel panelTour;
    private JLabel lblTour;
	
    String couleur = "rouge"; // TEST
    // --------------------------//
	
    // ------- PANEL OUEST //
    private JPanel panelPioche;
    //private JLabel lblPioche;
    private JButton[] ensPioche;
    // ------------------------ // 
	
    // ------- PANEL SUD //
    private JPanel panelPosition;
	
    private JLabel lblPos;
    private JLabel lblPosX;
    private JLabel lblPosY;
	
    private JTextField txtPosX;
    private JTextField txtPosY;
	
    private JButton btnValider;
    // ------------------------ //
	
    // ------- PANEL CENTRE //
    private JPanel panelJoueur;
    //private JPanel joueur1;
    //private JPanel joueur2;
    private Visu visuJ1;
    private Visu visuJ2;
	
    private JLabel lblJ1;
    private JLabel lblJ2;
    
    String nomJ1;
    String nomJ2;
    //private Graphics g;
    // ----------------------------- // 
	
    private Font font24 = new Font("Arial", Font.PLAIN, 24);
    private Font font18 = new Font("Arial", Font.PLAIN,18);
	
	
    public IHMGuiV2( Controleur ctrl )
    {
        super("KINGDOMINO");
        this.ctrl = ctrl;
        this.nomJ1 = ctrl.getNomJoueur(0);
        this.nomJ2 = ctrl.getNomJoueur(1);
        
        /*this.setTitle   ("KINGDOMINO");
        this.setLocation(100,100     );
        this.setSize    (820,700     );
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
        if(System.getProperty("os.name").equals("Mac OS X"))
        {
            try
            {
                UIManager.setLookAndFeel(new MetalLookAndFeel());
            }
             catch(UnsupportedLookAndFeelException e){ e.printStackTrace(); }
        }*/
		
        // ** Création du panel nord ** //
        this.panelTour = new JPanel();
		
        this.lblTour = new JLabel ("C'est au tour du Joueur " + this.couleur + " " + this.ctrl.getNomJoueurCourant()); //getCouleur() du joueur
        //Condition pour mettre de la couleur en fonction du joueur
        if(couleur.equals("bleu")) this.lblTour.setForeground(new Color(0,0,255));
        else                  this.lblTour.setForeground(new Color(255,0,0));
                
        this.lblTour.setFont(this.font24); //changement de police et taille
        this.panelTour.add(this.lblTour);
		
        this.add(panelTour, BorderLayout.NORTH);
		
        // ** Création du panel sud ** //
        this.panelPosition = new JPanel();
		
        this.lblPos = new JLabel("Choisissez votre position puis cliquez sur le bouton valider: ",JLabel.LEFT);
        this.lblPos.setFont(this.font18);
        this.panelPosition.add(this.lblPos);
		
        this.lblPosX = new JLabel(" X : "  );
        this.panelPosition.add(this.lblPosX);
        this.txtPosX = new JTextField("0",3);
        this.panelPosition.add(this.txtPosX);
		
        this.lblPosY = new JLabel(" Y : ");
        this.panelPosition.add(this.lblPosY);
        this.txtPosY = new JTextField("0",3);
        this.panelPosition.add(this.txtPosY);
		
        this.btnValider = new JButton("Valider");
        this.btnValider.addActionListener(this);
        
        this.panelPosition.add(this.btnValider);
		
        this.add(panelPosition, BorderLayout.SOUTH);
	
        // ** Création du panel Est ** //
        this.panelPioche = new JPanel(new GridLayout(4,1));
		
        this. ensPioche= new JButton[4];
        for(int cpt=0; cpt<this.ensPioche.length; cpt++)
        {
            this.ensPioche[cpt] = new JButton (new ImageIcon( "imgs/" +this.ctrl.getNomImage(cpt)+ ".gif"));//getImage().piocher()
            this.ensPioche[cpt].setPreferredSize(new Dimension(290,145));
            this.panelPioche.add(this.ensPioche[cpt]);
            this.ensPioche[cpt].addActionListener(this);
            //System.out.println("imgs/" +this.ctrl.getNomImage(cpt)+ ".gif");
        }
		
        this.add(this.panelPioche, BorderLayout.EAST);
		
        // ** Création des plateaux ** //
        this.panelJoueur = new JPanel(new GridLayout(2,2));
		
        this.lblJ1 = new JLabel("Joueur Rouge 1 : " + this.nomJ1, JLabel.CENTER); //getNom()
        this.lblJ1.setForeground(new Color(255,0,0));
        this.lblJ1.setFont(this.font18);
        this.panelJoueur.add(this.lblJ1);
        
        visuJ1 = new Visu();
        this.panelJoueur.add(this.visuJ1);
		
        this.lblJ2 = new JLabel("Joueur Bleu 2 : " + this.nomJ2, JLabel.CENTER); //getNom()
        this.lblJ2.setForeground(new Color(0,0,255));
        this.lblJ2.setFont(this.font18);
        this.panelJoueur.add(this.lblJ2);
        
        visuJ2 = new Visu();
        this.panelJoueur.add(this.visuJ2);
		
        this.add(this.panelJoueur);
		
        //this.setResizable(false);
        this.setVisible  (true );
    }
    
    public void poserTuile(String url, int x, int y)
    {
        if(this.ctrl.getNumJoueurCourant() == 1) this.visuJ1.poserTuile(url, x, y);
        else                                     this.visuJ2.poserTuile(url, x, y);
    }
    
    public void refresh()
    {
        //this.panelTour = new JPanel();
        this.couleur = this.ctrl.getCouleurJoueurCourant();
        this.lblTour.setText("C'est au tour du Joueur " + this.couleur + " " + this.ctrl.getNomJoueurCourant());
        
        //Condition pour mettre de la couleur en fonction du joueur
        if(couleur.equals("bleu")) this.lblTour.setForeground(new Color(0,0,255));
        else                  this.lblTour.setForeground(new Color(255,0,0));
                
        
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String x;
        String y;
        
        x = this.txtPosX.getText();
        y = this.txtPosY.getText();
        
        System.out.println("(" +x+ ";" +y+")");
        
        if(e.getSource() == this.btnValider)
        {
            this.ctrl.poserTuile();
            return;
        }
        
        for(int cpt=0; cpt<this.ensPioche.length; cpt++)
            if(this.ensPioche[cpt] == e.getSource())
                this.ensPioche[cpt].setEnabled(false);
    }
    
    //public void setNom    (String nom    ){this.nom     = nom    ;}
    public void setCouleur(String couleur){this.couleur = couleur;}
    
    public int getPosX()
    {
        try
        {
            return Integer.parseInt(this.txtPosX.getText());
        }
        catch(NumberFormatException evt){return -1;}
    }
    
    public int getPosY()
    {
        try
        {
            return Integer.parseInt(this.txtPosY.getText());
        }
        catch(NumberFormatException evt){return -1;}
    }
}













