/**
 * Class DualGhost
 * A dual ghost in the castle. 
 * Changes the exits of the room to the opposite direction.
 * 
 * @author Olaf Chitil, Lauren Little
 * @version 13/2/2020
 */

public class DualGhost extends Ghost
{
    /**
     * Constructor initialising location and description.
     * Pre-condition: location not null.
     * Pre-condition: description not null.
     */
    public DualGhost(Room loc, String desc)
    {
        super(loc, desc);
        assert loc != null :"DualGhost.DualGhost has null location";
        assert desc != null :"DualGhost.DualGhost has null description";
        //dual exits of current locatuin
        loc.dual();
    }
    
    /**
     * Moves dual ghost to another room.
     * duals location of current room, moves ghost to another room, duals location of 
     * new room.
     */
    public void move(Room loc)
    {
        this.getLocation().dual();
        super.move(loc);
        this.getLocation().dual();
    }
}
