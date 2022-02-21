import edu.princeton.cs.algs4.MinPQ;
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
        SearchNode twinCurrent = searchNodeTwinMinPQ.delMin();
        while(!current.board.isGoal() && !twinCurrent.board.isGoal()) {
            Iterable<Board> neighbors = current.board.neighbors();
            for(Board neighbor : neighbors) {

                if(! (current.previous != null && current.previous.board.equals(neighbor))) {
                    searchNodeMinPQ.insert(new SearchNode(neighbor, current.numberOfMoves + 1, current));
                }

            }
            current = searchNodeMinPQ.delMin();

            // twin
            Iterable<Board> neighborsTwin = twinCurrent.board.neighbors();
            for(Board neighbor : neighborsTwin) {
                if(!(twinCurrent.previous != null && twinCurrent.previous.board.equals(neighbor))){
                    searchNodeTwinMinPQ.insert(new SearchNode(neighbor, twinCurrent.numberOfMoves + 1, twinCurrent));
                }

            }
            twinCurrent = searchNodeTwinMinPQ.delMin();
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

        private int priority;

        public SearchNode(Board board, int numberOfMoves, SearchNode previous) {
            this.board = board;
            this.numberOfMoves = numberOfMoves;
            this.previous = previous;
            this.priority = numberOfMoves + board.manhattan();
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
            return this.priority;
        }

        public int compareTo(SearchNode other) {
            if(priority == other.getPriority()) {
                return 0;
            } else if(priority > other.getPriority()) {
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