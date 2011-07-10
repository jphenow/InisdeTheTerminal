/*
 * File: ZHSet.java
 */

package zhstructures;

import java.util.Iterator;
import java.io.*;

/**
 * A collection in the Ziegler/Holey collection hierarchy that contains
 * no duplicate elements.
 * As implied by its name, this interface models the mathematical set
 * abstraction.
 * Unlike the Java Set interface, this version directly supports set
 * intersection, difference and union methods, and these methods generate
 * a new set without modifying either operand.
 * 
 * @author J. Andrew Holey
 * @version January 27, 2009
 */
public interface ZHSet<ElementType> extends ZHCollection<ElementType>, Serializable {
 
  
  public static final long serialVersionID=1L;
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
  * Returns the number of elements in this set (its cardinality).
  * 
  * @return the number of elements in this set (its cardinality)
  */
 public int size();
 
 /**
  * Adds the specified element to this set if it is not already
  * present as determined by the contains() method.
  * If this set already contains the element, the call leaves the
  * set unchanged and returns false.
  * 
  * @param element the element to be added to this set 
  * @return true if this set did not already contain the specified
     *         element
  */
 public boolean add(ElementType element);
 
 /**
  * Removes the specified element from this set if it is present,
  * that is, if an equal element is present as determined by the
     * contains() method.
  * 
  * @param element the element to be removed from this set,
  *        if present
  * @return true if this set previously contained the specified
  *         element 
  */
 public boolean remove(ElementType element);
 
 /**
  * Returns a new set that is the intersection of this set and
  * otherSet.
  * That is, it returns a set that contains exactly those element
  * contained both in this set and otherSet.
  * It corresponds to the retainAll() method in the Java Set
  * specification, but creates a new set without modifying either
  * of its operands rather than modifying this set.
  * 
  * @param otherSet the set to be intersected with this set
  * @return a new set that is the intersection of this set and
  *         otherSet
  */
 public ZHSet<ElementType> intersection(ZHSet<ElementType> otherSet);
 
 /**
  * Returns a new set that is the asymmetric difference of this set
  * and otherSet.
  * That is, it returns a set that contains the elements of this set
  * that are not contained in otherSet.
  * It corresponds to the removeAll() method in the Java Set
  * specification, but creates a new set without modifying either of
  * its operands rather than modifying this set.
  * 
  * @param otherSet the set to be subtracted from this set
  * @return a new set that is the asymmetric difference of this set
  *         and otherSet
  */
 public ZHSet<ElementType> difference(ZHSet<ElementType> otherSet);
 
 /**
  * Returns a new set that is the union of this set and otherSet.
  * That is, it returns a set that contains all elements contained
  * in this set, otherSet or both.
  * It corresponds to the addAll() method in the Java Set
  * specification, but creates a new set without modifying either of
  * its operands rather modifying this set.
  * 
  * @param otherSet the set to form the union with this set
  * @return a new set that is the union of this set and otherSet
  */
 public ZHSet<ElementType> union(ZHSet<ElementType> otherSet);
 
 /**
  * Returns true if the specified potential subset is a subset of
  * this set.
  * It is equivalent to the containsAll() method in the Java Set
     * specification.
  * 
  * @param potentialSubset the set to check whether it is a subset
  *        of this set or not
  * @return true if the specified potential subset is a subset of
  *         this set
  */
 public boolean subset(ZHSet<ElementType> potentialSubset);
 
}
