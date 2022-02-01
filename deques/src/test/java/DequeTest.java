import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

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

    @Test
    public void shouldRemoveFirstElement(){
        Deque<Integer> numbers = new Deque<>();
        numbers.addLast(1);
        numbers.addLast(2);
        numbers.addLast(3);

        Integer element = numbers.removeFirst();

        Assertions.assertEquals(2, numbers.size());
        Assertions.assertEquals(1, element);
    }

    @Test
    public void shouldRemoveLastElement(){
        Deque<Integer> numbers = new Deque<>();
        numbers.addLast(1);
        numbers.addLast(2);
        numbers.addLast(3);

        Integer element = numbers.removeLast();

        Assertions.assertEquals(2, numbers.size());
        Assertions.assertEquals(3, element);
    }

    @Test
    public void shouldIterate(){
        Deque<Integer> numbers = new Deque<>();
        numbers.addLast(1);
        numbers.addLast(2);
        numbers.addLast(3);

        Iterator<Integer> values = numbers.iterator();

        Assertions.assertEquals(1, values.next());
        Assertions.assertEquals(2, values.next());
        Assertions.assertEquals(3, values.next());
    }

}