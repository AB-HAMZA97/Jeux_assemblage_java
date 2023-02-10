package modele;

import java.awt.Color;

/**
 * Creation de la price T qui contient Largeur, hauteur, Orientation, Couleur
 * |1|1|1|
 * |0|1|0|
 * |0|1|0|
 * On extends de la classe Piecepuzzle, on redefinie les methodes createPiece() et copiePiece()
 * 
 * 
 */

public class PieceT extends PiecePuzzle {
	
	// Constructeur pour inisialise la largeur, hauteur,Coleur  de la   piece
	public PieceT() {
		this.setHauteur(5);
		this.setLargeur(5);
		this.setColor(Color.RED);
		this.pieceGrille = new boolean[this.getHauteur()][this.getLargeur()];
	}

	//Cration de la piece T
	@Override
	public void createPiece() {
		
		double Pos_Milieu = Math.ceil(this.getLargeur() / 2);
		
		for (int i = 0; i < this.getLargeur(); i++) {
			for (int j = 0; j < this.getHauteur(); j++) {
				if (i == 0 || j == Pos_Milieu) {
					this.pieceGrille[i][j] = true;
				} 
				else {
					this.pieceGrille[i][j] = false;
				}
			}
		}

	}

	//Copie de la piece T
	@Override
	public PiecePuzzle copiePiece() {
		
		PiecePuzzle t = new PieceT();
		t.setHauteur(this.getHauteur());
		t.setLargeur(this.getLargeur());
		
		for (int i = 0; i < this.getHauteur(); i++) {
			for (int j = 0; j < this.getLargeur(); j++) {
				t.setOccupePieceGrille(i, j, this.getOccupePieceGrille(i, j));
			}
		}
		
		return t;
	}

}
