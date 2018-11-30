package project5;

import java.util.Iterator;

/**
 * PeopleList represents the list of person.
 * 
 * @author gengzelyu
 * @version 2018.11.28
 */
public class PeopleList extends LinkedList<Person> {

    /**
     * create a personlist by super the list.
     */
    public PeopleList() {
        super();
    }


    /**
     * check if both personlist are equal.
     * 
     * @return returns true only if every entries are equal.
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException(
                "the other PeopleList cannot be null");
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        PeopleList other = (PeopleList)obj;
        if (this.getSize() != other.getSize()) {
            return false;
        }
        if (this.getSize() == 0 && other.getSize() == 0) {
            throw new IllegalArgumentException(
                "cannot comapare on 2 empty lists.");
        }
        Iterator<Person> thisIter = this.iterator();
        Iterator<Person> otherIter = other.iterator();
        boolean isEqual = true;
        // iterate the this list one by one, if any one of entries in any other
        // list is different, return false.
        while (thisIter.hasNext()) {
            isEqual = isEqual && (thisIter.next().equals((otherIter).next()));
            if (!isEqual) {
                return false;
            }
        }
        return true;
    }
}
