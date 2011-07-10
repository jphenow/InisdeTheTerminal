/*
 * File: ZHOneWayLinkedStructure.java
 */

package zhstructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Abstract class that provides a node structure for one-way linked implementations of
 * linear collections. The individual objects of this class are traditionally referred to
 * as "nodes," but we will use the term "structure component" to refer to them in these
 * documentation comments.<br>
 * 
 * Classes implementing this interface will typically use this class in one of two ways.
 * A class may extend this class, passing its own class name (with the generic ElementType
 * parameter) as the StructureType parameter. In this case, the implementing class should
 * only call constructors of this class from within its own constructors and not from its
 * other methods. This way of using the ZHOneWayLinkedStructure will probably most often be
 * used for a situation in which the implementing class needs a single reference to a fixed
 * starting node. A typical declaration of this type might be:<br>
 *   public class Foo\<ElementType\>
 *             extends ZHOneWayLinkedStructure\<ElementType, Foo\<ElementType\>\> ...<br>
 * 
 * The second way to use this class occurs when the implementing class needs one or more
 * instance variable references to parts of the structure. In this case, the implementing
 * class declares a protected inner class that extends this class with the inner class
 * name passed as the StructureType generic parameter; the outer class also declares one
 * or more instance variables of the inner class type. The inner class need only implement
 * constructors that match the constructors of this class, but it may of course implement
 * any additional methods that will be useful in traversing the structure. If the
 * implementing class is not a member of the zhstructures package, it will be necessary to
 * add appropriate accessor methods to the inner class, typically getElement() and
 * getNext().<br>
 * 
 * Structure components are either empty or not. In an empty structure component, the
 * element and next instance variables are irrelevant and should be set to null (or
 * left uninitialized) to facilitatZHLinkedStack.javae garbage collection. If a structure component is not
 * empty, both its element and next variables must be initialized to appropriate objects.
 * Following this convention, there is always exactly one empty component at the end of
 * every structure, and all other components in the structure are non-empty.
 * 
 * @param ElementType the type of data elements contained in this structure
 * @param StructureType a class extending this class that is to be used in a particular
 *        collection
 * 
 * @author J. Andrew Holey
 * @version August 10, 2008, documentation revised January 15, 2009
 */
public abstract class ZHOneWayLinkedStructure
<ElementType, StructureType extends ZHOneWayLinkedStructure<ElementType, StructureType>>
  implements ZHCollection<ElementType> {
 
 /**
  * The data element associated with this node.
  * This variable should be null in an empty component and should refer to an object
  * in a non-empty component (unless null elements are allowed in the collection).
  */
 protected ElementType element;
 /**
  * The component that follows this one in this structure.
  * This variable should be null in an empty component and should refer to another
  * structure component (possibly empty) in a non-empty component.
  */
 protected StructureType next;
 /**
  * The state of this node: either ZHNodeState.EMPTY or ZHNodeState.NOT_EMPTY
  */
 protected ZHComponentState state;
 
 /**
  * Creates a new empty structure.
  */
 public ZHOneWayLinkedStructure() {
  this.state = ZHComponentState.EMPTY;
  /*
   * The remaining instance variables (element & next) are irrelevant in an
   * empty structure and so need not be initialized in this constructor.
   */
 }
 
 /**
  * Creates a new non-empty structure component with the specified element and next
     * structure component.
  * 
  * @param element the data element associated with this structure component
  * @param next the next component in this structure, which should generally be an
     *        actual component rather than null
  */
 public ZHOneWayLinkedStructure(ElementType element, StructureType next) {
  this.element = element;
  this.next = next;
  this.state = ZHComponentState.NOT_EMPTY;
 }

 /* (non-Javadoc)
  * @see zhstructures.ZHCollection#contains(java.lang.Object)
  */
 public boolean contains(ElementType element) {
  switch (this.state) {
   case EMPTY:
    return false;
   case NOT_EMPTY:
    return (element.equals(this.element) || this.next.contains(element));
   default:
    throw new IllegalStateException();
  }
 }

 /* (non-Javadoc)
  * @see zhstructures.ZHCollection#isEmpty()
  */
 public boolean isEmpty() {
  switch (this.state) {
   case EMPTY:
    return true;
   case NOT_EMPTY:
    return false;
   default:
    throw new IllegalStateException();
  }
 }

 /* (non-Javadoc)
  * @see zhstructures.ZHCollection#iterator()
  */
 @SuppressWarnings("unchecked")
 public Iterator<ElementType> iterator() {
  return new InternalIterator((StructureType) this);
 }
 
 /**
  * Iterator class for the structure.
     * This iterator does not support the remove operation.
  */
 protected class InternalIterator implements Iterator<ElementType> {
  
  private StructureType currentStructure;  
  
  /**
   * Creates a new iterator starting at the specified component.
   * 
   * @param startComponent the node at which to start iteration
   */
  public InternalIterator(StructureType startComponent) {
   currentStructure = startComponent;
  }

  /* (non-Javadoc)
   * @see java.util.Iterator#hasNext()
   */
  public boolean hasNext() {
   switch (currentStructure.state) {
   case EMPTY:
    return false;
   case NOT_EMPTY:
    return true;
   }
   throw new IllegalStateException();
  }

  /* (non-Javadoc)
   * @see java.util.Iterator#next()
   */
  public ElementType next() {
   switch (currentStructure.state) {
   case EMPTY:
    throw new NoSuchElementException();
   case NOT_EMPTY:
    ElementType result = currentStructure.element;
    currentStructure = currentStructure.next;
    return result;
   }
   throw new IllegalStateException();
  }

  /* (non-Javadoc)
   * @see java.util.Iterator#remove()
   */
  public void remove() {
   throw new UnsupportedOperationException();
  }
  
 }

}