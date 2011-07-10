/*
 * File ZHArrayStructure.java
 */

package zhstructures;

import java.io.Serializable;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * An abstract data structure for collections built on resizeable arrays.
 * 
 * @author J. Andrew Holey
 * @version January 19, 2009
 */
public class ZHArrayStructure<ElementType>
implements ZHCollection<ElementType>, Serializable {

    /**
     * Serialization ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * The default initial capacity for the array in a structure when the
     * no-parameter constructor is used
     */
    public static final int DEFAULT_CAPACITY = 1024;

    /**
     * The array containing the elements of this structure
     */
	protected Object[] elements;
    /**
     * The current size of the elements array
     */
    protected int capacity;
    /**
     * The index of the first element in the structure.
     * In this base class, first always remains zero.
     * In extending classes that allow adding or removing elements at the
     * front of the structure, the value of first may change accordingly.
     * 
     */
    protected int first = 0;
    /**
     * The index one greater than the last element in the structure.
     * This is the index where the next element added to the end of the
     * structure should be placed.
     * next should not exceed capacity and must be greater than or equal to
     * first.
     * (Circular implementations may violate this last condition but must
     * then override the contains(), iterator() and reallocate() methods for
     * wrap around.)
     */
	protected int next = 0;

    /**
     * Creates a new empty array structure with a default initial capacity of
     * ZHArrayStructure.DEFAULT_CAPACITY.
     */
    public ZHArrayStructure() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Creates a new empty array structure with the specified initial
     * capacity.
     *
     * @param capacity the initial capacity of this array structure
     * @throws IllegalArumentException if capacity <= 0
     */
    public ZHArrayStructure(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be greater than 0");
        }
        this.capacity = capacity;
        this.elements = new Object[capacity];
    }

    /* (non-Javadoc)
     * @see zhstructures.ZHCollection#contains(java.lang.Object)
     */
    public boolean contains(ElementType element) {
        for (int i = this.first; i < this.next; i++) {
            if (element.equals(this.elements[i])) return true;
        }
        return false;
    }

    /**
     * Returns the first position at which the specified element occurs in
     * this array structure or -1 if the element is not present.
     * 
     * @param element the item to be searched for
     * @return the first position at which the specified element occurs in
     *         this array structure or -1 if the element is not present
     */
    public int find(ElementType element) {
        for (int i = this.first; i < this.next; i++) {
            if (element.equals(this.elements[i])) return i;
        }
        return -1;
    }

    /* (non-Javadoc)
     * @see zhstructures.ZHCollection#isEmpty()
     */
    public boolean isEmpty() {
        return (this.size() == 0);
    }

    /**
     * Returns the number of elements in this structure.
     * 
     * @return the number of elements in this structure
     */
    public int size() {
        return (this.next - this.first);
    }
	
    /**
     * Returns the index of the first element in this structure.
     * 
     * @return the index of the first element in this structure
     */
    public int firstIndex() {
        return this.first;
    }
	
    /**
     * Returns the index of the last element in this structure.
     * 
     * @return the index of the last element in this structure
     */
    public int lastIndex() {
        return this.next - 1;
    }

    /* (non-Javadoc)
     * @see zhstructures.ZHCollection#iterator()
     */
    public Iterator<ElementType> iterator() {
        return listIterator();
    }
	
    /**
     * Returns a list iterator over the elements in this structure
     * in sequence from first to last element.
     * 
     * @returns a list iterator over the elements in this structure
     *          in sequence from first to last element
     */
    public ListIterator<ElementType> listIterator() {
        return new InternalListIterator();
    }
	
    /**
     * Returns a list iterator over the elements in this structure
     * starting with the specified index in the structure.
     * The specified index indicates the first element that would be
     * returned by an initial call to next(). An initial call to
     * previous() would return the element with the specified
     * index minus one.
     * 
     * @param index the index of the first element to be returned from
     *        the list iterator by an initial call to the next() method
     * @returns a list iterator over the elements in this structure
     *          in sequence from first to last element
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (index < this.first || index > this.next)
     */
    public ListIterator<ElementType> listIterator(int index) {
        return new InternalListIterator();
    }

    /**
     * Returns the element at the specified position in this structure.
     * 
     * @param index the index of the element to return
     * @return the element at the specified position in this structure
     * @throws IndexOutOfBoundsException if the index is out of range
     * 			(index < this.first || index >= this.nextLast)
     */
    @SuppressWarnings("unchecked")
    public ElementType get(int index) {
        if (index < this.first || index >= this.next) {
            throw new IndexOutOfBoundsException();
        }
        return (ElementType) this.elements[index];
    }

    /**
     * Replaces the element at the specified position in this structure with
     * the specified element and returns the element previously at the
     * specified position.
     * 
     * @param index the index of the element to replace
     * @param element the element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     * 			(index < this.first || index >= this.nextLast)
     */
    @SuppressWarnings("unchecked")
    public ElementType set(int index, ElementType element) {
        if (index < this.first || index >= this.next) {
            throw new IndexOutOfBoundsException();
        }
        ElementType result = (ElementType) this.elements[index];
        this.elements[index] = element;
        return result;
    }

    /**
     * Adds the specified element to the end of this structure.
     * 
     * @param element the element to be added
     */
    public void addLast(ElementType element) {
        if (this.isAtCapacity()) this.reallocate();
        this.elements[this.next] = element;
        this.next++;
    }
	
    /**
     * Removes and returns the element at the end of this structure.
     * 
     * @return the element at the end of this structure
     * @throws NoSuchElementException if this structure is empty
     */
    @SuppressWarnings("unchecked")
    public ElementType removeLast() {
        if (this.isEmpty()) throw new NoSuchElementException();
        this.next--;
        ElementType result = (ElementType) this.elements[this.next];
        this.elements[this.next] = null;
        return result;
    }

    /**
     * Returns true if no more elements can be added to the end of this
     * structure
     * 
     * @return true if no more elements can be added to the end of this
     *         structure
     */
    protected boolean isAtCapacity() {
        return (this.next == this.capacity);
    }

    /**
     * Repositions the elements at the beginning of this array structure,
     * and if the structure is more than half full doubles the capacity of
     * this array structure by allocating a new elements array and copying
     * the current elements into the new array.
     * This method assumes that first is zero and should be overridden in
     * subclasses that modify the value of first.
     */
    protected void reallocate() {
        this.capacity *= 2;
        Object[] newElements = new Object[this.capacity];
        for (int i = 0; i < this.next; i++) {
            newElements[i] = elements[i];
        }
        this.elements = newElements;
    }

    /**
     * Internal class implementing the ListIterator interface on
     * array structures.
     */
    protected class InternalListIterator
    implements ListIterator<ElementType> {

        /**
         * The current index of the iterator
         */
        protected int position;

        /**
         * Creates a new InternalListIterator.
         */
        public InternalListIterator() {
            this(first);
        }

        /**
         * Creates a new InternalListIterator,
         * initially at the specified index.
         * 
         * @param startPosition the index for the iterator to start at
         */
        public InternalListIterator(int startPosition) {
            if (startPosition < first || startPosition > next) {
                throw new IndexOutOfBoundsException();
            }
            this.position = startPosition;
        }

        /**
         * Unsupported operation for this iterator
         */
        public void add(ElementType arg0) {
            throw new UnsupportedOperationException();
        }

        /* (non-Javadoc)
         * @see java.util.ListIterator#hasNext()
         */
        public boolean hasNext() {
            return (this.position < next);
        }

        /* (non-Javadoc)
         * @see java.util.ListIterator#hasPrevious()
         */
        public boolean hasPrevious() {
            return (this.position > first);
        }

        /* (non-Javadoc)
         * @see java.util.ListIterator#next()
         */
        public ElementType next() {
            if (!this.hasNext()) throw new NoSuchElementException();
            ElementType result = get(this.position);
            this.position++;
            return result;
        }

        /* (non-Javadoc)
         * @see java.util.ListIterator#nextIndex()
         */
        public int nextIndex() {
            return this.position;
        }

        /* (non-Javadoc)
         * @see java.util.ListIterator#previous()
         */
        public ElementType previous() {
            if (!this.hasPrevious()) throw new NoSuchElementException();
            this.position--;
            return get(this.position);
        }

        /* (non-Javadoc)
         * @see java.util.ListIterator#previousIndex()
         */
        public int previousIndex() {
            return (this.position - 1);
        }

        /**
         * Unsupported operation for this iterator
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /**
         * Unsupported operation for this iterator
         */
        public void set(ElementType element) {
            throw new UnsupportedOperationException();
        }

    }

}
