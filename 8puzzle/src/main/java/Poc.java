public class Poc {


    public static void main(String[] args) {


        /**
         *  8 1 3
         *  4 0 2
         *  7 6 5
         */

        int square = 6;

      //  square--;


        int currentRow = 2;
        int currentCol = 1;


//        int goalRow = 1;
//        int goalCol = 2;

        int dimension = 3;

        int goalCol = square == 0 ? dimension - 1 : (square - 1) % dimension;
        System.out.println("goal Col = " + goalCol);

        int goalRow = square == 0 ? dimension - 1 : (square - 1)  / dimension;
        System.out.println("goal Row = " + goalRow);


        int r = Math.abs(currentRow - goalRow) + Math.abs(currentCol - goalCol);
        System.out.println(r);

        // int manhattanDistance = calcManhattanDistance(currentRow, currentCol, square, 3);

        //System.out.println(manhattanDistance);

    }

    private static int calcManhattanDistance(int x1, int y1, int square, int dimension) {

        int x2 = (square) % dimension;
        int y2 = (square) / dimension;

        System.out.println("should be = (" + x2 + "," + y2 + ")");
        System.out.println("be = (" + x1 + "," + y1 + ")");

        // https://iq.opengenus.org/manhattan-distance/#:~:text=Manhattan%20distance%20is%20a%20distance,all%20dimensions%20of%20two%20points.


        int oix = square == 0 ? dimension - 1 : (square - 1) % dimension;
        int oiy = square == 0 ? dimension - 1 : (square - 1) / dimension;

        int abs = Math.abs(oix - x1);
        int absy = Math.abs(oiy - y1);


        return abs + absy;
    }


}
