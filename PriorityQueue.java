
public class PriorityQueue<V> implements QueueInterface<V>{

    int capacity;
	private int currentSize=0;
	Node<V>[] queue;
    // Complete the Priority Queue implementation
    public PriorityQueue(int capacity) {    
    	this.capacity = capacity;
    	queue = new Node[capacity];
    }

    public int size() {
		return currentSize;
    }

    public boolean isEmpty() {
    	if(currentSize == 0)
    		return true;
    	else return false;
    }
	
    public boolean isFull() {
    	if(currentSize == capacity)
    		return true;
    	else return false;
    }

    public void enqueue(Node<V> node) {
    	if(!this.isFull()) {
    	queue[currentSize] = node;
    	currentSize++;
    	}
    }

    // In case of priority queue, the dequeue() should 
    // always remove the element with minimum priority value
    public NodeBase<V> dequeue() {
	if(!this.isEmpty()){
    	NodeBase<V> n = queue[0];
    	int a =0;
    	for(int i=1; i<currentSize; i++)
    	{
    		if(n.getPriority()>queue[i].getPriority())
    			{
    				n = queue[i];
    				a = i;
    			}
    	}
    	for(int i=a; i<currentSize-1; i++)
    	{
    		queue[i] = queue[i+1];
    	}
    	currentSize--;
    	return n;
	}
	else return null;
    }

    public void display () {
	if (this.isEmpty()) {
            System.out.println("Queue is empty");
	}
	for(int i=0; i<currentSize; i++) {
            queue[i].show();
	}
    }

	public void add(int i, V string) {
		
		Node<V> n = new Node(i, string);
		this.enqueue(n);
	}

	public Node<V> removeMin() {
		
		return (Node<V>) this.dequeue();
	}

	
}

