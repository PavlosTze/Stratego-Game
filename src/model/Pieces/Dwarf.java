package model.Pieces;

/**
 * Dwarf class creates and represents a Dwarf
 * @version 1.0
 * @author Pavlos Tzegiannakis - csd3470
 */
public class Dwarf extends SpecialMoveablePiece {

	/**
        * <b>Constructor</b>: Constructs a new Dwarf and 
        * via the parent class SpecialMoveablePiece using super 
        * sets position = x, rank = 3, quantity = 5
        * <b>Postcondition</b>: Constructs a new Dwarf
        * @param x position
        */
	public Dwarf(int x)
	{
            super(x,3);
	}

}
