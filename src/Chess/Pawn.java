package Chess;

import javafx.scene.text.Font;

/**
 * Pawn.
 *
 * @author Lawrence Zheng
 * @version 1.0
 */
public class Pawn extends Piece {
    
    /**
     * Pawn Serial.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Pawn Image.
     */
    private String pawnImage = "\u265F";
    
    /**
     * Name.
     */
    private String name = "Pawn";
    
    /**
     * Has moved.
     */
    private boolean notMoved = true;
    
    /**
     * Constructs an object of type Pawn.
     * @param colour of Pawn
     * @param xCor an int
     * @param yCor an int
     */
    public Pawn(String colour, int xCor, int yCor) {
        super(colour, xCor, yCor);
        setText(pawnImage);

        // Assigns black or white icon
        setColour();
        
        setFont(new Font(Piece.SIZE));
        
    }
    
    /**
     * Gets the name of this Knight Object.
     * @return a String
     */
    public String getName() {
        return name;
    }

    /**
     * Text to string.
     * @return a string
     */
    @Override
    public String toString() {
        return (getColour() + " " + name);
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
    boolean validMove(Square[][] squareArray, int fromX, int fromY,
            int toX, int toY) {
        if ((toX == fromX || toX == (fromX + 8) || toX == (fromX - 8) || toX == (fromX + 16) || toX == (fromX - 16)) 
                && colourValid(fromY, toY)) {
            
            if (Math.abs(fromY - toY) > 2) {
                return false;
            } else if (!notMoved && Math.abs(fromY - toY) == 2) {
                return false;
            }
            // Disallows movement of two boards if moving only one space
            if ((toX == (fromX + 16) || toX == (fromX - 16)) && Math.abs(fromY - toY) == 1) {
                return false;
            }
            notMoved = false;
            return true;
        }
        return false;
    }
    
    /**
     * Determines if valid depending on the colour.
     * @param fromY an int
     * @param toY an int
     * @return boolean
     */
    boolean colourValid(int fromY, int toY) {
        if (getColour().equals("black")) {
            if (fromY < toY) {
                return true;
            }
        } else if (getColour().equals("white")) {
            if (fromY > toY) {
                return true;
            }
        }
        return false;
    }
    
}