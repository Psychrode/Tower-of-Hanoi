package towerofhanoi;
// -- Solaiman Ibrahimi (kuplar)

import student.TestCase;

/**
 * Class to test disk functionality
 * 
 * @author Solaiman Ibrahimi
 * @version 03.21.2023
 */
public class DiskTest extends TestCase {

    private Disk big;
    private Disk small;

    /**
     * setUp method that runs once before each test method
     */
    public void setUp() {
        big = new Disk(6);
        small = new Disk(3);
    }


    /**
     * testing compareTo method
     */
    public void testCompareTo() {
        assertEquals(big.compareTo(small), 1);
        assertEquals(small.compareTo(big), -1);
        assertEquals(big.compareTo(big), 0);

        Exception exception = null;
        try {
            big.compareTo(null);
            fail("compareTo() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("compareTo) is throwing the wrong type of exceptions",
            exception instanceof IllegalArgumentException);
    }


    /**
     * testing toString method
     */
    public void testToString() {
        assertEquals(big.toString(), "6");
        assertEquals(small.toString(), "3");
    }


    /**
     * testing equals method
     */
    public void testEquals() {
        Disk clone = new Disk(6);
        Object str = "hi";

        assertTrue(big.equals(big));
        assertTrue(big.equals(clone));

        assertFalse(big.equals(null));
        assertFalse(big.equals(str));
        assertFalse(big.equals(small));
    }

}
