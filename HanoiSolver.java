package towerofhanoi;
// -- Solaiman Ibrahimi (kuplar)

import java.util.Observable;

/**
 * Class that holds the recursive tree-like traversal algorithm
 * 
 * @author Solaiman Ibrahimi
 * @version 03.21.2023
 */
public class HanoiSolver extends Observable {

    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;

    /**
     * Class constructor
     * 
     * @param numDisks
     *            the number of disks to start with on startpole
     */
    public HanoiSolver(int numDisks) {
        this.numDisks = numDisks;
        this.left = new Tower(Position.LEFT);
        this.middle = new Tower(Position.MIDDLE);
        this.right = new Tower(Position.RIGHT);
    }


    /**
     * getter for numDisks field
     * 
     * @return the curr numDisk val
     */
    public int disks() {
        return this.numDisks;
    }


    /**
     * Obtain tower based on position inputted
     * 
     * @param pos
     *            the position of tower location
     * @return the tower located at pos
     */
    public Tower getTower(Position pos) {
        switch (pos) {
            case LEFT:
                return this.left;
            case MIDDLE:
                return this.middle;
            case RIGHT:
                return this.right;
            default:
                return this.middle;
        }
    }


    /**
     * toString method used for testing purposes
     * 
     * @return string in proper format
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(this.left.toString());
        str.append(this.middle.toString());
        str.append(this.right.toString());
        return str.toString();
    }


    /**
     * private method to move disks from one tower to another
     * 
     * @param source
     *            starting tower to move from
     * @param destination
     *            ending tower to move to
     */
    private void move(Tower source, Tower destination) {
        destination.push(source.pop());
        this.setChanged();
        notifyObservers(destination.position());
    }


    /**
     * Solve the tower problem by moving disk stack from one tower to the
     * next. Can treat this method as a Tree traversal : recursively move disks
     * 
     * @param currentDisks
     *            disks left to move
     * @param startPole
     *            starting pole with disks
     * @param tempPole
     *            middle pole to help move disks
     * @param endPole
     *            final pole we must move disks to
     */
    private void solveTowers(int currentDisks, Tower startPole, Tower tempPole, Tower endPole) {
        if (currentDisks == 1) {
            this.move(startPole, endPole);
        }
        else {
            // move all disks except for largest to temp
            this.solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            this.move(startPole, endPole);
            // proceed same procedure above except to the endpole starting from
            // temp
            this.solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
    }


    /**
     * method to call within frontend to solve
     * the configuration of disks when the solve button
     * has been clicked
     */
    public void solve() {
        this.solveTowers(this.numDisks, this.left, this.middle, this.right);
    }
}
