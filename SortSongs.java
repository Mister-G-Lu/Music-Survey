/**
 * 
 */
package project5;

import java.util.LinkedList;

/**
 * @author Goodwin Lu
 * @version 11/1/2018
 *          This class sorts either by artist, title, year, or genre.
 */
public class SortSongs {
    // This array of strings stores each song, with artist, title, year
    // genre, and LL<T> people in that order
    private SortedList<T[]> allSongs;


    public SortSongs(LinkedList<T[]> temp) {
        allSongs = temp;
    }


    public LinkedList<T> sortArtists() {
        // case does NOT matter in this method
        allSongs.insertSortString(0);
    }


    public LinkedList<T> sortTitles() {
        allSongs.insertSortString(1);
    }


    public LinkedList<T> sortAscendingDate() {
        allSongs.insertSortString(2);
    }
    
    public LinkedList<T> sortGenres() {
        // Case DOES matter in this sorting method
        allSongs.insertSortString(3);
    }



}
