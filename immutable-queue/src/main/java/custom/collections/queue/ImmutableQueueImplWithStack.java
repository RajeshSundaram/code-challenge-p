package custom.collections.queue;

import java.io.Serializable;

public final class ImmutableQueueImplWithStack<T> implements Serializable {

    private T root;
    private ImmutableQueueImplWithStack<T> next;

    public ImmutableQueueImplWithStack() {
        this.root = null;
        this.next = null;
    }

    public ImmutableQueueImplWithStack(T item) {
        this.root = item;
        this.next = null;
    }

    public ImmutableQueueImplWithStack(T item, ImmutableQueueImplWithStack<T> stackItem) {
        this.root = item;
        this.next = stackItem;
    }

    public ImmutableQueueImplWithStack<T> push(T t) {
        return new ImmutableQueueImplWithStack(t, this);
    }

    public T head() {
        if (root != null) {
            if (this.next == null || this.next.root == null) {
                return root;
            } else {
                ImmutableQueueImplWithStack itemPointer = this.next;
                while (itemPointer.next != null && itemPointer.next.root != null) {
                    itemPointer = itemPointer.next;
                }
                return (T) itemPointer.root;
            }
        }
        return null;
    }

    public T dequeue() {
        if (root != null) {
            T lastItem = null;
            ImmutableQueueImplWithStack itemPointer = this;
            do {
                if (itemPointer.next != null) {
                    if (itemPointer.next.root == null) {
                        itemPointer.next = null;
                    } else if (itemPointer.next.next != null) {
                        itemPointer = itemPointer.next;
                    } else {
                        lastItem = (T) itemPointer.next.root;
                        itemPointer.next = null;
                        break;
                    }
                } else {
                    lastItem = (T) itemPointer.root;
                    itemPointer.root = null;
                    break;
                }
            } while (true);
            return lastItem;
        }
        return null;
    }

    public boolean isEmpty() {
        return root == null;
    }
}
