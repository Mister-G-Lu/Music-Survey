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

    public Input() {

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
    public static void main(String args[]) {
        String surveyFileName = args[0];
        String songListFileName = args[1];
        FilesScanner scanner = new FilesScanner();
        try {
            scanner.scanFiles(surveyFileName, songListFileName);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        SortedList<String> allSongData = scanner.getAllSongData();
        
        // temperolly print data. 
        System.out.println(allSongData.toString());
    }

}
