package model.Pieces;

/**
 * Dragon class creates and represents a Dragon
 * @version 1.0
 * @author Pavlos Tzegiannakis - csd3470
 */
public class Dragon extends SpecialMoveablePiece {

	/**
        * <b>Constructor</b>: Constructs a new Dragon and 
        * via the parent class SpecialMoveablePiece using super 
        * sets position = x, rank = 10, quantity = 1
        * <b>Postcondition</b>: Constructs a new Dragon
        * @param x position
        */
	public Dragon(int x)
	{
            super(x,10);
	}
	
}