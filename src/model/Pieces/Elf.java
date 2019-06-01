package model.Pieces;

/**
 * Elf class creates and represents a Elf
 * @version 1.0
 * @author Pavlos Tzegiannakis - csd3470
 */
public class Elf extends SpecialMoveablePiece {

	/**
        * <b>Constructor</b>: Constructs a new Elf and 
        * via the parent class SpecialMoveablePiece using super 
        * sets position = x, rank = 4, quantity = 2
        * <b>Postcondition</b>: Constructs a new Elf
        * @param x position
        */
	public Elf(int x)
	{
            super(x,4);
	}
	
}