package project5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import student.TestCase;; 

/**
 * test linked list class; 
 * @author gengzelyu
 * @version 2018.11.1
 */
public class LinkedListTest extends TestCase {

    private LinkedList<String> list1; 
    private LinkedList<String> list2; 
    
    /**
     * setup method for each run. 
     */
    public void setUp() {
        
        list1 = new LinkedList<String>(); 
        list2 = new LinkedList<String>(); 
    }
    
    /**
     * test isEmpty. 
     */
    public void testIsEmpty() {
        
        assertTrue(list1.isEmpty());
        assertTrue(list2.isEmpty()); 
    }
    
    public void testGetSize() {
        
        assertEquals(0, list1.getSize()); 
        assertEquals(0, list2.getSize()); 
    }
    
    /**
     * test add(newEntry). 
     */
    public void testAddEnd() {
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        assertFalse(list1.isEmpty());
        assertEquals(4, list1.getSize()); 
        assertEquals("{1, 2, 3, 4}", list1.toString()); 
        list1.clear();
        String stringList = "{";
        for (int i = 0; i < 100; i++) {
            stringList += Integer.toString(i);
            if (i != 99) {
                stringList += ", ";
            }
            list2.add(Integer.toString(i));
        }
        stringList += "}";
        assertEquals(stringList, list2.toString()); 
        
    }
    
    /**
     * test add(index, newEntry). 
     */
    public void testAddIndex() {
        list1.add(0, "1");
        assertEquals("{1}", list1.toString());
        list1.add(1, "3");
        assertEquals("{1, 3}", list1.toString()); 
        list1.add(1, "2");
        assertEquals("{1, 2, 3}", list1.toString()); 
        list1.add(0, "0");
        assertEquals("{0, 1, 2, 3}", list1.toString());
        list1.add(4, "4");
        assertEquals("{0, 1, 2, 3, 4}", list1.toString());
    }
    
    /**
     * test iterator of the list.
     */
    public void testIterator() {

        Iterator<String> iter = list1.iterator();
        assertFalse(iter.hasNext());
        list1.add("1");
        list1.add("2");
        list1.add("3");
        assertTrue(iter.hasNext());
        assertEquals("1", iter.next());
        iter.remove();
        assertEquals("{2, 3}", list1.toString());
        Exception thrown = null;
        try {
            iter.remove();
        }
        catch (IllegalStateException e) {
            thrown = e;
        }
        assertNotNull(thrown);
        iter.next();
        iter.next();
        Exception thrown2 = null;
        try {
            iter.next();
        }
        catch (NoSuchElementException e) {
            thrown2 = e;
        }
        assertNotNull(thrown2);
    }
    
    /**
     * Tests that an IndexOutOfBounds exception is thrown when the index is
     * greater than or equal to size and less than zero
     */
    public void testRemoveException() {
        list1.add("A");
        Exception e = null;
        try {
            list1.remove(2);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
        e = null;
        try {
            list1.remove(-1);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
    }
    
    /**
     * Tests that objects can be removed at the beginning and end and that the
     * size is changed
     */
    public void testRemoveIndex() {
        list1.add("A");
        list1.add("B");
        list1.remove(1);
        assertEquals(1, list1.getSize());
        list1.add("B");
        list1.remove(1);
        assertEquals(1, list1.getSize());
    }
    
    /**
     * This tests that the add method throws a null pointer exception when
     * adding null data to the list
     */
    public void testAddNullException() {
        Exception e = null;
        try {
            list1.add(null);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }


    /**
     * This tests that the add method throws a Invalid argument when adding null
     * data to the list
     */
    public void testAddIndexNullException() {
        Exception e = null;
        try {
            list1.add(0, null);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }


    /**
     * This tests when the add method is called and the index is greater than
     * size or less than zero
     */
    public void testAddException() {
        list1.add("A");
        Exception e = null;
        try {
            list1.add(2, "B");
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
        e = null;
        try {
            list1.add(-1, "B");
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
    }
    
    
}
