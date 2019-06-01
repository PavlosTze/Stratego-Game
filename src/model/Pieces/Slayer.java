package model.Pieces;

/**
 * Slayer class creates and represents a Slayer
 * @version 1.0
 * @author Pavlos Tzegiannakis - csd3470
 */
public class Slayer extends SpecialMoveablePiece {
	
	/**
        * <b>Constructor</b>: Constructs a new Slayer and 
        * via the parent class SpecialMoveablePiece using super 
        * sets position = x, rank = 1, quantity = 1
        * <b>Postcondition</b>: Constructs a new Slayer
        * @param x position
        */
	public Slayer(int x)
	{
            super(x,1);
	}

}
