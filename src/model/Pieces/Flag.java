package model.Pieces;

/**
 * Flag class creates and represents a flag
 * @version 1.0
 * @author Pavlos Tzegiannakis - csd3470
 */
public class Flag extends ImmovablePiece {
	
	/**
        * <b>Constructor</b>: Constructs a new Flag and via the
        * parent class SpecialCard sets with the command super position = x, and quantity = 1
        * <b>Precondition</b>: x >= 1 AND x <= 80
        * <b>Postcondition</b>: Constructs a new Flag
        * @param x position
        */
	public Flag(int x)
	{
            super(x);
	}
	
}
