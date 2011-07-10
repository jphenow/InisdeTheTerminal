/*
 * File: ZHArrayQueue.java
 */

package zhstructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class that implements a ZHQueue using an internal array structure.
 * 
 * @author J. Andrew Holey
 * @version February 4, 2009
 */
public class ZHArrayQueue<ElementType> implements ZHQueue<ElementType> {
	
	private ZHTwoWayArrayStructure<ElementType> elements;

	/**
	 * Creates a new empty queue with a default capacity.
	 */
	public ZHArrayQueue() {
		this.elements = new ZHTwoWayArrayStructure<ElementType>();
	}

	/**
	 * Creates a new empty queue with the specified capacity.
	 * 
	 * @param capacity the initial capacity of the queue
	 * @throws IllegalArumentException if capacity <=0
	 */
	public ZHArrayQueue(int capacity) {
		this.elements = new ZHTwoWayArrayStructure<ElementType>(capacity);
	}

	/* (non-Javadoc)
	 * @see zhstructures.ZHQueue#dequeue()
	 */
	public ElementType dequeue() {
		if (this.isEmpty()) throw new NoSuchElementException();
		return this.elements.removeFirst();
	}

	/* (non-Javadoc)
	 * @see zhstructures.ZHQueue#enqueue(java.lang.Object)
	 */
	public void enqueue(ElementType element) {
		this.elements.addLast(element);
	}

	/* (non-Javadoc)
	 * @see zhstructures.ZHQueue#peek()
	 */
	public ElementType peek() {
		if (this.isEmpty()) throw new NoSuchElementException();
		return this.elements.get(this.elements.firstIndex());
	}

	@Override
	public boolean contains(ElementType element) {
		return this.elements.contains(element);
	}

	@Override
	public boolean isEmpty() {
		return this.elements.isEmpty();
	}

	@Override
	public Iterator<ElementType> iterator() {
		return this.elements.iterator();
	}

}
