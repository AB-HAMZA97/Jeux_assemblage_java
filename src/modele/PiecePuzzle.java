package modele;


import java.awt.Color;

/*
 * 
 * Class abstract PiecePuzzle qui implements l'interface Piece 
 * 
 */

public abstract class PiecePuzzle implements Piece {
	protected boolean pieceGrille[][];
	protected int largeur;
	protected int hauteur;
	private Position position;
	private Color couleur;

	@Override
	public void setLargeur(int la) {
		this.largeur = la;
	}

	@Override
	public void setHauteur(int hau) {
		this.hauteur = hau;
	}

	@Override
	public void setColor(Color clr) {
		this.couleur = clr;
	}

	public void setPositionPiece(Position p) {
		this.position = p;
	}

	public void setOccupePieceGrille(int x, int y, boolean b) {
		this.pieceGrille[x][y] = b;
	}

	@Override
	public int getLargeur() {
		return this.largeur;
	}

	@Override
	public int getHauteur() {
		return this.hauteur;
	}

	public Position getPositionPiece() {
		return this.position;
	}

	@Override
	public boolean getOccupePieceGrille(int x, int y) {
		return this.pieceGrille[x][y];
	}

	
	@Override
	public Position getMidPos() {
		return new Position(this.hauteur/2,this.largeur/2);
	}

	@Override
	public Color getColor() {
		return this.couleur;
	}

	// Création Piece qui l'extends par les Pieces
	public abstract void createPiece();

	// Création copie Piece qui extends par les Pieces
	public abstract PiecePuzzle copiePiece();

	
	// Rotation a gauche est droite si direction=1 rotation droite, direction ==0 rotation gauche
	@Override
	public void rotation(int direction) {
		
		if (direction == 1) {
			int ligne = this.pieceGrille.length;
			int colonne = this.pieceGrille[0].length;
			//Création de la nouvelle grille
			boolean newPieceGrille[][] = new boolean[largeur][hauteur];
			for (int i = 0; i < ligne; i++) {
				for (int j = 0; j < colonne; j++) {
					newPieceGrille[j][i] = this.pieceGrille[ligne - i - 1][j];
				}
			}
			this.setPiecegrille(newPieceGrille);
		}
		if (direction == 0) {
			int ligne = this.pieceGrille.length;
			int colonne = this.pieceGrille[0].length;
			// Création de la nouvele grille
			boolean newPieceGrille[][] = new boolean[largeur][hauteur];
			for (int i = 0; i < ligne; i++) {
				for (int j = 0; j < colonne; j++) {
					newPieceGrille[j][i] = this.pieceGrille[i][colonne - j - 1];
				}
			}
			this.setPiecegrille(newPieceGrille);
		}
	}

	public void setPiecegrille(boolean[][] piecegrille) {
		pieceGrille = piecegrille;
	}

	
	//L'appel de la methode de la rotation avec la direction
	public void rotationPlateau(int direction) {
		this.rotation(direction);
	}

	// Methode de déplacement Plateau
	public void DeplacementPlateau(int dep) {
		this.deplacement(dep);
	}

	// Méthode de déplacement
	public void deplacement(int dep) {
		if (dep == 1) {
			this.position.setX(this.position.getX() - 1);// Déplacement Haut
		} else if (dep == 2) {
			this.position.setX(this.position.getX() + 1);// Déplacement Bas
		} else if (dep == 3) {
			this.position.setY(this.position.getY() + 1);// Déplacement Droite
		} else if (dep == 4) {
			this.position.setY(this.position.getY() - 1);// Déplacement Gauche
		} else {
			System.out.println("error");
		}

	}

	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < this.largeur; i++) {
			for (int j = 0; j < this.hauteur; j++) {
				str += "|" + pieceGrille[i][j];
			}
			str += "|";
		}
		return str;
	}
}
