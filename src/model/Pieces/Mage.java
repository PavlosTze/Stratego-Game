package model.Pieces;

/**
 * Mage class creates and represents a Mage
 * @version 1.0
 * @author Pavlos Tzegiannakis - csd3470
 */
public class Mage extends MoveablePiece {
	
	/**
        * <b>Constructor</b>: Constructs a new Mage and 
        * via the parent class MoveablePiece using super 
        * sets position = x, rank = 9, quantity = 1
        * <b>Postcondition</b>: Constructs a new Mage
        * @param x position
        */
	public Mage(int x)
	{
            super(x, 9);
	}
}
