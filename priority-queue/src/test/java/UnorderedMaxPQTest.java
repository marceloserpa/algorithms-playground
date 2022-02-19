import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UnorderedMaxPQTest {

    @Test
    public void showTop3(){
        UnorderedMaxPQ<Integer> numbers = new UnorderedMaxPQ<>(10);
        numbers.insert(10);
        numbers.insert(1);
        numbers.insert(2);
        numbers.insert(3);
        numbers.insert(5);
        numbers.insert(6);
        numbers.insert(100);
        numbers.insert(0);
        numbers.insert(9);

        Assertions.assertEquals(100, numbers.delMax());
        Assertions.assertEquals(10, numbers.delMax());
        Assertions.assertEquals(9, numbers.delMax());
    }


}