/*
 * File: ZHIterator.java
 */

package zhstructures;

import java.util.Iterator;

/**
 * Wrapper class for any Iterator that throws an UnsupportedOperationException
 * when the remove method is called.
 * 
 * @author J. Andrew Holey
 * @version April 28, 2008
 */
public class ZHIterator<ElementType> implements Iterator<ElementType> {

  protected Iterator<ElementType> iterator;
	
  /**
   * Creates a new wrapper for the specified iterator that behaves exactly like
   * the specified iterator except that it throws an
   * UnsupportedOperationException when the remove method is called.
   * 
   * @param iterator the iterator to be wrapped
   */
  public ZHIterator(Iterator<ElementType> iterator) {
    this.iterator = iterator;
  }

  /* (non-Javadoc)
   * @see java.util.Iterator#hasNext()
   */
  @Override
  public boolean hasNext() {
    return iterator.hasNext();
  }

  /* (non-Javadoc)
   * @see java.util.Iterator#next()
   */
  @Override
  public ElementType next() {
    return iterator.next();
  }

  /* (non-Javadoc)
   * @see java.util.Iterator#remove()
   */
  @Override
  public void remove() {
    throw new UnsupportedOperationException();
  }
	
}
