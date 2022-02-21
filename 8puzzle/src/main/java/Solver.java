import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class Solver {

    private SearchNode endNode;

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        SearchNode searchNode = new SearchNode(initial, 0, null);

        MinPQ<SearchNode> searchNodeMinPQ = new MinPQ<>();
        searchNodeMinPQ.insert(searchNode);

        MinPQ<SearchNode> searchNodeTwinMinPQ = new MinPQ<>();
        searchNodeTwinMinPQ.insert(new SearchNode(searchNode.board.twin(), 0, null));

        SearchNode current = searchNodeMinPQ.delMin();
        while(!current.board.isGoal()) {
            Iterable<Board> neighbors = current.board.neighbors();
            for(Board neighbor : neighbors) {
                searchNodeMinPQ.insert(new SearchNode(neighbor, current.numberOfMoves + 1, current));
            }

            current = searchNodeMinPQ.delMin();
        }

        endNode = current;

    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        return endNode.board.isGoal();
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        return endNode.getNumberOfMoves();
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {

        Stack<Board> stack = new Stack<>();

        SearchNode localSearchNode = endNode;
        do {
            stack.push(localSearchNode.board);

            localSearchNode = localSearchNode.previous;

        }while(localSearchNode != null);

        return stack;
    }

    private class SearchNode implements Comparable<SearchNode>{

        private Board board;
        private int numberOfMoves;
        private SearchNode previous;

        public SearchNode(Board board, int numberOfMoves, SearchNode previous) {
            this.board = board;
            this.numberOfMoves = numberOfMoves;
            this.previous = previous;
        }

        public Board getBoard() {
            return board;
        }

        public int getNumberOfMoves() {
            return numberOfMoves;
        }

        public SearchNode getPrevious() {
            return previous;
        }

        public int getPriority(){
            return this.numberOfMoves + this.board.manhattan();
        }

        public int compareTo(SearchNode other) {
            if(getPriority() == other.getPriority()) {
                return 0;
            } else if(getPriority() > other.getPriority()) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    // test client (see below)
    public static void main(String[] args) {

        int[][] grid1 = new int[2][2];
        grid1[0][0] = 0;
        grid1[0][1] = 1;

        grid1[1][0] = 3;
        grid1[1][1] = 2;

        Board board = new Board(grid1);

        Solver solver = new Solver(board);
        solver.moves();

        for(Board solution : solver.solution()) {
//            System.out.println("----");
  //          System.out.println(solution);
        }


    }

}