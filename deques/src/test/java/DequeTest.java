import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DequeTest {

    @Test
    public void shouldSizeReturnsTotalOfItems1(){
        Deque<Integer> numbers = new Deque<>();
        numbers.addFirst(1);
        numbers.addFirst(2);
        numbers.addFirst(3);

        Assertions.assertEquals(3, numbers.size());
    }

    @Test
    public void shouldSizeReturnsTotalOfItems2(){
        Deque<Integer> numbers = new Deque<>();
        numbers.addLast(1);
        numbers.addLast(2);
        numbers.addLast(3);

        Assertions.assertEquals(3, numbers.size());
    }

}