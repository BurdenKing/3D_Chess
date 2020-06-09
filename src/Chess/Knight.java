package Chess;

import javafx.scene.text.Font;

/**
 * knight.
 *
 * @author Lawrence Zheng
 * @version 1.0
 */
public class Knight extends Piece {
    
    /**
     * Knight Serial.
     */
    private static final long serialVersionUID = 1L;

    /**
     * For movement calculation.
     */
    private static final int FIVE = 5;
    
    /**
     * Knight Image.
     */
    private String knightImage = "\u265E";
    
    /**
     * Name.
     */
    private String name = "Knight";
    
    /**
     * Constructs an object of type Knight.
     * @param colour of Knight
     * @param xCor an int
     * @param yCor an int
     */
    public Knight(String colour, int xCor, int yCor) {
        super(colour, xCor, yCor);
        setText(knightImage);

        // Assigns black or white icon
        setColour();
        
        setFont(new Font(Piece.SIZE));
        
    }

    /**
     * Gets name.
     * @return name.
     */
    public String getName() {
        return name;
    }

    

    /**
     * Text to string.
     * @see java.lang.Text#toString()
     * @return a string
     */
    @Override
    public String toString() {
        return (getColour() + " " + name );
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
        int deltaY = fromY - toY;
        int deltaX = fromX - toX;
        return FIVE == Math.pow(deltaY, 2) + Math.pow(deltaX, 2);
    }

}