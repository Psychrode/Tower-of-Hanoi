package towerofhanoi;
// -- Solaiman Ibrahimi (kuplar)

import java.util.EmptyStackException;
import student.TestCase;

/**
 * tester class for linkedstack functionality
 * 
 * @author Solaiman Ibrahimi
 * @version 03.21.2023
 * @param <T>
 *            type to hold in stack
 */
public class LinkedStackTest<T> extends TestCase {

    private LinkedStack<T> full;
    private LinkedStack<T> empty;

    /**
     * setUp method to run before tests
     */
    @SuppressWarnings("unchecked")
    public void setUp() {
        T first = (T)"first";
        T second = (T)"second";
        T third = (T)"third";

        full = new LinkedStack<T>();
        full.push(third);
        full.push(second);
        full.push(first);

        empty = new LinkedStack<T>();
    }


    /**
     * testing clear method
     */
    public void testClear() {
        full.clear();
        assertEquals(full.toString(), empty.toString());
    }


    /**
     * testing the getter for size field
     */
    public void testSize() {
        assertEquals(full.size(), 3);
        assertEquals(empty.size(), 0);
    }


    /**
     * testing isEmpty() method
     */
    public void testIsEmpty() {
        assertFalse(full.isEmpty());
        assertTrue(empty.isEmpty());
    }


    /**
     * testing toString method
     */
    public void testToString() {
        assertEquals(full.toString(), "[first, second, third]");
        assertEquals(empty.toString(), "[]");
    }


    /**
     * testing peek method
     */
    public void testPeek() {

        assertEquals(full.peek(), "first");

        Exception exception = null;
        try {
            empty.peek();
            fail("peek() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("peek() is throwing the wrong type of exceptions",
            exception instanceof EmptyStackException);

    }


    /**
     * testing pop method
     */
    public void testPop() {

        assertEquals(full.pop(), "first");

        Exception exception = null;
        try {
            empty.pop();
            fail("pop() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("pop() is throwing the wrong type of exceptions",
            exception instanceof EmptyStackException);

    }


    /**
     * testing push method
     */
    @SuppressWarnings("unchecked")
    public void testPush() {
        T lol = (T)"lol";
        empty.push(lol);
        assertEquals(empty.toString(), "[lol]");
    }


    /**
     * testing the private node class methods
     */
    @SuppressWarnings("unchecked")
    public void testSetNextNode() {
        T zero = (T)"zero";
        full.push(zero);
        assertEquals(full.peek(), "zero");
    }
}
