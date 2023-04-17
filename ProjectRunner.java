package towerofhanoi;
// -- Solaiman Ibrahimi (kuplar)

/**
 * Project Runner class
 * 
 * @author Solaiman Ibrahimi
 * @version 03.20.2023
 */
public class ProjectRunner {

    /**
     * main method to run application
     * 
     * @param args
     *        used to check if custom input of disks inputted
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
        // empty - main only needed for now
    }
}
