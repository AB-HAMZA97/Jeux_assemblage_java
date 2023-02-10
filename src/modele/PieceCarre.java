package modele;

import java.awt.Color;

/**
 * Creation de la piece carre qui contient Largeu, hauteur, Couleur
 * |1|1|
 * |1|1|
 * On extends de la classe Piecepuzzle et on redefinie les methodes createPiece() et copiePiece()
 */

public class PieceCarre extends PiecePuzzle {

	public PieceCarre() {
		this.setLargeur(2);
		this.setHauteur(2);
		this.setColor(Color.BLUE);

		this.pieceGrille = new boolean[this.getHauteur()][this.getLargeur()];
	}

	// Creation de la Piece Carre
	@Override
	public void createPiece() {
		for (int i = 0; i < this.getLargeur(); i++) {
			for (int j = 0; j < this.getHauteur(); j++) {
				this.pieceGrille[i][j] = true;
			}
		}
	}

	//Copie de la Piece Carre
	@Override
	public PiecePuzzle copiePiece() {
		PiecePuzzle x = new PieceX();

		x.setHauteur(this.getHauteur());
		x.setLargeur(this.getLargeur());

		for (int i = 0; i < this.getHauteur(); i++) {
			for (int j = 0; j < this.getLargeur(); j++) {
				x.setOccupePieceGrille(i, j, this.getOccupePieceGrille(i, j));
			}
		}
		return x;
	}
}
