package project5;

import project5.AllEnum.hobbyEnum;
import project5.AllEnum.majorEnum;
import project5.AllEnum.regionEnum;
import project5.AllEnum.responseEnum;
import student.TestCase;

/**
 * test case for song.
 * 
 * @author gengzelyu
 * @version 2018.11.29
 */
public class SongTest extends TestCase {

    private Person person1;
    private Person person2;
    private Person person3;
    private Person person4;
    private Person person5;
    private Person person6;
    private Person person7;
    private Person person8;
    private Person person9;
    private Person person10;
    private PeopleList list1;
    private SurveyStat stat;
    private PeopleList list2;

    private Song song1;
    private Song song2;


    /**
     * set up at each run.
     */
    public void setUp() {
        person1 = new Person(majorEnum.CS, regionEnum.NEUS, hobbyEnum.READ,
            responseEnum.YES, responseEnum.YES);
        person2 = new Person(majorEnum.OTHERENG, regionEnum.RESTUS,
            hobbyEnum.ART, responseEnum.NO, responseEnum.NO);
        person3 = new Person(majorEnum.MC, regionEnum.OUTUS, hobbyEnum.SPORTS,
            responseEnum.YES, responseEnum.NO);
        person4 = new Person(majorEnum.OTHER, regionEnum.SEUS, hobbyEnum.MUSIC,
            responseEnum.NO, responseEnum.YES);
        person5 = new Person(majorEnum.BLANK, regionEnum.BLANK, hobbyEnum.BLANK,
            responseEnum.BLANK, responseEnum.BLANK);
        person6 = new Person(majorEnum.OTHER, regionEnum.SEUS, hobbyEnum.BLANK,
            responseEnum.BLANK, responseEnum.YES);
        person7 = new Person(majorEnum.OTHERENG, regionEnum.OUTUS,
            hobbyEnum.SPORTS, responseEnum.YES, responseEnum.NO);
        person8 = new Person(majorEnum.BLANK, regionEnum.RESTUS, hobbyEnum.ART,
            responseEnum.NO, responseEnum.NO);
        person9 = new Person(majorEnum.MC, regionEnum.RESTUS, hobbyEnum.READ,
            responseEnum.YES, responseEnum.YES);
        person10 = new Person(majorEnum.CS, regionEnum.BLANK, hobbyEnum.BLANK,
            responseEnum.BLANK, responseEnum.BLANK);
        list1 = new PeopleList();
        list2 = new PeopleList();
        list1.add(person1);
        list1.add(person3);
        list1.add(person5);
        list1.add(person7);
        list1.add(person9);
        list1.add(person2);
        list1.add(person4);
        list1.add(person6);
        list1.add(person8);
        list1.add(person10);
        stat = new SurveyStat(list1);
        song1 = new Song("song1", "gen", "1999", "hip-pop", stat);
    }


    /**
     * test getters method.
     */
    public void testGetters() {
        assertEquals(song1.getArtist(), "gen");
        assertEquals(song1.getTitle(), "song1");
        assertEquals(song1.getGenre(), "hip-pop");
        assertEquals(song1.getYear(), "1999");
        assertEquals(song1.getSurveyStatistic(), stat);
        System.out.println(song1);
        SurveyStat nullStat = null;
        try {
            song1.setSurveyStatistic(nullStat);
        }
        catch (IllegalArgumentException e) {
            assert e != null;
        }
    }


    /**
     * test compareto.
     */
    public void testCompareTo() {
        // same oder.
        assertEquals(0, song1.compareTo("a", "a"));
        assertEquals(0, song1.compareTo("a", "A"));
        assertEquals(0, song1.compareTo("abc", "abc"));
        assertEquals(0, song1.compareTo("ABC", "ABC"));
        assertEquals(0, song1.compareTo("AbC", "AbC"));
        assertEquals(0, song1.compareTo(" a ", " a"));
        assertEquals(-1, song1.compareTo("a", "B"));
        assertEquals(-25, song1.compareTo("a", "Z"));
        assertEquals(-25, song1.compareTo("a", "zz"));
        assertEquals(-24, song1.compareTo("ab", "az"));
        // integer string.
        assertEquals(0, song1.compareTo("1", "1"));
        assertEquals(-1, song1.compareTo("1", "2"));
        assertEquals(1, song1.compareTo("2", "1"));
        assertEquals(1, song1.compareTo("123", "12"));
        assertEquals(-2, song1.compareTo("1", "100"));
        assertEquals(1, song1.compareTo("101", "100"));
        // string with
        assertEquals(0, song1.compareTo(",", ","));
        assertEquals(-1, song1.compareTo(",", ",,"));
        assertEquals(-2, song1.compareTo(", ", ",,,"));
        assertEquals(0, song1.compareTo("a's", "a's"));
        assertEquals(-1, song1.compareTo("a'b", "a'c"));
        assertEquals(1, song1.compareTo("a'c", "a'b"));
    }

    /**
     * test equals funcion 
     */
    public void testEquals() {
        // same entries diff reff. 
        Song nullSong = null;
        String string = "hey"; 
        try {
            song1.equals(nullSong);
        }
        catch (IllegalArgumentException e) {
            assert e != null;
        }
        assertFalse(song1.equals(string));
        assertTrue(song1.equals(song1));
        list2.add(person2);
        list2.add(person4);
        list2.add(person6);
        list2.add(person8);
        list2.add(person10);
        list2.add(person1);
        list2.add(person3);
        list2.add(person5);
        list2.add(person7);
        list2.add(person9);
        SurveyStat stat2 = new SurveyStat(list2);
        song2 = new Song("song1", "gen", "1999", "hip-pop", stat2);
        assertTrue(song1.equals(song2));
        
        // diff entries. 
        list2.clear();
        list2.add(person1);
        list2.add(person3);
        list2.add(person5);
        list2.add(person7);
        list2.add(person9);
        list2.add(person1);
        list2.add(person3);
        list2.add(person5);
        list2.add(person7);
        list2.add(person9);
        stat2 = new SurveyStat(list2);
        song2.setSurveyStatistic(stat2);
        assertFalse(song1.equals(song2));
    }
}
