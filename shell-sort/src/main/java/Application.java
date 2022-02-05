public class Application {
    public static void main(String[] args) {
        Integer[] numbers = new Integer[10];
        numbers[0] = 9;
        numbers[1] = 2;
        numbers[2] = 1;
        numbers[3] = 3;
        numbers[4] = 10;
        numbers[5] = 2;
        numbers[6] = 6;
        numbers[7] = 5;
        numbers[8] = 1;
        numbers[9] = 0;

        Shell.sort(numbers);

        System.out.println("\n\n");
        for(int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i]);
        }




    }
}
