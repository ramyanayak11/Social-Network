
public final class LinkedStack<T> implements StackInterface<T> {

	private Node topNode; // References the first node in the chain

	LinkedStack () {
		topNode = null;
	}

	private class Node {

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
		
	}// end Node

	@Override
	public void push(T newEntry) {
		Node newNode = new Node(newEntry, topNode);
		topNode = newNode;
	}

	@Override
	public T pop() {
		T top = peek();
		assert topNode != null;
		topNode = topNode.getNextNode();
		return top;
	}

	@Override
	public T peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		else {
			return topNode.getData(); 
		}
	}

	@Override
	public boolean isEmpty() {
		boolean empty = false;
		if (topNode == null) {
			empty = true;
		}
		return empty;
	}

	@Override
	public void clear() {
		topNode = null;
	}

}// end LinkedStack
