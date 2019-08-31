// This class implements the Queue
public class Queue<V> implements QueueInterface<V>{

    // Complete the Queue implementation
    private NodeBase<V>[] queue;
    private int capacity, currentSize=0, front=-1, rear=-1;
	
    public Queue(int capacity) {    
    	this.capacity = capacity;
    	queue = new NodeBase[capacity];
    }

    public int size() {
    	return currentSize;
    }

    public boolean isEmpty() {
    	if(currentSize == 0) return true;
    	else return false;
    }
	
    public boolean isFull() {
    	if(currentSize == capacity) return true;
    	else return false;
    }

    public void enqueue(Node<V> node) {
    	if(!this.isFull())
    	{
    	if((rear == -1) && (front == -1))
    	{
    		front =0;
    		rear = 0;
    	}
    	else if(rear == capacity-1 && front != 0)
    	{
    		rear = 0;
    	}
    	else {
    		rear = (rear+1)%capacity;
    	}
    	queue[rear] = node;
    	currentSize++;
    	}
    	else
    	{
    		System.out.println("Queue is full.");
    	}
    }

    public NodeBase<V> dequeue() {
    	if(!isEmpty())
    	{
    	NodeBase<V> a = queue[front];
    	if(front == rear)
    	{
    		front = -1;
    		rear = -1;    				
    	}
    	else if(front == capacity-1)
    		front = 0;
    	else
    	{
    		front = front+1;
    	}
    	currentSize--;
    	return a;
    	
    }
    	else
    		return null;
    }

}

