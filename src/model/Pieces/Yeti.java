package model.Pieces;

/**
 * Yeti class creates and represents a Yeti
 * @version 1.0
 * @author Pavlos Tzegiannakis - csd3470
 */
public class Yeti extends MoveablePiece{
	
	/**
        * <b>Constructor</b>: Constructs a new Yeti and 
        * via the parent class MoveablePiece using super 
        * sets position = x, rank = 5, quantity = 2
        * <b>Postcondition</b>: Constructs a new Yeti
        * @param x position
        */
	public Yeti(int x)
	{
		super(x, 5);
	}
}
