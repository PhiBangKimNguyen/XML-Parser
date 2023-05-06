package utility;

import java.io.*;
import java.util.NoSuchElementException;

/**
 * 
 * @author Phi N, Dias R, Thanh V, Steven Z
 *
 */
public interface QueueADT<E> extends Serializable
{
	/**
	 * Enqueue will place the added item at the end position in the
	 * queue. toAdd must not be null
	 * 
	 * @param toAdd the element to be added
	 * @throws NullPointerException raised when a null object is passed
	 * 
	 */
	public void enqueue(E toAdd) throws NullPointerException;
	
	/**
	 * Dequeue removes the first element of the Queue.
	 * 
	 * @return the first item in the Queue.
	 * @throws raised when no such element found.
	 */
	public E dequeue() throws NoSuchElementException;
	
	/**
	 * dequeueAll clears all elements in the queue.
	 */
	public void dequeueAll();
	
	/**
	 * Peek allows user to view the first element in the queue without
	 * removing it
	 * 
	 * @return the first element in the queue.
	 * @throws raised when no such element found.
	 */
	public E peek() throws NoSuchElementException;
		
	
	/**
	 * Returns an iterator over the collections in proper order.
	 * 
	 * @return E iterator over the collections in proper order.
	 */
	public Iterator<E> iterator();
	
	
	/**
	 * toArray method will return an array containing all of the elements in the queue in proper
	 * order. 
	 * 
	 * @return an array containing all of the elements in the queue
	 */
	public Object[] toArray();

	/**
	 * toArray method will return an array containing all of the elements in the queue in proper
	 * order.
	 * 
	 * @param arr
	 *            
	 * @return an array containing the elements of this queue.
	 * @throws NullPointerException if arr is null
	 *        
	 */
	public E[] toArray(E[] arr) throws NullPointerException;
	
	/**
	 * equals will used to compare two QueueADT. True when two queues contain
	 * same elements in the same order.
	 * 
	 * @param queue to be compared.
	 * @return true if the queues are equal.
	 */
	public boolean equals(QueueADT<E> queue);
	
	/**
	 * Returns true if the number of elements in the queue
	 * equals the length. This is used only if the queue is a fixed size queue.
	 * @return true if is full.
	 */
	public boolean isFull();
	
	/**
	 * Returns true when the queue contains no elements.
	 * @return true when queue length is zero.
	 */
	public boolean isEmpty();
	
	/**
	 * Returns the integer length of the current queue value.
	 * @return size.
	 */
	public int size();
}
