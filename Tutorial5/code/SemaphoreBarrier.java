public class SemaphoreBarrier implements Barrier {
    private int receipts;
    private Semaphore sem;
    
    public SemaphoreBarrier(int parties) {
        this.receipts = parties;
        sem = new Semaphore(0); //No one allow to cross
    }
    public void await() throws InterruptedException {
        synchronized(this) {
            --receipts; //Take receipts
            if(receipts == 0) {
                System.out.println("Barrier is open");
                sem.release();
            }
        }
        sem.acquire();
        sem.release();
    }
}