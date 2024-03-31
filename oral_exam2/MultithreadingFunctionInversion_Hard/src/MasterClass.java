import java.security.SecureRandom;
import java.util.concurrent.*;
import java.util.concurrent.TimeUnit;

/**
 * MasterClass creates 10 threads then generates random values of y and places them into a circular
 * buffer which is shared between the slaves.
 */
public class MasterClass implements Buffer{
    // the Array-BlockingQueue class is an implementation of interface BlockingQueue
    private final ArrayBlockingQueue<Double> buffer; // shared buffer

    /**
     * Constructor to initialize an ArrayBlockingQueue to hold the 10 threads
     */
    public MasterClass() {
        buffer = new ArrayBlockingQueue<Double>(10);
    }

    /**
     * blockingPut is an overridden method from the Buffer class used to write values into the
     * shared buffer which must be consumed exactly once.
     * @param value to put into buffer
     * @throws InterruptedException if a thread is interrupted
     */
    @Override
    public void blockingPut(double value) throws InterruptedException {
        buffer.put(value);
        System.out.println("Producer writes "+value+" Buffer cells occupied: "+ buffer.size());
    }

    /**
     * blockingGet is an overridden method from the Buffer class used to remove values from the
     * shared buffer.
     * @return value from buffer
     * @throws InterruptedException if the thread is interrupted
     */
    @Override
    public double blockingGet() throws InterruptedException {
        double readValue = buffer.take();
        System.out.println("Consumer reads "+ readValue+" Buffer cells occupied: "+ buffer.size());
        return readValue;
    }

    public static void main (String[] args) throws InterruptedException {
        SecureRandom generator = new SecureRandom(); // create random generator

        // use executor service to launch concurrent threads that execute runnables
        ExecutorService executor = Executors.newCachedThreadPool();

        // create MasterClass and SlaveClass object to store ints
        Buffer sharedBuffer = new MasterClass();

        for (int i = 0; i < 10; i++){
            double random_y = generator.nextDouble();
            if (random_y > -14.0 && random_y < 2.0){
                sharedBuffer.blockingPut(random_y);
            }
        }

        executor.execute(new SlaveClass(sharedBuffer));

}
}
