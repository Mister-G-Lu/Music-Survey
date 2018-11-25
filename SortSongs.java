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

    
    /**
    * default constructor.
    * @param temp
    * the linked list we use.
    */
    public SortSongs(LinkedList<T[]> temp) {
        allSongs = temp;
    }

    /**
    * get the song.
    * @return
    * The array "allsongs"
    */
    public SortedList<T[]> getSongs(){
        return allSongs;
    }
    /**
    * sort artists.
    * @return sorted list artist wise
    */
    public LinkedList<T> sortArtists() {
        // case does NOT matter in this method
        allSongs.insertSortString(0);
    }

 /**
    * sort title.
    * @return sorted list title wise
    */
    public LinkedList<T> sortTitles() {
        allSongs.insertSortString(1);
    }

 /**
    * sort dates.
    * @return sorted list date wise
    */
    public LinkedList<T> sortAscendingDate() {
        allSongs.insertSortString(2);
    }
    
     /**
    * sort genres.
    * @return sorted list genre wise
    */
    public LinkedList<T> sortGenres() {
        // Case DOES matter in this sorting method
        allSongs.insertSortString(3);
    }



}
