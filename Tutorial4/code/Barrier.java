public class Barrier {
    private int elements;

    public Barrier(int elements) {
        this.elements = elements;
    }

    public synchronized void await() throws InterruptedException{
        --elements;
        if(elements == 0) {
            notifyAll();
        }else {
            while(elements > 0)
                wait();
        }
    }
}