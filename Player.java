/**
 * Class Player
 * A single object represents the single player.
 * 
 * @author Olaf Chitil, Lauren Little
 * @version 6/2/2020
 */

public class Player extends Character
{
    private Room goal; //room that player needs to get to in order to win
    /**
     * Constructor, taking start room and goal room.
     * Pre-condition: start location is not null.
     */
    public Player(Room start, Room goal)
    {
        super(start);
        assert start != null :"DualGhost.DualGhost has null start location";
        this.goal = goal;
    }
    
    /**
     * Check whether time limit has been reached.
     * @param time The current count of movements
     * @return true If player has reached time limit
     * @return false If player still has moves left
     */
    public boolean isAtTimeLimit(int time)
    {
        int limit = 12;
        if (limit == time){
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Check whether goal has been reached.
     * @return returns true if player has reached end room.
     * @return false if player hasn't reached goal.
     */
    public boolean isAtGoal()
    {
        if (getLocation().getShortDescription() == goal.getShortDescription()){
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Return a description.
     */
    public String toString()
    {
        return "you";
    }
}
