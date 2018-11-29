package project5;

import java.util.ArrayList;

/**
 * sort list in alphabetical order or integer order.
 * 
 * @author gengzelyu
 * @version 2018.11.12
 * @param <T>
 *            generic type.
 */
public class SortedList<T >extends LinkedList<T> {

    /**
     * create linked list type.
     */
    public SortedList() {
        super();
    }


    /**
     * sort list wiht alphabetical order with index.
     * 
     * @param index
     *            position of string in array.
     */
    public void insertSortString(int index) {
        if (index != 3 && index != 2) {
            // if we're NOT sorting by genre, capitalization does NOT matter
            Node<T> currNode = head;
            while (currNode.next != null) {
                // String s = (String)currNode.getData().get(0);
                currNode = currNode.next;
            }
        }

        if (getSize() > 1) {
            assert head != null;
            Node<T> unsorted = head.next.next;
            assert unsorted != null;
            head.next.setNext(null);
            // insert node.
            while (unsorted.next != null) {
                Node<T> nodeToInsert = unsorted;
                unsorted = unsorted.next;
                if (index != 2) {
                    // sort by string if we're not accessing year
                    insertStringInOrder(nodeToInsert, index);
                }
                else {
                    insertNumberInOrder(nodeToInsert);
                }
            }
            // repositioning head and tail.
            head.setNext(getFirstNode());
            tail.setPrevious(getLastNode());
        }
    }


    /**
     * insert node into list.
     * 
     * @param nodeToInsert
     *            node to be insert.
     * @param index
     *            position of string in array.
     */
    private void insertStringInOrder(
        Node<T> nodeToInsert,
        // get string in array with index.
        int index) {
        // uses [index] due to SortedList<T[]>
        T data = nodeToInsert.getData().get(index);f
        Node<T> currentNode = head.getNextNode();
        Node<T> previousNode = null;
        // compare order
        while ((currentNode != null) && (data.compareTo(currentNode.getData()
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
     * insert node in order in the list.
     * 
     * @param nodeToInsert
     *            node need to insert.
     */
    private void insertNumberInOrder(Node<T> nodeToInsert) {
        // get integer at index 2 in array.
        int num = Integer.valueOf((nodeToInsert.getData().toString()));
        Node<T> currentNode = head.getNextNode();
        Node<T> previousNode = null;
        // compare number, cast it out.
        while ((currentNode != null) && (num) > (Integer.valueOf((currentNode
            .getData().toString())))) {
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
}
