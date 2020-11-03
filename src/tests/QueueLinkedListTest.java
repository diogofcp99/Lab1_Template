package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.pa.adts.EmptyQueueException;
import pt.pa.adts.FullQueueException;
import pt.pa.adts.Queue;
import pt.pa.adts.QueueLinkedList;
import static org.junit.jupiter.api.Assertions.*;

public class QueueLinkedListTest {
    private Queue<String> queue;

    @BeforeEach
    public void setUp(){
        queue = new QueueLinkedList<>(10);
    }

    @Test
    void enqueue() throws FullQueueException, EmptyQueueException {
        Queue<String> queue = new QueueLinkedList<>(10);
        queue.enqueue("Test");

        assertEquals("Test", queue.front());

        assertEquals(1, queue.size());

    }

    @Test
    void enqueueOverCapacity() throws FullQueueException{
        int i;
        for(i = 0; i < 10; i++)
            queue.enqueue("test " + i);
        assertThrows(FullQueueException.class, () -> queue.enqueue("Reject"));
    }

    @Test
    void dequeueWhenEmpty() throws FullQueueException, EmptyQueueException {
        assertThrows(EmptyQueueException.class, () -> queue.dequeue());
    }

    @Test
    void dequeueOneElement() throws FullQueueException, EmptyQueueException {
        queue.enqueue("Test");
        assertEquals("Test", queue.dequeue());
    }

    @Test
    void dequeueTwoElementAndEmpty() throws FullQueueException, EmptyQueueException {
        queue.enqueue("Test 1");
        queue.enqueue("Test 2");
        assertEquals("Test 1", queue.dequeue());
        assertEquals("Test 2", queue.dequeue());
        assertThrows(EmptyQueueException.class, () -> queue.dequeue());

    }

    @Test
    void front() throws FullQueueException, EmptyQueueException {
        assertThrows(EmptyQueueException.class, () -> queue.front());
        queue.enqueue("Test 1");
        assertEquals("Test 1", queue.front());
        queue.enqueue("Test 2");
        assertEquals("Test 1", queue.front());
    }

    @Test
    void size() throws FullQueueException, EmptyQueueException {
        assertEquals(0,queue.size());
        queue.enqueue("Test 1");
        assertEquals(1,queue.size());
        queue.enqueue("Test 2");
        assertEquals(2,queue.size());
        queue.dequeue();
        assertEquals(1, queue.size());
        queue.clear();
        assertEquals(0, queue.size());
    }

    @Test
    void isEmpty() throws FullQueueException {
        assertTrue(queue.isEmpty());
        queue.enqueue("Test 1");
        assertFalse(queue.isEmpty());
    }

    @Test
    void clear() throws FullQueueException {
        queue.enqueue("Test 1");
        queue.enqueue("Test 2");
        queue.clear();
        assertEquals(0, queue.size());
    }
}
