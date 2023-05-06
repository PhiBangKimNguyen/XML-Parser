package utility;

import java.lang.reflect.Array;

public class MyArrayList<E> implements ListADT<E> {

	private static final long serialVersionUID = 1L;
	private E[] arrayList;
	private static final int MIN_CAPACITY = 0;
	private int size;
	
	/**
	 * Constructor
	 */
	@SuppressWarnings("unchecked")
	public MyArrayList()
	{
		this.arrayList = (E[]) new Object[MIN_CAPACITY];
		this.size = arrayList.length;
	}
	

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		this.arrayList = (E[]) new Object[MIN_CAPACITY];
		this.size = 0;
	}
	
	@Override
	public E get(int index) {
		if(index < 0 || index > size)		
			throw new IndexOutOfBoundsException();	
		return this.arrayList[index];
	}
	
	@Override
	public E set(int index, E toChange) {
		if(index < 0 || index > size) 		
			throw new IndexOutOfBoundsException();		
		else if(toChange.equals(null))	
			throw new NullPointerException();		
		this.arrayList[index] = toChange;
		return this.arrayList[index];
	}

	@Override
	public boolean add(int index, E toAdd) {
		if(index < 0 || index > this.size)
			throw new IndexOutOfBoundsException();
		else if(toAdd.equals(null))
				throw new NullPointerException();		
		else if(index == size) {		
			this.size += 1;
			this.arrayList = duplicateArray(this.arrayList, this.size);
			this.arrayList[size-1] = toAdd;
		}		
		else {					
			this.size += 1;
			this.arrayList = duplicateArray(this.arrayList, this.size);
			for(int i = size-1; i > index; i--)			
				this.arrayList[i] = arrayList[i-1];			
			this.arrayList[index] = toAdd;
		}		
	
		return (get(index).equals(toAdd)) ? true : false;
	}

	@Override
	public boolean add(E toAdd) {
		if(toAdd.equals(null))		
			throw new NullPointerException();	
		this.arrayList = duplicateArray(this.arrayList, size+1);
		this.arrayList[size++] = toAdd;
		return (this.arrayList[size-1].equals(toAdd)) ? true : false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean addAll(ListADT<? extends E> toAdd) {	
		if(toAdd.equals(null))		
			throw new NullPointerException();		
		
		for(int i = 0; i < toAdd.toArray().length; i++)
		{
			this.arrayList = duplicateArray(this.arrayList, this.size+1);
			this.arrayList[size++] = (E) (toAdd.toArray()[i]);
		}
		
		return (toAdd.toArray()[toAdd.toArray().length-1].equals(arrayList[this.size-1])) ? true : false; 			
	}
	
	

	@Override
	public E remove(int index) {
		if(index < 0 || index >= this.size)
			throw new IndexOutOfBoundsException();
		E toRemove = arrayList[index];

		//shift all values to the left
		for(int i = index; i < size-1; i++)		
			arrayList[i] = arrayList[i+1];
				
		//copy arraylist with -1 size and increment size
		this.size--;
		this.arrayList = duplicateArray(this.arrayList, this.size);
		
		return toRemove;
	}

	@Override
	public E remove(E toRemove) {
		if(toRemove.equals(null))		
			throw new NullPointerException();
		
		for(int i = 0; i < this.size; i++) {		
			if(this.arrayList[i].equals(toRemove)) {		
				remove(i);
			}
		}
		return toRemove;
	}

	

	@Override
	public boolean contains(E toFind)  {
		if (toFind.equals(null)) 
			throw new NullPointerException();
		for(int i = 0; i < this.arrayList.length;i++) {		
			if(this.arrayList[i].equals(toFind))
				return true;			
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(E[] toHold) {
		if (toHold.equals(null)) 
			throw new NullPointerException();
		
		if (toHold.length < this.size) {
			E[] tempArray = (E[]) Array.newInstance(this.get(0).getClass(), this.size);
			for (int i = 0; i < this.size; i++) 
				tempArray[i] = this.arrayList[i];			
			return tempArray;
		} else {
			for (int i = 0; i < this.size; i++) 
				toHold[i] = this.arrayList[i];			
			return toHold;
		}
	}
	
	@Override
	public Iterator<E> iterator() {
		return new iterate();
	}
	
	@Override
	public Object[] toArray() {
		return this.arrayList;
	}
	
	@SuppressWarnings("unchecked")
	private E[] duplicateArray(E[] toDuplicate, int length) {
		E[] duplicatedArray = (E[]) new Object[length];
		if(length < toDuplicate.length) {
			for(int i = 0; i < length; i++) {
				duplicatedArray[i] = toDuplicate[i];
			}
		} else {
			for(int i = 0; i < toDuplicate.length; i++) {
				duplicatedArray[i] = toDuplicate[i];
			}
		}
		return duplicatedArray;
	}
	
	private class iterate implements Iterator<E>{
		private int pos;
		@Override
		public boolean hasNext() {
			return pos < size;
		}
		
		@Override
		public E next() {		
			E nextElement = arrayList[pos++];
			return nextElement;
		}
	}
}
