package custom.collections.queue.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import custom.collections.queue.v1.QueueWithArray;

public class QueueWithArrayTests {

    @Test
    public void test1() {
        QueueWithArray queue = new QueueWithArray(5);
        for(int i=1; i<= 100; i++) {
            queue.enQueue(i);
        }
        for(int i=1; i <= 99; i++) {
            queue.deQueue();
        }
        assertEquals(100, queue.head());
        assertFalse(queue.isEmpty());
    }
}