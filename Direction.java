/**
 * A direction in the game.
 * There exist only a few different directions.
 * 
 * @author Olaf Chitil, Lauren Little
 * @version 13/2/2020
 */
public enum Direction
{
    NORTH("north"), 

    WEST("west"), 

    SOUTH("south"), 

    EAST("east"), 

    UP("up"), 

    DOWN("down");

    private String name; //name of direction

    /**
     * Constructor with parameter.
     * Pre-condition: name is not null.
     */
    private Direction(String name)
    {
        assert name != null : "Direction.Direction has null name";
        this.name = name;
        assert toString().equals(name) : "Direction.Direction produces wrong toString";
    }

    /**
     * Return the direction name.
     */
    public String toString()
    {
        return name;
    }
    
    /** 
     * Return the dual (opposite) of this direction.
     * @return the dual direction.
     */
    public Direction dual()
    {
        if(name.equals("south")){
            return NORTH;
        }
        else if(name.equals("north")){
            return SOUTH;
        }
        else if(name.equals("east")){
            return WEST;
        }
        else if(name.equals("west")){
            return EAST;
        }
        else if(name.equals("up")){
            return DOWN;
        }
        else if(name.equals("down")){
            return UP;
        }
        else{
            return null;
        }
    }
}
