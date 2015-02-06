import java.util.concurrent.Semaphore;
import java.util.LinkedList;
import java.util.Queue;

class BoundedQueue<E> {
  private final Queue<E> elements = new LinkedList<E>();
  private final Semaphore emptyCount;
  private final Semaphore filledCount;
  
  public BoundedQueue(int size) throws InterruptedException {
    emptyCount = new Semaphore(size);
    filledCount = new Semaphore(size);
    filledCount.acquire(size);
  }

  public void put(E e) throws InterruptedException {
    emptyCount.acquire();
    synchronized(this){
        elements.add(e);
    }
    filledCount.release();
  }

  public E take() throws InterruptedException {
    final E e;
    filledCount.acquire();
    synchronized(this){
      e = elements.remove();
    }
    emptyCount.release();
    return e;
  }
}