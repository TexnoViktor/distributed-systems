package task1;

public class ThreadExample {
    public static void main(String[] args) {
        System.out.println("Hauptprogramm startet...");

        // Erstelle die Task-Objekte (Runnables)
        Runnable taskA = new SimpleTask("Thread A");
        Runnable taskB = new SimpleTask("Thread B");
        Runnable taskC = new SimpleTask("Thread C"); // Mehr als zwei Threads

        // Erstelle die Thread-Objekte und weise ihnen die Tasks zu
        Thread thread1 = new Thread(taskA);
        Thread thread2 = new Thread(taskB);
        Thread thread3 = new Thread(taskC);

        // Starte die Threads 
        // WICHTIG: .start() rufen, nicht .run()!
        // .start() sorgt dafür, dass das Betriebssystem einen neuen Thread startet.
        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("Hauptprogramm wartet auf das Ende der Threads...");
        // (Für diese Aufgabe müssen wir nicht explizit warten,
        // aber in echten Anwendungen würde man oft .join() verwenden)
    }
}