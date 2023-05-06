package utility;

public class MyStack<E> implements StackADT<E>{
	
	private static final long serialVersionUID = 1L;
	private MyArrayList<E> stack;
	
	/**
	 * Constructor
	 */
	public MyStack(){
		stack = new MyArrayList<>();
	}
	
	@Override
	public void push(E toAdd) throws NullPointerException {
		stack.add(0, toAdd);
	}

	@Override
	public E pop() throws IndexOutOfBoundsException {	
		E poppedElement = stack.get(0);
		stack.remove(0);
		return poppedElement;
		
	}

	@Override
	public E peek() throws IndexOutOfBoundsException {	
		return stack.get(0);
	}

	@Override
	public int size() {
		return stack.size();
	}

	@Override
	public boolean isEmpty() {
		return stack.size() == 0;
	}

	@Override
	public void clear() {
		stack.clear();	
	}

	@Override
	public boolean equals(StackADT<E> that) throws NullPointerException {
		Iterator<E> stackIterator = this.iterator();
		Iterator<E> thatIterator = that.iterator();
		
		while (stackIterator.hasNext()) {
			if (!stackIterator.next().equals(thatIterator.next())) 
				return false;		
		}	
		return true;
	}

	@Override
	public int search(E toFind) throws NullPointerException {		
		for(int i = 0; i < stack.size(); i++)		
			if(stack.get(i).equals(toFind)) 
				return i+1;		
		return -1;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		return stack.contains(toFind);
	}

	@Override
	public Object[] toArray() {
		return stack.toArray();
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		return stack.toArray(toHold);
	}

	@Override
	public Iterator<E> iterator() {
		return stack.iterator();
	}

}
