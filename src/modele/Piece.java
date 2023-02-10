
package modele;

import java.awt.Color;

// L'interface Piece en l'implement dans la class PiecePuzzle
public interface Piece {

	public void setLargeur(int l);

	public void setHauteur(int h);

	public int getLargeur();

	public int getHauteur();

	public void setColor(Color c);

	public Color getColor();

	public boolean getOccupePieceGrille(int x, int y);

	public Position getMidPos();

	public void rotation(int dir);

}
