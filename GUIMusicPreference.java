package project5;

import project5.AllEnum.*;
import CS2114.*;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.Iterator;

/**
 * The class crates a window and showing the statistics of survey.
 * 
 * @author gengzelyu
 * @version 2018.11.29
 */
public class GUIMusicPreference {
    // data fields
    private static SongList songList;
    private static int windowHeight = 500;
    private static int windowWidth = 900;
    private static int midBarGap = 10;
    private static int midBarWidth = 5;
    private static int midBarHeight = windowHeight / 9;
    private int barBaseY = windowHeight / 9 + midBarGap;
    private int barBaseX = windowWidth / 9;
    private static int glyphWidthCoefficient = 1;
    private static int glyphHeight = midBarHeight / 4 + 1;
    private int pageIndex;
    private static SongList sortedListByTitle;
    private static SongList sortedListByArtist;
    private static SongList sortedListByYear;
    private static SongList sortedListByGenre;
    private static int legendWidth = 150;
    private static int legendGapToWindow = 5;
    private static int legendHeight = 300;
    private int legendLineWidth = 1;
    // window fields
    private Window window;
    private Button prevButton;
    private Button sortByArtistButton;
    private Button sortByTitleButton;
    private Button sortByYearButton;
    private Button sortByGenreButton;
    private Button nextButton;
    private Button repMajorButton;
    private Button repHobbyButton;
    private Button repRegionButton;
    private Button quitButton;
    private Shape leftGlyphBar;
    private Shape rightGlyphBar;
    // other fiels.
    private String currSortMode;
    private TextShape systemStateTextShape;
    /**
     * represent mode
     */
    private String currRepMode;


    /**
     * create a noew window naming Project 5
     * 
     * @param args
     *            string array that contains files name.
     *            [0] is survey file name, [1] is song list file name.
     */
    public GUIMusicPreference(String[] args) {
        initializeWindow();
        reportSystemState("loading");
        initializeData(args);
        reportSystemState("loaded");
    }


    /**
     * initialize window.
     */
    private void initializeWindow() {
        window = new Window("Project 5");
        window.setSize(windowWidth, windowHeight);
        prevButton = new Button("Previous");
        nextButton = new Button("Next");
        quitButton = new Button("Quit");
        sortByArtistButton = new Button("Sort By Artist");
        sortByTitleButton = new Button("Sort By Title");
        sortByYearButton = new Button("Sort By Year");
        sortByGenreButton = new Button("Sory By Genre");
        repRegionButton = new Button("Represent Region");
        repMajorButton = new Button("Represent Major");
        repHobbyButton = new Button("Represent Hobby");
        systemStateTextShape = new TextShape(0, 0, "");
        systemStateTextShape.setBackgroundColor(Color.WHITE);
        window.addShape(systemStateTextShape);
        window.addButton(prevButton, WindowSide.NORTH);
        window.addButton(nextButton, WindowSide.NORTH);
        window.addButton(sortByArtistButton, WindowSide.NORTH);
        window.addButton(sortByTitleButton, WindowSide.NORTH);
        window.addButton(sortByYearButton, WindowSide.NORTH);
        window.addButton(sortByGenreButton, WindowSide.NORTH);
        window.addButton(repMajorButton, WindowSide.SOUTH);
        window.addButton(repRegionButton, WindowSide.SOUTH);
        window.addButton(repHobbyButton, WindowSide.SOUTH);
        window.addButton(quitButton, WindowSide.SOUTH);
        centerSystemStateTextShape();
        initializeButtons();
    }


    /**
     * initialize buttons on the sindow.
     */
    private void initializeButtons() {
        systemStateTextShape.onClick(this, "clickedSystemState");
        prevButton.onClick(this, "clickedPrev");
        nextButton.onClick(this, "clickedNext");
        quitButton.onClick(this, "clickedQuit");
        sortByArtistButton.onClick(this, "clickedSortArtist");
        sortByTitleButton.onClick(this, "clickedSortTitle");
        sortByYearButton.onClick(this, "clickedSortYear");
        sortByGenreButton.onClick(this, "clickedSortGenre");
        repRegionButton.onClick(this, "clickedRepRegion");
        repMajorButton.onClick(this, "clickedRepMajor");
        repHobbyButton.onClick(this, "clickedRepHobby");
    }


    /**
     * initialize data fileds, create raw song list.
     * 
     * @param args
     *            string array that contains files name.
     *            [0] is survey file name, [1] is song list file name.
     */
    private void initializeData(String[] args) {
        pageIndex = 0;
        try {
            songList = new FilesScanner(args).getScannedSongList();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        currSortMode = "title";
        currRepMode = "hobby";
        sortedListByTitle = songList.getCopy();
        sortedListByTitle.insertSort(currSortMode);
    }


    /**
     * click on systemstate on center of window
     * 
     * @param text
     *            text shape
     */
    public void clickedSystemState(TextShape text) {
        nextButton.enable();
        sortByArtistButton.enable();
        sortByTitleButton.enable();
        sortByYearButton.enable();
        sortByGenreButton.enable();
        repMajorButton.enable();
        repHobbyButton.enable();
        repRegionButton.enable();
        updateShapes(currSortMode, currRepMode, null);
    }


    /**
     * click on button to sort artist
     * 
     * @param button
     *            clicked button
     */
    public void clickedSortArtist(Button button) {
        currSortMode = "artist";
        if (sortedListByArtist == null) {
            sortedListByArtist = songList.getCopy();
            sortedListByArtist.insertSort(currSortMode);
        }
        updateShapes(currSortMode, currRepMode, sortedListByArtist);
        disableSortRepButtons();
    }


    /**
     * click on button to sort year
     * 
     * @param button
     *            clicked button
     */
    public void clickedSortYear(Button button) {
        currSortMode = "year";
        if (sortedListByYear == null) {
            sortedListByYear = songList.getCopy();
            sortedListByYear.insertSort(currSortMode);
        }
        updateShapes(currSortMode, currRepMode, sortedListByYear);
        disableSortRepButtons();
    }


    /**
     * click on button to sort genre
     * 
     * @param button
     *            clicked button
     */
    public void clickedSortGenre(Button button) {
        currSortMode = "genre";
        if (sortedListByGenre == null) {
            sortedListByGenre = songList.getCopy();
            sortedListByGenre.insertSort(currSortMode);
        }
        updateShapes(currSortMode, currRepMode, sortedListByGenre);
        disableSortRepButtons();
    }


    /**
     * click on represent hobby button.
     * 
     * @param button
     *            button clicked.
     */
    public void clickedRepHobby(Button button) {
        currRepMode = "hobby";
        updateShapes(currSortMode, currRepMode, null);
        disableSortRepButtons();
    }


    /**
     * click on represent region button.
     * 
     * @param button
     *            button clicked.
     */
    public void clickedRepRegion(Button button) {
        currRepMode = "region";
        updateShapes(currSortMode, currRepMode, null);
        disableSortRepButtons();
    }


    /**
     * click on represent major button.
     * 
     * @param button
     *            button clicked.
     */
    public void clickedRepMajor(Button button) {
        currRepMode = "major";
        updateShapes(currSortMode, currRepMode, null);
        disableSortRepButtons();
    }


    /**
     * click on button to sort title
     * 
     * @param button
     *            clickedButton
     */
    public void clickedSortTitle(Button button) {
        currSortMode = "title";
        updateShapes(currSortMode, currRepMode, sortedListByTitle);
        disableSortRepButtons();
    }


    /**
     * click on the next button goes to next page.
     * 
     * @param button
     *            the button on window.
     */
    public void clickedNext(Widget button) {
        pageIndex += 1;
        if (pageIndex != 0) {
            prevButton.enable();
        }
        updateShapes(currSortMode, currRepMode, null);
        disableSortRepButtons();
    }


    /**
     * click on prev button will goes back to last page
     * 
     * @param button
     *            button clicked.
     */
    public void clickedPrev(Button button) {
        pageIndex -= 1;
        updateShapes(currSortMode, currRepMode, null);
        if (pageIndex == 0) {
            prevButton.disable();
        }
        disableSortRepButtons();
    }


    /**
     * click on quit button and exsit.
     * 
     * @param button
     *            clicked Button
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * update all newable shapes on window.
     * 
     * @param sortMode
     *            request sorting mode.
     * @param repMode
     *            request represent mode.
     * @param currSortedList
     * @param isNext
     *            is next button clicked.
     */
    private void updateShapes(
        String sortMode,
        String repMode,
        SongList currSortedList) {
        int beginIndex = pageIndex * 9;
        int endIndex = (pageIndex + 1) * 9;
        if (currSortedList == null) {
            currSortedList = getCurrentSortedList(sortMode);
        }
        SongList subSongList = currSortedList.getSubSongList(beginIndex,
            endIndex);
        window.removeAllShapes();
        glyphesDrawer(sortMode, repMode, subSongList);
        lengendDrawer();
        if (subSongList.getSize() < 9) {
            nextButton.disable();
        }
        else {
            nextButton.enable();
        }
    }


    /**
     * draw new lengend when sort and rep mode changes.
     */
    private void lengendDrawer() {
        // draw legend.
        window.addShape(new Shape(windowWidth - legendWidth - legendGapToWindow,
            window.getGraphPanelHeight() / 2, legendWidth, legendLineWidth,
            Color.BLACK));
        window.addShape(new Shape(windowWidth - legendGapToWindow, windowHeight
            - legendHeight, legendLineWidth, (window.getGraphPanelHeight()
                - legendGapToWindow) / 2, Color.BLACK));
        window.addShape(new Shape(windowWidth - legendWidth - legendGapToWindow,
            (window.getGraphPanelHeight() - legendGapToWindow) + 1, legendWidth,
            legendLineWidth, Color.BLACK));
        window.addShape(new Shape(windowWidth - legendGapToWindow - legendWidth,
            windowHeight - legendHeight, legendLineWidth, (window
                .getGraphPanelHeight() - legendGapToWindow) / 2, Color.BLACK));
        // add rep mode to window
        String currRepresentModeString = currRepMode.substring(0, 1)
            .toUpperCase() + currRepMode.substring(1);
        TextShape currRepresentModeText = new TextShape(0, 0,
            currRepresentModeString + " Legend");
        currRepresentModeText.setBackgroundColor(Color.WHITE);
        window.addShape(currRepresentModeText);
        currRepresentModeText.moveTo(windowWidth - legendWidth, window
            .getGraphPanelHeight() / 2);
        // draw represent mode.
        for (int i = 0; i < 4; i++) {
            TextShape sortModeText = new TextShape(0, 0, repModeTextHelper()[i],
                pickColor(i));
            sortModeText.setBackgroundColor(Color.WHITE);
            window.addShape(sortModeText);
            sortModeText.moveTo(windowWidth - legendWidth, window
                .getGraphPanelHeight() / 2 + sortModeText.getHeight() * (i
                    + 1));
        }
        // draw others.
        Shape legendMidBar = new Shape(window.getGraphPanelWidth() - legendWidth
            / 2, window.getGraphPanelHeight() - midBarHeight - 2
                * legendGapToWindow, midBarWidth, midBarHeight, Color.BLACK);
        window.addShape(legendMidBar);
        // legend title
        TextShape legendTitleText = new TextShape(0, 0, "Song Title");
        window.addShape(legendTitleText);
        legendTitleText.moveTo(window.getGraphPanelWidth() - legendWidth / 2
            - legendTitleText.getWidth() / 2, window.getGraphPanelHeight()
                - midBarHeight - 2 * legendGapToWindow - legendTitleText
                    .getHeight() * 2);
        legendTitleText.setBackgroundColor(Color.WHITE);
        // extra info.(sec line)
        TextShape legendTitleExtraInfoText = new TextShape(0, 0, currSortMode
            .substring(0, 1).toUpperCase() + currSortMode.substring(1));
        window.addShape(legendTitleExtraInfoText);
        legendTitleExtraInfoText.moveTo(window.getGraphPanelWidth()
            - legendWidth / 2 - legendTitleExtraInfoText.getWidth() / 2, window
                .getGraphPanelHeight() - midBarHeight - 2 * legendGapToWindow
                - legendTitleExtraInfoText.getHeight());
        legendTitleExtraInfoText.setBackgroundColor(Color.WHITE);
        // draw heard and like
        TextShape legendHeardText = new TextShape(0, 0, "Heard");
        window.addShape(legendHeardText);
        legendHeardText.moveTo(window.getGraphPanelWidth() - legendWidth / 2
            - legendHeardText.getWidth() - 5, window.getGraphPanelHeight()
                - midBarHeight - 2 * legendGapToWindow - legendHeardText
                    .getHeight() * 2 + midBarHeight - 2);
        legendHeardText.setBackgroundColor(Color.WHITE);
        TextShape legendLike = new TextShape(0, 0, "Likes");
        window.addShape(legendLike);
        legendLike.moveTo(window.getGraphPanelWidth() - legendWidth / 2 + 5,
            window.getGraphPanelHeight() - midBarHeight - 2 * legendGapToWindow
                - legendLike.getHeight() * 2 + midBarHeight - 2);
        legendLike.setBackgroundColor(Color.WHITE);
    }


    /**
     * helps legend to drawer current represent mode.
     * 
     * @return returns string array that conains 4 strings.
     */
    private String[] repModeTextHelper() {
        switch (currRepMode) {
            case "major":
                return new String[] { "Computer Science", "Other Engineering",
                    "Math / CMDA", "Other" };
            case "region":
                return new String[] { "North East US", "South East US",
                    "Rest of US", "Out of US" };
            default:
                return new String[] { "Read", "Art", "Sports", "Music" };
        }
    }


    /**
     * helps updates shape to find the current sorted list.
     * 
     * @param sortMode
     *            string current sorted mode,
     * @return returns songlist that is corresponding to sortmode.
     */
    private SongList getCurrentSortedList(String sortMode) {
        switch (sortMode) {
            case "artist":
                return sortedListByArtist;
            case "year":
                return sortedListByYear;
            case "genre":
                return sortedListByGenre;
            default:
                return sortedListByTitle;
        }
    }


    /**
     * draw glypes on window.
     * 
     * @param sortMode
     *            request sorting mode.
     * @param repMode
     *            request represent mode.
     * @param subSongList
     *            a sub song list based on page index.
     */
    private void glyphesDrawer(
        String sortMode,
        String repMode,
        SongList subSongList) {
        // small iterator.
        Iterator<Song> iter = subSongList.iterator();
        // first 2 iterate to draw the position of whole glyph on window.
        // each song is a glyph on window.
        for (int k : new int[] { 1, 3, 5 }) {
            for (int n : new int[] { 2, 4, 6 }) {
                // iter thorough list.
                if (iter.hasNext()) {
                    // current start x y positon in window
                    int x = barBaseX * n;
                    int y = barBaseY * k;
                    // midBar
                    window.addShape(new Shape(x, y, midBarWidth, midBarHeight,
                        Color.BLACK));
                    Song currSong = iter.next();
                    SurveyStat currStat = currSong.getSurveyStatistic();
                    // add text to above each glyph.
                    updateTextShapes(currSong, sortMode, repMode, x, y);
                    // draw smaller bars on window.
                    for (int i = 0; i < 4; i++) {
                        int leftBarWidth = glphyDrawerHelper(currStat, repMode,
                            i, true) * glyphWidthCoefficient;
                        int rightBarWidth = glphyDrawerHelper(currStat, repMode,
                            i, false) * glyphWidthCoefficient;
                        leftGlyphBar = new Shape(x - leftBarWidth, y + i
                            * glyphHeight, leftBarWidth, glyphHeight, pickColor(
                                i));
                        rightGlyphBar = new Shape(x, y + i * glyphHeight,
                            rightBarWidth, glyphHeight, pickColor(i));
                        window.addShape(leftGlyphBar);
                        window.addShape(rightGlyphBar);
                    }
                }
            }
        }
    }


    /**
     * update text shapes that show song info.
     * 
     * @param currSong
     *            current song drawing in winfow.
     * @param sortMode
     *            string sort mode.
     * @param repMode
     *            string represent mode.
     * @param x
     *            x position in window.
     * @param y
     *            y position in window.
     */
    private void updateTextShapes(
        Song currSong,
        String sortMode,
        String repMode,
        int x,
        int y) {
        String extraInfo;
        if (sortMode.equals("year")) {
            extraInfo = "on " + currSong.getYear();
        }
        else if (sortMode.equals("genre")) {
            extraInfo = "genre " + currSong.getGenre();
        }
        else {
            // if not specific, than it is artist.
            extraInfo = "by " + currSong.getArtist();
        }
        TextShape firstLine = new TextShape(0, 0, currSong.getTitle());
        TextShape secLine = new TextShape(0, 0, extraInfo);
        firstLine.setBackgroundColor(Color.WHITE);
        secLine.setBackgroundColor(Color.WHITE);
        window.addShape(firstLine);
        window.addShape(secLine);
        // move texts on the center of mid bar.
        firstLine.moveTo(x - firstLine.getWidth() / 2, y - firstLine.getHeight()
            * 2 - 5);
        secLine.moveTo(x - secLine.getWidth() / 2, y - secLine.getHeight() - 5);

    }


    /**
     * pick a good looling color based on index bar on window.
     * 
     * @param i
     *            index of number of bar on window.
     * @return returns a good looking color.
     */
    private Color pickColor(int i) {
        if (i == 3) {
            return new Color(173, 147, 189);
        }
        else if (i == 2) {
            return new Color(102, 176, 174);
        }
        else if (i == 1) {
            return new Color(112, 148, 180);
        }
        return new Color(165, 209, 232);
    }


    /**
     * help drawer to decide the width of a glphy by getting survey percentage.
     * 
     * @param stat
     *            current survey stat.
     * @param repMode
     *            current represent mode.
     * @param barIndex
     *            the nth bar in a glyph.
     * @param isHeard
     *            is called to want heard count or like count.
     * @return returns a int that represent percentage of bar width
     */
    private int glphyDrawerHelper(
        SurveyStat stat,
        String repMode,
        int barIndex,
        boolean isHeard) {
        int percentage;
        switch (repMode) {
            case "major":
                if (isHeard) {
                    percentage = stat.getPreffByMajorIndex(barIndex)
                        .getHeardPercent();
                }
                else {
                    percentage = stat.getPreffByMajorIndex(barIndex)
                        .getLikesPercent();
                }
                break;

            case "region":
                if (isHeard) {
                    percentage = stat.getPreffByRegionIndex(barIndex)
                        .getHeardPercent();
                }
                else {
                    percentage = stat.getPreffByRegionIndex(barIndex)
                        .getLikesPercent();
                }
                break;
            // case hobby
            default:
                if (isHeard) {
                    percentage = stat.getPreffByHobbyIndex(barIndex)
                        .getHeardPercent();
                }
                else {
                    percentage = stat.getPreffByHobbyIndex(barIndex)
                        .getLikesPercent();
                }
                break;
        }
        return percentage;
    }


    /**
     * center system state to the center of window.
     */
    private void centerSystemStateTextShape() {
        systemStateTextShape.moveTo(windowWidth / 2 - systemStateTextShape
            .getWidth() / 2, windowHeight / 2 - systemStateTextShape.getHeight()
                / 2);
    }


    /**
     * disable sort buttons based on current sort mode.
     */
    private void disableSortRepButtons() {
        switch (currSortMode) {
            case "artist":
                sortByArtistButton.disable();
                sortByGenreButton.enable();
                sortByYearButton.enable();
                sortByTitleButton.enable();
                break;
            case "year":
                sortByArtistButton.enable();
                sortByGenreButton.enable();
                sortByYearButton.disable();
                sortByTitleButton.enable();
                break;
            case "genre":
                sortByArtistButton.enable();
                sortByGenreButton.disable();
                sortByYearButton.enable();
                sortByTitleButton.enable();
                break;
            default:
                sortByArtistButton.enable();
                sortByGenreButton.enable();
                sortByYearButton.enable();
                sortByTitleButton.disable();
                break;
        }
        switch (currRepMode) {
            case "major":
                repMajorButton.disable();
                repHobbyButton.enable();
                repRegionButton.enable();
                break;
            case "region":
                repMajorButton.enable();
                repHobbyButton.enable();
                repRegionButton.disable();
                break;
            default:
                repMajorButton.enable();
                repHobbyButton.disable();
                repRegionButton.enable();
                break;
        }
    }


    /**
     * report the system state.
     * 
     * @param state
     *            the string system state.
     */
    private void reportSystemState(String state) {
        switch (state) {
            case "loading":
                systemStateTextShape.setText("System is loading...");
                prevButton.disable();
                nextButton.disable();
                sortByArtistButton.disable();
                sortByTitleButton.disable();
                sortByYearButton.disable();
                sortByGenreButton.disable();
                repMajorButton.disable();
                repHobbyButton.disable();
                repRegionButton.disable();
                centerSystemStateTextShape();
                break;
            case "loaded":
                systemStateTextShape.setText(
                    "System is loaded. Click HERE to start.");
                systemStateTextShape.setBackgroundColor(Color.LIGHT_GRAY);
                centerSystemStateTextShape();
                break;
        }
    }
}
