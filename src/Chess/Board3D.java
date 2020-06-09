package Chess;

public class Board3D extends Board {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    String squareColour;
    
    public void newGame() {
        setSquares(24, 8);
        // turnCheck in getDestination info is off
        setWhitePieces();
        setBlackPieces();
        System.out.println("Started New Game");
    }

    /**
     * @param rows
     * @param cols
     */
    public void setSquares(int rows, int cols) {
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                // Determines colour of square
                if (x >= 0 && x <= 7) {
                    level = 0;
                    squareColour = ((x + y) % 2 == 0) ? "brown" : "indigo";
                    squareArray[x][y] = new Square(squareColour, x, y);
                } else if (x >= 8 && x <= 15) {
                    level = 1;
                    squareColour = ((x + y) % 2 == 0) ? "blue" : "royalblue";
                    squareArray[x][y] = new Square(squareColour, x, y);
                } else {
                    level = 2;
                    squareColour = ((x + y) % 2 == 0) ? "brown" : "indigo";
                    squareArray[x][y] = new Square(squareColour, x, y);
                }
                
                add(squareArray[x][y], x, y);
                
                // Returns coordinates of the square
                squareArray[x][y].setOnMousePressed(this::move);
                
            }
        }
    }
}
