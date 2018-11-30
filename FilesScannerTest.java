package project5;

//import java.io.File;
import java.io.FileNotFoundException;
//import project5.AllEnum.*;
import student.TestCase;

/**
 * test case for filesScanner
 * 
 * @author Gengze Lyu (lgengze)
 * @version 2018.11.29
 */
public class FilesScannerTest extends TestCase {

    private FilesScanner scanner;
    private String[] files;


    /**
     * test scanner with small files.
     */
    public void test1() {
        // file with 1 song.
        files = new String[] { "MusicSurveyDataTest2.csv",
            "SongListTest2.csv" };
        try {
            scanner = new FilesScanner(files);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        SongList list = scanner.getScannedSongList();
// System.out.println(list);
        assertEquals(list.getSize(), 1);
        assertEquals("All These Things I've Done", list.getSong(0).getTitle());

        // scan files with 5 songs
        files = new String[] { "MusicSurveyDataTest1.csv",
            "SongListTest1.csv" };
        try {
            scanner = new FilesScanner(files);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        list = scanner.getScannedSongList();
// System.out.println(list);
        assertEquals(list.getSize(), 5);
        assertEquals("All These Things I've Done", list.getSong(0).getTitle());
    }


    /**
     * test with files witout genre repeats.
     */
    public void test2() {
        files = new String[] { "MusicSurveyDataNoGenreRepeats.csv",
            "SongListNoGenreRepeats.csv" };
        try {
            scanner = new FilesScanner(files);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        SongList list = scanner.getScannedSongList().insertSort("title");
        System.out.println(list);

        // test on real file.
        files = new String[] { "MusicSurveyData.csv", "SongList.csv" };
        try {
            scanner = new FilesScanner(files);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        list = scanner.getScannedSongList().insertSort("title");
// System.out.println(list);
    }
}
