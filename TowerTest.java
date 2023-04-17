package towerofhanoi;
// -- Solaiman Ibrahimi (kuplar)

import student.TestCase;

/**
 * Tester class for Tower
 * 
 * @author Solaiman Ibrahimi
 * @version 03.21.2023
 */
public class TowerTest extends TestCase {

    private Tower middle;

    /**
     * setUp method to run before each test
     */
    public void setUp() {
        middle = new Tower(Position.MIDDLE);
    }


    /**
     * testing position getter
     */
    public void testPosition() {
        assertEquals(middle.position(), Position.MIDDLE);
    }


    /**
     * testing overridden push method
     */
    public void testPush() {
        Disk small = new Disk(6);
        middle.push(small);

        Disk big = new Disk(7);

        Exception exception = null;
        try {
            middle.push(big);
            fail("push() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("push() is throwing the wrong type of exceptions",
            exception instanceof IllegalStateException);

        Exception exceptionTwo = null;
        try {
            middle.push(null);
            fail("push() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exceptionTwo = e;
        }
        assertTrue("push() is throwing the wrong type of exceptions",
            exceptionTwo instanceof IllegalArgumentException);
        assertEquals(middle.size(), 1);
    }

}
