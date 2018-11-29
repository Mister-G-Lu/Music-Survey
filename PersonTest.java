package project5;

import project5.AllEnum.*;
import student.TestCase;

/**
 * test case for Person class.
 * 
 * @author gengzelyu
 * @version 2018.11.28
 */
public class PersonTest extends TestCase {

    /**
     * teset all methods in class.
     */
    public void test1() {
        Person person1 = new Person(majorEnum.CS, regionEnum.NEUS,
            hobbyEnum.READ, responseEnum.YES, responseEnum.YES);
        Person person2 = new Person(majorEnum.OTHERENG, regionEnum.RESTUS,
            hobbyEnum.ART, responseEnum.NO, responseEnum.NO);
        Person person3 = new Person(majorEnum.MC, regionEnum.OUTUS,
            hobbyEnum.SPORTS, responseEnum.YES, responseEnum.NO);
        Person person4 = new Person(majorEnum.OTHER, regionEnum.SEUS,
            hobbyEnum.MUSIC, responseEnum.NO, responseEnum.YES);
        Person person5 = new Person(majorEnum.BLANK, regionEnum.BLANK,
            hobbyEnum.BLANK, responseEnum.BLANK, responseEnum.BLANK);

        /**
         * test to string
         */
        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);
        System.out.println(person4);
        System.out.println(person5);

        // test all get methods
        assert person1.getHobby() == hobbyEnum.READ;
        assert person2.getMajor() == majorEnum.OTHERENG;
        assert person3.getRegion() == regionEnum.OUTUS;
        responseEnum[] person4Responses = { responseEnum.NO, responseEnum.YES };
        assert person4.getHeard().equals(person4Responses[0]);
        assert person4.getLike().equals(person4Responses[1]);

        // test toarray
        Object[] person1Array = person1.toArray();
        assertEquals(person1Array[0], majorEnum.CS);
        assertEquals(person1Array[1], regionEnum.NEUS);
        assertEquals(person1Array[2], hobbyEnum.READ);
        assertEquals(person1Array[3], responseEnum.YES);
        assertEquals(person1Array[4], responseEnum.YES);

        // test equals
        Person nullP = null;
        String stringP = "{CS READ NEUS [YES YES]}";
        try {
            assertFalse(person1.equals(nullP));
        }
        catch (IllegalArgumentException e) {
            assert e != null;
        }
        assertFalse(person1.equals(stringP));
        assertTrue(person1.equals(person1));
        assertFalse(person1.equals(person2));
        Person person1Copy = new Person(majorEnum.CS, regionEnum.NEUS,
            hobbyEnum.READ, responseEnum.YES, responseEnum.YES);
        assertTrue(person1.equals(person1Copy));
    }
}
