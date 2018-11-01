/**
 * 
 */
package project5;

import CS2114.*;

/**
 * @author Goodwin Lu
 *         front-end GUI class
 */
public class GUIProjectWindow {
    // to get the item, use list.getData().get(key)
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
    // TO-DO: create class that sorts the songs
    static sortSongs ss;
    static representSurvey rs;


    public GUIProjectWindow() {
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

        legend = new Shape(550, 250, 50, 100);

        Button prev = new Button("<- Prev");
        window.addButton((prev), WindowSide.NORTH);
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
        Button next = new Button("Next ->");
        window.addButton(next, WindowSide.NORTH);
        next.onClick(this, "clickedNext");

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
            }
        }.start();
    }


    /**
     * visit next 9 genres
     * 
     * @param b
     *            next button
     */
    public void clickedNext(Button b) {
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
                rs.representHobby();
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
                rs.representMajor();
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
                rs.representRegion();
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
}
