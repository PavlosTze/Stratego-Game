package model.Pieces;

/**
 * LavaBeast class creates and represents a LavaBeast
 * @version 1.0
 * @author Pavlos Tzegiannakis - csd3470
 */
public class LavaBeast extends MoveablePiece{
	
	/**
        * <b>Constructor</b>: Constructs a new LavaBeast and 
        * via the parent class MoveablePiece using super 
        * sets position = x, rank = 5, quantity = 2
        * <b>Postcondition</b>: Constructs a new LavaBeast
        * @param x position
        */
	public LavaBeast(int x)
	{
		super(x, 5);
	}
}
