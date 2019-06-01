package CollectionPieces;

import java.util.ArrayList;

import model.Pieces.*;

/**
* This class creates a new Collection of pieces.
* @version 1.0
* @author Pavlos Tzegiannakis - csd3470
*/
public class CollectionPieces {
    
    private ArrayList<Piece> pieces;

    /**Constructor.
    * <b>Postcondition</b>Creates a new Sullogipieces with a new piece ArrayList.
    */
    public CollectionPieces()
    {
            pieces = new ArrayList<Piece>();
    }
	
    /**
     * <b>Transformer:</b> Initializes the pieces.
     * <b>Postcondition:</b> The pieces have been initialized.
     */
    public void init_pieces()
    {
        pieces.add(new Flag(5));
        pieces.add(new Bomb(0));
        pieces.add(new Bomb(7));
        pieces.add(new Bomb(10));
        pieces.add(new Bomb(14));
        pieces.add(new Bomb(21));
        pieces.add(new Bomb(27));
        pieces.add(new Slayer(29));
        pieces.add(new Scout(2));
        pieces.add(new Scout(12));
        pieces.add(new Scout(18));
        pieces.add(new Scout(23));
        pieces.add(new Dwarf(1));
        pieces.add(new Dwarf(3));
        pieces.add(new Dwarf(9));
        pieces.add(new Dwarf(22));
        pieces.add(new Dwarf(28));
        pieces.add(new Elf(15));
        pieces.add(new Elf(24));
        pieces.add(new Yeti(4));
        pieces.add(new Yeti(8));
        pieces.add(new Sorceress(6));
        pieces.add(new Sorceress(25));
        pieces.add(new BeastRider(17));
        pieces.add(new BeastRider(19));
        pieces.add(new BeastRider(20));
        pieces.add(new Knight(16));
        pieces.add(new Knight(26));
        pieces.add(new Mage(13));
        pieces.add(new Dragon(11));

        pieces.add(new Flag(65));
        pieces.add(new Bomb(50));
        pieces.add(new Bomb(53));
        pieces.add(new Bomb(55));
        pieces.add(new Bomb(60));
        pieces.add(new Bomb(61));
        pieces.add(new Bomb(71));
        pieces.add(new Slayer(62));
        pieces.add(new Scout(58));
        pieces.add(new Scout(66));
        pieces.add(new Scout(68));
        pieces.add(new Scout(73));
        pieces.add(new Dwarf(54));
        pieces.add(new Dwarf(57));
        pieces.add(new Dwarf(70));
        pieces.add(new Dwarf(77));
        pieces.add(new Dwarf(78));
        pieces.add(new Elf(59));
        pieces.add(new Elf(63));
        pieces.add(new LavaBeast(72));
        pieces.add(new LavaBeast(75));
        pieces.add(new Sorceress(74));
        pieces.add(new Sorceress(76));
        pieces.add(new BeastRider(52));
        pieces.add(new BeastRider(56));
        pieces.add(new BeastRider(69));
        pieces.add(new Knight(51));
        pieces.add(new Knight(64));
        pieces.add(new Mage(79));
        pieces.add(new Dragon(67));
    }
	
    /**
     * <b>Observer:</b> Returns true if this list contains no elements.
     * <b>Postcondition:</b> Returns true if this list contains no elements.
     * invariants pieces
     * @return true if this list contains no elements
     */
	public boolean isEmpty()
	{
            return pieces.isEmpty();
	}
	
	/**
    * <b>Accessor(selector):</b> returns the piece's rank in position i
    * <b>Postcondition:</b> piece's rank in position i has been returned
    * invariants pieces
    * @return the piece's rank in position i
    */
    public int getRank(int i)
    {
        return pieces.get(i).getRank();
    }
	
    /**
    * <b>Transformer:</b> Adds a piece to the list.
    * <b>Postcondition:</b> A piece has been added to the list.
    * @param piece
    */
    public void addPiece(Piece piece)
    {
        pieces.add(piece);
    }
	
    /**
    * <b>Transformer:</b> Deletes a piece from the list.
    * <b>Postcondition:</b> A piece has been deleted from the list.
    * @param piece
    */
    public void removePiece(Piece piece)
    {
        this.pieces.remove(piece);
    }
    
    /**
    * <b>Transformer:</b> Clears an ArrayList 
    * <b>Postcondition:</b> An ArrayList is cleared.
    */
    public void clearAll()
    {
    	this.pieces.clear();
    }  
    
    /**
    * <b>Accessor(selector):</b> returns all the pieces
    * <b>Postcondition:</b> all the pieces has been returned
    * @return all the pieces
    */
    public ArrayList<Piece> getPieces()
    {
        return this.pieces;
    }
    
    /**
    * <b>Accessor(selector):</b> returns the size of the arraylist pieces
    * <b>Postcondition:</b> returns the size of the arraylist pieces
    * @return the size of the arraylist pieces
    */
    public int size()
    {
    	return pieces.size();
    }
    
    /**
    * <b>Accessor(selector):</b> returns the piece at position i of the arraylist pieces
    * <b>Postcondition:</b> returns the piece at position i of the arraylist pieces
    * @return the piece at position i of the arraylist pieces
    */
    public Piece getPiece(int i)
    {
    	return pieces.get(i);
    }	
	
}
