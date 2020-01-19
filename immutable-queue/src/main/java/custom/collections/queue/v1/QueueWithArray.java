package custom.collections.queue.v1;

import java.util.Arrays;


public class QueueWithArray {

    private int[] storage = null;
    private int filledItemsCount = 0;
    private int DEFAULT_CAPACITY_INCREASE = 10;

    public QueueWithArray(int initialSize) {
        storage = new int[initialSize];
        Arrays.fill(storage, -1);
    }

    public QueueWithArray enQueue(int item) {
        if(filledItemsCount >= storage.length) {
            storage = Arrays.copyOf(storage, storage.length + DEFAULT_CAPACITY_INCREASE);
        }
        for(int i=filledItemsCount - 1; i>=0 ; i--) {
            storage[i+1] = storage[i];
        }
        storage[0] = item;
        filledItemsCount++;
        return this;
    }

    public QueueWithArray deQueue() {
        storage[--filledItemsCount] = -1;
        return this;
    } 

    public int head() {
        return storage[filledItemsCount - 1];
    }

    public boolean isEmpty() {
        return storage.length == 0;
    }

    public static void main(String[] args) {
        QueueWithArray queue = new QueueWithArray(5);
        queue.enQueue(1);
        queue.enQueue(3);
        queue.enQueue(2);
        queue.deQueue();
        System.out.println(queue.head());
        System.out.println(queue.isEmpty());
        System.out.println(queue.filledItemsCount);
    }
}