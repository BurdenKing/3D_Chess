package Chess;

import javafx.scene.text.Text;
import java.io.Serializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**

 *
 * @author Lawrence Zheng
 * @version 1.0
 */
abstract class Piece extends Text implements Serializable {


    
    /**
     * Size of the chess piece.
     */
    public static final int SIZE = 35;
    
    /**
     * Serialization long.
     */
    private static final long serialVersionUID = 1L;
    

    /**
     * Colour of piece.
     */
    private String colour;
    
    /**
     * Color toggle.
     */
    private boolean toggle;
    
    /**
     * X Coordinate.
     */
    private int xCor;
    
    /**
     * Y Coordinate.
     */
    private int yCor;
    
    /**
     * Name of chessPiece.
     */
    private String name;
    

    
    /**
     * Constructs an object of type ChessPiece.
     * @param colour of piece
     * @param xCor an int
     * @param yCor an int
     */
    Piece(String colour, int xCor, int yCor) {
        this.colour = colour;
        this.xCor = xCor;
        this.yCor = yCor;

        this.setOnMouseEntered(this::hover);
        this.setOnMouseExited(this::hover);
    }
    
    /**
     * Get name.
     * @return a name.
     */
    public String getName() {
        return name;
    }
    
    



    /**
     * Highlights the borders blue when selected.
     * @param me an event.
     */
    public void hover(MouseEvent me) {
        if (!toggle) {
            setFill(Color.CYAN);
            toggle = true;
        } else {
            setColour();
            toggle = false;
        }
    }
    
    /**
     * Sets Color.
     */
    public void setColour() {
        if (colour.equals("white")) {
            this.setFill(Color.WHITE);
        } else {
            this.setFill(Color.BLACK);
        }
    }
    

    /**
     * Returns the colour for this ChessPiece.
     * @return colour
     */
    public String getColour() {
        return colour;
    }

    /**
     * Sets the colour for this ChessPiece.
     * @param colour a String
     */
    public void setColour(String colour) {
        this.colour = colour;
    }
    
    /**
     * Checks if the move is performing a valid move.
     * @param fromX an int
     * @param fromY an int
     * @param toX an int
     * @param toY an int
     * @param squareArray Squares
     * @return a boolean.
     */
    abstract boolean validMove(Square[][] squareArray,
            int fromX, int fromY, int toX, int toY);

    /**
     * Checks path to see if a piece is in the way.
     * @param squareArray a Square
     * @param dirX X direction
     * @param dirY Y direction
     * @param srcX X source
     * @param srcY Y source
     * @param destX X destination
     * @param destY Y destination
     * @return a boolean
     */
    public boolean checkPath(Square[][] squareArray, int dirX, int dirY,
            int srcX, int srcY, int destX, int destY) {

        
        while (destY != srcY + dirY || destX != srcX + dirX) {
            srcY = srcY + dirY;
            srcX = srcX + dirX;
            
            try {
                
                if (srcX >= 8 && srcX <= 15) {
                    // For Level 2 board destination
                    // check level 1
                    if ((squareArray[srcX - 8][srcY].getPiece() != null) 
                            //check level 3
                            || (squareArray[srcX + 8][srcY].getPiece() != null)) {
                        return false;
                    }
                } else if (srcX >= 16 && srcX <= 23){
                    // For Level 2 board destination
                    // check level 1
                    if ((squareArray[srcX - 16][srcY].getPiece() != null)
                            // check level 2
                            || (squareArray[srcX - 16][srcY].getPiece() != null)) {
                        return false;
                    }
                }
                
                if ((squareArray[srcX][srcY].getPiece() != null)) {
                    return false;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
                return true;
            }
        }
        
        return true;
    }
    
    /**
     * Returns the xCor for this ChessPiece.
     * @return xCor
     */
    public int getxCor() {
        return xCor;
    }

    /**
     * Returns the yCor for this ChessPiece.
     * @return yCor
     */
    public int getyCor() {
        return yCor;
    }

    /**
     * Sets the xCor for this ChessPiece.
     * @param xCor the xCor to set
     */
    public void setxCor(int xCor) {
        this.xCor = xCor;
    }

    /**
     * Sets the yCor for this ChessPiece.
     * @param yCor the yCor to set
     */
    public void setyCor(int yCor) {
        this.yCor = yCor;
    }
 
    /**
     * Prints the coordinates of this piece.
     */
    public void getCor() {
        System.out.println("yCor:" + yCor + "," + " xCor: " 
                + xCor + " colour: " + colour);
    }
    
    /**
     * Text to string.
     * @see java.lang.Text#toString()
     * @return a string
     */
    @Override
    public String toString() {
        return "";
    }
    
}