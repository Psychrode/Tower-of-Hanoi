package towerofhanoi;
// -- Solaiman Ibrahimi (kuplar)

import java.awt.Color;
import cs2.Shape;
import student.TestableRandom;

/**
 * Disk class that transposes the disks to
 * moving along towers
 * 
 * @author Solaiman Ibrahimi
 * @version 03.20.2023
 */
public class Disk extends Shape implements Comparable<Disk> {

    /**
     * class constructor
     * 
     * @param width
     *            width value
     */
    public Disk(int width) {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
        TestableRandom tr = new TestableRandom();
        Color bg = new Color(tr.nextInt(256), tr.nextInt(256), tr.nextInt(256));
        this.setBackgroundColor(bg);
    }


    /**
     * compareTo overridden method (compare disk objects)
     * 
     * @param o
     *            inserted disk
     * @return an int 1 or -1 or 0
     */
    @Override
    public int compareTo(Disk o) {
        if (o == null) {
            throw new IllegalArgumentException();
        }
        if (this.getWidth() < o.getWidth()) {
            return -1;
        }
        else if (this.getWidth() > o.getWidth()) {
            return 1;
        }
        return 0;
    }


    /**
     * toString method for width display && testing
     * 
     * @return the string in proper format
     */
    @Override
    public String toString() {
        return Integer.toString(this.getWidth());
    }


    /**
     * equals method to check if disks are equal (width)
     * 
     * @param o
     *            inputted object for equivalence
     * @return true or false if equal or not
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }
        Disk comp = (Disk)o;
        return comp.getWidth() == this.getWidth();
    }
}
