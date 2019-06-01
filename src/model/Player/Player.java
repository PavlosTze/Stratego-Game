package model.Player;

import model.Pieces.Piece;
import CollectionPieces.CollectionPieces;

/**
* Player class describes the characteristics of a player
* and provides modification methods. 
* @version 1.0
* @author Pavlos Tzegiannakis - csd3470
*/
public class Player {

    /**
    * This enum contains the colors of the teams
    */
    public static enum COLOR {
        RED,BLUE
    }

    private CollectionPieces remaining_pieces,lost_pieces;
    private String name;
    private COLOR team;
    private boolean lost;
    private int restored;

    /**
    * <b>constructor</b>: Constructs a new Player with the given
    * parameter name and team.
    * <b>postcondition</b>: Creates and initializes a player with the given
    * name and team.Also initializes some variables that give us information 
    * about the player's remaining and lost pieces, if he has lost 
    * and how many pieces he has restored
    * @param name is the name of the player.
    * @param team is the team of the player
    */
    public Player(String name, COLOR team) {
        setName(name);
        setTeam(team);
        this.remaining_pieces = new CollectionPieces();
        this.lost_pieces = new CollectionPieces();
        this.lost = false;
        restored = 0;
    }
	
    /**
    * <b>accessor(selector)</b>:Returns the name of the player
    * <b>Postcondition:</b> returns the name of the player
    * invariants name,team,lost,remaining_pieces,lost_pieces,restored
    * @return the the name of the player
    */
    public String getName()
    {
        return this.name;
    }

    /**
    * <b>transformer(mutative)</b>: sets the name of the player to newName
    * <b>Postcondition:</b> the name of this player is changed to newName
    * invariants team,lost,remaining_pieces,lost_pieces,restored
    * @param newName the new name of the player
    */
    public void setName(String newName) 
    {
        this.name = newName;
    }

    /**
     * <b>accessor(selector)</b>: Returns the team of a player.
     * <b>postcondition</b>: Returns the team of the player.
     * invariants name,team,lost,remaining_pieces,lost_pieces,restored
     * @return the team of the player (COLOR)
     */
    public COLOR getTeam()
    {
        return this.team;
    }

    /**
    * <b>transformer(mutative)</b>: It sets the team of a player
    * <b>precondition</b>: team = COLOR.RED OR team = COLOR.BLUE
    * <b>postcondition</b>:the team of the player is changed to team  
    * invariants name,lost,remaining_pieces,lost_pieces,restored
    * @param team the new team of the player
    */	
    public void setTeam(COLOR team) 
    {
        this.team = team;
    }
	
    /**
    * <b>Observer</b>:Returns if a player has lost
    * <b>Postcondition:</b> Returns if a player has lost
    * invariants name,team,lost,remaining_pieces,lost_pieces,restored
    * @return true if a player has lost, false otherwise
    */
    public boolean hasLost()
    {
        return lost;
    }
	
    /**
    * <b>transformer(mutative)</b>: set player's status as lost
    * <b>Postcondition:</b> lost = true player lost
    * invariants name,team,remaining_pieces,lost_pieces,restored
    */
    public void setLost() 
    {
        lost = true;
    }

    /**
     * <b>transformer(mutative)</b>: adds a piece to players remaining_pieces
     * <b>Postcondition:</b> a piece added to players remaining_pieces
     * invariants name,team,lost,lost_pieces,restored
     * @param piece the piece that will be added to players remaining_pieces
     */
    public void addPiece(Piece piece) 
    {
        remaining_pieces.addPiece(piece);
    }
	
    /**
    * <b>transformer(mutative)</b>: adds a piece to players lost_pieces
    * <b>Postcondition:</b> a piece added to players lost_pieces
    * invariants name,team,lost,playingPiece,remaining_pieces,restored
    * @param piece the piece that will be added to players lost_pieces
    */
    public void addLostPieces(Piece piece)
    {
        lost_pieces.addPiece(piece);
    }

    /**
    * <b>transformer(mutative)</b>: removes a piece to players remaining_pieces
    * <b>Postcondition:</b> a piece added to players remaining_pieces
    * invariants name,team,lost,playingPiece,restored,lost_pieces
    * @param piece the piece that will be added to players remaining_pieces
    */
    public void removeRemainingPieces(Piece piece)
    {
        remaining_pieces.removePiece(piece);
    }
	
    /**
    * <b>transformer(mutative)</b>: removes a piece to players lost_pieces
    * <b>Postcondition:</b> a piece added to players lost_pieces
    * invariants name,team,lost,playingPiece,restored,remaining_pieces
    * @param piece the piece that will be added to players lost_pieces
    */
    public void removeLostPieces(Piece piece)
    {
        lost_pieces.removePiece(piece);
    }
	
    /**
    * <b>accessor(selector)</b>: Returns the player's lost pieces.
    * <b>postcondition</b>: Returns the player's lost pieces.
    * invariants name,team,lost,remaining_pieces,remaining_pieces,lost_pieces,restored
    * @return the player's lost pieces.
    */
    public CollectionPieces getLostPieces()
    {
        return lost_pieces;
    }
	
    /**
    * <b>accessor(selector)</b>: Returns the player's remaining pieces.
    * <b>postcondition</b>: Returns the player's remaining pieces.
    * invariants name,team,lost,remaining_pieces,lost_pieces,restored
    * @return the player's remaining pieces.
    */
    public CollectionPieces getRemainingPieces()
    {
        return remaining_pieces;
    }
	
    /**
    * <b>accessor(selector)</b>: Returns the number of the player's restored pieces.
    * <b>postcondition</b>: Returns the number of the player's restored pieces.
    * invariants name,team,lost,remaining_pieces,lost_pieces,restored
    * @return the number of the player's restored pieces.
    */
    public int getRestored()
    {
        return this.restored;
    }
	
    /**
    * <b>transformer(mutative)</b>: increments by one the number of the player's restored pieces
    * <b>Postcondition:</b> increments by one the number of the player's restored pieces
    * invariants name,team,lost,playingPiece,remaining_pieces,restored
    */
    public void setRestored()
    {
        this.restored++;
    }
}
