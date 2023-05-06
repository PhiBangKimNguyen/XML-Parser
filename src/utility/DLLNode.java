package utility;

public class DLLNode<E> {
	private E element;
	private DLLNode<E> prev;
	private DLLNode<E> next;
	
	/**
	 * Preconditions: An element for the node.
	 * <p>Postconditions: Node constructor with no references to prev or next.</p>
	 * @param elem
	 * 			the element that the node holds
	 */
	public DLLNode(E element) {
		this.prev = null;
		this.next = null;
		this.element = element;
	}
	
	/**
	 * Preconditions: An element, previous node, and next node.
	 * <p>Postconditions: Node constructor with references to the previous and next node.</p>
	 * @param elem
	 * 			the element that the node holds.
	 * @param prev
	 * 			the link to the previous node.
	 * @param next
	 * 			the link to the next node.
	 */
	public DLLNode(E element, DLLNode<E> prev, DLLNode<E> next) {
		this.element = element;
		this.prev = prev;
		this.next = next;
	}
	
	/**
	 * Preconditions: Node object must be created.
	 * <p>Postconditions: Returns the data of the node.</p>
	 * @return element inside the node.
	 * @throws NullPointerException
	 * 				if element is null.
	 */
	public E getElement() throws NullPointerException{
		return element;
	}
	
	/**
	 * Preconditions: Node object must be created.
	 * <p>Postconditions: Returns the next node.</p>
	 * @return next node.
	 * @throws NullPointerException
	 * 				if next node is null.
	 */
	public DLLNode<E> getNext() throws NullPointerException{
		return next;
	}
	
	/**
	 * Preconditions: Node object must be created.
	 * <p>Postconditions: Returns the previous node.</p>
	 * @return previous node.
	 * @throws NullPointerException
	 * 				if next node is null.
	 */
	public DLLNode<E> getPrev() throws NullPointerException{
		return prev;
	}
	
	/**
	 * Preconditions: Node object must be created.
	 * <p>Postconditions: Sets the next node.</p>
	 * @param next
	 * 			the new next node.
	 */
	public void setNext(DLLNode<E> next) {
		this.next = next;
	}
	
	/**
	 * Preconditions: Node object must be created.
	 * <p>Postconditions: Sets the next node.</p>
	 * @param prev
	 * 			the new previous node.
	 */
	public void setPrev(DLLNode<E> prev) {
		this.prev = prev;
	}
	
	/**
	 * Preconditions: Node object must be created.
	 * <p>Postconditions: Sets a new element.</p>
	 * @param prev
	 * 			the new previous node.
	 */
	public void setElement(E element) {
		this.element = element;
	}
}
