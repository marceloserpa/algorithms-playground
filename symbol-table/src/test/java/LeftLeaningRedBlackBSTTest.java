import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LeftLeaningRedBlackBSTTest {


    @Test
    public void testGet(){
        LeftLeaningRedBlackBST<Integer, String> playersID = new LeftLeaningRedBlackBST<>();

        playersID.put(18, "Yugi Muto");
        playersID.put(70, "Bakura");
        playersID.put(33, "Joe");
        playersID.put(1, "Marik");
        playersID.put(0, "Kaiba");

        Assertions.assertEquals("Joe", playersID.get(33));
    }

    @Test
    public void testDelete(){
        LeftLeaningRedBlackBST<Integer, String> playersID = new LeftLeaningRedBlackBST<>();

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
        LeftLeaningRedBlackBST<Integer, String> playersID = new LeftLeaningRedBlackBST<>();

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