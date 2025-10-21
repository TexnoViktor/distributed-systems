package exersice1.task2.unsync;

public class InterferenceTest {
    public static void main(String[] args) throws InterruptedException {

        // EIN Counter-Objekt für ALLE Threads
        Counter counter = new Counter();

        // Ein Thread, der 1.000.000 Mal inkrementiert
        Runnable incrementTask = () -> {
            for (int i = 0; i < 1000000; i++) {
                counter.increment();
            }
        };

        // Ein Thread, der 1.000.000 Mal dekrementiert
        Runnable decrementTask = () -> {
            for (int i = 0; i < 1000000; i++) {
                counter.decrement();
            }
        };

        Thread t1 = new Thread(incrementTask);
        Thread t2 = new Thread(decrementTask);

        t1.start();
        t2.start();

        // Warten, bis beide Threads fertig sind
        // (Sonst würden wir den Wert ausgeben, bevor sie fertig sind)
        t1.join();
        t2.join();

        // Erwartetes Ergebnis: 0 (da +1.000.000 und -1.000.000)
        // Tatsächliches Ergebnis: Fast nie 0!
        System.out.println("Endwert (unsynchronisiert): " + counter.value());
        // Dies ist der nachgewiesene Interferenzfehler 
    }
}
