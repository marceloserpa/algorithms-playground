import java.util.ArrayList;
import java.util.List;

public class Board {

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    private int [][] tiles;

    private int blankSquareRow = 0;
    private int blankSquareCol = 0;


    public Board(int[][] tiles){
        int n = tiles.length;
        this.tiles = new int[n][n];

        // create a copy
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                this.tiles[i][j] = tiles[i][j];
                if(tiles[i][j] == 0) { // search for blank square
                    blankSquareRow = i;
                    blankSquareCol = j;
                }
            }
        }

    }

    // string representation of this board
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(tiles.length).append("\n");
        for(int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles.length; j++) {
                sb.append(" " + tiles[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // board dimension n
    public int dimension() {
        return 0;
    }

    // number of tiles out of place
    public int hamming() {
        return 0;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        return 0;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return false;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        return false;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        List<Board> neighbors = new ArrayList<>();
        // right
        if(blankSquareCol > 0) {
            neighbors.add(createNeighbor(blankSquareRow, blankSquareCol - 1));
        }

        // top
        if(blankSquareRow > 0) {
            neighbors.add(createNeighbor(blankSquareRow-1, blankSquareCol ));
        }

        // left
        if(blankSquareCol < tiles.length) {
            neighbors.add(createNeighbor(blankSquareRow, blankSquareCol+1));
        }

        // bottom
        if(blankSquareRow < tiles.length) {
            neighbors.add(createNeighbor(blankSquareRow+1, blankSquareCol));
        }
        return neighbors;
    }

    private Board createNeighbor(int blankRow, int blankCol) {
        int n = tiles.length;
        int[][] newArray = new int[n][n];

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newArray[i][j] = tiles[i][j];
            }
        }

        // swap
        newArray[blankSquareRow][blankSquareCol] = newArray[blankRow][blankCol];
        newArray[blankRow][blankCol] = 0; // move blank

        return new Board(newArray);
    }


    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        return null;
    }

    // unit testing (not graded)
    public static void main(String[] args) {

        int[][] a = new int[3][3];

        a[0][0] = 1;
        a[0][1] = 0;
        a[0][2] = 3;

        a[1][0] = 4;
        a[1][1] = 2;
        a[1][2] = 5;

        a[2][0] = 7;
        a[2][1] = 8;
        a[2][2] = 6;

        Board board = new Board(a);
        System.out.println(board.toString());

        /**
         3
         1 0 3
         4 2 5
         7 8 6
         */

        System.out.println("------");
        int i = 1;
        for(Board board1 : board.neighbors()){
            System.out.println("# " + i++ + " === \n");
            System.out.println(board1);
        }

    }

}