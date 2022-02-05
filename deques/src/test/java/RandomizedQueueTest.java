import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

class RandomizedQueueTest {

    @Test
    public void shouldSizeReturnsTotalOfIndexFilled(){
        RandomizedQueue<Integer> numbers = new RandomizedQueue<>();
        numbers.enqueue(1);
        numbers.enqueue(2);
        numbers.enqueue(3);

        Assertions.assertEquals(3, numbers.size());
    }

    @Test
    public void shouldResizeInternalCapacity(){
        // the initial capacity is 5
        RandomizedQueue<Integer> numbers = new RandomizedQueue<>();
        numbers.enqueue(1);
        numbers.enqueue(2);
        numbers.enqueue(3);
        numbers.enqueue(4);
        numbers.enqueue(5);
        numbers.enqueue(6);
        numbers.enqueue(7);

        Assertions.assertEquals(7, numbers.size());
    }

    @Test
    public void shouldRemoveRandomElement(){
        RandomizedQueue<Integer> numbers = new RandomizedQueue<>();
        numbers.enqueue(1);
        numbers.enqueue(2);
        numbers.enqueue(3);

        numbers.dequeue();

        Assertions.assertEquals(2, numbers.size());
    }

    @Test
    public void shouldThrowExceptionWhenEnqueueNullElement(){
        RandomizedQueue<Integer> integers = new RandomizedQueue<>();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            integers.enqueue(null);
        });
    }

    @Test
    public void shouldThrowExceptionWhenDequeEmptyQueue(){
        RandomizedQueue<Integer> empty = new RandomizedQueue<>();
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            empty.dequeue();
        });
    }

    @Test
    public void shouldThrowExceptionWhenSampleEmptyQueue(){
        RandomizedQueue<Integer> empty = new RandomizedQueue<>();
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            empty.sample();
        });
    }

    @Test
    public void shouldThrowExceptionWhenTryToMoveToNextInEmptyIterator(){
        RandomizedQueue<Integer> empty = new RandomizedQueue<>();
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            empty.iterator().next();
        });
    }

    @Test
    public void shouldThrowExceptionWhenTryToInvokeRemoveInEmptyIterator(){
        RandomizedQueue<Integer> empty = new RandomizedQueue<>();
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            empty.iterator().remove();
        });
    }

    @Test
    public void shouldRemoveAllElementsSuccessfully(){
        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<>();
        Assertions.assertTrue(randomizedQueue.isEmpty());
        Assertions.assertTrue(randomizedQueue.isEmpty());
        randomizedQueue.enqueue(1);
        Assertions.assertFalse(randomizedQueue.isEmpty());
        randomizedQueue.dequeue();
        Assertions.assertTrue(randomizedQueue.isEmpty());
    }

    @Test
    public void shouldNotRemoveWhenInvokeSample(){
        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<>();
        Assertions.assertTrue(randomizedQueue.isEmpty());
        Assertions.assertTrue(randomizedQueue.isEmpty());
        randomizedQueue.enqueue(1);
        Assertions.assertFalse(randomizedQueue.isEmpty());
        randomizedQueue.sample();
        Assertions.assertFalse(randomizedQueue.isEmpty());
    }

    @Test
    public void shouldSimulateCornerCase(){
        RandomizedQueue rq = new RandomizedQueue();
        rq.enqueue("IHFXWUSRPV");
        rq.sample();
        rq.enqueue("IBLCPNEXXY");
        rq.sample();
        rq.dequeue();

        Assertions.assertEquals(1, rq.size());
    }


}