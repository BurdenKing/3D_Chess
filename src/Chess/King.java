package Chess;

import javafx.scene.text.Font;


    
/**
 * King.
 *
 * @author Lawrence Zheng
 * @version 1.0
 */
public class King extends Piece {
    
    /**
     * King Serial.
     */
    private static final long serialVersionUID = 1L;

    /**
     * King Image.
     */
    private String kingImage = "\u265A";
    
    /**
     * Name.
     */
    private String name = "King";
    
    /**
     * Constructs an object of type King.
     * @param colour of King
     * @param xCor an int
     * @param yCor an int
     */
    public King(String colour, int xCor, int yCor) {
        super(colour, xCor, yCor);
        setText(kingImage);

        // Assigns black or white icon
        setColour();
        
        setFont(new Font(Piece.SIZE));
        
    }
    
    /**
     * Get Name.
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
     * @return a boolean
     */
    @Override
    boolean validMove(Square[][] squareArray, int fromX, int fromY,
            int toX, int toY) {
        int move = (int) (Math.pow((toX - fromX), 2) 
                + Math.pow((toY - fromY), 2));
        return (move == 1 || move == 2);
    }

}