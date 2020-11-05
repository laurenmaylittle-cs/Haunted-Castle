import java.util.List;
import java.util.Collections;

/**
 * Class Ghost
 * A ghost in the castle.
 * 
 * @author Olaf Chitil, Lauren Little
 * @version 6/2/2020
 */

public class Ghost extends Character
{
    private String description;
    /**
     * Constructor initialising location and description.
     * Pre-condition: location not null.
     * Pre-condition: description not null.
     */
    public Ghost(Room loc, String desc)
    {
        super(loc);
        assert loc != null :"Ghost.Ghost has null location";
        assert desc != null :"Ghost.Ghost has null description";
        description = desc;
    }

    /**
     * Return the description.
     * @return description of ghost
     */
    public String toString()
    {
        return description;
    }

    /**
     * Ghosts move to a random room.
     * @param rooms all rooms available
     * Pre-condition: the list is not empty.
     */
    public void goRandom(List<Room> rooms)
    {
        assert !(rooms.isEmpty()) :"Ghost.goRandom has null rooms";
        this.move(rooms.get((int) (Math.random() * rooms.size())));
    }
}
