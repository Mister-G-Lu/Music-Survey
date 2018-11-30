/**
 * 
 */
package project5;

import java.awt.Color;
import java.util.Random;
import CS2114.Shape;

/**
 * @author Goodwin Lu
 * @version 11/11/2018
 *          the heard and liked percent for each song, calculated in GUI, is
 *          stored here, then used to create the bars
 */
public class BarShape extends Shape {
    private Shape[] bars;
    private Shape divider;
    private String percent
    private int x;
    private int y;
    
    private int width;
    
    private final int BAR_HEIGHT = 10;

    // ~ Constructor
    /**
     * creates a new BarShape
     * 
     * @param percent
     *            hobby/major/region
     * @param startX
     *            start X
     * @param startY
     *            start Y
     * @param width
     *            width of bar
     */
    public Barshape(int percent, int startX, int startY, int w) 
    {
        this.percent = percent;
        x = startX;
        y = startY;
        width = w;
        bar = new Shape[8];
        
        divider = new Shape(0, 0, 5, BAR_HEIGHT * 4);
        divider.setX(x + (width - divider.getWidth()) / 2);
        divider.setY(y);
        divider.setForegroundColor(Color.BLACK);
        divider.setBackgroundColor(Color.BLACK);
        
        setUpBars();
    }

    /**
     * sets up the bar
     */
    private void setUpBars() 
    {
        for (int i = 0; i < 4; i++) 
                {
                   bars[i] = new Shape(0, 0, percent, BAR_HEIGHT);
                   bars[i + 4] = new Shape(0, 0, percent, BAR_HEIGHT);
                }

        }

        setCoordinate();
        
        for (int i = 0; i < 8; i++) 
        {
            bars[i].setForegroundColor(Color.WHITE);
        }
        
        bars[0].setBackgroundColor(Color.RED);
        bars[4].setBackgroundColor(Color.RED);
        bars[1].setBackgroundColor(Color.CYAN);
        bars[5].setBackgroundColor(Color.CYAN);
        bars[2].setBackgroundColor(Color.GREEN);
        bars[6].setBackgroundColor(Color.GREEN);
        bars[3].setBackgroundColor(Color.ORANGE);
        bars[7].setBackgroundColor(Color.ORANGE);
 
    }

    /**
     * Set bar's coordinate
     */
    private void setCoordinate() 
    {
        int ytemp = y;

        // Like
        for (int i = 0; i < 4; i++) 
        {
            bars[i].setX(divider.getX() - bars[i].getWidth());
            bars[i].setY(ytemp);
            ytemp += BAR_HEIGHT;
        }

        ytemp = y;

        // Heard
        for (int i = 0; i < 4; i++) 
        {
            bars[i + 4].setX(divider.getX() + divider.getWidth());
            bars[i + 4].setY(ytemp);
            ytemp += BAR_HEIGHT;
        }
    }

    /**
     * Get divider
     * 
     * @return divider
     */
    public Shape getDivider() 
    {
        return divider;
    }

    /**
     * Get the bar
     * 
     * @return bar
     */
    public Shape[] getBars() 
    {
        return bars;
    }
}
