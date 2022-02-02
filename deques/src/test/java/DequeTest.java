import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

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

    @Test
    public void shouldThrowExceptionWhenAddFirstNull(){
        Deque<Integer> integers = new Deque<>();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            integers.addFirst(null);
        });
    }

    @Test
    public void shouldThrowExceptionWhenAddLastNull(){
        Deque<Integer> integers = new Deque<>();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            integers.addLast(null);
        });
    }

    @Test
    public void shouldThrowExceptionWhenRemoveFirstForEmptyQueue(){
        Deque<Integer> empty = new Deque<>();
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            empty.removeFirst();
        });
    }

    @Test
    public void shouldThrowExceptionWhenRemoveLastForEmptyQueue(){
        Deque<Integer> empty = new Deque<>();
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            empty.removeLast();
        });
    }

    @Test
    public void shouldThrowExceptionWhenClientCallsNextInEmptyInterator(){
        Deque<Integer> numbers = new Deque<>();
        numbers.addFirst(1);

        Iterator<Integer> iterator = numbers.iterator();
        iterator.next();

        Assertions.assertThrows(NoSuchElementException.class, () -> {
            iterator.next();
        });
    }

    @Test
    public void shouldThrowExceptionWhenClientCallsRemoveFromIterator(){
        Deque<Integer> numbers = new Deque<>();
        Iterator<Integer> iterator = numbers.iterator();

        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            iterator.remove();
        });
    }

    @Test
    public void shouldRemoveAllElementsSuccessfully(){
        Deque<Integer> deque = new Deque<>();
        Assertions.assertTrue(deque.isEmpty());
        Assertions.assertTrue(deque.isEmpty());
        deque.addLast(3);
        Assertions.assertFalse(deque.isEmpty());
        deque.removeLast();
        Assertions.assertTrue(deque.isEmpty());
    }

    @Test
    public void shouldReturnsNextElementsSuccessfully(){
        Deque<Integer> deque = new Deque<>();
        Assertions.assertTrue(deque.isEmpty());
        deque.addLast(2);
        Assertions.assertFalse(deque.isEmpty());
        Assertions.assertFalse(deque.isEmpty());
        Assertions.assertFalse(deque.isEmpty());
        deque.addFirst(6);
        Assertions.assertEquals(2, deque.size());
        Assertions.assertFalse(deque.isEmpty());
        deque.addLast(9);
        Assertions.assertEquals(3, deque.size());

        Iterator<Integer> iterator = deque.iterator();
        Assertions.assertEquals(6, iterator.next());
        Assertions.assertEquals(2, iterator.next());
        Assertions.assertEquals(9, iterator.next());

    }

}