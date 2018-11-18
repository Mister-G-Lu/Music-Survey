package prj5;

import java.util.ArrayList;

/**
 *  sort list in alphabetical order or integer order. 
 * @author gengzelyu
 * @version 2018.11.12
 * @param <T> generic type. 
 */
public class SortedList<T>
    extends LinkedList<ArrayList<T>> {

    /**
     * create linked list type. 
     */
    public SortedList() {
        super();
    }
    
    /**
     * sort list wiht alphabetical order wiht index. 
     * @param index position of string in array. 
     */
    public void insertSortString(int index) {
        if (getSize() > 1) {
            assert head != null;
            Node<ArrayList<T>> unsorted = head.next.next;
            assert unsorted != null;
            head.next.setNext(null);
            // insert node. 
            while (unsorted.next != null) {
                Node<ArrayList<T>> nodeToInsert = unsorted;
                unsorted = unsorted.next;
                insertStringInOrder(nodeToInsert, index);
            }
            // repositioning head and tail. 
            head.setNext(getFirstNode());
            tail.setPrevious(getLastNode());
        }
    }
    
    /**
     * insert node into list. 
     * @param nodeToInsert node to be insert. 
     * @param index position of string in array. 
     */
    private void insertStringInOrder(
        Node<ArrayList<T>> nodeToInsert,
        // get string in array with index. 
        int index) {
        String data = (String) nodeToInsert.getData().get(index);
        Node<ArrayList<T>> currentNode = head.getNextNode();
        Node<ArrayList<T>> previousNode = null;
        // compare order
        while ((currentNode != null) && (data.compareTo((String) currentNode.getData()
            .get(index)) > 0)) {
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
        }
        // insert order
        if (previousNode != null) {
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setNext(currentNode);
        }
        // place it at beginning. 
        else {
            nodeToInsert.setNext(currentNode);
            nodeToInsert.setPrevious(head);
            head.setNext(nodeToInsert);
            currentNode.setPrevious(nodeToInsert);
        }
    }

    /**
     * insert node based on size of integer.
     */
    public void insertSortNumber() {
        if (getSize() > 1) {
            assert head != null;
            Node<ArrayList<T>> unsorted = head.next.next;
            assert unsorted != null;
            head.next.setNext(null);
            while (unsorted.next != null) {
                Node<ArrayList<T>> nodeToInsert = unsorted;
                unsorted = unsorted.next;
                insertNumberInOrder(nodeToInsert);
            }
            // reposition head and tail. 
            head.setNext(getFirstNode());
            tail.setPrevious(getLastNode());
        }
    }

    /**
     * insert node in order in the list. 
     * @param nodeToInsert node need to insert. 
     */
    private void insertNumberInOrder(Node<ArrayList<T>> nodeToInsert) {
        // get integer at index 2 in array. 
        int num = Integer.valueOf((nodeToInsert.getData().get(2).toString()));
        Node<ArrayList<T>> currentNode = head.getNextNode();
        Node<ArrayList<T>> previousNode = null;
        // compare number, cast it out.
        while ((currentNode != null) && (num) > (Integer.valueOf((currentNode
            .getData().get(2).toString())))) {
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();

        }
        if (previousNode != null) {
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setNext(currentNode);
        }
        else {
            nodeToInsert.setNext(currentNode);
            nodeToInsert.setPrevious(head);
            head.setNext(nodeToInsert);
            currentNode.setPrevious(nodeToInsert);
        }
    }
    
    @Override
    public void add(ArrayList<T> newArray) {
        super.add(newArray);
    }
}
