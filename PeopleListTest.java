package project5;

import java.util.Iterator;
import java.util.Random;
import project5.AllEnum.hobbyEnum;
import project5.AllEnum.majorEnum;
import project5.AllEnum.regionEnum;
import project5.AllEnum.responseEnum;
import student.TestCase;

/**
 * Test case for PeopleList.
 * 
 * @author gengzelyu
 * @version 2018.11.28
 */
public class PeopleListTest extends TestCase {

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
    private PeopleList bigList1;
    private PeopleList bigList2;


    /**
     * setup method at each run.
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
        bigList1 = new PeopleList();
        bigList2 = new PeopleList();
        
        // test on empty lists. 
        try {
            list1.equals(list2);
        }
        catch (IllegalArgumentException e) {
            assert e != null;
        }
        
        list1.add(person1);
        list1.add(person3);
        list1.add(person5);
        list1.add(person7);
        list1.add(person9);
        System.out.println(list1);
    }


    /**
     * test equals
     */
    public void test1() {
        // test on easy statements.
        PeopleList nullList = null;
        String stringList =
            "{{CS READ NEUS [YES YES]}, {MC SPORTS OUTUS [YES NO]}, "
                + "{BLANK BLANK BLANK [BLANK BLANK]}, {OTHERENG SPORTS OUTUS [YES NO]}, "
                + "{MC READ RESTUS [YES YES]}}";
        try {
            assertFalse(list1.equals(nullList));
        }
        catch (IllegalArgumentException e) {
            assert e != null;
        }
        assertFalse(list1.equals(stringList));
        assertTrue(list1.equals(list1));
        // diff size
        list2.add(person1);
        list2.add(person3);
        list2.add(person5);
        list2.add(person7);
        assertFalse(list1.equals(list2));
        assertFalse(list2.equals(list1));
        // test on diff list but same entries.
        list2.clear();
        list2.add(person1);
        list2.add(person3);
        list2.add(person5);
        list2.add(person7);
        list2.add(person9);
        assertTrue(list1.equals(list2));
        assertTrue(list2.equals(list1));
        // test on totaly different list.
        list2.clear();
        assertFalse(list1.equals(list2));
        assertFalse(list2.equals(list1));
        list2.add(person2);
        list2.add(person4);
        list2.add(person6);
        list2.add(person8);
        list2.add(person10);
        assertFalse(list1.equals(list2));
        assertFalse(list2.equals(list1));
        // remove some entries.
        list2.remove(1);
        assertFalse(list1.equals(list2));
        assertFalse(list2.equals(list1));
        list2.remove(1);
        assertFalse(list1.equals(list2));
        assertFalse(list2.equals(list1));
        list2.remove(1);
        assertFalse(list1.equals(list2));
        assertFalse(list2.equals(list1));
        list2.remove(1);
        assertFalse(list1.equals(list2));
        assertFalse(list2.equals(list1));
        list2.remove(1); 
        assertFalse(list1.equals(list2));
        assertFalse(list2.equals(list1));
        // test on equal lists but gradually remove. 
        list2.clear();
        list2.add(person1);
        list2.add(person3);
        list2.add(person5);
        list2.add(person7);
        list2.add(person9);
        assertTrue(list1.equals(list2));
        assertTrue(list2.equals(list1));
        list2.remove(1);
        assertFalse(list1.equals(list2));
        assertFalse(list2.equals(list1));
        list1.remove(1);
        assertTrue(list1.equals(list2));
        assertTrue(list2.equals(list1));
        list2.remove(1);
        assertFalse(list1.equals(list2));
        assertFalse(list2.equals(list1));
        list1.remove(1);
        assertTrue(list1.equals(list2));
        assertTrue(list2.equals(list1));
        list2.remove(1);
        assertFalse(list1.equals(list2));
        assertFalse(list2.equals(list1));
        list1.remove(1);
        assertTrue(list1.equals(list2));
        assertTrue(list2.equals(list1));
        list2.remove(1);
        assertFalse(list1.equals(list2));
        assertFalse(list2.equals(list1));
        list1.remove(1);
        assertTrue(list1.equals(list2));
        assertTrue(list2.equals(list1));
        list2.remove(1);
        assertFalse(list1.equals(list2));
        assertFalse(list2.equals(list1));
        list1.remove(1);
    }
    
    /**
     * test on big lists. 
     */
    public void test2() {
        // diff big lists and same entries
        Person[] people = {person1, person2, person3, person4, person5, person6, person7, person8, person9, person10};
        Random rand = new Random();
        for (int i = 0; i < 1000; i++) {
            int n = rand.nextInt(10); 
            bigList1.add(people[n]);
            bigList2.add(people[n]);
        }
        // randomly remove entries. 
        assertEquals(bigList1, bigList2);
        for (int i = 1000; i > 1; i--) {
            int n = rand.nextInt(i) + 1;
            bigList1.remove(n);
            assertFalse(bigList1.equals(bigList2));
            bigList2.remove(n);
            assertTrue(bigList1.equals(bigList2));
        }
    }
}
