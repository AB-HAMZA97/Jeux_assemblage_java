package controleur;

import modele.PiecePuzzle;
import modele.Position;


public class PieceModeleEcoutable implements ModeleEcoutable{
    protected EcouteurModele ecouter;
    PiecePuzzle piecepuzzle;
    
    @Override
    public void addEcouteur(EcouteurModele e){
    	this.ecouter=e;
    }

    
    @Override
    public void notifierEcouteur(){
    	this.ecouter.update(this);
    }
    
    public PieceModeleEcoutable(PiecePuzzle piece){
        this.piecepuzzle=piece;
    }
    
    public EcouteurModele getecouter() {
        return ecouter;
    }

    public PiecePuzzle getPiece() {
        return piecepuzzle;
    }
    
   /*
    * @param dir la direction si gauche 0 or droite 1
    * 
    */
    public void rotationPlateau(int dir){
        if(canRotatation((PlateauModeleEcoutable)ecouter,dir)){   
            piecepuzzle.rotationPlateau(dir);
            this.notifierEcouteur();           
        }
    }
    
    /*
     * @param dep la deplacement haut bas droite gauche
     * @si c'est possible ce déplacer
     * 
     */
    public void DeplacementPlateau(int dep){
        if(canMovementPiece((PlateauModeleEcoutable)ecouter,dep)){
            piecepuzzle.DeplacementPlateau(dep);
            this.notifierEcouteur();
        }
    }
    /*
     * Test s'il peut rotationer 
     * @param direction si tourne droite ou tourne a gauche
     * @param pme pour supprime l'ancienne postion
     * @return True or False
     * 
     */
    public boolean canRotatation(PlateauModeleEcoutable pme, int direction){      
    	pme.getPlateau().removePiece(this.piecepuzzle);
    	PiecePuzzle copiePiece = piecepuzzle.copiePiece();
    	copiePiece.rotation(direction);
    	return pme.getPlateau().canAjoutePiece(copiePiece,piecepuzzle.getPositionPiece());
    }
    /*
     * 
     * On supprime la piece du palteau l'ancienne piece
     * Un copie de la piece et on affecte l'ancienne position
     * Teste si on peut faire un deplacement avec
     * @return true si possible false l'inverse
     * 
     */

    public boolean canMovementPiece(PlateauModeleEcoutable pme,int dep){
    	
    	pme.getPlateau().removePiece(piecepuzzle);
       	PiecePuzzle copiePiece = piecepuzzle.copiePiece();
    	int x = piecepuzzle.getPositionPiece().getX();
    	int y = piecepuzzle.getPositionPiece().getY();
    	copiePiece.setPositionPiece(new Position(x, y));
    	copiePiece.deplacement(dep);
    	
    	return pme.getPlateau().canAjoutePiece(copiePiece,copiePiece.getPositionPiece())? true : false;
    }        
    
}