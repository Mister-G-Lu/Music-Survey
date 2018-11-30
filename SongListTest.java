package project5;

import project5.AllEnum.*;
import student.TestCase;
import java.util.Random;

/**
 * test case for SongList.
 * 
 * @author gengzelyu
 * @version 2018.11.29
 */
public class SongListTest extends TestCase {
    private Song song1;
    private Song song2;
    private Song song3;
    private Song song4;
    private Song song5;
    private Song song6;
    private Song song7;
    private Song song8;
    private Song song9;
    private Song song10;
    private SongList songList;
    private SurveyStat stat1;
    private Song[] randSongs;
    private Person person1;
    private PeopleList peopleList;


    /**
     * set up at each run.
     */
    public void setUp() {
        person1 = new Person(majorEnum.MC, regionEnum.OUTUS, hobbyEnum.MUSIC,
            responseEnum.YES, responseEnum.YES);
        peopleList = new PeopleList();
        peopleList.add(person1);
        stat1 = new SurveyStat(peopleList);
        song1 = new Song("All These Things I've Done", "The Killers", "2005",
            "alternative", stat1);
        song2 = new Song("All You Need Is Love", "The Beatles", "1967",
            "pop rock", stat1);
        song3 = new Song("American Pie", "Don McLean", "1971", "folk rock",
            stat1);
        song4 = new Song("Anarchy in the UK", "The Sex Pistols", "1976", "punk",
            stat1);
        song5 = new Song("Another One Bites the Dust", "Queen", "1980", "disco",
            stat1);
        song6 = new Song("Life On Mars?", "David Bowie", "1971", "glam rock",
            stat1);
        song7 = new Song("No One", "Alicia Keys", "2007", "R&B", stat1);
        song8 = new Song("Party Rock Anthem", "LMFAO", "2011", "EDM", stat1);
        song9 = new Song("Smells Like Teen Spirit", "Nirvana", "1991", "grunge",
            stat1);
        song10 = new Song("Tik Tok", "Ke$ha", "2009", "electronic", stat1);
        songList = new SongList();
        randSongs = new Song[] { song1, song2, song3, song4, song5, song6,
            song7, song8, song9, song10 };
        Random rand = new Random();
        // command one of the codes below to try diff oder.
// for (int i = 0; i < 10; i++) {
// songList.add(randSongs[i]);
// }
        for (int i = 9; i > -1; i--) {
            songList.add(randSongs[i]);
        }
// for (int i = 0; i < 10; i ++) {
// songList.add(randSongs[rand.nextInt(10)]);
// }
    }


    /**
     * test insert sort.
     */
    public void testInsertSortTitle() {
        System.out.println("Sort by titile");
        SongList sortByTitle = songList.insertSort("title");
        System.out.println(sortByTitle);
        assertEquals(sortByTitle.getSong(0), song1);
        assertEquals(sortByTitle.getSong(1), song2);
        assertEquals(sortByTitle.getSong(2), song3);
        assertEquals(sortByTitle.getSong(3), song4);
        assertEquals(sortByTitle.getSong(4), song5);
        assertEquals(sortByTitle.getSong(5), song6);
        assertEquals(sortByTitle.getSong(6), song7);
        assertEquals(sortByTitle.getSong(7), song8);
        assertEquals(sortByTitle.getSong(8), song9);
        assertEquals(sortByTitle.getSong(9), song10);

    }


    /**
     * test insert sort.
     */
    public void testInsertSortYear() {
        System.out.println("\n\nSort by year");
        SongList sortByYear = songList.insertSort("year");
        System.out.println(sortByYear);
        assertEquals(sortByYear.getSong(0), song2);
        assertEquals(sortByYear.getSong(1), song3);
        assertEquals(sortByYear.getSong(2), song6);
        assertEquals(sortByYear.getSong(3), song4);
        assertEquals(sortByYear.getSong(4), song5);
        assertEquals(sortByYear.getSong(5), song9);
        assertEquals(sortByYear.getSong(6), song1);
        assertEquals(sortByYear.getSong(7), song7);
        assertEquals(sortByYear.getSong(8), song10);
        assertEquals(sortByYear.getSong(9), song8);

    }


    /**
     * test insert sort.
     */
    public void testInsertSortArtist() {
        System.out.println("\n\nSort by artist");
        SongList sortByArtist = songList.insertSort("artist");
        System.out.println(sortByArtist);

    }


    /**
     * test insert sort.
     */
    public void testInsertSortGenre() {
        System.out.println("\n\nSort by genre");
        SongList sortByGenre = songList.insertSort("genre");
        System.out.println(sortByGenre);
    }
}
