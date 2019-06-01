package model.Board;

import model.Pieces.Piece;

/**
 * Board class creates and represents the board(grid) of the game, 80 instances of Squares for every position
 * @version 1.0
 * @author Pavlos Tzegiannakis - csd3470
 */
public class Board {

    private final Square[] board = new Square[80];

    /**
    * <b>Constructor</b>: Constructs a new Board
    * <b>Postcondition</b>: constructs a new Board 
    */
    public Board()
    {
        int i;
        for(i=0;i<80;i++)
        {
            board[i] = new Square();
            board[i].setEmpty();
        }
    }

    /**
    * <b>Observer</b>: returns true if the square at position i has no piece, false otherwise
    * <b>Postcondition</b>: returns true if the square at position i has no piece, false otherwise
    * @param i the position of the square we want to check
    * @return true if the square at position i has no piece, false otherwise
    */
    public boolean isEmpty(int i)
    {
        return board[i].IsEmpty();
    }

    /**
    * <b>Transformer</b>: set the square at position i empty
    * <b>Postcondition</b>: square at position i is empty, no piece assigned to it
    * @param i the position of the square we want to free
    */
    public void setEmpty(int i)
    {
        board[i].setEmpty();
    }

    /**
    * <b>Accessor(selector)</b>: returns the piece of the square at position i
    * <b>Postcondition</b>: returns the piece of the square at position i
    * @param i the position of the square that we want to get the piece
    * @return the piece of the square
    */
    public Piece getPiece(int i)
    {
        return board[i].getPiece();
    }

    /**
    * <b>Transformer</b>: assigns a piece to the square at position i
    * <b>Precondition</b>:  1: piece != null 2: i >=0 AND i<=79
    * <b>Postcondition</b>: assigns a piece to the square at position i
    * @param p the piece we will assign at the square
    * @param i the position of the square that the piece will be assigned
    */
    public void setPiece(Piece p, int i)
    {
        if(i < 0 || i > 79 || p == null) {
            System.err.println("Error at setting a piece at a square");
        } else {
            board[i].setPiece_ToSquare(p);
        }
    }
}
