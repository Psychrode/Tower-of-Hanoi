package towerofhanoi;
// -- Solaiman Ibrahimi (kuplar)

import student.TestCase;

/**
 * tester class for HanoiSolver algorithm
 * 
 * @author Solaiman Ibrahimi
 * @version 03.21.2023
 */
public class HanoiSolverTest extends TestCase {

    private HanoiSolver game;

    /**
     * setUp method to run before each test
     */
    public void setUp() {
        game = new HanoiSolver(6);
    }


    /**
     * testing disks method
     */
    public void testDisks() {
        assertEquals(game.disks(), 6);
    }


    /**
     * testing getter for tower method
     */
    public void testGetTower() {
        Tower left = game.getTower(Position.LEFT);
        Tower middle = game.getTower(Position.MIDDLE);
        Tower right = game.getTower(Position.RIGHT);

        assertEquals(game.getTower(Position.LEFT), left);
        assertEquals(game.getTower(Position.MIDDLE), middle);
        assertEquals(game.getTower(Position.RIGHT), right);
        assertEquals(game.getTower(Position.DEFAULT), middle);
    }


    /**
     * testing toString method
     */
    public void testToString() {
        assertEquals(game.toString(), "[][][]");

        Disk disk1 = new Disk(1);
        Disk disk2 = new Disk(2);
        Disk disk3 = new Disk(3);
        Disk disk4 = new Disk(4);
        Disk disk5 = new Disk(5);
        Disk disk6 = new Disk(6);

        game.getTower(Position.LEFT).push(disk2);
        game.getTower(Position.LEFT).push(disk1);

        game.getTower(Position.MIDDLE).push(disk4);
        game.getTower(Position.MIDDLE).push(disk3);

        game.getTower(Position.RIGHT).push(disk6);
        game.getTower(Position.RIGHT).push(disk5);

        assertEquals(game.toString(), "[1, 2][3, 4][5, 6]");
    }


    /**
     * testing move method / solve method / solveTowers method
     */
    public void testSolve() {
        Disk disk1 = new Disk(1);
        Disk disk2 = new Disk(2);
        Disk disk3 = new Disk(3);
        Disk disk4 = new Disk(4);
        Disk disk5 = new Disk(5);
        Disk disk6 = new Disk(6);

        game.getTower(Position.LEFT).push(disk6);
        game.getTower(Position.LEFT).push(disk5);
        game.getTower(Position.LEFT).push(disk4);
        game.getTower(Position.LEFT).push(disk3);
        game.getTower(Position.LEFT).push(disk2);
        game.getTower(Position.LEFT).push(disk1);

        assertEquals(game.toString(), "[1, 2, 3, 4, 5, 6][][]");

        game.solve();

        assertEquals(game.toString(), "[][][1, 2, 3, 4, 5, 6]");
    }

}
