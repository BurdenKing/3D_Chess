package Chess;


import javafx.scene.text.Font;

/**
 * Bishop.
 *
 * @author Lawrence Zheng
 * @version 1.0
 */
public class Bishop extends Piece {

    /**
     * Bishop Serial.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Bishop Image.
     */
    private String bishopImage = "\u265D";
    
    /**
     * Name.
     */
    private String name = "Bishop";
    
    /**
     * Bishop constructor.
     * @param colour of Bishop
     * @param xCor an int
     * @param yCor an int
     */
    public Bishop(String colour, int xCor, int yCor) {
        super(colour, xCor, yCor);
        setText(bishopImage);

        // Assigns black or white icon
        setColour();
        
        setFont(new Font(Piece.SIZE));
        
    }

    /**
     * Gets the name.
     * @return a name;
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
     * Checks if is a valid move.
     * @param fromX
     * @param fromY
     * @param toX
     * @param toY
     * @return boolean
     */
    @Override
    boolean validMove(Square[][] squareArray, int fromX, int fromY,
            int toX, int toY) {
        
        //move from level 1 to 2
        if (toX >= 8 && toX <= 15 && fromX >= 0 && fromX <=7) {
            toX = toX - 8;
        }
        //move from level 1 to 3
        if (toX >= 16 && toX <= 23 && fromX >= 0 && fromX <=7) {
            toX = toX - 16;
        }
        //move from level 2 to 1
        if (toX >= 0 && toX <= 7 && fromX >= 8 && fromX <=15) {
            toX = toX + 8;
        }
        //move from level 2 to 3
        if (toX >= 16 && toX <= 23 && fromX >= 8 && fromX <=15) {
            toX = toX - 8;
        }
        
        //move from level 3 to 1
        if (toX >= 0 && toX <= 7 && fromX >= 16 && fromX <=23) {
            toX = toX + 16;
        }
        //move from level 3 to 2
        if (toX >= 8 && toX <= 15 && fromX >= 16 && fromX <=23) {
            toX = toX + 8;
        }
        
        
        // Up-left
        if (fromX - toX > 0 && fromX - toX == fromY - toY) {
            System.out.println("upleft");
            return checkPath(squareArray, -1, -1, fromX, fromY, toX, toY);
        }
        
        // Up-right
        if (fromX - toX < 0 && fromX - toX == (fromY - toY) * -1) {
            System.out.println("upright");
            return checkPath(squareArray, 1, -1, fromX, fromY, toX, toY);
        }
        
        // Down-left
        if (fromX - toX > 0 && fromX - toX == (fromY - toY) * -1) {
            System.out.println("downleft");
            return checkPath(squareArray, -1, 1, fromX, fromY, toX, toY);
        }
        
        // Down-right
        if (fromX - toX < 0 && fromX - toX == fromY - toY) {
            System.out.println("downright");
            return checkPath(squareArray, 1, 1, fromX, fromY, toX, toY);
        }
        
        
        return false;
    }

    
    public boolean checkPath3D (Square[][] squareArray, int dirX, int dirY,
            int srcX, int srcY, int destX, int destY) {
        
        
        
        
        
        
        
        
        return true;
    }

}
