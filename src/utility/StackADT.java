package utility;

import java.util.*;
import java.io.*;

/**
 * 
 * @author Phi N, Dias R, Thanh V, Steven Z
 *
 */

public interface StackADT<E> extends Serializable
{
	
	/**
	 * Add an element onto the top of stack.
	 * 
	 * @param toAdd
	 *           
	 * @throws NullPointerException when null is added
	 */
	public void push(E toAdd) throws NullPointerException;

	/**
	 * Removes the element at the top of stack. And return the removed element 
	 * 
	 * @return the removed element 
	 * @throws EmptyStackException if stack empty.         
	 */
	public E pop() throws EmptyStackException;

	/**
	 * Views the element at the top of this stack without removing it.
	 * 
	 * @return the top element
	 * @throws EmptyStackException if stack empty
	 */
	public E peek() throws EmptyStackException;

	/**
	 * Clears all the elements from this Stack.
	 */
	public void clear();


	/**
	 * toArray method will return an array containing all of the elements in the stack in proper
	 * order. 
	 * 
	 * @return an array containing all of the elements in the stack
	 */
	public Object[] toArray();

	/**
	 * toArray method will return an array containing all of the elements in the stack in proper
	 * order.
	 * 
	 * @param arr
	 *            
	 * @return an array containing the elements of this stack.
	 * @throws NullPointerException if arr is null
	 *        
	 */
	public E[] toArray(E[] arr) throws NullPointerException;

	
	/**
	 * Returns the 1-based position where an object is on this stack. 
	 * If the object obj is an element in this stack, 
	 * this method returns the distance from the top of the stack of the occurrence nearest the top of the stack; 
	 * the topmost element on the stack is considered to be at distance 1. 
	 * The equals method is used to compare obj to the items in this stack.
	 * 
	 * @param obj the wanted object.
	 *            
	 * @return The index of the element from the stack. If not found, return -1.
	 */
	public int search(E obj);

	/**
	 * Returns an iterator over the collections in proper order.
	 * 
	 * @return E iterator over the collections in proper order.
	 */
	public Iterator<E> iterator();
	
	/**
	 * isEmpty returns true if there is no elements in the Stack.
	 * 
	 * @return true if this Stack is empty.
	 */
	public boolean isEmpty();
	
	/**
	 * Returns true if this list contains the expected test element. 
	 * 
	 * @param obj to be tested
	 *            
	 * @return true if this list contains the expected test element.
	 * @throws NullPointerException if obj is null.
	 *            
	 */
	public boolean contains(E obj) throws NullPointerException;

	/**
	 * equals will used to compare two stack ADT. True when two stacks contain
	 * same elements in the same order.
	 * 
	 * @param stack to be compared.
	 * @return true if the stacks are equal.
	 */
	public boolean equals(StackADT<E> stack);
	
	/**
	 * Returns the integer depth of the current stack value.
	 * @return size.
	 */
	public int size();
}