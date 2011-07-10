/*
 * File: ZHTwoWayArrayStructure.java
 */

package zhstructures;

import java.util.NoSuchElementException;

/**
 * An abstract data structure for collections built on resizeable arrays with
 * access at both ends of the array.
 * 
 * @author J. Andrew Holey
 * @version February 4, 2009
 */
public class ZHTwoWayArrayStructure<ElementType> extends
		ZHArrayStructure<ElementType> {

	/**
	 *  Serialization ID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The default load factor value when not specified in the constructor.
	 */
	public static final double DEFAULT_LOAD_FACTOR = 0.875;
	
	/**
	 * The portion of the array that must be full to precipitate a complete
	 * reallocation when addFirst() is called with a structure that
	 * isAtFront() or addLast() is called with a structure that isAtCapacity().
	 */
	protected final double loadFactor;

	/**
	 * Creates a new empty array structure with a default initial capacity of
	 * ZHArrayStructure.DEFAULT_CAPACITY.
	 */
	public ZHTwoWayArrayStructure() {
		this(ZHArrayStructure.DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
	}

	/**
	 * Creates a new empty array structure with the specified initial capacity.
	 *
	 * @param capacity the initial capacity of this array structure
	 * @throws IllegalArumentException if capacity <=0
	 */
	public ZHTwoWayArrayStructure(int capacity) {
		this(capacity, DEFAULT_LOAD_FACTOR);
	}

	/**
	 * Creates a new empty array structure with the specified initial capacity
	 * and load factor.
	 *
	 * @param capacity the initial capacity of this array structure
	 * @param loadFactor the proportion full that triggers a complete
     *        reallocation in certain add situations
	 * @throws IllegalArumentException if capacity <=0 || loadFactor < 0.0 ||
	 *                                    loadFactor >= 1.0
	 */
	public ZHTwoWayArrayStructure(int capacity, double loadFactor) {
		super(capacity);
		if (loadFactor < 0.0 || loadFactor >= 1.0) {
			throw new IllegalArgumentException();
		}
		this.first = this.capacity / 2;
		this.next = this.first;
		this.loadFactor = loadFactor;
	}

	/* (non-Javadoc)
	 * @see zhstructures.ZHArrayStructure#reallocate()
	 */
	@Override
	protected void reallocate() {
		// TODO Auto-generated method stub
		int newFirst;
		int newNext;
		if (this.size() < this.capacity * this.loadFactor) {
			newFirst = (this.capacity - this.size()) / 2;
			newNext = newFirst + this.size();
			if (this.first < newFirst) {
				for (int i = this.next-1, j = newNext-1;
				i >= this.first; i--, j--) {
					this.elements[j] = this.elements[i];
				}
			}
			else { // this.first > newFirst
				for (int i = this.first, j = newFirst;
				i < this.next; i++, j++) {
					this.elements[j] = this.elements[i];
				}
			}
		}
		else { // too full, need to reallocate
			this.capacity *= 2;
			newFirst = (this.capacity - this.size()) / 2;
			newNext = newFirst + this.size();
			Object[] newElements = new Object[this.capacity];
			for (int i = this.next-1, j = newNext-1;
			i >= this.first; i--, j--) {
				newElements[j] = this.elements[i];
			}
			this.elements = newElements;
		}
		this.first = newFirst;
		this.next = newNext;
	}

	/**
	 * Adds the specified element to the beginning of this structure.
	 * 
	 * @param element the element to be added
	 */
	public void addFirst(ElementType element) {
		if (this.isAtZero()) this.reallocate();
		this.first--;
		this.elements[this.first] = element;
	}
	
	/**
	 * Removes and returns the element at the end of this structure.
	 * 
	 * @return the element at the front of this structure
	 * @throws NoSuchElementException if this structure is empty
	 */
	@SuppressWarnings("unchecked")
	public ElementType removeFirst() {
		if (this.isEmpty()) throw new NoSuchElementException();
		ElementType result = (ElementType) this.elements[this.first];
		this.elements[this.first] = null;
		this.first++;
		return result;
	}

	/**
	 * Returns true if no more elements can be added to the front of this
     * structure
	 * 
	 * @return true if no more elements can be added to the front of this
     *         structure
	 */
	protected boolean isAtZero() {
		return (this.first == 0);
	}

}
