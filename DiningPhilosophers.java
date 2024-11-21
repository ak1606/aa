package daa;
import java.util.concurrent.*;
public class DiningPhilosophers {
    private static final int NUM_PHILOSOPHERS = 5;
    private static final int MAX_MEALS = 1;  // Number of meals before stopping

    // Semaphore array representing chopsticks
    private final Semaphore[] chopsticks = new Semaphore[NUM_PHILOSOPHERS];

    public DiningPhilosophers() {
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            chopsticks[i] = new Semaphore(1); // Binary semaphore
        }
    }

    // Philosopher behavior
    public void philosopher(int philosopherId) {
        int leftChopstick = philosopherId;
        int rightChopstick = (philosopherId + 1) % NUM_PHILOSOPHERS;
        int meals = 0;

        while (meals < MAX_MEALS) {
            try {
                // Thinking
                System.out.println("Philosopher " + philosopherId + " is thinking.");
                Thread.sleep((long) (Math.random() * 1000));

                // Attempt to pick up chopsticks
                if (philosopherId % 2 == 0) {
                    chopsticks[leftChopstick].acquire();
                    System.out.println("Philosopher " + philosopherId + " picked up left chopstick.");
                    chopsticks[rightChopstick].acquire();
                    System.out.println("Philosopher " + philosopherId + " picked up right chopstick.");
                } else {
                    chopsticks[rightChopstick].acquire();
                    System.out.println("Philosopher " + philosopherId + " picked up right chopstick.");
                    chopsticks[leftChopstick].acquire();
                    System.out.println("Philosopher " + philosopherId + " picked up left chopstick.");
                }

                // Eating
                System.out.println("Philosopher " + philosopherId + " is eating.");
                Thread.sleep((long) (Math.random() * 1000));

                // Put down chopsticks
                chopsticks[leftChopstick].release();
                System.out.println("Philosopher " + philosopherId + " put down left chopstick.");
                chopsticks[rightChopstick].release();
                System.out.println("Philosopher " + philosopherId + " put down right chopstick.");
                meals++;  // Increment meal count
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Philosopher " + philosopherId + " has finished eating.");
    }

    public static void main(String[] args) {
        DiningPhilosophers dp = new DiningPhilosophers();

        // Create and start threads for each philosopher
        Thread[] philosophers = new Thread[NUM_PHILOSOPHERS];
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            final int philosopherId = i;
            philosophers[i] = new Thread(() -> dp.philosopher(philosopherId));
            philosophers[i].start();
        }
    }
}
