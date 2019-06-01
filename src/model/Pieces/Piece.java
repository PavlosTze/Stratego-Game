package model.Pieces;

/**
 * Piece is superclass that represents all pieces of the game
 * @version 1.0
 * @author Pavlos Tzegiannakis - csd3470
 */
public abstract interface Piece {
	
    /**
    * <b>Accessor(selector)</b>: returns the position of this piece
    * <b>Postcondition</b>: returns the position of this piece
    * @return the position of this piece
    */
    public int getPosition();

    /**
    * <b>Transformer</b>: sets the position of this piece
    * <b>Postcondition</b>: sets the position of this piece
    */
    public void setPosition(int position);


    /**
    * <b>Accessor(selector)</b>: returns the position (and rank if movable) of this piece if it alive, 
    * otherwise a message that shows it is dead
    * <b>Postcondition</b>: returns the position (and rank if movable) of this piece if it alive, 
    * otherwise a message that shows it is dead
    * invariants: position,defeated,quantity remain unchanged
    * @return the position (and rank if movable) of this piece if it alive, 
    * otherwise a message that shows it is dead
    */
    @Override
    public String toString(); 

    /**
    * <b>Observer</b>: returns true if the piece is defeated, false otherwise
    * <b>Postcondition</b>: returns true if the piece is defeated, false otherwise
    * @return true if the piece is defeated, false otherwise
    */
    public boolean isDefeated();

    /**
    * <b>Transformer</b>: sets the defeated status of this piece
    * <b>Postcondition</b>:  sets the defeated status of this piece
    */
    public void setDefeated(boolean x);

    /**
    * <b>Accessor(selector)</b>: returns the rank of this piece
    * <b>Postcondition</b>: returns the rank of this piece
    * @return the rank of this piece
    */
    public int getRank();
}
