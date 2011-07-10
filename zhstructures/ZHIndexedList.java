/*
 * File: ZHIndexedList.java
 */

package zhstructures;

import java.util.Iterator;

/**
 * Interface for a list accessed by element index (0 .. size-1)
 * 
 * @author J. Andrew Holey
 * @version February 25, 2009
 */
public interface ZHIndexedList<ElementType>
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
   * @see zhstructures.ZHCollection#iterator()
   */
  public Iterator<ElementType> iterator();
	
  /**
   * Returns the number of elements in this list.
   * 
   * @return the number of elements in this list
   */
  public int size();

  /**
   * Gets the element at the specified index in the list (0 .. size-1).
   * 
   * @param index the position to get the element from (0 .. size-1)
   * @return the element at the specified index
   * @throws IndexOutOfBoundsException if index < 0 or index >= size
   */
  public ElementType get(int index);
	
  /**
   * Sets the element at the specified index in the list (0 .. size-1)
   * to the specified new value and returns the previous value.   *
   * @param index the position to set the element from (0 .. size-1)
   * @param newValue the new value to put at the specified position
   * @return the old value at the specified position
   * @throws IndexOutOfBoundsException if index < 0 or index >= size
   */
  public ElementType set(int index, ElementType newValue);
	
  /**
   * Inserts the specified element at the specified index (0 .. size)
   * and increments the indices of any remaining elements. An index of 0
   * inserts the element at the beginning of the list; an index of size
   * appends the element to the list.
   * 
   * @param index the position at which to insert the element (0 .. size)
   * @param element the element to be inserted
   * @throws IndexOutOfBoundsException if index < 0 or index > size
   */
  public void addElementAt(int index, ElementType element);
	
  /**
   * Removes and returns the element at the specified index (0 .. size-1)
   * in the list and decrements the index of any following elements.
   * 
   * @param index the position from which to remove the element
   *              (0 .. size-1)
   * @return the element removed from the specified position
   * @throws IndexOutOfBoundsException if index < 0 or index >= size
   */
  public ElementType removeElementAt(int index);
	
  /**
   * Returns the lowest index at which the specified element is found
   * in the list (0 .. size-1) or -1 if the element is not present.
   * 
   * @param element the element to be searched for
   * @return the lowest index at which the specified element is found
   * in the list (0 .. size-1) or -1 if the element is not present
   */
  public int search(ElementType element);

}
