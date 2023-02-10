package modele;

import java.awt.Color;

/*
*Creation de la price L qui contient Largeur, hauteur, Couleur
*
* |1|0|0|
* |1|0|0|
* |1|1|1|
*
* On extends de la classe Piecepuzzle, on redefinie les methodes createPiece() et copiePiece()
*/

public class PieceL extends PiecePuzzle {
	
	//  Constructeur pour inisialise la largeur, hauteur,Couleur  de la   piece
	public PieceL() {
		this.setLargeur(4);
		this.setHauteur(4);
		this.setColor(Color.pink);
		this.pieceGrille = new boolean[this.getHauteur()][this.getLargeur()];
	}

	// Creation de la Piece L
	@Override
	public void createPiece() {
		
		for (int i = 0; i < this.getLargeur(); i++) {
			for (int j = 0; j < this.getHauteur(); j++) {
				if (i == 0 || j == 0) {
					this.pieceGrille[i][j] = true;
				} 
				else {
					this.pieceGrille[i][j] = false;
				}
			}
		}
	}

	//Copie de la Piece L
	@Override
	public PiecePuzzle copiePiece() {
		
		PiecePuzzle l = new PieceL();
		l.setHauteur(this.getHauteur());
		l.setLargeur(this.getLargeur());
		
		for (int i = 0; i < this.getHauteur(); i++) {
			for (int j = 0; j < this.getLargeur(); j++) {
				l.setOccupePieceGrille(i, j, this.getOccupePieceGrille(i, j));
			}
		}
		return l;
	}
}
