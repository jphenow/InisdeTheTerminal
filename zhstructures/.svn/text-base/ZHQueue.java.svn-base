/*
 * File ZHQueue.java
 */

package zhstructures;

/**
 * Interface for a queue class.
 * 
 * @author J. Andrew Holey
 * @version August 11, 2008
 */
public interface ZHQueue<ElementType> extends ZHCollection<ElementType> {
	
	/**
	 * Returns the first element in the queue without removing it.
	 * 
	 * @return the first element in the queue
	 * @throws NoSuchElementException if this queue is empty
	 */
	public ElementType peek();
	
	/**
	 * Removes and returns the first element in this queue.
	 * 
	 * @return the first element in this queue
	 * @throws NoSuchElementException if this queue is empty
	 */
	public ElementType dequeue();
	
	/**
	 * Adds a new element to the back of this queue.
	 * 
	 * @param element the element to be added
	 */
	public void enqueue(ElementType element);

}
