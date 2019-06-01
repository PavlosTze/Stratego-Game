package model.Pieces;

/**
 * Sorceress class creates and represents a Sorceress
 * @version 1.0
 * @author Pavlos Tzegiannakis - csd3470
 */
public class Sorceress extends SpecialMoveablePiece {

	/**
        * <b>Constructor</b>: Constructs a new Sorceress and 
        * via the parent class SpecialMoveablePiece using super 
        * sets position = x, rank = 6, quantity = 2
        * <b>Postcondition</b>: Constructs a new Sorceress
        * @param x position
        */
	public Sorceress(int x)
	{
            super(x,6);
	}
	
}