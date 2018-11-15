package project5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * scan files and record data.
 * 
 * @author gengzelyu
 * @version 2018.11.14
 */
public class FilesScanner {

    private SortedList<String> allSongData;
    private String rootLocation;
    private String surveyName;


    public FilesScanner() {

        allSongData = new SortedList<String>();
    }


    /**
     * scan files and add data to list.
     * 
     * @param surveyName
     *            file name of survey data.
     * @param songListName
     *            file name of song list data.
     * @throws FileNotFoundException
     *             throw exception if file is not found.
     * @return returns list contians all songs' data.
     */
    public void scanFiles(String surveyName, String songListName)
        throws FileNotFoundException {
        // save it for resetter.
        this.surveyName = surveyName;
        // files location. change this or comment out on different pc.
        rootLocation = "/Users/gengzelyu/Desktop/CS 2114/Project5/InputFiles/";
        Exception thrown = null;
        try {
            Scanner surveyData = new Scanner(new File(rootLocation
                + surveyName));
            Scanner songListData = new Scanner(new File(rootLocation
                + surveyName));
        }
        catch (FileNotFoundException e) {
            thrown = e;
        }
        if (thrown != null) {
            throw new FileNotFoundException();
        }
        Scanner surveyData = new Scanner(new File(rootLocation + surveyName));
        Scanner songListData = new Scanner(new File(rootLocation
            + songListName));
        listCreator(surveyData, songListData);
    }


    /**
     * create list from scanner files.
     * 
     * @param surveyData
     *            survey scanner.
     * @param songListData
     *            song list scanner.
     * @throws FileNotFoundException
     */
    private void listCreator(Scanner surveyData, Scanner songListData)
        throws FileNotFoundException {
        // get song info.
        // skip first line.
        Scanner localSurveyData = surveyData;
        surveyData.nextLine();
        songListData.nextLine();
        // song index in the song list.
        int songIndex = 1;
        while (songListData.hasNextLine()) {
            ArrayList<Object> newSong = songListScanner(songListData);
            // get survey info under one line in song list.
            while (localSurveyData.hasNextLine()) {
                Person newPerson = surveyScanner(localSurveyData, songIndex);
                newSong.add(newPerson);
            }
            // reset survey scanner.
            localSurveyData = resetSurveyScanner();
            allSongData.add(newSong);
            songIndex++;
        }

    }


    /**
     * reset survey file scanner.
     * 
     * @throws FileNotFoundException
     * @return returns new scanner.
     */
    private Scanner resetSurveyScanner() throws FileNotFoundException {
        Scanner surveyData = new Scanner(new File(rootLocation + surveyName));
        surveyData.nextLine();
        return surveyData;
    }


    /**
     * scan song list file and create song array.
     * 
     * @param songListData
     *            song list scanner.
     * @return returns an array storing song info.
     */
    private ArrayList<Object> songListScanner(Scanner songListData) {
        // cant use scanner cause a line is not seperated by space.
        String[] aLine = songListData.nextLine().split(",");
        String title = aLine[0];
        String albums = aLine[1];
        String year = aLine[2];
        String genre = aLine[3];

        ArrayList<Object> aSong = new ArrayList<Object>();
        aSong.add(title);
        aSong.add(albums);
        aSong.add(year);
        aSong.add(genre);
        return aSong;
    }


    /**
     * scan survey file and create a person class.
     * 
     * @param surveyData
     *            surey data scanner.
     * @return returns new person class that storing person info.
     */
    private Person surveyScanner(Scanner surveyData, int songIndex) {
        String[] aLine = surveyData.nextLine().split(",");
        // skip first 2 index and date.

        String major = aLine[2];
        String region = aLine[3];
        String hobby = aLine[4];
        Person newPerson = new Person(major, region, hobby);
        // skip to ith song based on songIndex.
        newPerson.addResponses(aLine[4 + songIndex]);
        newPerson.addResponses(aLine[5 + songIndex]);
        return newPerson;
    }


    /**
     * get song list store in this class.
     * 
     * @return returns song list with all raw data.
     */
    public SortedList<String> getAllSongData() {
        return allSongData;
    }

}
