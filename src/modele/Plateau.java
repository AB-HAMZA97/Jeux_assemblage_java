package modele;

import controleur.PieceModeleEcoutable;

public interface Plateau {

	public void ajoutePiece(PieceModeleEcoutable piece, Position position);
	
	public boolean canAjoutePiece(PiecePuzzle piece,Position p);
	
	public int score();
	
	public void removePiece(PiecePuzzle piece);
}
