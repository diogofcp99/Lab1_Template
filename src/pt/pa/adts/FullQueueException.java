package pt.pa.adts;

public class FullQueueException extends Exception {
    public FullQueueException(){
        super("The queue is full!");
    }
}
