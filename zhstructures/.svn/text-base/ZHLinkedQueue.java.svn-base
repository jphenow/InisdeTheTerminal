/*
 * File: ZHLinkedQueue.java
 */
package zhstructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class implementing a ZHQueue using an internal one-way linked structure.
 * 
 * @author Lee Buermann
 * @version February 10, 2009
 */
public class ZHLinkedQueue<ElementType> implements ZHQueue<ElementType> {
 
 /**
  * A reference to the top node in this Queue.
  */
 protected QueueStructure front, back;
 
 /**
  * Creates a new empty Queue.
  */
 public ZHLinkedQueue() {
  this.front = new QueueStructure();
  this.back = new QueueStructure();
 }

 /* (non-Javadoc)
  * @see zhstructures.ZHQueue#peek()
  */
 public ElementType peek() {
  if (this.isEmpty()) throw new NoSuchElementException();
  return this.front.element;
 }

 /* (non-Javadoc)
  * @see zhstructures.ZHQueue#pop()
  */
 public ElementType dequeue() {
  if (this.isEmpty()) throw new NoSuchElementException();
  ElementType result = this.front.element;
  this.front = this.front.next;
  return result;
 }

 /* (non-Javadoc)
  * @see zhstructures.ZHQueue#push(java.lang.Object)
  */
 public void enqueue(ElementType element) {
   QueueStructure empty = new QueueStructure();
   if (this.isEmpty()){
     this.front = new QueueStructure(element, empty);
     this.back=this.front;
   }
   else{
     this.back.next = new QueueStructure(element, empty);
     this.back = this.back.next;
   }
 }

 /* (non-Javadoc)
  * @see zhstructures.ZHCollection#contains(java.lang.Object)
  */
 public boolean contains(ElementType element) {
  return front.contains(element);
 }

 /* (non-Javadoc)
  * @see zhstructures.ZHCollection#isEmpty()
  */
 public boolean isEmpty() {
  return this.front.isEmpty();
 }

 /* (non-Javadoc)
  * @see zhstructures.ZHCollection#iterator()
  */
 public Iterator<ElementType> iterator() {
  return this.front.iterator();
 }

 /**
  * Class implementing the this Queue with a ZHOneWayLinkedStructure.
  */
 protected class QueueStructure
              extends ZHOneWayLinkedStructure<ElementType, QueueStructure> {

  /**
   * Creates a new empty structure component.
   */
  public QueueStructure() {
   super();
  }

  /**
   * Creates a new structure component with the specified data element
         * and next component.
   * 
   * @param element the data element for the new component
   * @param next the next component for the new component
   */
  public QueueStructure(ElementType element, QueueStructure next) {
   super(element, next);
  }
  
 }
}
