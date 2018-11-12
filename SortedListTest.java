package project5;

import java.util.ArrayList;
import student.TestCase;

/**
 * test case for sortedList. 
 * @author gengzelyu
 * @version 2018.11.12
 */
public class SortedListTest extends TestCase {

    private SortedList<String> list1;
//    private SortedList<String> list2;
    private ArrayList<String> arrayL1;
    private ArrayList<String> arrayL2;
    private ArrayList<String> arrayL3;
//    private String sList1;
//    private String sList2;
//    private String sList3;

    /**
     * set up method for each run. 
     */
    public void setUp() {
        list1 = new SortedList<String>();
//        list2 = new SortedList<String>();

        arrayL1 = new ArrayList<String>();
        arrayL2 = new ArrayList<String>();
        arrayL3 = new ArrayList<String>();

        arrayL1.add("a");
        arrayL1.add("a");
        arrayL1.add("1");
        arrayL1.add("a");

        arrayL2.add("b");
        arrayL2.add("b");
        arrayL2.add("2");
        arrayL2.add("b");

        arrayL3.add("c");
        arrayL3.add("c");
        arrayL3.add("3");
        arrayL3.add("c");
    }

    /**
     * test insertSortNumber. 
     */
    public void test1() {

        // 1 entry.
        list1.add(arrayL3);
        list1.insertSortNumber();
        assertEquals("{[c, c, 3, c]}", list1.toString());
        // 2 entries.
        list1.add(arrayL2);
        list1.insertSortNumber();
        assertEquals("{[b, b, 2, b], [c, c, 3, c]}", list1.toString());
        // 3 entries;
        list1.clear();
        list1.add(arrayL2);
        list1.add(arrayL3);
        list1.add(arrayL1);
        list1.add(arrayL1);
        list1.add(arrayL3);
        list1.insertSortNumber();
        assertEquals(
            "{[a, a, 1, a], [a, a, 1, a], [b, b, 2, b], [c, c, 3, c], [c, c, 3, c]}",
            list1.toString());
    }


    /**
     * test sort string.
     */
    public void test2() {
        // empty list
        list1.insertSortString(0);
        assertEquals("{}", list1.toString());
        // 1 entry.
        list1.add(arrayL1);
        assertEquals("{[a, a, 1, a]}", list1.toString());
        // 2 engtries.
        list1.add(arrayL3);
        list1.insertSortString(0);
        assertEquals("{[a, a, 1, a], [c, c, 3, c]}", list1.toString());
        list1.clear();
        list1.add(arrayL2);
        list1.add(arrayL1);
        list1.insertSortNumber();
        assertEquals("{[a, a, 1, a], [b, b, 2, b]}", list1.toString());
        // 3 entries.
        list1.clear();
        list1.add(arrayL3);
        list1.add(arrayL2);
        list1.add(arrayL1);
        list1.insertSortString(0);
        assertEquals("{[a, a, 1, a], [b, b, 2, b], [c, c, 3, c]}", list1
            .toString());
    }

}
