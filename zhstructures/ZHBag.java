/*
 * File: ZHBag.java
 */

package zhstructures;

import java.util.Iterator;

/**
 * A collection in the Ziegler/Holey collection hierarchy that contains
 * elements in arbitrary order with duplicates allowed.
 * This interface models the mathematical multi-set abstraction.
 * 
 * @author J. Andrew Holey
 * @version February 13, 2009
 */
public interface ZHBag<ElementType> extends ZHCollection<ElementType> {
	
	/* (non-Javadoc)
	 * @see zhstructures.ZHCollection#isEmpty()
	 */
	public boolean isEmpty();
	
	/* (non-Javadoc)
	 * @see zhstructures.ZHCollection#contains(java.lang.Object)
	 */
	public boolean contains(ElementType element);
	
	/* (non-Javadoc)
	 * @see zhstructures.ZHCollection#iterator()
	 */
	public Iterator<ElementType> iterator();
	
	/**
	 * Returns the number of elements in this bag (its cardinality)
	 * including duplications. For example, the size of the bag
	 * {3, 2, 1, 3} is 4.
	 * 
	 * @return the number of elements in this bag (its cardinality)
	 */
	public int size();
	
	/**
	 * Returns the number of occurrences of the specified element in
	 * this bag.
	 * 
	 * @param element
	 * @return the number of occurrences of the specified element in
	 *         this bag
	 */
	public int count(ElementType element);
	
	/**
	 * Adds the specified element to this bag and returns true.
	 * 
	 * @param element the element to be added to this bag 
	 * @return true 
	 */
	public boolean add(ElementType element);
	
	/**
	 * Removes one instance of the specified element from this bag
     * if it is present, that is, if an equal element is present
     * as determined by the equals() method.
	 * 
	 * @param element the element to be removed from this bag,
	 *        if present
	 * @return true if this bag was modified by this operation,
	 *         i.e., if it previously contained the specified
	 *         element 
	 */
	public boolean remove(ElementType element);
	
	/**
	 * Returns a new bag that is the union of this bag and otherBag.
	 * That is, it returns a bag that contains all elements contained
	 * in this bag and otherBag. The count of each element in the
	 * result will be the sum of the counts of that element in this
	 * bag and otherBag.
	 * 
	 * @param otherBag the bag to form the union with this bag
	 * @return a new bag that is the union of this bag and otherBag
	 */
	public ZHBag<ElementType> union(ZHBag<ElementType> otherBag);
	
	/**
	 * Returns true if the specified potential subbag is a subbag of
	 * this bag. Bag A is a subbag of Bag B if for every element e in
	 * A, the count of e in A is less than or equal to the count of
	 * e in B.
	 * 
	 * @param potentialSubbag the bag to check whether it is a subbag
	 *        of this bag or not
	 * @return true if the specified potential subbag is a subbag of
	 *         this bag
	 */
	public boolean subbag(ZHBag<ElementType> potentialSubbag);
	
	/**
	 * Indicates whether some other object is equal to this one.
	 * For bags, this should return true if an only if the other
	 * object is a bag and each bag is a subbag of the other.
	 * 
	 * @param other the object with which to compare this one
	 * @return true if this object is the same as the specified other
	 */
	public boolean equals(Object other);
	
}

