import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *  This class is the central class of the "Haunted Castle" application. 
 *  "Haunted Castle" is a very simple, text based game.  Users 
 *  can walk around some castle. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 * @author  Lauren Little, Michael Kölling, David J. Barnes and Olaf Chitil
 * @version 6/2/2020
 */

public class Game 
{
    private boolean finished; //whether game is finished or not
    private Player player;
    private int time = 0; //no moves have been made
    private ArrayList<Ghost> ghosts =new ArrayList<>(); //stores all ghost characters
    private ArrayList<Room> rooms= new ArrayList<>(); //stores all rooms
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        finished = false;
        player = createScenario();

    }

    /**
     * Create all the rooms and link their exits together.
     */
    private Player createScenario()
    {
        Room gate, hall, greatHall, staircase, kitchen, chapel, hall2, 
        toilet, bedroom, dungeon;
        
        Ghost lady, headless, skeleton, jack;
               
        // create the rooms
        gate = new Room("at the main gate");
        hall = new Room("in the entrance hall");
        greatHall = new Room("in the great hall");
        staircase = new Room("at the staircase");
        kitchen = new Room("in the kitchen");
        chapel = new Room("in the chapel");
        hall2 = new Room("in the upper hall");
        toilet = new Room("in the toilet");
        bedroom = new Room("in the bedroom");
        dungeon = new Room("in the dungeon");
        
        // initialise room exits
        gate.setExit(Direction.NORTH, hall);
        hall.setExit(Direction.SOUTH, gate);
        hall.setExit(Direction.NORTH, staircase);
        hall.setExit(Direction.WEST, kitchen);
        hall.setExit(Direction.EAST, greatHall);
        kitchen.setExit(Direction.EAST, hall);
        greatHall.setExit(Direction.WEST, hall);
        greatHall.setExit(Direction.SOUTH, chapel);
        chapel.setExit(Direction.NORTH, greatHall);
        staircase.setExit(Direction.SOUTH, hall);
        staircase.setExit(Direction.DOWN, dungeon);
        dungeon.setExit(Direction.UP, staircase);
        staircase.setExit(Direction.UP, hall2);
        hall2.setExit(Direction.DOWN, staircase);
        hall2.setExit(Direction.SOUTH, toilet);
        toilet.setExit(Direction.NORTH, hall2);
        hall2.setExit(Direction.WEST, bedroom);
        bedroom.setExit(Direction.EAST, hall2);
        
        //add all rooms to arraylist
        rooms.add(gate);
        rooms.add(hall);
        rooms.add(kitchen);
        rooms.add(greatHall);
        rooms.add(chapel);
        rooms.add(staircase);    
        rooms.add(dungeon);
        rooms.add(hall2);
        rooms.add(bedroom);
        
        //this will create ghosts
        skeleton = new Ghost(gate, "skeleton");
        headless = new Ghost(staircase, "headless");
        lady = new DualGhost(gate, "lady");
        jack = new SolidGhost(kitchen, "jack");
        
        //add all instances of Ghosts to list
        ghosts.add(skeleton);
        ghosts.add(headless);
        ghosts.add(lady);
        ghosts.add(jack);      
        
        return new Player(gate, bedroom);
        //starts at gate and game ends at bedroom
    }

    /**
     * Return the player object.
     */
    public Player getPlayer()
    {
        return player;
    }
    
    /**
     * Return whether the game has finished or not.
     */
    public boolean finished()
    {
        return finished;
    }

    /**
     * Opening message for the player.
     */
    public String welcome()
    {
        return "\nWelcome to the Haunted Castle!\n" +
        "Haunted Castle is a new game.\n" +
        player.getLocation().getLongDescription() + "\n";
    }

        /**
     * Give some help information.
     */
    public String help() 
    {
        return "You are lost. You are alone. You wander around the castle.\n";
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room and return its long description; otherwise return an error message.
     * @param direction The direction in which to go.
     * Pre-condition: direction is not null.
     */
    public String goRoom(Direction direction) 
    {
        assert direction != null : "Game.goRoom gets null direction";

        // Try to leave current room.
        Room nextRoom = player.getLocation().getExit(direction);
        String output;
        if (nextRoom == null) {
            return "There is no exit in that direction!";
        }
        else{
            //ghosts moving randomly
            for (Ghost g : ghosts){
                g.goRandom(rooms);
            }
            player.move(nextRoom);
            //increasing time
            time ++;
            output = player.getLocation().getLongDescription();
            //checks to see if player has won the game 
            if (player.isAtGoal() == false){
                //checks to see if player has reached time limit
                if (player.isAtTimeLimit(time)){
                    finished = true;
                    output += "\nLost! You ran out of time.";
    
                }
                else{
                    return player.getLocation().getLongDescription();
                }
            }
            else{
                finished = true;
                output += "\nCongratulations! You reached the goal.";
          
            }
            output +="\nThank you for playing.  Good bye.";
            return output;
        }

    }

    /**
     * Execute quit command.
     */
    public String quit()
    {
        finished = true;
        return "Thank you for playing.  Good bye.";
    }
   
    
    /**
     * Execute look command.
     * @return long description of current location
     */
    public String look()
    {
        Room currentRoom = player.getLocation();
        return currentRoom.getLongDescription();
    }
}
