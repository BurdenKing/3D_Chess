package Chess;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Save the game.
 *
 * @author Lawrence Zheng
 * @version 1.0
 */
public class Save implements Serializable {

    /**
     * Serial Number.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Holds all the pieces to be saved.
     */
    protected ArrayList<Piece> pieceArray = new ArrayList<Piece>();
    
    /**
     * Method to save pieces into this object.
     * @param piece a Piece
     */
    public void savePiece(Piece piece) {
        pieceArray.add(piece);
    }
    
    /**
     * Returns the squareArray for this SaveState.
     * @return squareArray
     */
    public ArrayList<Piece> getPieceArray() {
        return pieceArray;
    }

        
}