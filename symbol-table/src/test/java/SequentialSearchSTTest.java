import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SequentialSearchSTTest {


    @Test
    public void test(){
        SequentialSearchST<String, String> dns = new SequentialSearchST<>();
        dns.put("www.google.com", "8.8.8.8");
        dns.put("www.yahoo.com", "8.8.8.1");

        Assertions.assertEquals("8.8.8.1", dns.get("www.yahoo.com"));
    }

}