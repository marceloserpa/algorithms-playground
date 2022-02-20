import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    @DisplayName("calculate manhattan distance")
    public void testManhattahnDistance() {
        int[][] a = new int[3][3];

        a[0][0] = 8;
        a[0][1] = 1;
        a[0][2] = 3;

        a[1][0] = 4;
        a[1][1] = 0;
        a[1][2] = 2;

        a[2][0] = 7;
        a[2][1] = 6;
        a[2][2] = 5;

        Board board = new Board(a);

        Assertions.assertEquals(10, board.manhattan());
    }

    @Test
    @DisplayName("calculate hamming distance")
    public void testHammingDistance() {
        int[][] a = new int[3][3];

        a[0][0] = 8;
        a[0][1] = 1;
        a[0][2] = 3;

        a[1][0] = 4;
        a[1][1] = 0;
        a[1][2] = 2;

        a[2][0] = 7;
        a[2][1] = 6;
        a[2][2] = 5;

        Board board = new Board(a);

        Assertions.assertEquals(5, board.hamming());
    }

    @Test
    @DisplayName("create neighbors")
    public void testNeighbors() {
        int[][] a = new int[3][3];

        a[0][0] = 8;
        a[0][1] = 1;
        a[0][2] = 3;

        a[1][0] = 4;
        a[1][1] = 0;
        a[1][2] = 2;

        a[2][0] = 7;
        a[2][1] = 6;
        a[2][2] = 5;

        Board board = new Board(a);

        List<Board> neighbors = StreamSupport.stream(board.neighbors().spliterator(), false)
                        .collect(Collectors.toList());

        Assertions.assertEquals(4, neighbors.size());


        int[][] right = new int[3][3];

        right[0][0] = 8;
        right[0][1] = 1;
        right[0][2] = 3;

        right[1][0] = 0;
        right[1][1] = 4;
        right[1][2] = 2;

        right[2][0] = 7;
        right[2][1] = 6;
        right[2][2] = 5;

        Board rightNeighborExpected = new Board(right);

        Assertions.assertEquals(rightNeighborExpected, neighbors.get(0));


        int[][] top = new int[3][3];

        top[0][0] = 8;
        top[0][1] = 0;
        top[0][2] = 3;

        top[1][0] = 4;
        top[1][1] = 1;
        top[1][2] = 2;

        top[2][0] = 7;
        top[2][1] = 6;
        top[2][2] = 5;

        Board topNeighborExpected = new Board(top);
        Assertions.assertEquals(topNeighborExpected, neighbors.get(1));


        int[][] left = new int[3][3];

        left[0][0] = 8;
        left[0][1] = 1;
        left[0][2] = 3;

        left[1][0] = 4;
        left[1][1] = 2;
        left[1][2] = 0;

        left[2][0] = 7;
        left[2][1] = 6;
        left[2][2] = 5;

        Board leftNeighborExpected = new Board(left);
        Assertions.assertEquals(leftNeighborExpected, neighbors.get(2));


        int[][] bottom = new int[3][3];

        bottom[0][0] = 8;
        bottom[0][1] = 1;
        bottom[0][2] = 3;

        bottom[1][0] = 4;
        bottom[1][1] = 6;
        bottom[1][2] = 2;

        bottom[2][0] = 7;
        bottom[2][1] = 0;
        bottom[2][2] = 5;

        Board bottomNeighborExpected = new Board(bottom);
        Assertions.assertEquals(bottomNeighborExpected, neighbors.get(3));

    }


    @Test
    @DisplayName("Testing hamming in a 5-by-5 grid")
    public void hamming5by5grid(){
        int[][] grid = new int[5][5];
        grid[0][0] = 7;
        grid[0][1] = 14;
        grid[0][2] = 12;
        grid[0][3] = 1;
        grid[0][4] = 6;

        grid[1][0] = 20;
        grid[1][1] = 3;
        grid[1][2] = 22;
        grid[1][3] = 8;
        grid[1][4] = 10;

        grid[2][0] = 16;
        grid[2][1] = 2;
        grid[2][2] = 13;
        grid[2][3] = 4;
        grid[2][4] = 23;

        grid[3][0] = 0;
        grid[3][1] = 19;
        grid[3][2] = 21;
        grid[3][3] = 18;
        grid[3][4] = 24;

        grid[4][0] = 11;
        grid[4][1] = 17;
        grid[4][2] = 15;
        grid[4][3] = 5;
        grid[4][4] = 9;

        Board board = new Board(grid);


        Assertions.assertEquals(22, board.hamming());
    }

    @Test
    @DisplayName("Testing hamming in a 3-by-3 grid")
    public void hamming3by3grid(){
        int[][] grid = new int[3][3];
        grid[0][0] = 2;
        grid[0][1] = 1;
        grid[0][2] = 7;

        grid[1][0] = 0;
        grid[1][1] = 5;
        grid[1][2] = 6;

        grid[2][0] = 8;
        grid[2][1] = 4;
        grid[2][2] = 3;


        Board board = new Board(grid);


        Assertions.assertEquals(6, board.hamming());
    }

    @Test
    @DisplayName("Testing hamming in a 3-by-3 grid second scenario")
    public void hamming3by3grid2(){
        int[][] grid = new int[3][3];
        grid[0][0] = 1;
        grid[0][1] = 2;
        grid[0][2] = 0;

        grid[1][0] = 7;
        grid[1][1] = 8;
        grid[1][2] = 4;

        grid[2][0] = 5;
        grid[2][1] = 6;
        grid[2][2] = 3;


        Board board = new Board(grid);


        Assertions.assertEquals(6, board.hamming());
    }

    @Test
    public void twin(){

        int[][] grid = new int[3][3];
        grid[0][0] = 5;
        grid[0][1] = 0;
        grid[0][2] = 4;

        grid[1][0] = 2;
        grid[1][1] = 3;
        grid[1][2] = 8;

        grid[2][0] = 7;
        grid[2][1] = 1;
        grid[2][2] = 6;

        Board board = new Board(grid);



        int[][] twinGrid = new int[3][3];
        twinGrid[0][0] = 4;
        twinGrid[0][1] = 0;
        twinGrid[0][2] = 5;

        twinGrid[1][0] = 2;
        twinGrid[1][1] = 3;
        twinGrid[1][2] = 8;

        twinGrid[2][0] = 7;
        twinGrid[2][1] = 1;
        twinGrid[2][2] = 6;

        Board expectedTwin = new Board(twinGrid);

        Assertions.assertNotEquals(board, board.twin());
        Assertions.assertEquals(expectedTwin, board.twin());
    }

    @Test
    public void compareBoardsWithDifferent(){
        int[][] grid1 = new int[2][2];
        grid1[0][0] = 3;
        grid1[0][1] = 1;

        grid1[1][0] = 2;
        grid1[1][1] = 0;

        Board board1 = new Board(grid1);


        int[][] grid2 = new int[3][3];
        grid2[0][0] = 3;
        grid2[0][1] = 1;
        grid2[0][2] = 6;

        grid2[1][0] = 2;
        grid2[1][1] = 0;
        grid2[1][2] = 8;

        grid2[2][0] = 4;
        grid2[2][1] = 5;
        grid2[2][2] = 7;

        Board board2 = new Board(grid2);

        Assertions.assertNotEquals(board2, board1);
    }


}