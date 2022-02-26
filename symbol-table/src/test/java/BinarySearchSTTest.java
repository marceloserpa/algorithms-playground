import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinarySearchSTTest {

    @Test
    public void insert(){
        BinarySearchST<Integer, String> playersID = new BinarySearchST<>(10);
        playersID.put(18, "Yugi Muto");
        playersID.put(70, "Bakura");
        playersID.put(33, "Joe");
        playersID.put(1, "Marik");
        playersID.put(0, "Kaiba");


        Assertions.assertEquals("Kaiba", playersID.get(0));
        Assertions.assertEquals("Yugi Muto", playersID.get(18));
    }

}