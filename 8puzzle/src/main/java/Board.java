import java.util.ArrayList;
import java.util.List;

public class Board {

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    private int[][] tiles;

    private int blankSquareRow = 0;
    private int blankSquareCol = 0;


    public Board(int[][] tiles) {
        int n = tiles.length;
        this.tiles = new int[n][n];

        // create a copy
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.tiles[i][j] = tiles[i][j];
                if (tiles[i][j] == 0) { // search for blank square
                    blankSquareRow = i;
                    blankSquareCol = j;
                }
            }
        }

    }

    // string representation of this board
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(tiles.length).append("\n");
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                sb.append(" " + tiles[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // board dimension n
    public int dimension() {
        return tiles.length;
    }

    // number of tiles out of place
    public int hamming() {
        int tilesOutOfPlace = 0;
        int item = 1;
        int blankSpaceFinalPosition = tiles.length ^ tiles.length;

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                String message = "[i=" + i + " j=" + j + "] " + tiles[i][j] + " != " + item;

                if (tiles[i][j] != 0) {
                    if (item == blankSpaceFinalPosition) {
                        if (tiles[i][j] != 0) {
                            tilesOutOfPlace++;
                            //System.out.println(message + " x");
                        }
                    } else if (tiles[i][j] != item) {
                        tilesOutOfPlace++;
                        //System.out.println(message + " x");
                    } else {
                        //System.out.println(message + " v");
                    }
                }


                item++;
            }
        }

        return tilesOutOfPlace;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        int manhattanDistance = 0;
        int tmp = 1;

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                String message = tmp + " (" + i + "," + j + ") = " + tiles[i][j] + " distance=";

                if (tiles[i][j] != 0) {
                    if (tiles[i][j] == tmp) {
                       // System.out.println(message + " 0");
                    } else {
                        int distance = calcManhattanDistance(i, j, tiles[i][j]);
                      //  System.out.println(message + " " + distance);
                        manhattanDistance += distance;
                    }


                }
                tmp++;

            }
        }

        return manhattanDistance;
    }

    private int calcManhattanDistance(int row, int col, int square) {
        int dimension = tiles.length;

        // find the goal X and Y axis
        int goalCol = square == 0 ? dimension - 1 : (square - 1) % dimension;
        int goalRow = square == 0 ? dimension - 1 : (square - 1) / dimension;

        // calculate Manhattan distance
        return  Math.abs(row - goalRow) + Math.abs(col - goalCol);
    }


    // is this board the goal board?
    public boolean isGoal() {
        int end = tiles.length - 1;

        if(tiles[end][end] != 0) {
            return false;
        }

        int current = 1;
        for(int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles.length; j++) {
                if(tiles[i][j] != current) {
                    if(i == end && j == end && tiles[i][j] == 0) {
                        // zero always the last element
                        return true;
                    }
                    return false;
                }
                current++;
            }
        }

        return true;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if(y == null) {
            return false;
        }

        if(!y.getClass().equals(this.getClass())) {
           return false;
        }

        Board other = (Board) y;

        if(dimension() != other.dimension()) {
            return false;
        }

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                if (tiles[i][j] != other.tiles[i][j]) {
                    return false;
                }
            }

        }
        return true;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        List<Board> neighbors = new ArrayList<>();
        // right
        if (blankSquareCol > 0) {
            neighbors.add(createNeighbor(blankSquareRow, blankSquareCol - 1));
        }

        // top
        if (blankSquareRow > 0) {
            neighbors.add(createNeighbor(blankSquareRow - 1, blankSquareCol));
        }

        // left
        if (blankSquareCol < tiles.length - 1) {
            neighbors.add(createNeighbor(blankSquareRow, blankSquareCol + 1));
        }

        // bottom
        if (blankSquareRow < tiles.length - 1) {
            neighbors.add(createNeighbor(blankSquareRow + 1, blankSquareCol));
        }
        return neighbors;
    }

    private Board createNeighbor(int blankRow, int blankCol) {
        int n = tiles.length;
        int[][] newArray = new int[n][n];

        for (int i = 0; i < n; i++) {
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

        int n = tiles.length;
        int[][] newArray = new int[n][n];

        // create a copy from tiles
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newArray[i][j] = tiles[i][j];
            }
        }

        // find first axis non-zero
        int[] firstAxis = findNonBlank(0, 0);
        int row1 = firstAxis[0];
        int col1 = firstAxis[1];


        // find second axis non-zero
        int y = col1 < n - 1 ? col1 +1 : col1;
        int x = row1;

        if(y == col1) {
            x++;
            y=0;
        }

        int[] secondAxis = findNonBlank(x, y);

        int row2 = secondAxis[0];
        int col2 = secondAxis[1];

        int tmp = newArray[row1][col1];

        newArray[row1][col1] = newArray[row2][col2];
        newArray[row2][col2] = tmp;

        return new Board(newArray);
    }

    private int[] findNonBlank(int row, int col) {
        int n = dimension();

        for(int i = row; i < n; i++) {
            for( int j = col; j <  n; j++) {
                if(tiles[i][j] != 0) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{0, 0};
    }

    // unit testing (not graded)
    public static void main(String[] args) {


        /**
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
         System.out.println(String.format("hamming distance : %d", board.hamming()));
         System.out.println(String.format("manhatthan distance : %d", board.manhattan()));
         **/

        /**
         3
         1 0 3
         4 2 5
         7 8 6
         */

        System.out.println("------");

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
      //  System.out.println(board.toString());
     //   System.out.println(String.format("hamming distance : %d", board.hamming()));
      //  System.out.println(String.format("manhatthan distance : %d", board.manhattan()));


        /*
        int i = 1;
        for(Board board1 : board.neighbors()){
            System.out.println("# " + i++ + " === \n");
            System.out.println(board1);
            System.out.println(String.format("hamming distance : %d", board1.hamming()));
            System.out.println(String.format("manhatthan distance : %d", board1.manhattan()));
        }

         */

    }

}