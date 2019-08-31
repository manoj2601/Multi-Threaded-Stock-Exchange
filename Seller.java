import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Seller<V> extends SellerBase<V> {
	
	private int catalogSize, sleepTime;
	
	public Seller (int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty, PriorityQueue<V> catalog, Queue<V> inventory) {
        // Complete the constructor method by initializing the attibutes
        // ...
		this.sleepTime = sleepTime;
    	setSleepTime(sleepTime);
    	this.catalogSize = catalogSize;
    	this.lock = lock;
    	this.full = full;
    	this.empty = empty;
    	this.catalog = catalog;
    	this.inventory = inventory;
    }
    
    public void sell() throws InterruptedException {
	try {
		
            // Complete the try block for produce method
            // ...
		lock.lock();
		while(catalog.isFull())
		{ 
			full.await();
		}
		if(!inventory.isEmpty()) {
		catalog.enqueue( (Node<V>) inventory.dequeue());
		empty.signalAll();
		}
	} catch(Exception e) {
            e.printStackTrace();
	} finally {
            // Complete this block
			Thread.sleep(sleepTime);
			lock.unlock();

	}		
    }
}
