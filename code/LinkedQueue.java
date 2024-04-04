
public final class LinkedQueue<T> implements QueueInterface<T> {
	
	private Node firstNode;
	private Node lastNode;
	
	// default constructor
	public LinkedQueue() {
		firstNode = null;					// references node at front of queue
		lastNode = null;					// references node at back of queue
	}

	// -----------------------------------------------------------------------------------------------------
	
	class Node {
		private T data;
		private Node next;
		
		private Node(T dataPortion) {  
			this(dataPortion, null);
		} // end constructor

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		} // end constructor

		private T getData() {
			return data;
		} // end getData

		private void setData(T newData) {
			data = newData;
		} // end setData

		private Node getNextNode() {
			return next;
		} // end getNextNode

		private void setNextNode(Node nextNode) {
			next = nextNode;
		} // end setNextNode
	} // end Node
	
	// -----------------------------------------------------------------------------------------------------
	
	@Override
	// adds a new entry to the queue
	public void enqueue(T newEntry) {
		Node newNode = new Node (newEntry, null);
		
		if (isEmpty()) {
			firstNode = newNode;
		}
		else {
			lastNode.setNextNode(newNode);
		}
		lastNode = newNode;
	}
	
	// -----------------------------------------------------------------------------------------------------
	
	@Override
	// removes the first entry from the queue
	public T dequeue() {
		T front = getFront();
		assert firstNode != null;
		firstNode.setData(null);
		firstNode = firstNode.getNextNode();
		if (firstNode == null) {
			lastNode = null;
		}
		return front;
	}
	
	// -----------------------------------------------------------------------------------------------------
	
	@Override 
	// returns the first entry in the queue
	public T getFront() {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		else {
			return firstNode.getData();
		}
	}
	
	// -----------------------------------------------------------------------------------------------------
	
	@Override
	// returns whether the queue is empty or not
	public boolean isEmpty() {
		boolean empty = false;
		if ((firstNode == null) && (lastNode == null)) {
			empty = true;
		}
		return empty;
	}
	
	// -----------------------------------------------------------------------------------------------------
	
	@Override
	// clears the queue
	public void clear() {
		firstNode = null;
		lastNode = null;
	}
	
} // end LinkedQueue

