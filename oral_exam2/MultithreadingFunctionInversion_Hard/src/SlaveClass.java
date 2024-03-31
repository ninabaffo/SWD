import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Math.*;

/**
 * SlaveClass implements the Runnable interface allowing it to be ran as a thread
 */
public class SlaveClass implements Runnable {
    private static final SecureRandom generator = new SecureRandom();
    private final Buffer sharedLocation; // reference to shared object
    Buffer newSharedBuffer = new MasterClass();

    /**
     * Constructor which makes a reference to the shared buffers location
     * @param sharedLocation is the Buffer that is used to create the thread
     */
    public SlaveClass(Buffer sharedLocation) {
        this.sharedLocation = sharedLocation;
    }

    /**
     * computeInverse takes in a y-value from the Masterclass to find the inverse. I used a loop
     * for trial x values from -2.7938 to 1.2350 incrementing by .00001 each time to see if the output
     * (inverse) matches the inputted y value. If 'trialX' gives a y value within +-0.0001 of the actual y,
     * add it to the buffer.
     * @param yValue is the randomly generated y from MasterClass
     * @throws InterruptedException
     */
    public void computeInverse(double yValue) throws InterruptedException {
        for (double trialX = -2.7938; trialX <= 1.2350; trialX += 0.00001) {
            double roundedY = Math.round(yValue * Math.pow(10, 4))/ Math.pow(10, 4);
            double trialY = trialX - exp(trialX * -1) + (5 * log(abs(trialX)));
            double roundedTrialY = Math.round(trialY * Math.pow(10, 4))/ Math.pow(10, 4);
            // if our trial x value gives us a y value withing +-0.0001 of actualY, add trialX to the buffer
            if (roundedTrialY == roundedY || roundedTrialY == roundedY- 0.0001 || roundedTrialY == roundedY+ 0.0001) {
                System.out.println("yes we got a match!! ActualY: "+roundedY+ " TrialY: " + roundedTrialY);
                newSharedBuffer.blockingPut(trialX);
                return;
            }
        }
    }

    /**
     * run() is a method from the runnable interface. In this method, the thread randomly sleeps from 0 to 3 seconds
     * so it has a chance to get the information. It loops through 10 times because we have 10 threads to execute
     * and it calls method computeInverse(y).
     */
    @Override
    public void run() {
        for (int count = 1; count <= 10; count++) {
            try // sleep 0 to 3 seconds, then place value in Buffer
            {
                Thread.sleep(generator.nextInt(3000)); // random sleep
                for (int i = 0; i <= 10; i++){
                    double actualY = sharedLocation.blockingGet();
                    computeInverse(actualY);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}