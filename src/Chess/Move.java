package Chess;

import javafx.scene.input.MouseEvent;

/**
 * Move.
 *
 * @author Lawrence Zheng
 * @version 1.0
 */
public interface Move {

    /**
     * Moves piece.
     * @param e Mouse event
     * @return a boolean
     */
    boolean move(MouseEvent e);
    
    /**
     * Toggles selected piece.
     * @param e Mouse event
     */
    void togglePiece(MouseEvent e);
    
}