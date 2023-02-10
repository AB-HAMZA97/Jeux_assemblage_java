package modele;

import java.awt.Color;

/**
 * Creation de la price + qui contient Largeur, hauteur, Couleur

 * |0|1|0|
 * |1|1|1|
 * |0|1|0|
 *  on extends de la classe Piece puzzle et on redefinie les methodes createPiece() et copiePiece()

 */

public class PieceX extends PiecePuzzle {

	//  Constructeur pour inisialise la largeur, hauteur,Coleur  de la   piece
	public PieceX() {
		this.setLargeur(5);
		this.setHauteur(5);
		this.setColor(Color.ORANGE);
		this.pieceGrille = new boolean[this.getHauteur()][this.getLargeur()];
	}

	//Cration de la piece X
	@Override
	public void createPiece() {
		double Pos_Milieu = Math.ceil(this.getLargeur() / 2);
		double Pos_Milieu1 = Math.ceil(this.getHauteur() / 2);
		for (int i = 0; i < this.getLargeur(); i++) {
			for (int j = 0; j < this.getHauteur(); j++) {
				if (i == Pos_Milieu1 || j == Pos_Milieu) {
					this.pieceGrille[i][j] = true;
				} 
				else {
					this.pieceGrille[i][j] = false;
				}
			}
		}
	}

	//Copie de la piece X
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
