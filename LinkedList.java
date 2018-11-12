package project5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * liked list class that store basic data.
 * 
 * @author gengzelyu
 * @version 2018.11.1
 * @param <E>
 *            genric type.
 */
public class LinkedList<E> {

    protected Node<E> head;
    protected Node<E> tail;
    private int size;


    /**
     * protect node class.
     * 
     * @author gengzelyu
     * @version 2018.11.1
     */
    protected final class Node<E> {

        protected E data;
        protected Node<E> next;
        protected Node<E> previous;


        /**
         * new node without specific location.
         * 
         * @param data
         *            stored on node.
         */
        protected Node(E data) {

            this.data = data;
            previous = null;
            next = null; 
        }


        /**
         * new node insert with next node.
         * 
         * @param data
         *            on the node.
         * @param nextNode
         *            insert with next node.
         */
        protected Node(E data, Node<E> nextNode) {

            this.data = data;
            next = nextNode;
        }


        /**
         * get data on node.
         * 
         * @return returns data on node;
         */
        protected final E getData() {
            return data;
        }


        /**
         * set data on node;
         * 
         * @param newData
         *            new data store on node.
         */
        protected final void setData(E newData) {
            this.data = newData;
        }


        /**
         * get next node;
         * 
         * @return returns next node.
         */
        protected final Node<E> getNextNode() {
            return next;
        }

        /**
         * get previous node. 
         * @return returns previous node. 
         */
        protected final Node<E> getPreviousNode() {
            return previous; 
        }

        /**
         * set the next node.
         * 
         * @param nextNode
         *            next node.
         */
        protected final void setNext(Node<E> nextNode) {
            this.next = nextNode;
        }


        /**
         * Sets the node before this one
         *
         * @param n
         *            the node before this one
         */
        protected final void setPrevious(Node<E> n) {
            this.previous = n;
        }
    }


    /**
     * create new list obj and initialize the defualt data fields.
     */
    public LinkedList() {

        initialize();
    }


    /**
     * inialize data fields.
     */
    private void initialize() {

        head = new Node<E>(null);
        tail = new Node<E>(null);
        head.setNext(tail);
        tail.setPrevious(head);
        size = 0;
    }


    /**
     * is linked list empty?
     * 
     * @return returns true if list is empty.
     */
    public boolean isEmpty() {
        return head != null && size == 0;
    }


    /**
     * get size of current list.
     * 
     * @return returns size of list;
     */
    public int getSize() {

        return size;
    }

    public void clear() {
        initialize();
    }

    /**
     * Adds the object to the position in the list
     *
     * @param index
     *            where to add the object
     * @param obj
     *            the object to add
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     * @throws IllegalArgumentException
     *             if obj is null
     */
    public void add(int index, E obj) {
        if (index < 0 || size < index) {
            throw new IndexOutOfBoundsException();
        }
        if (obj == null) {
            throw new IllegalArgumentException("Cannot add null "
                + "objects to a list");
        }

        Node<E> nodeAfter;
        if (index == size) {
            nodeAfter = tail;
        }
        else {
            nodeAfter = getNodeAtIndex(index);
        }

        Node<E> addition = new Node<E>(obj);
        addition.setPrevious(nodeAfter.previous);
        addition.setNext(nodeAfter);
        nodeAfter.previous.setNext(addition);
        nodeAfter.setPrevious(addition);
        size++;
    }


    /**
     * Adds a element to the end of the list
     *
     * @param newEntry
     *            the element to add to the end
     */
    public void add(E newEntry) {
        add(size, newEntry);
    }

    /**
     * 
     * @return
     */
    public Node<E> getLastNode() {   
        return getNodeAtIndex(size - 1); 
    }

    /**
     * Returns an array representation of the list If a list contains A, B, and
     * C, the following should be returned {A, B, C}, If a list
     * contains A, B, C, and C the following should be returned {A, B, C, C}
     *
     * @return an array representing the list
     */
    public Object[] toArray() {

        Object[] array = new Object[this.getSize()];
        Node<E> current = head;
        int count = 0;
        while (current != null) {
            array[count] = current.getData();
            current = current.next;
            count++;
        }
        return array;
    }


    /**
     * Returns a string representation of the list If a list contains A, B, and
     * C, the following should be returned "{A, B, C}" (Without the quotations)
     *
     * @return a string representing the list
     */
    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        if (!isEmpty()) {
            Node<E> currNode = head.next;
            while (currNode != tail && currNode != null) {
                E element = currNode.getData();
                builder.append(element.toString());
                if (currNode.next != tail && currNode.next != null) {
                    builder.append(", ");
                }
                currNode = currNode.next;
            }
        }

        builder.append("}");
        return builder.toString();
    }


    /**
     * Gets the object at the given position
     *
     * @param index
     *            where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException
     *             if there no node at the given index
     */
    public E getData(int index) {
        return getNodeAtIndex(index).getData();
    }

    /**
     * 
     * @return
     */
    protected final Node<E> getFirstNode() {
        return getNodeAtIndex(0); 
    }
    /**
     * gets the node at that index
     * 
     * @param index
     * @return node at index
     */
    protected final Node<E> getNodeAtIndex(int index) {
        if (index < 0 || size <= index) {
            throw new IndexOutOfBoundsException("No element exists at "
                + index);
        }
        Node<E> current = head.next; // as we have a sentinel node
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }


    /**
     * Checks if the list contains the given object
     *
     * @param obj
     *            the object to check for
     * @return true if it contains the object
     */
    public boolean contains(E obj) {
        Node<E> current = head;
        while (current != null) {
            if (obj.equals(current.data)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }


    /**
     * Removes the element at the specified index from the list
     *
     * @param index
     *            where the object is located
     * @throws IndexOutOfBoundsException
     *             if there is not an element at the index
     * @return node's data that is removedl 
     */
    public E remove(int index) {
        E removed = null; 
        if (index >= 1) {
            assert !isEmpty(); 
            if (index == 1) {
                removed = head.getData(); 
                head = head.getNextNode();
            }
            else {
                Node<E> nodeBefore = getNodeAtIndex(index -1);
                Node<E> nodeToRemoved = nodeBefore.getNextNode();
                removed = nodeToRemoved.getData();
                Node<E> nodeAfter = nodeToRemoved.getNextNode();
                nodeBefore.setNext(nodeAfter);
                }
            size--;
            return removed; 
        }
        
            throw new IndexOutOfBoundsException(); 
    }


    /**
     * The inner interator class for ddlist.
     * 
     * @author gengzelyu
     * @version 2018.11.2
     * @param <A>
     *            the type of data list stores.
     */
    private class LListIterator<A> implements Iterator<E> {
        private int nextPosition;
        private boolean wasNextCalled;
        private LinkedList<E> list;


        /**
         * Creates a new DLListIterator
         */
        public LListIterator() {
            list = LinkedList.this;
            nextPosition = -1;
            wasNextCalled = false;
        }


        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext() {
            return nextPosition < list.getSize() - 1;
        }


        /**
         * Gets the next value in the list
         *
         * @return the next value
         * @throws NoSuchElementException
         *             if there are no nodes left in the list
         */
        @Override
        public E next() {
            if (this.hasNext()) {
                wasNextCalled = true;
                nextPosition++;
                return list.getData(nextPosition);
            }
            throw new NoSuchElementException();
        }


        /**
         * Removes the last object returned with next() from the list
         *
         * @throws IllegalStateException
         *             if next has not been called yet
         *             and if the element has already been removed
         */
        @Override
        public void remove() {
            if (wasNextCalled) {
                list.remove(nextPosition + 1);
                nextPosition--;
                wasNextCalled = false;
            }
            else {
                throw new IllegalStateException(
                    "if next has not been called yet and if the element "
                        + "has already been removed");
            }
        }
    }


    /**
     * the iterator class for ddlist.
     * 
     * @author gengzelyu
     * @version 2018.11.2
     * @return returns new iterator object.
     */
    public Iterator<E> iterator() {
        return new LListIterator<E>();
    }

}
