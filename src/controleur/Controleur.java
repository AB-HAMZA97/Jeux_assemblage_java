package controleur;

import modele.PlateauPuzzle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import modele.Position;

/**
 * La class Controleur de l'application 
 * 
 * 
 */
public class Controleur extends JPanel implements EcouteurModele, MouseListener,MouseMotionListener {

    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private final static int dimension = 20;
    
    private PlateauModeleEcoutable plateauControleur;
    
    
    private PieceModeleEcoutable pieceClicked;
    private PieceModeleEcoutable pieceMovement;
    
    
    
    public Controleur(PlateauModeleEcoutable plateauControleur){
        this.plateauControleur = plateauControleur;
        this.setSize(plateauControleur.plateau.plateauPuzzle.length*plateauControleur.plateau.plateauPuzzle.length,plateauControleur.plateau.plateauPuzzle.length*plateauControleur.plateau.plateauPuzzle.length);
        this.addMouseListener(this);
        this.plateauControleur.addEcouteur(this);
    }
    
    
    
    @Override
    public void paintComponent(Graphics g){
    	
        super.paintComponent(g);       
        int dimCase=dimension;
        
        plateauControleur.plateau.getListePiece().forEach(piece -> {
        	
        	
            int x = piece.getPiece().getPositionPiece().getX() - piece.getPiece().getMidPos().getX();
            int y = piece.getPiece().getPositionPiece().getY() - piece.getPiece().getMidPos().getY();
            
            for(int i = x; i<x+piece.getPiece().getLargeur(); i++) {
            	for(int j = y; j<y+piece.getPiece().getHauteur(); j++){
            		if(piece.getPiece().getOccupePieceGrille(i-x,j-y)){
            				//Si on clique sur une pice pour l deplace sa couleur devient LIGHT_GRAY
            				if(this.pieceClicked == piece){
                            g.setColor(Color.LIGHT_GRAY);
                            g.fillRect(j*dimCase, i*dimCase, dimCase, dimCase);
            				}
            				
            				else{
            					g.setColor(piece.getPiece().getColor());
            					g.fillRect(j*dimCase, i*dimCase, dimCase, dimCase);
            				}
                    }   
              }
            }
        });     
        
        // Affichage des colonne 
        for(int i = 0; i < plateauControleur.plateau.plateauPuzzle.length+1; i++){
            g.drawLine(i*dimCase,0, i*dimCase, dimCase*plateauControleur.plateau.plateauPuzzle.length);
            g.setColor(Color.black);
        }
        
        // Affichage des lignes
        for(int i = 0; i < plateauControleur.plateau.plateauPuzzle.length+1; i++){
            g.drawLine(0,i*dimCase,dimCase*plateauControleur.plateau.plateauPuzzle.length, i*dimCase);
            g.setColor(Color.black);
        }
    }
    
  
    public PieceModeleEcoutable getPieceClicked(){
    	return this.pieceClicked;
    }
       
    public PlateauPuzzle getPlateauDeJeu(){
    	return plateauControleur.plateau;
    }
    
    public  PieceModeleEcoutable getPieceMovement(){
        return  this.pieceMovement;
    }
    
    
    
    
    @Override
    public void update(ModeleEcoutable plateau){
    	this.repaint();
    }
    
    
    
    @Override
    public void mouseClicked(MouseEvent e){
        
    	Position positionPieceClicked = new Position(e.getY()/dimension, e.getX()/dimension);
        if(plateauControleur.plateau.OccupePlateau(positionPieceClicked)) {
            this.pieceClicked = plateauControleur.plateau.findPiecePlateau(positionPieceClicked);
        }
        
        // On initialise la pieceClicked a null pour que la piece clique reprenne sa couleur original
        else {
        	this.pieceClicked = null; 
        }
        
        this.update( plateauControleur);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {       
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
}
