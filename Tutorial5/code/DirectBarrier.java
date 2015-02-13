

public class DirectBarrier implements Barrier {
    private int receipts;

    public DirectBarrier(int parties) {
        this.receipts = parties;
    }

    public synchronized void await() throws InterruptedException {
        --receipts; //Take receipts
        //If the last receipts, inform all to cross barrier
        if(receipts == 0) { 
            notifyAll();
        }else { //Otherwise waits until all ready
            while(receipts > 0)
             wait(); 
        }
    }
}