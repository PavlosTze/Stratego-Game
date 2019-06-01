package model.Pieces;

/**
 * MovablePiece is subclass of class Piece
 * that represents all pieces that can be moved
 * @version 1.0
 * @author Pavlos Tzegiannakis - csd3470
 */
public abstract class MoveablePiece implements Piece {

    private int position;
    private int rank;
    private boolean defeated;

    /**
    * <b>Constructor</b>: Constructs a new Moveable Piece
    * <b>Precondition</b>: 
    * (A): position >= 1 AND position <= 80
    * (B): rank >=1 AND rank <= 10
    * <b>Postcondition</b>: Constructs a new Moveable Piece
    */
    public MoveablePiece(int position, int rank)
    {
        if(position >= 0 && position <= 79 && rank >= 1 && rank <= 10) {
            setPosition(position);
            setRank(rank);
            this.defeated = false;
        } else {
            System.err.println("Wrong position or rank");
        }
    }

    /**
    * <b>Accessor(selector)</b>: returns the rank of this piece
    * <b>Postcondition</b>: returns the rank of this piece
    * invariants: position,defeated,rank remain unchanged
    * @return the rank of this piece
    */
    @Override
    public int getRank()
    {
        return this.rank;
    }

    /**
    * <b>Transformer</b>: sets the rank of this piece
    * <b>Postcondition</b>: sets the rank of this piece
    * invariants: defeated,position remain unchanged
    */
    public void setRank(int rank)
    {
        this.rank = rank;
    }

    /**
    * <b>Accessor(selector)</b>: returns the position of this piece
    * <b>Postcondition</b>: returns the position of this piece
    * invariants: position,defeated,rank remain unchanged
    * @return the position of this piece
    */
    @Override
    public int getPosition()
    {
        return this.position;	
    }

    /**
    * <b>Transformer</b>: sets the position of this piece
    * <b>Postcondition</b>: sets the position of this piece
    * invariants: defeated,rank remain unchanged
    */
    @Override
    public void setPosition(int position)
    {
        this.position = position;
    }

    /**
    * <b>Accessor(selector)</b>: returns the position and rank of this piece if it alive, 
    * otherwise a message that shows it is dead
    * <b>Postcondition</b>: returns the position and rank of this piece if it alive, 
    * otherwise a message that shows it is dead
    * invariants: position,defeated,rank remain unchanged
    * @return the position and rank of this piece if it alive, 
    * otherwise a message that shows it is dead
    */
    @Override
    public String toString()
    {
        if(defeated == false) {
            return ("Position: " + position + "Rank: " + rank);
        } else {
            return ("Defeated.");
        }
    } 

    /**
    * <b>Observer</b>: returns true if the piece is defeated, false otherwise
    * <b>Postcondition</b>: returns true if the piece is defeated, false otherwise
    * invariants: position,defeated,rank remain unchanged
    * @return true if the piece is defeated, false otherwise
    */
    @Override
    public boolean isDefeated()
    {
        return this.defeated;
    }

    /**
    * <b>Transformer</b>: sets the defeated status of this piece
    * <b>Postcondition</b>:  sets the defeated status of this piece
    * invariants: rank remain unchanged
    */
    @Override
    public void setDefeated(boolean x)
    {
        this.defeated = x;
    }
}
