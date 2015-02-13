
class Participant implements Runnable {
    private String name;
    private int snooze;
    private int distance;
    private Barrier barrier;

    Participant(String name, int snooze, int distance, Barrier barrier) {
        this.name = name;
        this.snooze = snooze;
        this.distance = distance;
        this.barrier = barrier;
    }
    
    private void travel() throws InterruptedException {
        System.out.println(name + " going to snooze: " + snooze);
        Thread.sleep(snooze);
        System.out.println(name + " starts travelling: " + distance);
        Thread.sleep(distance);
        System.out.println(name + " arrived");
    }
    
    private void prepareFood() {
        System.out.println(name + " starts prepare food");
    }
    
    public void run(){
        try {
            travel();
            barrier.await();
            prepareFood();
        }catch(InterruptedException ignored) {

        }
    }
}

public class TestBarrier {
    public static void main(String[] args) throws InterruptedException {
        Barrier barrier = new Barrier(4);
        Thread a = new Thread(new Participant("A", 0, 1000, barrier));
        Thread b = new Thread(new Participant("B", 2000, 2000, barrier));
        Thread c = new Thread(new Participant("C", 1000, 2000, barrier));
        Thread d = new Thread(new Participant("D", 4000, 1500, barrier));

        a.start();
        b.start();
        c.start();
        d.start();
    }
}