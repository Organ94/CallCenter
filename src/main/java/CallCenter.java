import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CallCenter {

    private static BlockingQueue<String> calls = new ArrayBlockingQueue<>(60, true);
    private static final String DONE = "done";
    private static final int NUMBER_OF_CALLS = 30;
    private static final int REQUEST_PROCESSING_TIME = 2500;

    protected static void atc() {
        try {
            for (int i = 0; i < NUMBER_OF_CALLS; i++) {
                calls.put(Thread.currentThread().getName() + i);
            }
            calls.put(DONE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected static void callOperator() {
        String msg = null;
        try {
            while (!((msg = calls.take()).equals(DONE))) {
                System.out.println(Thread.currentThread().getName() + " ответил на " + msg);
                Thread.sleep(REQUEST_PROCESSING_TIME);
            }
            System.out.println(Thread.currentThread().getName() + " ответил на все обращения!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
