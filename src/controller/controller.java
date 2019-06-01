package controller;

import model.Board.*;
import model.Pieces.*;
import model.Player.Player;
import model.Player.Player.COLOR;
import CollectionPieces.CollectionPieces;
import model.Turn.Turn;

/**
* Controller is the master of the game and controls all 
* of the operations executed
* @version 1.0
* @author Pavlos Tzegiannakis - csd3470
*/
public class controller {

    private Player P1,P2;
    private CollectionPieces allPieces = new CollectionPieces();
    private Board board;
    private boolean hasPiecePlayed;
    private Turn turn;
    private boolean gameOver;
    private Piece[] rescuers= new Piece[4];

    /**
    * <b>Constructor</b>
    * <b>Postcondition:</b> constructs a new controller,with 2 new players,new
    instances of Turn Class and CollectionPieces Class and initialize
    some int and boolean variables.So,is responsible for creating a new game
    and initializing it.
    */
    public controller() {
        P1 = new Player("Player 1", COLOR.RED);
        P2 = new Player("Player 2", COLOR.BLUE);
        turn = new Turn();
        gameOver = false;
        hasPiecePlayed = false;
        allPieces.init_pieces();
        init_player_pieces();
        board = new Board();
        setPiecesAtBoard();
    }

    /**
    * <b>transformer(mutative)</b>: set the pieces at the board at the starting positions
    * <p><b>Postcondition:</b> set the pieces at the board at the starting positions </p>
    * invariants: the gameOver,hasPiecePlayed,rescuers remain unchanged
    */ 
    public void setPiecesAtBoard()
    {
        int i;
        for(i=0; i<60;i++)
        {
            board.setPiece(allPieces.getPiece(i), allPieces.getPiece(i).getPosition());
        }
    }

    /**
    *<b>Observer</b>: Return true if the square at position i is empty, false otherwise
    * <p><b>Postcondition:</b> Return true if the square at position i is empty, false otherwise
    * invariants: hasPiecePlayed,rescuers remain unchanged
    * @param i the position of the square at the board
    * @return true if the square at position i is empty, false otherwise
    */
    public boolean isSquareEmpty(int i)
    {
        return board.isEmpty(i);
    }

    /**
     * <b>accessor(selector)</b>:Returns the board of the game
     * <p><b>Postcondition:</b> Returns the board of the game </p>
     * invariants: the gameOver,hasPiecePlayed,rescuers remain unchanged
     * @return the board of the game
     */
    public Board getBoard()
    {
        return board;
    }

    /**
    *<b>Observer</b>: Return true if the piece that player wanted to play , 
    * was finally played ,false otherwise
    * <p><b>Postcondition:</b> return true if the piece that player 
    * wanted to play , was finally played, false otherwise</p>
    * invariants: the gameOver,hasPiecePlayed,rescuers remain unchanged
    * @return true if the piece that player wanted to play , was finally played, false otherwise
    */
    public boolean hasPiecePlayed() 
    {
        return this.hasPiecePlayed;
    }

    /**
    * <b>transformer(mutative)</b>: set the status of hasPiecePlayed
    * <p><b>Postcondition:</b> set the status of hasPiecePlayed </p>
    * @param status the boolean status that will be assigned to hasPiecePlayed
    * invariants: the gameOver,hasPiecePlayed,rescuers remain unchanged
    */ 
    public void setPiecePlayed(boolean status) 
    {
        this.hasPiecePlayed = status;
    }

    /**
    * <b>accessor(selector)</b>:Returns which player(team) has the turn
    * <p><b>Postcondition:</b> Returns which player(team) has the turn </p>
    * invariants: the gameOver,hasPiecePlayed,rescuers remain unchanged
    * @return which player has the turn (for example RED if p1 has the turn, BLUE for p2 )
    */
    public COLOR getTurn() 
    {
        return turn.getTeam();
    }

    /**
    * <b>transformer(mutative)</b>: initialize which team has turn to play
    * <p><b>Postcondition:</b> initialize which team has turn to play </p>
    * invariants: the gameOver,hasPiecePlayed,rescuers remain unchanged
    */ 
    public void setTurn(COLOR team) 
    {
        turn.setTeam(team);
    }

    /**
    * <b>transformer(mutative)</b>: initializes player's pieces in the beginning
    * <p><b>Postcondition:</b> initializes player's pieces in the beginning </p>
 * invariants: the gameOver,hasPiecePlayed,rescuers remain unchanged
    */ 
    public void init_player_pieces()
    {
        for(int i = 0; i <30; i++)
        {
            P1.addPiece(allPieces.getPiece(i));
        }
        for(int i = 30; i <60; i++)
        {
            P2.addPiece(allPieces.getPiece(i));
        }
    }

    /**
    * <b>transformer(mutative)</b>: gets the Position of the selected Piece, the position of the destination, 
    * the enemy team of the playing piece and the type of the move for example if just moving, 
    * if attacking a stronger piece, if attacking a weaker piece or if the power of the 2 pieces is equal,
    * makes the move and change each player's remaining pieces and lost pieces in accordance to typeMove,
    * changes the position of the piece that has been played, make the necessary changes at the board
    * and last checks if the game is over or not
    * <p><b>Postcondition:</b> sets hasPiecePlayed to true if a piece has played and made the necessary changes 
    * at board, piece's position and each player's remaining and lost pieces and in some terms the gameOver variable</p>
    * invariants: the gameOver,hasPiecePlayed,rescuers remain unchanged
    */ 
    public void playPiece(int selectedPosition, int destinationPosition, COLOR enemy, int typeMove) 
    {
        Piece piecePlayed = this.getBoard().getPiece(selectedPosition);
        Piece pieceAtDestination = this.getBoard().getPiece(destinationPosition);
        switch (typeMove) {
            case 0: /* No piece was at destination */
                piecePlayed.setPosition(destinationPosition);
                this.getBoard().setPiece(piecePlayed, destinationPosition);
                break;
            case 1: /* Attacking an equal power piece */
                if(enemy == COLOR.RED){
                    P1.addLostPieces(piecePlayed);
                    P1.removeRemainingPieces(piecePlayed);
                    P2.addLostPieces(pieceAtDestination);
                    P2.removeRemainingPieces(pieceAtDestination);
                } else{
                    P1.addLostPieces(pieceAtDestination);
                    P1.removeRemainingPieces(pieceAtDestination);
                    P2.addLostPieces(piecePlayed);
                    P2.removeRemainingPieces(piecePlayed);
                }   
                pieceAtDestination.setDefeated(true);
                piecePlayed.setDefeated(true);
                this.getBoard().setEmpty(destinationPosition);
                break;
            case 2: /* Attacking a stronger piece */
                if(enemy == COLOR.RED){
                    P2.addLostPieces(piecePlayed);
                    P2.removeRemainingPieces(piecePlayed);
                    piecePlayed.setDefeated(true);
                } else{
                    P1.addLostPieces(piecePlayed);
                    P1.removeRemainingPieces(piecePlayed);
                    piecePlayed.setDefeated(true);
                }
                break;
            case 3: /* Attacking a weaker piece */
                if (enemy == COLOR.RED) {
                    P1.addLostPieces(pieceAtDestination);
                    P1.removeRemainingPieces(pieceAtDestination);
                    pieceAtDestination.setDefeated(true);
                    if (pieceAtDestination instanceof Flag) {
                        gameOver = true;
                        this.getPlayer(COLOR.BLUE).setLost();
                    }
                    this.getBoard().setEmpty(destinationPosition);
                } else {
                    P2.addLostPieces(pieceAtDestination);
                    P2.removeRemainingPieces(pieceAtDestination);
                    pieceAtDestination.setDefeated(true);
                    if (pieceAtDestination instanceof Flag) {
                        gameOver = true;
                        this.getPlayer(COLOR.RED).setLost();
                    }
                    this.getBoard().setEmpty(destinationPosition);
                }   
                this.getBoard().setPiece(piecePlayed, destinationPosition);
                break;
            default:
                break;
        }

        this.hasPiecePlayed = true;
        this.getBoard().setEmpty(selectedPosition);
    }


    /**
    * <b>transformer(mutative)</b>: restore a piece of a player after a piece of the same player
    * except Scout, has reached the opponent's base line, this method will be called from view Class, checks
    * if the piece that will restore another one has already restored one, and if it is false then it restores
    * the "choice" of the player and assigns the restored one at 1 of the 30 player's starting squares
    * <p><b>Precondition:</b> 
    * (1) choice != null
    * (2) the piece at rescuer_pos position hasn't already restored a piece
    * (3) the player (team) that will use restore has not restored already 2 pieces </p>
    * <p><b>Postcondition:</b> checks if restore can made and if true then 
    * make the necessary changes about the restore </p>
     * invariants: the gameOver,hasPiecePlayed, remain unchanged
    * @param team the team of the player that restores
    * @param choice the name of the piece that the user wants to restore
    * @param rescuer_pos the position of the piece that will be used to restore another one
    * @return the position of the square that the restored piece will be assigned
    */ 
    public int restorePiece(COLOR team, String choice, int rescuer_pos)
    {
        Board currentBoard = this.getBoard();
        Piece rescuerPiece = currentBoard.getPiece(rescuer_pos);
        
        for(int i = 0; i < 4; i++)
        {
            if(rescuers[i] == null && choice != null){
                rescuers[i] = rescuerPiece;
                break;
            }
        }

        if(!(rescuers[0] == rescuerPiece || rescuers[1] == rescuerPiece || rescuers[2] == rescuerPiece || rescuers[3] == rescuerPiece)) {
            int PositionForRestore = -1;
            if(team == COLOR.RED){
                for(int i = 50; i<80; i++)
                {
                    if(currentBoard.isEmpty(i)){
                        PositionForRestore = i;
                        break;
                    }
                }
            } else {
                for(int i = 0; i < 30; i++)
                {
                    if(currentBoard.isEmpty(i)){
                        PositionForRestore = i;
                        break;
                    }
                }
            }

            if(PositionForRestore >= 0){
                if(team == COLOR.RED){
                    for(int i = 0; i<P1.getLostPieces().getPieces().size();i++)
                    {
                        if(choice != null && P1.getLostPieces().getPiece(i).getClass().getSimpleName().contains(choice)){		
                            currentBoard.setPiece(P1.getLostPieces().getPiece(i), PositionForRestore);
                            currentBoard.getPiece(PositionForRestore).setPosition(PositionForRestore);
                            P1.addPiece(P1.getLostPieces().getPiece(i));
                            P1.removeLostPieces(P1.getLostPieces().getPiece(i));
                            P1.setRestored();
                            return PositionForRestore;
                        }
                    }
                } else {
                    for(int i = 0; i<P2.getLostPieces().getPieces().size();i++)
                    {
                        if(choice != null && P2.getLostPieces().getPiece(i).getClass().getSimpleName().contains(choice)){
                            currentBoard.setPiece(P2.getLostPieces().getPiece(i), PositionForRestore);
                            currentBoard.getPiece(PositionForRestore).setPosition(PositionForRestore);
                            P2.addPiece(P2.getLostPieces().getPiece(i));
                            P2.removeLostPieces(P2.getLostPieces().getPiece(i));
                            P2.setRestored();
                            return PositionForRestore;
                        }
                    }
                }
            }

        }
        return -1;
    }
	    
    /**
    *<b>Observer</b>: Return true if the game is over based on the conditions
    *that terminate a game, false otherwise
    * <p><b>Postcondition:</b> Return true if the game is over based on the conditions
    *that terminate a game, false otherwise
    * invariants: hasPiecePlayed,rescuers remain unchanged
    * @return true if the game is over, false otherwise
    */
    public boolean game_has_finished()
    {
    	boolean moveablePiecesLeft = false;
    	for(int i = 0; i<P1.getRemainingPieces().size(); i++)
    	{
            if(P1.getRemainingPieces().getPiece(i).getRank() > 0) {
                moveablePiecesLeft = true;
            }
    	}
    	if(!moveablePiecesLeft) {
            P1.setLost();
        }
    	
    	moveablePiecesLeft = false;
    	for(int i = 0; i<P2.getRemainingPieces().size(); i++)
    	{
            if(P2.getRemainingPieces().getPiece(i).getRank() > 0) {
                moveablePiecesLeft = true;
            }
    	}
    	if(!moveablePiecesLeft) {
            P2.setLost();
        }
        
        if(P1.hasLost() || P2.hasLost()){
            gameOver = true;
        }
        
    	return gameOver;
    }

    
    /**
    * <b>accessor(selector)</b>:Returns the player based on the team
    * <p><b>Postcondition:</b> Returns the player based on the team </p>
    * invariants: the gameOver,hasPiecePlayed,rescuers remain unchanged
    * @param team shows which player is, RED for P1, BLUE for P2 
    * @return the player based on the team
    */
    public Player getPlayer(COLOR team)
    {
    	if(COLOR.BLUE == team) {
            return P2;
        }
        else {
            return P1;
        }
    }
    
    /**
    *<b>Observer</b>: Return true if the piece that will be used to rescue another one
    * has already rescued one, false otherwise
    * <p><b>Postcondition:</b> Return true if the piece that will be used to rescue another one
    * has already rescued one, false otherwise
    * invariants: hasPiecePlayed,rescuers remain unchanged
    * @param rescuer_pos the position of the rescuer at the board
    * @return true if the piece that will be used to rescue another one
    * has already rescued one, false otherwise
    */
    public boolean hasRestored(int rescuer_pos)
    {
    	for(int k = 0; k < 4; k++)
    	{
            if(this.getBoard().getPiece(rescuer_pos) == rescuers[k]) {
                return true;
            }
    	}
    	return false;
    }
}
