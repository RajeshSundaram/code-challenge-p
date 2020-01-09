package custom.collections.queue;


import static org.junit.Assert.*;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CustomImmutableQueueTests {

    @Test
    public void queueOperationsTest() {
        ImmutableQueue queue = new CustomImmutableQueue<Integer>();
        assertTrue(queue.isEmpty());
        queue = new CustomImmutableQueue(1, 2, 3);
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.head());
        queue = queue.deQueue().deQueue();
        assertEquals(3, queue.head());
        queue.deQueue();
        assertTrue(queue.isEmpty());
        queue.enQueue(5);
        assertEquals(5, queue.head());
    }

    @Test
    public void longQueueTest() {
        // TODO: fix outOfMemoryError
        List<String> items = IntStream.range(0, 100000).boxed().map(value -> String.valueOf(value))
                .collect(Collectors.toList());
        ImmutableQueue queue = new CustomImmutableQueue(items);
        for (int i = 1; i < items.size(); i++) {
            queue = queue.deQueue();
        }
        assertEquals(items.get(items.size() - 1), queue.head());
    }
}
