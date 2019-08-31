import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Buyer<V> extends BuyerBase<V> {
	int catalogSize, sleepTime, iteration;
    public Buyer (int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty, PriorityQueue<V> catalog, int iteration) {
        // Complete the Buyer Constructor method
        // ...
    	this.catalogSize = catalogSize;
    	this.sleepTime = sleepTime;
    	setSleepTime(sleepTime);
    	this.lock = lock;
    	this.full = full;
    	this.empty = empty;
    	this.catalog = catalog;
    	this.iteration = iteration;
    	setIteration(iteration);
    }
    
    public void buy() throws InterruptedException {
	try {
            // Complete the try block for consume method
            // ...
		lock.lock();
		if(catalog.isEmpty())
		{
			empty.await();
		}
		NodeBase<V> n = catalog.dequeue();
		full.signalAll();
	    System.out.print("Consumed "); // For automated Testing
            n.show(); // (For Automated Testing)
            // ...
	} catch (Exception e) {
            e.printStackTrace();
	} finally {
            // Complete this block
		Thread.sleep(sleepTime);
		lock.unlock();
	}
    }
}
