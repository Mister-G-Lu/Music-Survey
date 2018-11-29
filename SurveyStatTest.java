package project5;

import project5.AllEnum.hobbyEnum;
import project5.AllEnum.majorEnum;
import project5.AllEnum.regionEnum;
import project5.AllEnum.responseEnum;
import student.TestCase;

/**
 * test case for surveystat.
 * 
 * @author gengzelyu
 * @version 2018.11.28
 */
public class SurveyStatTest extends TestCase {
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
    private PeopleList list2;

    private SurveyStat stat;


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
        list2 = new PeopleList();
// System.out.println(list1);
    }


    /**
     * test Preffernce class in surveystat test.
     */
    public void testPrefference() {
        // cs major, person 1 and 10.
        Prefference preffCS = new Prefference();
        preffCS.smartCountAdder(person1);
        assert preffCS.toString().equals(
            "Heard(total/yes): 1/1 Likes(total/yes): 1/1");
        preffCS.smartCountAdder(person10);
        assert preffCS.toString().equals(
            "Heard(total/yes): 1/1 Likes(total/yes): 1/1");

        // mc major, person 3 and 9
        Prefference preffMC = new Prefference();
        preffMC.smartCountAdder(person3);
        assertEquals(preffMC.toString(),
            "Heard(total/yes): 1/1 Likes(total/yes): 1/0");
        preffMC.smartCountAdder(person9);
        assertEquals(preffMC.toString(),
            "Heard(total/yes): 2/2 Likes(total/yes): 2/1");

        // other major, person 3 and 9
        Prefference preffOTHER = new Prefference();
        preffOTHER.smartCountAdder(person4);
        assertEquals(preffOTHER.toString(),
            "Heard(total/yes): 1/0 Likes(total/yes): 1/1");
        preffOTHER.smartCountAdder(person6);
        assertEquals(preffOTHER.toString(),
            "Heard(total/yes): 1/0 Likes(total/yes): 2/2");

        // otherENG major, person 3 and 9
        Prefference prefferOTHERENG = new Prefference();
        prefferOTHERENG.smartCountAdder(person2);
        assertEquals(prefferOTHERENG.toString(),
            "Heard(total/yes): 1/0 Likes(total/yes): 1/0");
        prefferOTHERENG.smartCountAdder(person7);
        assertEquals(prefferOTHERENG.toString(),
            "Heard(total/yes): 2/1 Likes(total/yes): 2/0");

        // if major, region or hobby is blank, it should be handled by
        // surveystat.
    }


    /**
     * test initiate new stat sucsessful.
     */
    public void testLegal() {
        try {
            stat = new SurveyStat(list2);
        }
        catch (IllegalArgumentException e) {
            assert e != null;
        }

        try {
            PeopleList nullList = null;
            stat = new SurveyStat(nullList);
        }
        catch (IllegalArgumentException e) {
            assert e != null;
        }
    }


    /**
     * test add people with diff
     */
    public void testAll() {
        stat = new SurveyStat(list1);
        System.out.println(stat.toString());
    }
}
