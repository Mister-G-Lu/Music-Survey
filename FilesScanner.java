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


    public FilesScanner() {

        allSongData = new SortedList<String>();
    }


    /**
     * 
     * @param surveyName
     * @param songListName
     * @throws FileNotFoundException
     */
    public SortedList<String> scanFiles(String surveyName, String songListName)
        throws FileNotFoundException {
        String rootLocation =
            "/Users/gengzelyu/Desktop/CS 2114/Project5/InputFiles/";
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
        return this.allSongData;
    }


    /**
     * 
     * @param surveyData
     * @param songListData
     */
    private void listCreator(Scanner surveyData, Scanner songListData) {
        // get song info.
        // skip first line.
        surveyData.nextLine();
        songListData.nextLine();
        // song index in the song list.
        int songIndex = 1;
        while (songListData.hasNextLine()) {
            ArrayList<Object> newSong = songListScanner(songListData); 
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
     * @param songListData
     * @return
     */
    private ArrayList<Object> songListScanner(Scanner songListData) {
        
        String songInfo = "";
        ArrayList<Object> aSong = new ArrayList<Object>(); 
        while (songListData.hasNext()) {
            String nextString = songListData.next();
            // if next string is not ',' scanner continues. 
            if (!nextString.endsWith(",")) {
                songInfo += nextString + " "; 
            }
            // else add it to array and clear song info. 
            else {
                aSong.add(songInfo); 
                songInfo = ""; 
            }
        }
        return aSong; 
    }
    /**
     * 
     * @param surveyData
     * @return
     */
    private Person surveyScanner(Scanner surveyData, int songIndex) {

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


    public SortedList<String> getAllSongData() {
        return allSongData;
    }

}
