package exersice1.task2.sync;

// Synchronisierte Version von Counter 
class SynchronizedCounter {
    private int c = 0;

    // synchronized sperrt das Objekt (Monitor-Lock)
    public synchronized void increment() {
        int b = c;
        b = b + 1;
        c = b;
    }

    // Dieser Thread muss warten, falls 'increment' oder 'value'
    // gerade das Lock hält
    public synchronized void decrement() {
        int d = c;
        d = d - 1;
        c = d;
    }

    // value() muss auch synchronisiert sein, um sicherzustellen,
    // dass wir den aktuellsten Wert lesen (Memory Visibility)
    public synchronized int value() {
        return c;
    }
}