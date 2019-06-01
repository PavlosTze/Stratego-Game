package model.Turn;

import model.Player.Player.COLOR;

/**
* This class represents the turn of the game
* @version 1.0
* @author Pavlos Tzegiannakis - csd3470
*/
public class Turn {
	
    private COLOR team;
	 
    /**  Constructor.
    * <b>Postcondition</b>Creates a new instance of Turn with starting team = RED, 
    */
    public Turn()
    {
        this.team = COLOR.RED;
    }
	
	   
    /**
    * <b>Transformer(Mutative):</b> Sets the player's(team) turn.(which player has the turn to play)
    * <b>Precondition:</b> team = COLOR.RED OR team = COLOR.BLUE
    * <b>Postcondition:</b> Player's(team) turn has been set.
    * @param team
    */
    public void setTeam(COLOR team)
    {
        this.team = team;
    }
	
    /**
    * <b>Accessor(Selector):</b> returns team(player) whose turn is to play
    * <b>Postcondition:</b> returns the team(player) whose turn is to play
    * invariants: team
    * @return the team(player) whose turn is to play
    */
    public COLOR getTeam()
    {
        return this.team;
    }
}
