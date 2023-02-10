
import modele.PlateauPuzzle;
import modele.FactoryPiece;
import modele.PiecePuzzle;
import modele.Position;
import vue.FrameJeu;
import modele.FactoryPiece.TypePiece;
import controleur.PieceModeleEcoutable;
import controleur.PlateauModeleEcoutable;

public class main {

	public static void main(String[] args) {
		//System.out.println("JEU TETRIS");
		FactoryPiece fabrique = new FactoryPiece();
		
		
		//Creation des pieces
       	PiecePuzzle L1 = fabrique.formerPiece(TypePiece.PieceL);
        PiecePuzzle L2 = fabrique.formerPiece(TypePiece.PieceL);
        PiecePuzzle L3 = fabrique.formerPiece(TypePiece.PieceL);
        PiecePuzzle X1 = fabrique.formerPiece(TypePiece.PieceX);
        PiecePuzzle X2 = fabrique.formerPiece(TypePiece.PieceX);
        PiecePuzzle X3 = fabrique.formerPiece(TypePiece.PieceX);
        PiecePuzzle T1 = fabrique.formerPiece(TypePiece.PieceT); 
        PiecePuzzle T2 = fabrique.formerPiece(TypePiece.PieceT); 
        PiecePuzzle T3 = fabrique.formerPiece(TypePiece.PieceT); 
        PiecePuzzle I1 = fabrique.formerPiece(TypePiece.PieceI);
        PiecePuzzle I2 = fabrique.formerPiece(TypePiece.PieceI);
        PiecePuzzle I3 = fabrique.formerPiece(TypePiece.PieceI);
        PiecePuzzle C1 = fabrique.formerPiece(TypePiece.PieceCarre);
        PiecePuzzle C2 = fabrique.formerPiece(TypePiece.PieceCarre);
        PiecePuzzle C3 = fabrique.formerPiece(TypePiece.PieceCarre);
        	 
       
        
        //Controleur 
        PieceModeleEcoutable CL1 = new PieceModeleEcoutable(L1);
        PieceModeleEcoutable CL2 = new PieceModeleEcoutable(L2);
        PieceModeleEcoutable CL3 = new PieceModeleEcoutable(L3);
        
        PieceModeleEcoutable CX1 = new PieceModeleEcoutable(X1);
        PieceModeleEcoutable CX2 = new PieceModeleEcoutable(X2);
        PieceModeleEcoutable CX3 = new PieceModeleEcoutable(X3);
        
        PieceModeleEcoutable CT1 = new PieceModeleEcoutable(T1);
        PieceModeleEcoutable CT2 = new PieceModeleEcoutable(T2);
        PieceModeleEcoutable CT3 = new PieceModeleEcoutable(T3);
        

        PieceModeleEcoutable CI1 = new PieceModeleEcoutable(I1);
        PieceModeleEcoutable CI2 = new PieceModeleEcoutable(I2);
        PieceModeleEcoutable CI3 = new PieceModeleEcoutable(I3);
        
        PieceModeleEcoutable CC1 = new PieceModeleEcoutable(C1);
        PieceModeleEcoutable CC2 = new PieceModeleEcoutable(C2);
        PieceModeleEcoutable CC3 = new PieceModeleEcoutable(C3);
        
        // La taille de plateau 27 * 27 
        PlateauPuzzle plateau = new PlateauPuzzle(27,27);
        
        
        /*
         * 
         * Pour des postions aléatoire pour les pieces
         * 
         */
        PlateauModeleEcoutable plateauControleur = new PlateauModeleEcoutable(plateau);
      
              
        Position positionL1 = plateauControleur.randomPositionOnPlateau(CL1);
        Position positionL2 = plateauControleur.randomPositionOnPlateau(CL2);
        Position positionL3 = plateauControleur.randomPositionOnPlateau(CL3);
        
        Position positionT1 = plateauControleur.randomPositionOnPlateau(CT1);
        Position positionT2 = plateauControleur.randomPositionOnPlateau(CT2);
        Position positionT3 = plateauControleur.randomPositionOnPlateau(CT3);
        
        Position positionX1 = plateauControleur.randomPositionOnPlateau(CX1);
        Position positionX2 = plateauControleur.randomPositionOnPlateau(CX2);
        Position positionX3 = plateauControleur.randomPositionOnPlateau(CX3);
        
        Position positionC1 = plateauControleur.randomPositionOnPlateau(CC1);
        Position positionC2 = plateauControleur.randomPositionOnPlateau(CC2);
        Position positionC3 = plateauControleur.randomPositionOnPlateau(CC3);
        
        Position positionI1 = plateauControleur.randomPositionOnPlateau(CI1);
        Position positionI2 = plateauControleur.randomPositionOnPlateau(CI2);
        Position positionI3 = plateauControleur.randomPositionOnPlateau(CI3);
       
       
        /*
         * add piece dans le plateau
         */
        plateauControleur.addPiece(CT1, positionT1);
        plateauControleur.addPiece(CT2, positionT2);
        plateauControleur.addPiece(CT3, positionT3);
       
        plateauControleur.addPiece(CL1, positionL1);
        plateauControleur.addPiece(CL2, positionL2);
        plateauControleur.addPiece(CL3, positionL3);
        
        plateauControleur.addPiece(CX1, positionX1);
        plateauControleur.addPiece(CX2, positionX2);
        plateauControleur.addPiece(CX3, positionX3);
        
        plateauControleur.addPiece(CC1, positionC1);
        plateauControleur.addPiece(CC2, positionC2);
        plateauControleur.addPiece(CC3, positionC3);
        
        plateauControleur.addPiece(CI1, positionI1);
        plateauControleur.addPiece(CI2, positionI2);
        plateauControleur.addPiece(CI3, positionI3);
        
        
        
        new FrameJeu(plateauControleur);
    }
 
}
