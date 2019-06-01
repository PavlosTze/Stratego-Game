package model.Pieces;

/**
 * Bomb class crates and represents a bomb
 * @version 1.0
 * @author Pavlos Tzegiannakis - csd3470
 */
public class Bomb extends ImmovablePiece {
	
	/**
        * <b>Constructor</b>: Constructs a new Bomb and via the
        * parent class SpecialCard sets with the command super position = x, and quantity = 6
        * <b>Precondition</b>: x >= 1 AND x <= 80
        * <b>Postcondition</b>: Constructs a new Bomb
        * @param x position
        */
	public Bomb(int x)
	{
            super(x);
	}

}
