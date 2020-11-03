package pt.pa.adts;

/**
 * Double linked list implementation of the queue data structure.
 *
 * @param <T> the queue element type.
 */
public class QueueLinkedList<T> implements Queue<T> {

    private Node header, trailer;
    private int size;
    private int capacity;

    public QueueLinkedList(int capacity) {
        this.header = new Node(null, null, null);
        this.trailer = new Node(null, header, null);
        header.next = trailer;
        size = 0;
        this.capacity = capacity;
    }

    /**
     * Enqueues a new element to the queue.
     *
     * @param element The Element to the queue.
     * @throws FullQueueException when the queue is full.
     */
    public void enqueue(T element) throws FullQueueException {
        if(size == capacity){
            throw new FullQueueException();
        }
        Node node = new Node(element, header, header.next);
        header.next.prev = node;
        header.next = node;
        size++;
    }

    /**
     * Dequeues the oldest element in the queue, according to the enqueuing order and returns it.
     *
     * @return the element that was removed.
     * @throws EmptyQueueException when the queue is empty.
     */
    public T dequeue() throws EmptyQueueException {
        if(isEmpty()) {
            throw new EmptyQueueException();
        }

        Node node = trailer.prev;
        node.prev.next = trailer;
        trailer.prev = node.prev;
        size--;

        return node.element;
    }

    /**
     * Returns the oldest element in the queue, according to the enqueuing order.
     *
     * @return the oldest element in the queue.
     * @throws EmptyQueueException when the queue is empty.
     */
    public T front() throws EmptyQueueException {
        if(isEmpty()) {
            throw new EmptyQueueException();
        }
        return trailer.prev.element;
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue.
     */
    public int size() {
        return this.size;
    }

    /**
     * Checks if the Queue is empty.
     *
     * @return true if queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return (size() == 0);
    }

    /**
     * Resets the queue.
     */
    public void clear() {
        header = new Node(null, null, null);
        trailer = new Node(null, header, null);
        header.next = trailer;
        size = 0;
    }


    private class Node {
        private T element;
        private Node next;
        private Node prev;

        public Node(T element, Node prev, Node next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
