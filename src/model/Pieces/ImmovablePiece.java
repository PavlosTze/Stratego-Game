package model.Pieces;

/**
 * ImmovablePiece is subclass of class Piece
 * that represents Flags and Bombs (Immovable Pieces)
 * @version 1.0
 * @author Pavlos Tzegiannakis - csd3470
 */
public class ImmovablePiece implements Piece {
    
    private int position;
    private boolean defeated;

    /**
    * <b>Constructor</b>: Constructs a new Immovable Piece
    * <b>Precondition</b>: position >= 1 AND position <= 80
    * <b>Postcondition</b>: Constructs a new Immovable Piece
    */
    public ImmovablePiece(int position)
    {
        if(position >= 0 && position <= 79){
            this.position = position;
            this.defeated = false;
        } else {
            System.err.println("Wrong position assignment.");
        }
    }

    /**
    * A method just for implementing the interface Piece that has this method, 
    * Immovable Pieces do not have rank
    */
    @Override
    public int getRank()
    {
        return 0;
    }

    /**
    * <b>Accessor(selector)</b>: returns the position of this piece
    * <b>Postcondition</b>: returns the position of this piece
    * invariants: position,defeated remain unchanged
    * @return the position of this piece
    */
    @Override
    public int getPosition()
    {
        return position;
    }

    /**
    * <b>Transformer</b>: sets the position of this piece<br />
    * <b>Postcondition</b>: sets the position of this piece
    * invariants: defeated remain unchanged
    */
    @Override
    public void setPosition(int position)
    {
        this.position = position;
    }

    /**
    * <b>Accessor(selector)</b>: returns the position of this piece if it alive, 
    * otherwise a message that shows it is dead
    * <b>Postcondition</b>: returns the position of this piece if it alive, 
    * otherwise a message that shows it is dead
    * invariants: position,defeated remain unchanged
    * @return the position of this piece if it alive, 
    * otherwise a message that shows it is dead
    */
    @Override
    public String toString()
    {
        if(defeated == false) {
            return ("Position: " + position);
        } else {
            return ("Defeated.");
        }
    } 

    /**
    * <b>Observer</b>: returns true if the piece is defeated, false otherwise
    * <b>Postcondition</b>: returns true if the piece is defeated, false otherwise
    * invariants: position,defeated remain unchanged
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
    */
    @Override
    public void setDefeated(boolean x)
    {
        this.defeated = x;
    }
}
