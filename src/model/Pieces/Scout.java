package model.Pieces;

/**
 * Scout class creates and represents a Scout
 * @version 1.0
 * @author Pavlos Tzegiannakis - csd3470
 */
public class Scout extends SpecialMoveablePiece{
	
	/**
        * <b>Constructor</b>: Constructs a new Scout and 
        * via the parent class SpecialMoveablePiece using super 
        * sets position = x, rank = 2, quantity = 4
        * <b>Postcondition</b>: Constructs a new Scout
        * @param x position
        */
	public Scout(int x)
	{
            super(x,2);
	}
	
}
