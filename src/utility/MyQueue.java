package utility;



public class MyQueue<E> implements QueueADT<E>{
	
	private static final long serialVersionUID = 1L;
	private MyDLL<E> queue;
	private int limit;
	
	/**
	 * Constructor
	 */
	public MyQueue() {
		queue = new MyDLL<>();
	}
	
	public MyQueue(int limit) {
		queue = new MyDLL<>();
		this.limit = limit;
	}
	@Override
	public void enqueue(E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		queue.add(toAdd);		
	}

	@Override
	public E dequeue()  {
		return queue.remove(0);
	}

	@Override
	public E peek() {
		return queue.get(0);
	}

	@Override
	public int size() {
		return queue.size();
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public void dequeueAll() {
		queue.clear();
	}

	@Override
	public boolean equals(QueueADT<E> that) throws NullPointerException {
		if(that == null) 
			throw new NullPointerException();
		
		Iterator<E> queueIterator = this.iterator();
		Iterator<E> thatIterator = that.iterator();

		while (queueIterator.hasNext()) {
			if (!queueIterator.next().equals(thatIterator.next())) 
				return false;		
		} 
		return true;
	}

	@Override
	public Object[] toArray() {
		return queue.toArray();
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		return queue.toArray(toHold);
	}

	@Override
	public boolean isFull() {
		return (queue.size() == limit) ? true : false;
	}

	@Override
	public Iterator<E> iterator() {
		return queue.iterator();
	}
	
	
}
