package towerofhanoi;
// Virginia Tech Honor Code Pledge:
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Solaiman Ibrahimi (kuplar)

import java.util.Observable;
import java.util.Observer;
import cs2.Button;
import cs2.ClickAction;
import cs2.Shape;
import java.util.Observable;
import java.util.Observer;
import cs2.Window;
import cs2.WindowSide;

/**
 * Class that handles the frontend of the project
 * 
 * @author Solaiman Ibrahimi
 * @version 03.21.2023
 */
public class PuzzleWindow implements Observer {

    private HanoiSolver game;
    private cs2.Shape left;
    private cs2.Shape right;
    private cs2.Shape middle;
    private cs2.Window window;
    public static final int WIDTH_FACTOR = 20;
    public static final int DISK_GAP = 20;
    public static final int DISK_HEIGHT = 20;

    /**
     * Class constructor to setup GUI
     * 
     * @param game
     *            the game config to deal with
     */
    public PuzzleWindow(HanoiSolver game) {
        this.game = game;
        game.addObserver(this);
        window = new Window("Tower of Hanoi");

        left = new Shape(WIDTH_FACTOR * (game.disks()), 100, WIDTH_FACTOR,
            DISK_HEIGHT * game.disks());
        middle = new Shape(WIDTH_FACTOR * (game.disks() * 2), 100, WIDTH_FACTOR,
            DISK_HEIGHT * game.disks());
        right = new Shape(WIDTH_FACTOR * (game.disks() * 3), 100, WIDTH_FACTOR,
            DISK_HEIGHT * game.disks());

        for (int i = game.disks() - 1; i >= 0; i--) {
            int diskWidth = (i + 1) * DISK_GAP;
            Disk disk = new Disk(diskWidth);
            window.addShape(disk);
            game.getTower(Position.LEFT).push(disk);
            moveDisk(Position.LEFT);
        }

        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);

        cs2.Button solve = new cs2.Button("Solve");
        solve.onClick(this, "clickedSolve");
        window.addButton(solve, WindowSide.NORTH);

    }


    /**
     * Updates board based on arguments
     * 
     * @param o
     *            honestly didnt understand what this does
     * @param arg
     *            a possible position argument to move objects
     */
    @Override
    public void update(Observable o, Object arg) {
        if (arg.getClass() == Position.class) {
            Position pos = (Position)arg;
            this.moveDisk(pos);
            this.sleep();
        }

    }


    /**
     * delay?
     */
    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }


    /**
     * method that checks if solved button has been pressed
     * 
     * @param button
     *            button on screen labled "solve"
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }


    /**
     * method that moves disks accordingly on screen
     * once solve has been pressed
     * 
     * @param position
     *            the disk on tower to move
     */
    private void moveDisk(Position position) {
        Disk currentDisk = game.getTower(position).peek();

        cs2.Shape currentPole = null;
        if (position == Position.LEFT) {
            currentPole = this.left;
        }
        else if (position == Position.RIGHT) {
            currentPole = this.right;
        }
        else {
            currentPole = this.middle;
        }

        int numDisks = game.getTower(position).size();
        int currPoleX = currentPole.getX() + currentPole.getWidth() / 2;
        int currPoleY = currentPole.getY() + currentPole.getHeight();
        int diskX = currPoleX - currentDisk.getWidth() / 2;
        int diskY = currPoleY - currentDisk.getHeight() - (numDisks
            * DISK_HEIGHT);

        currentDisk.moveTo(diskX, diskY);
    }

}
