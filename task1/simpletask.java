package task1;

class SimpleTask  implements Runnable{
    private String taskName;
    
    public SimpleTask(String Name){
        this.taskName = Name;
    }

    @Override
    public void run() {
        // Jeder Thread führt diese Schleife aus 
        for (int i = 1; i <= 5; i++) {
            System.out.println("Nachricht von " + taskName + ": Zähle " + i);

            // Kurze Pause, um das "Interleaving" (Vermischen)
            // wahrscheinlicher und besser sichtbar zu machen.
            try {
                Thread.sleep(100); // 100 Millisekunden warten
            } catch (InterruptedException e) {
                System.err.println(taskName + " wurde unterbrochen.");
            }
        }
        System.out.println(taskName + " ist fertig.");
    }
}