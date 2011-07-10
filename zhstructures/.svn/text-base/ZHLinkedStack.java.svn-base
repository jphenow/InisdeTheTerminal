/*
 * File: ZHLinkedStack.java
 */
package zhstructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class implementing a ZHStack using an internal one-way linked structure.
 * 
 * @author J. Andrew Holey
 * @version January 16, 2009
 */
public class ZHLinkedStack<ElementType> implements ZHStack<ElementType> {
	
	/**
	 * A reference to the top node in this stack.
	 */
	protected StackStructure top;
	
	/**
	 * Creates a new empty stack.
	 */
	public ZHLinkedStack() {
		this.top = new StackStructure();
	}

	/* (non-Javadoc)
	 * @see zhstructures.ZHStack#peek()
	 */
	public ElementType peek() {
		if (this.isEmpty()) throw new NoSuchElementException();
		return this.top.element;
	}

	/* (non-Javadoc)
	 * @see zhstructures.ZHStack#pop()
	 */
	public ElementType pop() {
		if (this.isEmpty()) throw new NoSuchElementException();
		ElementType result = this.top.element;
		this.top = this.top.next;
		return result;
	}

	/* (non-Javadoc)
	 * @see zhstructures.ZHStack#push(java.lang.Object)
	 */
	public void push(ElementType element) {
		this.top = new StackStructure(element, this.top);
	}

	/* (non-Javadoc)
	 * @see zhstructures.ZHCollection#contains(java.lang.Object)
	 */
	public boolean contains(ElementType element) {
		return top.contains(element);
	}

	/* (non-Javadoc)
	 * @see zhstructures.ZHCollection#isEmpty()
	 */
	public boolean isEmpty() {
		return this.top.isEmpty();
	}

	/* (non-Javadoc)
	 * @see zhstructures.ZHCollection#iterator()
	 */
	public Iterator<ElementType> iterator() {
		return this.top.iterator();
	}

	/**
	 * Class implementing the this stack with a ZHOneWayLinkedStructure.
	 */
	protected class StackStructure
              extends ZHOneWayLinkedStructure<ElementType, StackStructure> {

		/**
		 * Creates a new empty structure component.
		 */
		public StackStructure() {
			super();
		}

		/**
		 * Creates a new structure component with the specified data element
         * and next component.
		 * 
		 * @param element the data element for the new component
		 * @param next the next component for the new component
		 */
		public StackStructure(ElementType element, StackStructure next) {
			super(element, next);
		}
		
	}
}
