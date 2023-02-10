package modele;

/**
 	* Class permet de créer des pieces qu'on a dans méthode type qu'on a dèja affecter a chaque pieces 
 	* leurs hauteurs,largeurs et couleur. 
 	* 
 	*  
 	*/

public class FactoryPiece{
    
	public PiecePuzzle formerPiece(TypePiece type){
        PiecePuzzle piece = this.createPiece(type);
        piece.createPiece();
        return piece;
    }
	//On spécifier les pieces qu'on a dans notre application pour le fabriquer 
	public enum TypePiece{
	        PieceT,
	        PieceL,
	        PieceX,
	        PieceI,
	        PieceCarre,
	}
	  
	//Permet d'instancier dans chaque piece ca dépend le @param type
    public PiecePuzzle createPiece(TypePiece type){
        PiecePuzzle piece = null;
        
        switch(type){
            case PieceT:piece = new PieceT();break;
            case PieceL:piece = new PieceL();break;
            case PieceX:piece = new PieceX();break;
            case PieceI:piece = new PieceI();break;
            case PieceCarre:piece = new PieceCarre();break;
        }
        return piece;
    }
}
