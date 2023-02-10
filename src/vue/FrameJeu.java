package vue;


/*
 * Panel de jeu
 */

import modele.PlateauPuzzle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

import controleur.Controleur;
import controleur.PieceModeleEcoutable;
import controleur.PlateauModeleEcoutable;


public class FrameJeu extends JFrame implements ActionListener, KeyListener{

    
	private static final long serialVersionUID = 1L;
	final JButton droite; 
    final JButton gauche;
    final JButton score;
    final JPanel panelButton;
    final JButton quitter;
    final Panel panel;
    final JPanel panel2;
    final JPanel pr;
    final JPanel panel_score;
    final JPanel panjeu,panvide;
    
    final JPanel panel3;
    final JLabel espace;

    Controleur vueJeu;

    public FrameJeu(PlateauModeleEcoutable plateau){
    
		Container contp=this.getContentPane();
        contp.setLayout(new BorderLayout());
        panjeu = new JPanel();
        add(panjeu,BorderLayout.WEST);  

        panvide= new JPanel();
        panjeu.add(panvide);
        espace= new JLabel("        "+ "");
        panvide.add(espace);
        vueJeu = new Controleur(plateau);
        panjeu.add(vueJeu);
        panel = new Panel();
        add(panel);

        panelButton= new JPanel();
        contp.add(panelButton,BorderLayout.SOUTH);
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3,1));

        panelButton.add(panel2);
        pr=new JPanel();// Panel pour les buttons de rotation
        panel2.add(pr);
        pr.setLayout(new GridLayout(1,2));
        
        //  creation des boutons de rotation
        gauche=new JButton("Tourne Gauche\t\t");
        gauche.setFont(new Font("time new roman",Font.BOLD,20));
        gauche.setPreferredSize(new Dimension(250,55));// taille du bouton
        gauche.setBackground(Color.LIGHT_GRAY);// couleur du bouton
        pr.add(gauche);// ajouter le bouton gauche au panel ph

        droite = new JButton("Tourne Droite");
        droite.setFont(new Font("time new roman",Font.BOLD,20));
        droite.setPreferredSize(new Dimension(250,55));
        droite.setBackground(Color.LIGHT_GRAY);
        pr.add(droite);

        panel_score= new JPanel();
        panel2.add(panel_score);
        score = new JButton("Score");
        score.setPreferredSize(new Dimension(170,55));
        score.setFont(new Font("time new roman",Font.BOLD,20));

        
        score.setBackground(Color.LIGHT_GRAY);
        panel_score.add(score, BorderLayout.CENTER);
        score.setFont(new Font("time new roman",Font.BOLD,20));
        
        panel3=new JPanel();
        panel2.add(panel3);
        quitter= new JButton("QUITTER");
        quitter.setPreferredSize(new Dimension(170,55));
        quitter.setBackground(Color.LIGHT_GRAY);
        quitter.setFont(new Font("time new roman",Font.BOLD,20));

        panel3.add(quitter);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.pack();
        this.setVisible(true);

        this.setSize(680,800);
        this.setTitle("Jeu TETRIS");
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        // Ecouter des actions des boutons
        score.addActionListener(this);
        droite.addActionListener(this);
        gauche.addActionListener(this);
        quitter.addActionListener((event)-> System.exit(0));
        panel.setVisible(true);
        espace.setVisible(false);
        vueJeu.setVisible(false);

        panel.getJouer().addActionListener(this);
        panel.getInfr().addActionListener(this);
        panelButton.setVisible(false);
        addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        PieceModeleEcoutable pme = vueJeu.getPieceClicked();

        if(e.getSource()==panel.getJouer()){
            panel.setVisible(false);
            panelButton.setVisible(true);
            vueJeu.setVisible(true);
            espace.setVisible(true);

           this.getContentPane().add(vueJeu);
        }

        //Button d'information de l'application
        if(e.getSource()==panel.getInfr()){
            JOptionPane.showMessageDialog(null, "Realiser par :\n-HAMZA ABOUHAMMADI 22009791\n-YAHYA HASNAOUI 21912359"
            		+ "\n-HANAN ALLALOU 218111572\n-CHAIMAA SADIK 22012270","Information",JOptionPane.PLAIN_MESSAGE);
        }

        if(e.getSource() == score){
           PlateauPuzzle plateau = vueJeu.getPlateauDeJeu();
           int value = plateau.score();
           JOptionPane.showMessageDialog(null, "Score : "+ value);
        }
        
        // Si direction 0 sa sera une rotation gauche
        if(e.getSource()== gauche && pme!=null){
              pme.rotationPlateau(0);
        }

        // Si direction 1 sa sera une rotaiton dorite
        if(e.getSource()==droite && pme!=null){
              pme.rotationPlateau(1);
        }
        this.requestFocusInWindow();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyPressed(KeyEvent e) {

        PieceModeleEcoutable pme = vueJeu.getPieceClicked();
        
        if(e.getKeyCode()==KeyEvent.VK_UP ){
                pme.DeplacementPlateau(1);
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
             try {
            	 pme.DeplacementPlateau(2);	
			} catch (Exception e2) {
				// TODO: handle exception
			}
        }
        
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            try {

            	pme.DeplacementPlateau(3);
			} catch (Exception e2) {
				// TODO: handle exception
			}    
        }

        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            try {
            	pme.DeplacementPlateau(4);
			} catch (Exception e2) {
				// TODO: handle exception
			}
        }               
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
