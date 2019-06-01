package model.Board;

import model.Pieces.Piece;

/**
* Square is a grid's square of the game's board
* @version 1.0
* @author Pavlos Tzegiannakis - csd3470
*/
public class Square {
	
    private Piece piece = null;

    /**
    * <b>Constructor</b>: Constructs a new Square
    * <b>Postcondition</b>: Constructs a new Square
    */
    public Square()
    {

    }

    /**
    * <b>Transformer</b>: assigns a piece to the square
    * <b>Precondition</b>: piece != null
    * <b>Postcondition</b>: assigns a piece to the square
    */
    public void setPiece_ToSquare(Piece piece)
    {
        this.piece = piece;
    }

    /**
    * <b>Accessor(selector)</b>: returns the piece of the square
    * <b>Postcondition</b>: returns the piece of the square
    * invariants: piece
    * @return the piece of the square
    */
    public Piece getPiece()
    {
        return this.piece;
    }


    /**
    * <b>Observer</b>: returns true if the square has no piece, false otherwise
    * <b>Postcondition</b>: returns true if the square has no piece, false otherwise
    * invariants: piece
    * @return true if no piece at that square, false otherwise
    */
    public boolean IsEmpty()
    {
        return this.piece == null;
    }

    /**
    * <b>Transformer</b>: set the square empty
    * <b>Postcondition</b>: square is empty, no piece assigned to it
    */
    public void setEmpty()
    {
        this.piece = null;
    }
}
