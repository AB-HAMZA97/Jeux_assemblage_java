package modele;

import java.awt.Color;

/**
 * 
 * Creation de la price barre qui contient Largeur, hauteur, Couleur
 *  |0|1|0|
 *	|0|1|0|
 *	|0|1|0|
 *  on extends de la classe Piecepuzzle et on redefinie les methodes createPiece() et copiePiece()
 *  
 */

public class PieceI extends PiecePuzzle {
	
	//  Constructeur pour inisialise la largeur, hauteur,Coleur  de la   piece
	public PieceI() {
		this.setLargeur(5);
		this.setHauteur(5);
		this.setColor(Color.BLACK);
		this.pieceGrille = new boolean[this.getHauteur()][this.getLargeur()];
	}
	
	//Creation de la Piece I
	@Override
	public void createPiece() {
		double Pos_Milieu = Math.ceil(this.getLargeur() / 2);
		
		for (int i = 0; i < this.getLargeur(); i++) {
			for (int j = 0; j < this.getHauteur(); j++) {
				if (j == Pos_Milieu) {
					this.pieceGrille[i][j] = true;
				}
				else {
					this.pieceGrille[i][j] = false;
				}
			}
		}
	}

	//Copie de la Piece I
	@Override
	public PiecePuzzle copiePiece() {
		
		PiecePuzzle I = new PieceI();
		I.setHauteur(this.getHauteur());
		I.setLargeur(this.getLargeur());
		
		for (int i = 0; i < this.getHauteur(); i++) {
			for (int j = 0; j < this.getLargeur(); j++) {
				I.setOccupePieceGrille(i, j, this.getOccupePieceGrille(i, j));
			}
		}
		return I;
	}
}
