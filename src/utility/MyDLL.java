package utility;

import java.lang.reflect.Array;

public class MyDLL<E> implements ListADT<E> {
	
	private static final long serialVersionUID = 1L;
	private DLLNode<E> head;
	private DLLNode<E> tail;
	private int size;
	
	/**
	 * Constructor 
	 */
	public MyDLL() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	@Override
	public boolean add(int index, E toAdd) {
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		else if(toAdd.equals(null))
			throw new NullPointerException();
		
		DLLNode<E> currNode = getNode(index);
		DLLNode<E> newNode = new DLLNode<E>(toAdd);
		
		if(index == 0) {
			newNode.setNext(this.head);
			this.head.setPrev(newNode);
			this.head = newNode;
		}
		else {
			currNode.getPrev().setNext(newNode);
			newNode.setPrev(currNode.getPrev());
			currNode.setPrev(newNode);
			newNode.setNext(currNode);
		}
		this.size++;
		return (get(index).equals(toAdd)) ? true : false;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if(toAdd.equals(null))
			throw new NullPointerException();
		
		DLLNode<E> newNode = new DLLNode<E>(toAdd);
		//if empty list, set new node to tail and head
		if(size == 0) {
			head = newNode;
			tail = newNode;
		}
		//if it isn't, set new node to the tail
		else {
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;
		}
		//increase size of the list
		size++;
		return (newNode.getElement().equals(toAdd)) ? true : false;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		Object[] toAddArr = toAdd.toArray();
		for(int i = 0; i < toAdd.toArray().length; i++)		
			add((E)toAddArr[i]);
			
		return true;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		DLLNode<E> currNode = head;
		for(int i = 0; i < index; i++)		
			currNode = currNode.getNext();	
		return currNode.getElement();
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		
		DLLNode<E> removedNode;
		if(size==1) {
			removedNode = head;
			head = null;
			tail = null;
		} else if(index == 0){ 
			removedNode = head;
			head.getNext().setPrev(null);
			head = head.getNext();
		} else if(index == size-1) { 
			removedNode = tail;
			tail.getPrev().setNext(null);
			tail = tail.getPrev();
		} else {
			removedNode = getNode(index);
			removedNode.getPrev().setNext(removedNode.getNext());
			removedNode.getNext().setPrev(removedNode.getPrev());
		}
		size--;
		return removedNode.getElement();
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		if(toRemove.equals(null))
			throw new NullPointerException();
		
		for(int i = 0; i < size; i++) {
			if(get(i).equals(toRemove)) {			
				remove(i);
				return toRemove;
			}
		}
		return null;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		if(toChange.equals(null))
			throw new NullPointerException();
		
		getNode(index).setElement(toChange);		
		if(get(index).equals(toChange))
			return toChange;
		return null;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if(toFind.equals(null))
			throw new NullPointerException();
		
		for(int i = 0; i < size; i++) {
			if(get(i).equals(toFind))
				return true;
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if (toHold.length < size) {
			toHold = (E[]) Array.newInstance(this.get(0).getClass(), size);
		}

		for (int i = 0; i < size; i++) {
			toHold[i] = this.get(i);
		}

		return (E[]) toHold;
	}

	@Override
	public Object[] toArray() {
		Object[] toHold = new Object[size];
		for(int i = 0; i < size; i++) 
			toHold[i] = get(i);
		
		return toHold;
	}
	
	/**
	 * getNode method loop through  DLL and returns the Current Node 
	 * @param index
	 * @return currNode
	 */
	public DLLNode<E> getNode(int index) {
		DLLNode<E> currNode = head;
		for(int i = 0; i < index; i++)
			currNode = currNode.getNext();
		return currNode;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new iterate();
	}
	
	private class iterate implements Iterator<E> {
		private int pos;
		
		@Override
		public boolean hasNext() {
			return pos < size;
		}

		@Override
		public E next() {
			E nextElement = get(pos);
			pos++;
			return nextElement;
		}
		
	}
}
