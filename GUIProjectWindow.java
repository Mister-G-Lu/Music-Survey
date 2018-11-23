/**
 * 
 */
package project5;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import CS2114.*;

/**
 * @author Goodwin Lu
 * @version 11/11/2018
 *          front-end GUI class. Contains 9 shapes and 8 buttons.
 */
@SuppressWarnings("serial")
public class GUIProjectWindow extends JPanel {
    // to get the item, use listName.getData()[index]
    // use counting variable to keep track of which song we're on
    private int count = 0;
    private Window window;
    private Shape topleft;
    private Shape top;
    private Shape topright;
    private Shape left;
    private Shape mid;
    private Shape right;
    private Shape downleft;
    private Shape down;
    private Shape downright;
    private Shape legend;

    private TextShape toplefttext;
    private TextShape toptext;
    private TextShape toprighttext;
    private TextShape lefttext;
    private TextShape midtext;
    private TextShape righttext;
    private TextShape downlefttext;
    private TextShape downtext;
    private TextShape downrighttext;
    private TextShape legendtext;
    private Button prev;
    private Button next;
    // allSongs contains: artist, title, year, genre, and a LinkedList of the
    // people and their opinions on that specific song
    private SortedList<T[]> allSongs;
    // use fs to access the list of people
    private FileScanner fs;
    // count which song we're on.
    private int count = 0;
    static SortSongs ss;
    private RepresentSurvey rs;
    private double[] heard;
    private double[] liked;


    /**
     * default constructor.
     */
    public GUIProjectWindow() {
        // create all the 9 basic shapes and the window
        window = new Window("Project 5");
        // x, y, width, height
        topleft = new Shape(50, 50, 100, 50);
        left = new Shape(50, 150, 100, 50);
        downleft = new Shape(50, 250, 100, 50);

        top = new Shape(275, 50, 100, 50);
        mid = new Shape(275, 150, 100, 50);
        down = new Shape(275, 250, 100, 50);

        topright = new Shape(475, 50, 100, 50);
        right = new Shape(475, 150, 100, 50);
        downright = new Shape(475, 250, 100, 50);

        legend = new Shape(550, 250, 50, 100, Color.WHITE);

        // create the top buttons
        prev = new Button("<- Prev");
        window.addButton((prev), WindowSide.NORTH);
        prev.disable();
        prev.onClick(this, "clickedPrev");
        Button art = new Button("Sort by Artist Name");
        window.addButton(art, WindowSide.NORTH);
        art.onClick(this, "clickedArtist");
        Button title = new Button("Sort by Song Title");
        window.addButton(title, WindowSide.NORTH);
        title.onClick(this, "clickedTitle");
        Button year = new Button("Sort by Release Year");
        window.addButton(year, WindowSide.NORTH);
        year.onClick(this, "clickedYear");
        Button g = new Button("Sort by Genre");
        window.addButton(g, WindowSide.NORTH);
        g.onClick(this, "clickedGenre");
        next = new Button("Next ->");
        window.addButton(next, WindowSide.NORTH);
        next.onClick(this, "clickedNext");

        // create the bottom buttons
        Button rh = new Button("Represent Hobby");
        window.addButton(rh, WindowSide.SOUTH);
        rh.onClick(this, "clickedHobby");
        Button m = new Button("Represent Major");
        window.addButton(m, WindowSide.SOUTH);
        m.onClick(this, "clickedMajor");
        Button r = new Button("Represent Region");
        window.addButton(r, WindowSide.SOUTH);
        r.onClick(this, "clickedRegion");
        Button q = new Button("Quit");
        window.addButton(q, WindowSide.SOUTH);
        r.onClick(this, "quit");

        rs = new RepresentSurvey(allSongs);
        fs = new FileScanner();
    }


    /**
     * display the "Title by band" format
     * 
     * @param which
     *            the song we're obtaining
     * @return
     *         the string
     */
    public String display(int which) {
        return allSongs.get(which)[0] + " by " + allSongs.get(which)[1];
    }


    /**
    * update the GUI to match the 9 songs
    */
    public void update(){
    toplefttext.setText(display(count));
    toptext.setText(display(count+1));
    toprighttext.setText(display(count+2));
    lefttext.setText(display(count+3));
    midtext.setText(display(count+4));
    righttext.setText(display(count+5));
    downlefttext.setText(display(count+6));
    downtext.setText(display(count+7));
    downrighttext.setText(display(count+8));
          //TO-DO: LEGEND METHOD STUB
        for (int i = 0; i < 27; i++) {
            //TO-DO: Update BarShape to heard/liked percentages
            BarShape index = new BarShape(50, 50);
            window.addShape(index);
            if (i < 2) {
                moveBar(index, Position.TOPLEFT);
            }
            else if (i < 5) {
                moveBar(index, Position.TOP);
            }
            else if (i < 8) {
                moveBar(index, Position.TOPRIGHT);
            }
            else if (i < 11) {
                moveBar(index, Position.LEFT);
            }
            else if (i < 14) {
                moveBar(index, Position.MIDDLE);
            }
            else if (i < 17) {
                moveBar(index, Position.RIGHT);
            }
            else if (i < 20) {
                moveBar(index, Position.DOWNLEFT);
            }
            else if (i < 23) {
                moveBar(index, Position.DOWN);
            }
            else {
                moveBar(index, Position.DOWNRIGHT);
            }
        }
    }


    /**
     * sleep method
     */
    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }


    /**
     * visit previous 9 nodes
     * 
     * @param b
     *            previous button
     */
    public void clikedPrev(Button b) {
        next.enable();
        if (count - 9 < 0)
            // can't go to previous anymore
        {b.disable();
         count = 0;
        }
        else{
            count - = 9;
        }
         update();
        b.disable();
    }


    /**
     * sort by artist
     * 
     * @param b
     *            artist button
     */
    public void clickedArtist(Button b) {
        b.disable();
        new Thread() {
            public void run() {
                ss.sortArtists();
                update();
            }
        }.start();
    }


    /**
     * sort by title
     * 
     * @param b
     *            title button
     */
    public void clickedTitle(Button b) {
        b.disable();
        new Thread() {
            public void run() {
                ss.sortTitles();
                update();
            }
        }.start();
    }


    /**
     * sort by year
     * 
     * @param b
     *            year button
     */
    public void clickedYear(Button b) {
        b.disable();
        new Thread() {
            public void run() {
                ss.sortYears();
                update();
            }
        }.start();
    }


    /**
     * sort by genre
     * 
     * @param b
     *            genre button
     */
    public void clickedGenre(Button b) {
        b.disable();
        new Thread() {
            public void run() {
                ss.sortGenres();
                update();
            }
        }.start();
    }


    /**
     * visit next 9 songs
     * 
     * @param b
     *            next button
     */
    public void clickedNext(Button b) {
        prev.enable();
        if (count + 9 >allSongs.size())
            // can't go to next anymore
        {b.disable();
         count = allSongs.size();
        }
        else{
            count + = 9;
        }
            update();
        b.disable();
    }


    /**
     * represent by hobby
     * 
     * @param b
     *            hobby button
     */
    public void clickedHobby(Button b) {
        b.disable();
        new Thread() {
            public void run() {
                legendtext.setText(
                    "Hobby Legend \n Read \n Art \n Sports \n Music \n Song Title");
                rs.representHobby();
                update();
            }
        }.start();
    }


    /**
     * represent by major
     * 
     * @param b
     *            major button
     */
    public void clickedMajor(Button b) {
        b.disable();
        new Thread() {
            public void run() {

                legendtext.setText(
                    "Major Legend \n Comp Sci \n Other Eng \n Math/CMDA \n Other \n Song Title");
                rs.representMajor();
                update();
            }
        }.start();
    }


    /**
     * represent by region
     * 
     * @param b
     *            region button
     */
    public void clickedRegion(Button b) {
        b.disable();
        new Thread() {
            public void run() {

                legendtext.setText(
                    "Region Legend \n Northeast US \n Southeast US \n the rest of US \n outside the US");
                rs.representRegion();
                update();
            }
        }.start();
    }


    /**
     * quit
     * 
     * @param b
     *            quit button
     */
    public void quit(Button b) {
        b.disable();
        new Thread() {
            public void run() {
                System.exit(0);
            }
        }.start();
    }


    /**
     * move the barShape to the GUI position (left, middle, right)
     * 
     * @param p
     *            the position
     */
    private void moveBar(BarShape bar, Position p) {
        Shape currentPole = null;
        if (p == Position.TOPLEFT) {
            currentPole = topleft;
        }
        if (p == Position.TOP) {
            currentPole = top;
        }
        if (p == Position.TOPRIGHT) {
            currentPole = topright;
        }
        if (p == Position.LEFT) {
            currentPole = left;
        }
        if (p == Position.MIDDLE) {
            currentPole = mid;
        }
        if (p == Position.RIGHT) {
            currentPole = right;
        }

        if (p == Position.DOWNLEFT) {
            currentPole = downleft;
        }

        if (p == Position.DOWN) {
            currentPole = down;
        }

        if (p == Position.DOWNRIGHT) {
            currentPole = downright;
        }
        bar.moveTo(currentPole.getX(), currentPole.getY());

    }
}
