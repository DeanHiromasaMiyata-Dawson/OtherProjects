import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Creates the LinkedList generic object class
 * @param <T> generic object
 * @author Dean Hiromasa Miyata-Dawson
 * @version 11/17/2023
 */
public class LinkedList<T> {
    private Node<T> head;
    private int size;

    /**
     * Creates a LinkedList
     * 0-arg constructor
     */
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Checks if this LinkedList is empty
     * @return true if empty, false if not
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Adds data at a specified index of LinkedList
     * @param data node data inputted by user
     * @param index location of the data
     */
    public void addAtIndex(T data, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        Node<T> node = new Node<T>(data, null);
        Node<T> current = head;

        if (index == 0) {
            node.setNext(head);
            head = node;
        } else if (index == size) {
            while (current.getNext() != null) {
                current = current.getNext();
            }

            current.setNext(node);
        } else {
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }

            node.setNext(current.getNext());
            current.setNext(node);
        }

        size++;
    }

    /**
     * Remove a node at a particular index
     * @param index location of index being removed
     * @return elemtent that got removed
     */
    public T removeFromIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        Node<T> current = head;
        Node<T> before = null;
        T removedData;

        if (index == 0) {
            removedData = head.getData();
            head = current.getNext();
        } else {
            for (int i = 0; i < index; i++) {
                before = current;
                current = current.getNext();
            }

            removedData = current.getData();
            before.setNext(current.getNext());
            size--;
        }

        return removedData;
    }

    /**
     * Clears the entire LinkedList, unless it is already empty
     */
    public void clear() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("LinkedList is already empty.");
        }

        this.head = null;
        this.size = 0;
    }

    /**
     * Gets data at a specified index
     * @param index location of element
     * @return data of node at index
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index out of bounds.");
        }

        Node<T> current = head;

        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.getData();
    }

    /**
     * Converts LinkedList into ArrayList
     * @return ArrayList after the conversion
     */
    public ArrayList<T> toArrayList() {
        ArrayList<T> arrayList = new ArrayList<>(size);
        Node<T> current = head;

        while (current != null) {
            arrayList.add(current.getData());
            current = current.getNext();
        }

        return arrayList;
    }

    /**
     * Creates a fizzBuzz pattern for LinkedList
     * @return LinkList with type String of fizzBuzz pattern
     */
    public LinkedList<String> fizzBuzzLinkedList() {
        LinkedList<String> linkedList = new LinkedList<>();
        Node<T> current = head;
        int index = 1;

        while (current != null) {
            if (index % 3 == 0 && index % 5 == 0) {
                linkedList.addAtIndex("FizzBuzz", index - 1);
                index++;
            } else if (index % 3 == 0) {
                linkedList.addAtIndex("Fizz", index - 1);
                index++;
            } else if (index % 5 == 0) {
                linkedList.addAtIndex("Buzz", index - 1);
                index++;
            } else {
                linkedList.addAtIndex(index + ": " + current.getData().toString(), index - 1);
                index++;
            }

            current = current.getNext();
        }

        return linkedList;
    }
}
