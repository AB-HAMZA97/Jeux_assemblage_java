package controleur;


import modele.PlateauPuzzle;
import modele.Position;


public class PlateauModeleEcoutable implements EcouteurModele, ModeleEcoutable{
    EcouteurModele ecouteur;
    PlateauPuzzle plateau;

    public EcouteurModele getEcouter() {
        return ecouteur;
    }

    public PlateauPuzzle getPlateau() {
        return plateau;
    }
    
    public PlateauModeleEcoutable(PlateauPuzzle plateau){
        this.plateau=plateau;
    }
    
   
    @Override
    public void addEcouteur(EcouteurModele ecouteur){
    	this.ecouteur = ecouteur;
    }
  
    
    @Override
    public void notifierEcouteur(){
    	this.ecouteur.update(this);
    }

    @Override
    public void update(ModeleEcoutable e) {
        plateau.plateauPuzzle = new boolean[plateau.getHauteur()][plateau.getLargeur()];
        for(int i = 0; i<plateau.listePieces.size(); i++){
        	this.addPiece(plateau.listePieces.get(i), plateau.listePieces.get(i).getPiece().getPositionPiece());           
        }  
        this.notifierEcouteur(); 
    }
    
    /*
     * 
     */
    public void addPiece(PieceModeleEcoutable piece, Position position ){
        if(plateau.canAjoutePiece(piece.getPiece(),position)){
            plateau.ajoutePiece(piece, position);
            piece.addEcouteur(this);
        }
    }
    
    /*
     * 
     * Position des pieces aléatoire dans le plateau 
     * 
     * 
     */
    
    public Position randomPositionOnPlateau(PieceModeleEcoutable p){  
    	//Centre de Piece
        Position midPos = p.getPiece().getMidPos();
        
        int minX = midPos.getX();
        int minY = midPos.getY();
        
        int maxX =  plateau.getLargeur()-(p.getPiece().getLargeur()-midPos.getX());
        int maxY =  plateau.getHauteur()-(p.getPiece().getHauteur()-midPos.getY());
        
        Position posPiece = new Position(-1,-1);
        
        boolean possible = false;  
        
        while(!possible){
            int midX = minX + (int)(Math.random() * (maxX-minX));
            int midY = minY + (int)(Math.random() * (maxY-minY));
            
            posPiece = new Position(midX, midY);
          
            possible = plateau.canAjoutePiece(p.getPiece(),posPiece);  // Appel de la methode qui verifie si il est possible d'ajouter la piece sur la plateau
            
        }
        
        return posPiece;
    }

	
    

}
