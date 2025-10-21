package exersice1.task2.sync;

public class NoInterferenceTest {
    public static void main(String[] args) throws InterruptedException {

        // DIESMAL die synchronisierte Version verwenden 
        SynchronizedCounter counter = new SynchronizedCounter();

        Runnable incrementTask = () -> {
            for (int i = 0; i < 1000000; i++) {
                counter.increment();
            }
        };

        Runnable decrementTask = () -> {
            for (int i = 0; i < 1000000; i++) {
                counter.decrement();
            }
        };

        Thread t1 = new Thread(incrementTask);
        Thread t2 = new Thread(decrementTask);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        // Erwartetes Ergebnis: 0
        // Tatsächliches Ergebnis: Immer 0!
        System.out.println("Endwert (synchronisiert): " + counter.value());
        // Der Fehler kann nicht reproduziert werden 
    }
}