import ecs100.*;
import java.awt.Color;
/**
 * create a garden with each flower obj in an array
 * click on the flower and make it grow
 *
 * @author (Phoebe Williamson)
 * @version (14/3/23)
 */
public class ClickGarden
{
    // fields
    private static int STARTX = 75;
    private static int YPOS = 100;
    private static int MAXFLOWERS = 5;

    // make an array of flowers
    private Flower[] flowerBed = new Flower[MAXFLOWERS];    // initailise array
    
    /**
     * Constructor for objects of class ClickGarden
     */
    public ClickGarden()
    {
        // initialise instance variables
        UI.initialise();
        UI.addButton("Quit", UI::quit);
        
        // set up the flowers 
        for (int i = 0; i < MAXFLOWERS; i++) {
            // draw each flower
            Color col = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
            flowerBed[i] = new Flower(STARTX*(i+1), YPOS, 10, 50, col);     // create the flower obj in the array
        }
        
        // draw each flower
        for (Flower flower : flowerBed) {
            flower.draw();
        }
    }
}
