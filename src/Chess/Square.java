package Chess;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



/**
 * Squares class.
 *
 * @author Lawrence Zheng   
 * @version 1.0
 */
public class Square extends Rectangle {

    /**
     * Square size.
     */
    public static final int SQUARE_SIZE = 50;
    
    /**
     * Color toggle.
     */
    private boolean toggle;
    
    /**
     * Colour of the square.
     */
    private String colour;
    
    /**
     * X coordinate.
     */
    private int xCor;
    
    /**
     * Y coordinate.
     */
    private int yCor;
    
    
    /**
     * Chess piece on Square.
     */
    private Piece piece;
    
    /**
     * Constructs an object of type Square.
     * @param colour of square
     * @param x location
     * @param y location
     */
    public Square(String colour, int x, int y) {
        
        this.colour = colour;
        this.xCor = x;
        this.yCor = y;
        
        setWidth(SQUARE_SIZE);
        setHeight(SQUARE_SIZE);
        
        setColour();
        
        this.setOnMouseEntered(this::hover);
        this.setOnMouseExited(this::hover);
        
    }
    
    /**
     * Highlights the borders blue when selected.
     * @param me an event.
     */
    public void hover(MouseEvent me) {
        if (!toggle) {
            setFill(Color.YELLOW);
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
        if (colour.equals("brown")) {
            this.setFill(Color.BROWN);
        } else if (colour.equals("indigo")) {
            this.setFill(Color.INDIGO);
        } else if (colour.equals("blue")) {
            this.setFill(Color.BLUE);
        } else if (colour.equals("royalblue")) {
            this.setFill(Color.ROYALBLUE);
        }
    }
    
    /**
     * Returns the x for this Square.
     * @return x
     */
    public int getxCor() {
        return xCor;
    }

    /**
     * Returns the y for this Square.
     * @return y
     */
    public int getyCor() {
        return yCor;
    }





    /**
     * String representation of this Square.
     * @return
     */
    @Override
    public String toString() {
        return colour + " Square";
    }
    
    /**
     * Gets square source.
     * @return an Object.
     */
    public Object getSource() {
        return new Square(null, 0, 0);
    }

    /**
     * Returns the piece for this Square.
     * @return piece
     */
    public Piece getPiece() {
        return piece;
    }
    
    /**
     * Sets the piece for this Square.
     * @param piece the piece to set
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}