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

    private static Random r = new Random();
    private int heardPercent;
    private int likedPercent;


    /**
     * constructor
     * 
     * @param s
     *            the song
     * @param h
     *            the left side (heard)
     * @param l
     *            the right side (liked)
     * 
     */
    public BarShape(int h, int l) {
        super(-h, l, 5, new Color(r.nextInt(255)));
        heardPercent = h;
        likedPercent = l;
    }


    /**
     * get heard
     * 
     * @return
     *         the heard percent
     */
    public int getHeard() {
        return heardPercent;
    }


    /**
     * get liked
     * 
     * @return
     *         liked percent
     */
    public int getLiked() {
        return likedPercent;
    }
}
