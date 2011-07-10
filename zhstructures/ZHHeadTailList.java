/*
 * File: ZHHeadTailList.java
 */

package zhstructures;

/**
 * Interface for a Lisp-like list class that provides head() and tail() methods
 * along with appropriate constructors to build arbitrary immutable lists.<br>
 * 
 * Implementations of this interface should provide two constructors: a default
 * constructor that makes an empty list and a constructor that takes an element
 * and list as parameters and returns a new list with the specified element and
 * list as head and tail, respectively. The second constructor is equivalent to
 * the Lisp cons function.
 * 
 * @author J. Andrew Holey
 * @version October 1, 2008
 */
public interface ZHHeadTailList<ElementType> extends ZHCollection<ElementType> {
	
	/**
	 * Returns the first element of this HeadTailList. Equivalent to the Lisp
	 * car function.
	 * 
	 * @return the first element of this HeadTailList
	 * @throws NoSuchElementException if this HeadTailList is empty
	 */
	public ElementType head();
	
	/**
	 * Returns the tail of this HeadTailList, that is, a list consisting of
	 * all the elements in this list except the first element in the same order
	 * as the elements of this list. Equivalent to the Lisp cdr function.
	 * 
	 * @return the tail of this HeadTailList
	 * @throws NoSuchElementException if this HeadTailList is empty
	 */
	public ZHHeadTailList<ElementType> tail();
}
