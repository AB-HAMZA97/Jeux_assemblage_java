package modele;


import java.util.ArrayList;


import controleur.PieceModeleEcoutable;

/*
 * Class abstract PlateauPuzzle  qui implements l'interface plateau contient largeur, hauteur,
 *  un tableau plateau puzzle de 2 dimension ,une liste des pieces.
 *  
 */
public class PlateauPuzzle  implements Plateau {
	// Hauteur du plateau
	private int hauteur;
	// Largeur du plateau
	private int largeur;

	public boolean plateauPuzzle[][];
	// ArrayList qui contient l'ensemble de piece
	public ArrayList<PieceModeleEcoutable> listePieces;

	/*
	 * Constructeur de plateauPuzzle ou on mit l'affectation de l'hauteur, la largeur plateau, de listePiece, PlateauPuzzle et liste pieces
	 */
	public PlateauPuzzle(int largeur, int hauteur) {
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.plateauPuzzle = new boolean[this.hauteur][this.largeur];
		this.listePieces = new ArrayList<PieceModeleEcoutable>();

	}

	public int getHauteur() {
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}


	
	public ArrayList<PieceModeleEcoutable> getListePiece() {
		return this.listePieces;
	}


	/*
	 * Ajoute piece dans le plateau 
	 * @param piece la piece ajouter
	 * @param position position de la piece sur le plateau
	 */
	@Override
	public void ajoutePiece(PieceModeleEcoutable piece, Position position) {

		int x = position.getX() - piece.getPiece().getMidPos().getX();
		int y = position.getY() - piece.getPiece().getMidPos().getY();
		
		for (int i = x; i < x + piece.getPiece().getLargeur(); i++) {
			for (int j = y; j < y + piece.getPiece().getHauteur(); j++) {
				if (piece.getPiece().getOccupePieceGrille(i-x,j-y)) {
							this.plateauPuzzle[i][j] = piece.getPiece().getOccupePieceGrille(i-x,j-y);						
				}
			}
		}
		piece.getPiece().setPositionPiece(position);
		listePieces.add(piece);
	}
	
	/*
	 *  La possiblité d'ajoute une piece dans le plateau la position p 
	 * @param piece à ajoute
	 * @param p position de la piece sur le plateau
	 * @return return true si la piece à la possibilité de ce déplace
	 */

	@Override
	public boolean canAjoutePiece(PiecePuzzle piece, Position p) {
		// TODO Auto-generated method stub
		int x = p.getX() - piece.getMidPos().getX();//getMidPos position center lhauteur/2 largeur/2
		int y = p.getY() - piece.getMidPos().getY();

		if (this.outOfPlateau(piece, p) == false) {
			return false;
		} 
		else {
			for (int i = x; i < x + piece.getLargeur(); i++) {
				for (int j = y; j < y + piece.getHauteur();j++) {
					if (this.OccupePlateau(new Position(i,j))) {
						if (piece.getOccupePieceGrille(i-x,j-y)) {
							return false;
						}
					} else {
						if (this.OccupePlateau(new Position(i,j))) {
							return true;
						}
					}
				}
			}
		}
		return true;
	}
	
	/*
	 * Occupeplateau permetre d'indique si la position valide
	 * 	avec l'exception lorsqu'il dépasse la taille plateau
	 * return true si il peut pas ce déplace, false il peut
	*/
	
	public boolean OccupePlateau(Position p){
		try {
			boolean b=this.plateauPuzzle[p.getX()][p.getY()];
			//System.out.println(b); 
			return b;	
		} catch (ArrayIndexOutOfBoundsException e) {
			//System.out.println("Vous etes dehors du plateau");
		}
		return true;
		
		
	}
	

	// On verifier si la piece il existe dans le plateau
	public boolean outOfPlateau(PiecePuzzle piece, Position p) {
		
		if (p.getX() < 0 && p.getX() + piece.getLargeur() < this.getLargeur()) {
			return false;
		}
		if (p.getY() < 0 && p.getY() + piece.getHauteur() < this.getHauteur()) {
			return false;
		}
		return true;
	}

	
	/*
	 * Score return le nombre d'occupation des pieces dans le tableau il faut que le nombre return 
	 * soit min
	 */
	@Override
	  public int score(){
			
		//Teste si la liste contient des piece sinon return 0
		if(this.listePieces.isEmpty()) {
			System.out.println("test");
		}
		
        int minLargeur = this.largeur-1;
        int maxLargeur = 0;
        
        int minHauteur = this.hauteur-1;
        int maxHauteur = 0;      
            
        for(PieceModeleEcoutable pme : this.listePieces){
            int minX = pme.getPiece().getPositionPiece().getY() - pme.getPiece().getMidPos().getY();
            int minY = pme.getPiece().getPositionPiece().getX() - pme.getPiece().getMidPos().getX();
            
            int maxX = pme.getPiece().getPositionPiece().getY() + pme.getPiece().getMidPos().getY();
            int maxY = pme.getPiece().getPositionPiece().getX() + pme.getPiece().getMidPos().getX();
            
            if( minX < minLargeur)
                minLargeur = minX;
            
            if( minY < minHauteur)
                minHauteur = minY;
            
            if(maxX > maxLargeur)
                maxLargeur = maxX;
            
            if(maxY > maxHauteur)
                maxHauteur = maxY;   
        }
        
        int nbre_case = ((maxLargeur-minLargeur)+1) * ((maxHauteur-minHauteur)+1);
        
        return nbre_case;
    }
    





	/*
	 * Suppression de la piece dans le plateau
	 */
	@Override
	public void removePiece(PiecePuzzle piece) {
		// TODO Auto-generated method stub
		
		int x = piece.getPositionPiece().getX() - piece.getMidPos().getX();
		int y = piece.getPositionPiece().getY() - piece.getMidPos().getY();
		
		for (int i = x; i < x + piece.getHauteur(); i++) {
			for (int j = y; j < y + piece.getLargeur(); j++) {
				if (piece.getOccupePieceGrille(i - x, j - y)) {
					if (this.OccupePlateau(new Position(i, j))) {
						this.plateauPuzzle[i][j] = false;
					}
					
				}
			}
		}
	}

	/*
	 *cette methode permet de rechercher la position de la piece dans le plateau 
	 *@param pos qu'on cherche la piece qui occupe pos
	 *@return la piece qui s'occupe
	 * 
	 */
	
	public PieceModeleEcoutable findPiecePlateau(Position pos) {
		
		PieceModeleEcoutable pme = null;
		
		if (this.plateauPuzzle[pos.getX()][pos.getY()]) {
			
			for (PieceModeleEcoutable piece : this.listePieces) {
				
				int ligne = piece.getPiece().getPositionPiece().getX() - piece.getPiece().getMidPos().getX();
				int colonne = piece.getPiece().getPositionPiece().getY() - piece.getPiece().getMidPos().getY();

				for (int i = ligne; i < ligne + piece.getPiece().getHauteur(); i++) {
					for (int j = colonne; j < colonne + piece.getPiece().getLargeur(); j++) {
						
						if (pos.getX() == i && pos.getY() == j) {
							pme = piece;
						}
					}
				}
			}
		}
		return pme;
	}

	
	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < this.plateauPuzzle.length; i++) {
			for (int j = 0; j < this.plateauPuzzle[i].length; j++) {
				str += this.plateauPuzzle[i][j] ? "1" : " ";
				str += " ";
			}
			str += "\n";
		}
		return str;
	}

	

}
