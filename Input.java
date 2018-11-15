package project5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Simulate input in project 5.
 * 
 * @author gengzelyu
 * @version 2018.11.14
 */
public class Input {

    /**
     * big list that stored all songs' data.
     */
    private static SortedList<Object> allSongData;


    public Input() {

        allSongData = new SortedList<String>();
    }


    /**
     * run project with indicated files name.
     * 
     * @param args
     *            args[0] is file name of survey data. ars[1] is file name of
     *            song list.
     * @throws FileNotFoundException
     *             throws if files not found.
     */
    public static void main(String args[]) throws FileNotFoundException {

        String surveyFileName = args[0];
        String songListFileName = args[1];

        scanFiles(surveyFileName, songListFileName);
    }


    /**
     * 
     * @param surveyName
     * @param songListName
     * @throws FileNotFoundException
     */
    private static void scanFiles(String surveyName, String songListName)
        throws FileNotFoundException {
        String rootLocation =
            "/Users/gengzelyu/Desktop/CS 2114/Project5/InputFiles/";
        try {
            Scanner surveyData = new Scanner(new File(rootLocation
                + surveyName));
            Scanner songListData = new Scanner(new File(rootLocation
                + surveyName));
        }
        catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
        Scanner surveyData = new Scanner(new File(rootLocation + surveyName));
        Scanner songListData = new Scanner(new File(rootLocation + surveyName));
        listCreator(surveyData, songListData);

    }


    /**
     * 
     * @param surveyData
     * @param songListData
     */
    private static void listCreator(Scanner surveyData, Scanner songListData) {
        // get song info.
        // skip first line.
        surveyData.nextLine();
        songListData.nextLine();
        // song index in the song list.
        int songIndex = 1;
        while (songListData.hasNextLine()) {
            ArrayList<Object> newSong = new ArrayList<Object>();
            while (songListData.hasNext()) {
                newSong.add(songListData.next());
            }
            // get survey info under one line in song list.
            Person newPerson = surveyScanner(surveyData, songIndex);
            newSong.add(newPerson);
            allSongData.add(newSong); 
            surveyData.nextLine();
            songIndex++;
        }

    }


    /**
     * 
     * @param surveyData
     * @return
     */
    private static Person surveyScanner(Scanner surveyData, int songIndex) {

        // skip first 2 index and date.
        surveyData.next();
        surveyData.next();
        String major = surveyData.next();
        String region = surveyData.next();
        String hobby = surveyData.next();
        Person newPerson = new Person(major, region, hobby);
        // skip to ith song based on songIndex.
        for (int i = 1; i < songIndex; i++) {
            surveyData.next();
            surveyData.next();
        }
        newPerson.addResponses(surveyData.next());
        newPerson.addResponses(surveyData.next());
        return newPerson;
    }

}
