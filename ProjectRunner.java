package towerofhanoi;
// Virginia Tech Honor Code Pledge:
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Solaiman Ibrahimi (kuplar)

/**
 * Project Runner class
 * 
 * @author Solaiman Ibrahimi
 * @version 03.20.2023
 */
public class ProjectRunner {

    /**
     * main method
     * 
     * @param args
     */
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        int disks = 6;
        if (args.length == 1) {
            disks = Integer.parseInt(args[0]);
        }
        HanoiSolver hs = new HanoiSolver(disks);
        PuzzleWindow pw = new PuzzleWindow(hs);
    }


    /**
     * constructor for class
     */
    public ProjectRunner() {
        // empty
    }
}
