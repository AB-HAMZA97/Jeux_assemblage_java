package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 *		Panel Principale first page
 */

public class Panel extends JPanel {
    
	private static final long serialVersionUID = 1L;
	final JButton jouer;
    final JButton infr;

    final JPanel panel;
    final JPanel panel_image;
    final JPanel panel_button;
    final JLabel image;

    public Panel(){
    
    	
        panel= new JPanel();
        add(panel);
        
        panel.setLayout(new GridLayout(3,1));
                
        panel_image= new JPanel();
        panel.add(panel_image);
       
        image= new JLabel(new ImageIcon("piecesPuzzle/capture.jpeg"));//Image de notre application
        panel_image.add(image);
        
        
        panel_button= new JPanel();
        panel.add(panel_button);
        
        //Button pour acceder a l'application
        jouer = new JButton("Jouer");
        jouer.setBackground(Color.LIGHT_GRAY);
        jouer.setPreferredSize(new Dimension(225,32));
        jouer.setFont(new Font("time new roman",Font.BOLD,22));

        panel_button.add(jouer);
        
        //Button d'information qui contient notre nom avec numero etudiant
        infr = new JButton("Information");
        infr.setBackground(Color.LIGHT_GRAY);
        infr.setPreferredSize(new Dimension(225,32));
        infr.setFont(new Font("time new roman",Font.BOLD,22));

        panel_button.add(infr);
    
       
                
    }		
    
    public JButton getJouer(){
    	return jouer;
    }


    public JButton getInfr(){
    	return infr;
    }
}
