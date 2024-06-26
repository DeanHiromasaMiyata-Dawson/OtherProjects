/**
 * Node class represents nodes used in Linked List
 **/
public class Node<T> {
    private T data;
    private Node<T> next;

    /**
    * @param data to be stored in the node
    * @param next pointer to the next node
    **/
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    /**
    * @return the data in the node
    **/
    public T getData() {
        return this.data;
    }

    /**
    * @return the next node
    **/
    public Node<T> getNext() {
        return this.next;
    }

    /**
    * @param data sets the data
    **/
    public void setData(T data) {
        this.data = data;
    }

    /**
    * @param next sets next node
    **/
    public void setNext(Node<T> next) {
        this.next = next;
    }
}
