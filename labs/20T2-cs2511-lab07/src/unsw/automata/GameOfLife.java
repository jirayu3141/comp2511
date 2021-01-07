/**
 *
 */
package unsw.automata;

import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

/**
 * Conway's Game of Life on a 10x10 grid.
 *
 * @author Jirayu Sirivorawong
 *
 */
public class GameOfLife {
    private BooleanProperty[][] life;
    private static final int GRID_SIZE = 10;

    // At the start all cells are dead 10*10 cell
    public GameOfLife() {
        this.life = new BooleanProperty[GRID_SIZE][GRID_SIZE];
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                life[i][j] = new SimpleBooleanProperty(false);
            }
        }
    }

    // Set the cell at (x,y) as alive
    public void ensureAlive(int x, int y) {
        this.life[y][x].set(true);
    }

    // Set the cell at (x,y) as dead
    public void ensureDead(int x, int y) {
        this.life[y][x].set(false);
    }
    

    // Return true if the cell is alive
    public boolean isAlive(int x, int y) {
        if (this.life[y][x].get()) {
            return true;
        }
        return false;
    }

    // Return true if the cell is alive for a specified array
    public boolean isAlive(boolean[][] lifeArray, int x, int y) {
        if (lifeArray[y][x]) {
            return true;
        }
        return false;
    }

    public void tick() {
        // create a temp array to hold the value so when check for neighbour, it
        // does not check against the new value
        boolean[][] lifeClone = new boolean[GRID_SIZE][GRID_SIZE];
        lifeClone = copy(life, lifeClone);
        // y row
        for (int j = 0; j < GRID_SIZE; j++) {
            // x column
            for (int i = 0; i < GRID_SIZE; i++) {
                int neighbours = neighboursNum(lifeClone,i, j);
                // Any live cell with fewer than two live neighbours dies, as if by
                // underpopulation.
                if (neighbours < 2)
                    ensureDead(i, j);
                // Any live cell with more than three live neighbours dies, as if by
                // overpopulation.
                else if (neighbours > 3)
                    ensureDead(i, j);
                // Any dead cell with exactly three live neighbours becomes a live cell, as if
                // by reproduction.
                else if (!isAlive(i, j) && neighbours == 3)
                    ensureAlive(i, j);
            }
        }
    }

    /**
     * @param x coordinate
     * @param y coordinate
     * @return return the number of alive neighbour of the cell
     */
    public int neighboursNum(boolean[][] lifeArray,int x, int y) {
        int count = 0;
        // consider wrapped around cells
        int left = (x - 1 < 0) ? 9 : x - 1;
        int right = (x + 1 > 9) ? 0 : x + 1;
        int up = (y - 1 < 0) ? 9 : y - 1;
        int down = (y + 1 > 9) ? 0 : y + 1;

        // check west cell
        if (isAlive(lifeArray,left, y))
            count++;
        // check north-west cell
        if (isAlive(lifeArray ,left, up))
            count++;
        // check north
        if (isAlive(lifeArray, x, up))
            count++;
        // check north east
        if (isAlive(lifeArray, right, up))
            count++;
        // check east
        if (isAlive(lifeArray, right, y))
            count++;
        // check south east
        if (isAlive(lifeArray, right, down))
            count++;
        // check south
        if (isAlive(lifeArray, x, down))
            count++;
        // check south west
        if (isAlive(lifeArray, left, down))
            count++;

        return count;
    }

    private boolean[][] copy(BooleanProperty[][] life, boolean[][] lifeCopy) {
        for(int i = 0; i < GRID_SIZE; i++)
            for (int j = 0; j < GRID_SIZE; j++) {
                lifeCopy[i][j] = life[i][j].get();
            }
        return lifeCopy;
    }

    public static void main(String[] args) {
        GameOfLife newGame = new GameOfLife();
        newGame.tick();

    }

    public BooleanProperty getLifeAtCell(int x,int y) {
        return this.life[y][x];
    }

	public BooleanProperty cellProperty(int x, int y) {
		return getLifeAtCell(x, y);
	}


}
