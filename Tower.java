package towerofhanoi;
// -- Solaiman Ibrahimi (kuplar)

/**
 * Tower structure which will hold disks on display
 * 
 * @author Solaiman Ibrahimi
 * @version 03.21.2023
 */
public class Tower extends LinkedStack<Disk> {

    private Position position;

    /**
     * Class constructor for tower object
     * 
     * @param position
     *            where to position tower
     */
    public Tower(Position position) {
        super();
        this.position = position;
    }


    /**
     * getter for curr position
     * 
     * @return the curr position
     */
    public Position position() {
        return this.position;
    }


    /**
     * Overridden push method to check if valid push can be done
     * 
     * @param pushed
     *            The disk to check if able to be pushed
     */
    @Override
    public void push(Disk pushed) {
        if (pushed == null) {
            throw new IllegalArgumentException();
        }
        if (this.isEmpty() || pushed.compareTo(this.peek()) == -1) {
            super.push(pushed);
        }
        else {
            throw new IllegalStateException();
        }
    }
}
