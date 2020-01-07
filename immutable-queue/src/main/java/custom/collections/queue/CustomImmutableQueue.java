package custom.collections.queue;

import java.util.Collection;

public class CustomImmutableQueue<T> implements ImmutableQueue<T> {

    private ImmutableQueueImplWithStack<T> queue;

    @SuppressWarnings("unchecked")
    public CustomImmutableQueue() {
        this.queue = new ImmutableQueueImplWithStack<T>();
    }

    @SuppressWarnings("unchecked")
    public CustomImmutableQueue(T... items) {
        ImmutableQueueImplWithStack stack = new ImmutableQueueImplWithStack<T>(items[0]);
        for (int i = 1; i < items.length; i++) {
            stack = stack.push(items[i]);
        }
        this.queue = stack;
    }

    @SuppressWarnings("unchecked")
    public CustomImmutableQueue(Collection<T> items) {
        ImmutableQueueImplWithStack stack = new ImmutableQueueImplWithStack<T>();
        for (T item : items) {
            stack = stack.push(item);
        }
        this.queue = stack;
    }

    @Override
    public ImmutableQueue<T> enQueue(T t) {
        this.queue = this.queue.push(t);
        return this;
    }

    @Override
    public ImmutableQueue<T> deQueue() {
        this.queue.dequeue();
        return this;
    }

    @Override
    public T head() {
        return this.queue.head();
    }

    @Override
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }
}
