/*
 * File: ZHCollection.java
 */

package zhstructures;

import java.util.Iterator;


/**
 * The root interface in the Ziegler/Holey collection hierarchy, which
 * is a simplified version of the Java collection hierarchy.
 * A collection represents a group of objects, known as its elements.
 * Some collections allow duplicate elements and others do not.
 * Some are ordered and others unordered.
 * As with the JDK, we do not provide any direct implementations of this
 * interface; we provide implementations of more specific sub-interfaces
 * like ZHSet and ZHList.
 * This interface is typically used to pass collections around and
 * manipulate them where maximum generality is desired. 
 * 
 * A ZHCollection is more general than the Java Collection in that it does
 * not specify any means for adding, removing or updating elements of the
 * collection.
 * 
 * @author J. Andrew Holey
 * @version August 7, 2008
 */
public interface ZHCollection<ElementType> extends Iterable<ElementType> {
	
	/**
	 * Returns true if this collection contains no elements.
	 * 
	 * @return true if this collection contains no elements
	 */
	public boolean isEmpty();
	
	/**
	 * Returns true if this collection contains the specified element,
	 * that is, if it contains an element equal to the specified element
	 * under the equals () method.
	 * Note that unlike the Java Collection interface, only elements
	 * matching the template type may be tested.
	 * 
	 * @param element the element for which presence in this collection
     *        is to be tested 
	 * @return true if this collection contains the specified element
	 */
	public boolean contains(ElementType element);
	
	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	public Iterator<ElementType> iterator();

}
