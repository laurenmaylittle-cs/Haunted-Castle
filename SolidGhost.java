import java.util.List;
import java.util.LinkedList;
import java.util.Collections;
import java.util.ArrayList;
/**
 * Class SolidGhost
 * A solid ghost in the castle.
 * 
 * @author Olaf Chitil, Lauren Little
 * @version 13/2/2020
 */

public class SolidGhost extends Ghost
{
    /**
     * Constructor initialising location and description.
     * Pre-condition: location not null.
     * Pre-condition: description not null.
     */
    public SolidGhost(Room loc, String desc)
    {
        super(loc, desc);
        assert loc != null :"SolidGhost.SolidGhost has null location";
        assert desc != null :"SolidGhost.SolidGhost has null description";
    }
        
    /**
     * Go to a random neighbouring room.
     * If there is no neighbour, then stay in current room.
     * @param rooms all rooms available - actually ignored
     */
    public void goRandom(List<Room> rooms)
    {
        Room ghostLocation = this.getLocation();
        ArrayList<Room> canMove = new ArrayList<Room>();
        for(Direction direction : Direction.values()){
            Room exit = ghostLocation.getExit(direction);
            if(exit != null){
                canMove.add(exit);
            }
        }
        this.move(canMove.get((int) (Math.random()*canMove.size())));
    }
}
