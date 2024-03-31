import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Interface Buffer creates a synchronized buffer using ArrayBlockingQueue
 */
public interface Buffer {
    /**
     * blockingPut puts a value into the buffer
     * @param value put into the buffer
     * @throws InterruptedException to indicate that the method could temporarily be blocked from performing a task.
     */
    void blockingPut(double value) throws InterruptedException;

    /**
     * blockingGet gets a value from the buffer
     * @throws InterruptedException to indicate that the method could temporarily be blocked from performing a task.
     */
    double blockingGet() throws InterruptedException;
}
