import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BSTTest {


    @Test
    public void testGet(){
        BST<Integer, String> playersID = new BST<>();

        playersID.put(18, "Yugi Muto");
        playersID.put(70, "Bakura");
        playersID.put(33, "Joe");
        playersID.put(1, "Marik");
        playersID.put(0, "Kaiba");

        Assertions.assertEquals("Joe", playersID.get(33));
    }

    @Test
    public void testDelete(){
        BST<Integer, String> playersID = new BST<>();

        playersID.put(18, "Yugi Muto");
        playersID.put(70, "Bakura");
        playersID.put(33, "Joe");
        playersID.put(1, "Marik");
        playersID.put(0, "Kaiba");

        Assertions.assertEquals("Joe", playersID.get(33));

        playersID.delete(33);

        Assertions.assertNull(playersID.get(33));
    }

    @Test
    public void testPutDuplicated(){
        BST<Integer, String> playersID = new BST<>();

        playersID.put(18, "Yugi Muto");
        playersID.put(70, "Bakura");
        playersID.put(33, "Joe");
        playersID.put(1, "Marik");
        playersID.put(0, "Kaiba");

        Assertions.assertEquals("Joe", playersID.get(33));
        playersID.put(33, "Evil Joe");
        Assertions.assertEquals("Evil Joe", playersID.get(33));
    }

}