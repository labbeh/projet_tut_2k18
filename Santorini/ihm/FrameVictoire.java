package Santorini.ihm;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrameVictoire extends JFrame implements ActionListener
{
	
	private JLabel labImage ;
        private JLabel labelVictoire;
	private JPanel panelVictoire;
	private JButton btnValider;
	
	public FrameVictoire(String joueur)
	{
		this.setLocation(770,370);
                this.panelVictoire = new JPanel();
		this.labelVictoire = new JLabel (joueur + " a gagné, bravo !");
                this.labImage  = new JLabel    ();
		this.btnValider = new JButton("ok");
                this.btnValider.addActionListener(this);
		this.panelVictoire.add(labelVictoire);
		
		this.add(this.panelVictoire, BorderLayout.NORTH);
                this.setImage("image/Bravo.gif");
                this.add(this.labImage);
		this.add(this.btnValider, BorderLayout.SOUTH);
		
		this.setVisible(true);
		this.pack();
	}
	private void setImage(String urlImage)
        {
            ImageIcon image = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource(urlImage)));
            this.labImage.setIcon(image);
        }
	@Override
	public void actionPerformed(ActionEvent evt)
	{
		this.dispose();
	}
        public static void main (String[] arg)
        {
            FrameVictoire plateau = new FrameVictoire("test");
        }  
}