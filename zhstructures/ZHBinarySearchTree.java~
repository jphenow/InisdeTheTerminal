/*
 * File: ZHBinarySearchTree.java
 */

package zhstructures;

import java.util.Iterator;

/**
 * Interface for classes representing a binary search tree.
 * 
 * @author J. Andrew Holey
 * @version April 18, 2008
 *
 * @param <ElementType> the type of data stored in the nodes of this tree
 */
public interface ZHBinarySearchTree<ElementType extends Comparable<ElementType>>
    extends ZHCollection<ElementType> {

  /* (non-Javadoc)
   * @see zhstructures.ZHCollection#isEmpty()
   */
  public boolean isEmpty();
	
  /* (non-Javadoc)
   * @see zhstructures.ZHCollection#contains(java.lang.Object)
   */
  public boolean contains(ElementType element);
	
  /* (non-Javadoc)
   * @see java.lang.Iterable#iterator()
   */
  public Iterator<ElementType> iterator();
	
  /**
   * Adds the specified element to this tree if not already present and returns
   * true if the tree was modified as a result of this operation, otherwise
   * false.
   * 
   * @param element the element to be removed
   * @return true if this tree was modified as a result of this operation
   */
  public boolean add(ElementType element);

  /**
   * Removes the specified element from this tree if present and returns true
   * if the tree was modified as a result of this operation, otherwise false.
   * 
   * @param element
   * @return true the element was
   */
  public boolean remove(ElementType element);

}
