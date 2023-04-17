package towerofhanoi;
import java.util.EmptyStackException;
import stack.StackInterface;

/**
 * LinkedStack to hold disks on poles
 * 
 * @author Solaiman Ibrahimi
 * @version 03.21.2023
 * @param <T>
 *            this parameter represents type to hold objs
 */
public class LinkedStack<T> implements StackInterface<T> {

    private int size;
    private Node topNode;

    /**
     * class constructor
     */
    public LinkedStack() {
        this.topNode = null;
        this.size = 0;
    }


    /**
     * method that clears a stack
     */
    @Override
    public void clear() {
        while (!this.isEmpty()) {
            this.pop();
        }
    }


    /**
     * size getter
     * 
     * @return the curr size
     */
    public int size() {
        return this.size;
    }


    /**
     * checks if stack is empty
     * 
     * @return true or false
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }


    /**
     * converts stack into string array format
     * 
     * @return string in proper format
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        Node iterator = topNode;
        while (iterator != null) {
            str.append(iterator.getData());
            if (iterator.next != null) {
                str.append(", ");
            }
            iterator = iterator.next;
        }
        str.append("]");
        return str.toString();
    }


    /**
     * peek method to check top of stack without removal
     * 
     * @return the data of top node
     */
    @Override
    public T peek() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        return topNode.getData();
    }


    /**
     * removes node at the top of the stack
     * 
     * @return the data of the removed node
     */
    @Override
    public T pop() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        Node temp = topNode;
        topNode = topNode.getNextNode();
        this.size--;
        return temp.getData();
    }


    /**
     * pushes a new node on stack containing the inputed data
     * 
     * @param entry
     *            data of node to be pushed
     */
    @Override
    public void push(T entry) {
        Node pushed = new Node(entry, topNode);
        topNode = pushed;
        this.size++;
    }

    /**
     * Inner node class that this stack class utilizes
     * 
     * @author Solaiman Ibrahimi
     * @version 03.21.2023
     */
    private class Node {
        private T data;
        private Node next;

        /**
         * one overloaded constructor
         * 
         * @param entry
         *            insertion of data
         * @param node
         *            insertion of node
         */
        public Node(T data, Node next) {
            this(data);
            this.setNextNode(next);
        }


        /**
         * another overloaded constructor
         * 
         * @param data
         *            insertion of data only
         */
        public Node(T data) {
            this.data = data;
        }


        /**
         * sets next node
         * 
         * @param n
         *            the next node to set to
         */
        public void setNextNode(Node n) {
            this.next = n;
        }


        /**
         * getter for the next node in sequence
         * 
         * @return the next node
         */
        public Node getNextNode() {
            return this.next;
        }


        /**
         * return the data of the curr node
         * 
         * @return the T data
         */
        public T getData() {
            return this.data;
        }
    }
}
