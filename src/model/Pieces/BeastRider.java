package model.Pieces;

/**
 * BeastRider class creates and represents a BeastRider
 * @version 1.0
 * @author Pavlos Tzegiannakis - csd3470
 */
public class BeastRider extends SpecialMoveablePiece {

	/**
        * <b>Constructor</b>: Constructs a new BeastRider and 
        * via the parent class SpecialMoveablePiece using super 
        * sets position = x, rank = 7, quantity = 3
        * <b>Postcondition</b>: Constructs a new BeastRider
        * @param x position
        */
	public BeastRider(int x)
	{
            super(x,7);
	}
	
}