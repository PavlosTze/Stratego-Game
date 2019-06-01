package model.Pieces;

/**
 * MovablePiece is subclass of class MoveablePiece
 * that represents all pieces that can be moved and have a special power
 * @version 1.0
 * @author Pavlos Tzegiannakis - csd3470
 */
public abstract class SpecialMoveablePiece extends MoveablePiece {
	
	/**
        * <b>Constructor</b>: Constructs a new SpecialMoveablePiece Piece
        * <b>Postcondition</b>: Constructs a new SpecialMoveablePiece Piece
        */
	public SpecialMoveablePiece(int position,int rank)
	{
            super(position, rank);
	}
	
}
