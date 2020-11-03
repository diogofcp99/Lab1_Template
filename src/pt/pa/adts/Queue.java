package pt.pa.adts;

/**
 * TODO: Fornecer documentação da interface.
 *
 * @param <T>
 */
public interface Queue<T> {

    /**
     * Enqueues a new element to the queue.
     *
     * @param element The Element to the queue.
     * @throws FullQueueException when the queue is full.
     */
    void enqueue(T element) throws FullQueueException;

    /**
     * Dequeues the oldest element in the queue, according to the enqueuing order and returns it.
     *
     * @return the element that was removed.
     * @throws EmptyQueueException when the queue is empty.
     */
    T dequeue() throws EmptyQueueException;

    /**
     * Returns the oldest element in the queue, according to the enqueuing order.
     *
     * @return the oldest element in the queue.
     * @throws EmptyQueueException when the queue is empty.
     */
    T front() throws EmptyQueueException;

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue.
     */
    int size();

    /**
     * Checks if the Queue is empty.
     *
     * @return true if queue is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Resets the queue.
     *
     */
    void clear();

    //TODO: definir operações do ADT e documentá-las

}
