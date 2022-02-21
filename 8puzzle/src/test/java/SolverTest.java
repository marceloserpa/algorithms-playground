import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class SolverTest {

    @Test
    public void test(){
        int[][] grid = new int[2][2];
        grid[0][0] = 1;
        grid[0][1] = 0;
        grid[1][0] = 3;
        grid[1][1] = 2;

        Board board = new Board(grid);
        Solver solver = new Solver(board);

        Iterator<Board> process = solver.solution().iterator();
        Assertions.assertEquals(board, process.next());

    }

    @Test
    public void test2(){
        int[][] grid = new int[3][3];

        grid[0][0] = 0;
        grid[0][1] = 1;
        grid[0][2] = 3;

        grid[1][0] = 4;
        grid[1][1] = 2;
        grid[1][2] = 5;

        grid[2][0] = 7;
        grid[2][1] = 8;
        grid[2][2] = 6;

        Solver solver = new Solver(new Board(grid));

        Assertions.assertEquals(4, solver.moves());

    }

}