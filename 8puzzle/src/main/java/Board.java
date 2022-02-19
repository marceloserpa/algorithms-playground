public class Board {

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)

    private int [][] tiles;

    public Board(int[][] tiles){
        this.tiles = tiles;
    }

    // string representation of this board
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles.length; j++) {
                sb.append(tiles[i][j] + " ");
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
        return null;
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
         * 1 0 3
         * 4 2 5
         * 7 8 6 
         */

    }

}