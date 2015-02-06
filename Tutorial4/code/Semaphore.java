public class Semaphore {
    private int permits;
    
    public Semaphore(int permits){
        this.permits = permits;
    }
    
    public synchronized void acquire() {
        while(permits <= 0) {
            try { 
                wait(); 
            } catch(InterruptedException e){ }
        }
        --permits;
    }

    public synchronized void release() {
        ++permits;
        if(permits <= 1){
            notify();
        }
    }
}