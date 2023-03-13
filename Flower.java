import ecs100.*;
import java.awt.Color;
/**
 * FLower support class
 * creates a flower of a size and colour
 * it can grow
 * it can tell the driver class where it is on the screen
 *
 * @author (Phoebe WIlliamson)
 * @version (13/3/23)
 */
public class Flower
{
    // instance variables - replace the example below with your own
    private double flowerX ;       // x position of flower
    private double flowerY;        // y position of flower
    
    private int flowerSize;        // flower size
    private int flowerHeight;      // flower height
    
    private double left;          // left of flower
    private double top;            // top of flower
    private double bottom;         // bottom of flower
    
    private Color color;           // Color of flower

    /**
     * Constructor for objects of class Flower
     */
    public Flower(double x, double y, int size, int stem, Color col)
    {
        // initialise instance variables
        flowerX = x;
        flowerY = y;
        flowerSize = size;
        flowerHeight = stem;
        color = col;
        
        // set the top, left and bottom 
        setTop();
        setLeft();
        setBottom();
        
    }
    
    /**
     * getter left
     */
    public double getLeft() {
        return this.left;
    }
    
    /**
     * getter right
     */
    public double getRight() {
        return this.left + this.flowerSize;
    }
    
    /**
     * get top
     */
    public double getTop() {
        return this.top;
    }
    
    /**
     * get bottom
     */
    public double getBottom(){
        return this.bottom;
    }
    
    public void setLeft() {
        this.left = this.flowerX - this.flowerSize/2.0;
    }
    
    /**
     * set top
     */
    public void setTop() {
        this.top = this.flowerY - this.flowerSize/2.0;
    }
    
    /**
     * set bottom
     */
    public void setBottom() {
        this.bottom = this.flowerY + this.flowerHeight;
    }
    
    /**
     * draw the flower in the canvas
     */
    public void draw() {
        final int STEMWIDTH = 2;
        final int WAITTIME = 500;
        // draw stem
        UI.setColor(Color.green);    // set color of the stem
        UI.setLineWidth(STEMWIDTH);  // set width of the stem
        UI.drawLine(flowerX, flowerY, flowerX, bottom);  // draw in stem
        
        // draw flower
        UI.setColor(this.color); // set color of the flower
        UI.fillOval(left, top, flowerSize, flowerSize); // draw the flower
        UI.sleep(WAITTIME);    //wait
        
    }
    
    /**
     * erase a rectangle around the surrent instance
     */
    public void erase() {
        final int BUFFER = 1;
        UI.eraseRect(left, top, flowerSize+1, bottom+1);
    }
    
    /**
     * make the flower grow
     */
    public void grow() {
        final int GROWSIZE = 10;
        this.erase();   // erase the flower
        this.flowerY -=10;  // increase folwer height
        this.flowerSize +=10;   // increase the size of the bulb
        
        // set new position
        this.setTop();
        this.setLeft();
        this.draw();
    }
    
}
