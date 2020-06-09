package Chess;

import javafx.scene.text.Font;

/**
 * Rook.
 *
 * @author Lawrence Zheng   
 * @version 1.0
 */
public class Rook extends Piece {
    
    /**
     * Rook Serial.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Rook Image.
     */
    private String rookImage = "\u265C";
    
    /**
     * Name.
     */
    private String name = "Rook";
    
    /**
     * Constructs an object of type Rook.
     * @param colour of Rook
     * @param xCor an int
     * @param yCor an int
     */
    public Rook(String colour, int xCor, int yCor) {
        super(colour, xCor, yCor);
        setText(rookImage);

        // Assigns black or white icon
        setColour();
        setFont(new Font(Piece.SIZE));
    }
    
    /**
     * Gets the name.
     * @return name.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Checks if valid move.
     * @param fromX
     * @param fromY
     * @param toX
     * @param toY
     * @return boolean
     */
    @Override
    public boolean validMove(Square[][] squareArray, int fromX, int fromY,
            int toX, int toY) {
        
        // Vertical
        if (toX == fromX) {
            
            if (fromY > toY) {
                return checkPath(squareArray, 0, -1, fromX, fromY, toX, toY);
            } else {
                return checkPath(squareArray, 0, 1, fromX, fromY, toX, toY);
            }
        } 
        // Horizontal
        if (toY == fromY) {
            if (fromX > toX) {
                return checkPath(squareArray, -1, 0, fromX, fromY, toX, toY);
            } else {
                return checkPath(squareArray, 1, 0, fromX, fromY, toX, toY);
            }
        }
        return false;
    }

    /**
     * Text to string.
     * @see java.lang.Text#toString()
     * @return a string
     */
    @Override
    public String toString() {
        return (getColour() + " " + name);
    }

}

