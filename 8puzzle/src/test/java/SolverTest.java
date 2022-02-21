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

}