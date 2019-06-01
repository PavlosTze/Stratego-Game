package model.Pieces;

/**
 * Knight class creates and represents a knight
 * @version 1.0
 * @author Pavlos Tzegiannakis - csd3470
 */
public class Knight extends SpecialMoveablePiece {

	/**
        * <b>Constructor</b>: Constructs a new Knight and 
        * via the parent class SpecialMoveablePiece using super 
        * sets position = x, rank = 8, quantity = 2
        * <b>Postcondition</b>: Constructs a new Knight
        * @param x position
        */
	public Knight(int x)
	{
            super(x,8);
	}
	
}