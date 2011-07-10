/*
 * File: ZHHeapPriorityQueue.java
 */

package zhstructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class that implements a ZHQueue as heap-based priority queue
 * using an internal array structure.
 * 
 * @author J. Andrew Holey and <your name here>
 * @version <today's date here>
 */
public class ZHHeapPriorityQueue<ElementType extends Comparable<ElementType>>
implements ZHQueue<ElementType> {
 
  private ZHArrayStructure<ElementType> elements;

  /**
   * Creates a new empty queue with a default capacity.
   */
  public ZHHeapPriorityQueue() {
    elements = new ZHArrayStructure<ElementType>();
  }

  /**
   * Creates a new empty queue with the specified capacity.
   * 
   * @param capacity the initial capacity of the queue
   * @throws IllegalArumentException if capacity <=0
   */
  public ZHHeapPriorityQueue(int capacity) {
    elements = new ZHArrayStructure<ElementType>(capacity);
  }
  protected static int parentPosition(int childPosition){
    return (childPosition-1)/2;
  }
  protected static int leftChildPosition(int parentPosition){
    return 2*parentPosition+1;
  }
  protected static int rightChildPosition(int parentPosition){
    return 2*parentPosition+2;
  }
  protected int leastPosition(int currentPosition){
    int lpos = currentPosition;
    int left = leftChildPosition(currentPosition);
    if(left < elements.next){
      if (elements.get(left).compareTo(elements.get(currentPosition))<0){
        lpos = left;
      }
      int right = rightChildPosition(currentPosition);
      if(right < elements.next && elements.get(right).compareTo(elements.get(lpos))<0){
        lpos = right;
      }
    }
      return lpos;
          
  }
  
  protected void checkUpward(int currentPosition){
    if(!(currentPosition==0)){
      int pPos = parentPosition(currentPosition);
      int comp = elements.get(currentPosition).compareTo(elements.get(pPos));
      if(comp<0){
        ElementType parent = elements.get(pPos);
        elements.set(pPos,elements.get(currentPosition));
        elements.set(currentPosition,parent);
      }
      checkUpward(pPos);
    }
  }
  protected void checkDownward(int pos){
    int lpos = leastPosition(pos);
    if (!(lpos==pos)){
      ElementType e = elements.get(lpos);
      elements.set(lpos,elements.get(pos));
      elements.set(pos,e);
      checkDownward(lpos);
    }
    
  }

    
      
    
  /* (non-Javadoc)
   * @see zhstructures.ZHQueue#dequeue()
   */
  public ElementType dequeue() {
    if (this.isEmpty()) throw new NoSuchElementException();
    ElementType result = elements.get(0);
    ElementType last = elements.get(elements.size()-1);
    elements.removeLast();
    if(!elements.isEmpty()){
      elements.set(0,last);
      checkDownward(0);
    }
    return result;
  }

  /* (non-Javadoc)
   * @see zhstructures.ZHQueue#enqueue(java.lang.Object)
   */
  public void enqueue(ElementType element) {
    if(elements.isAtCapacity()){
      elements.reallocate();
    }
    elements.addLast(element);
    checkUpward(elements.size()-1);
  }

  /* (non-Javadoc)
   * @see zhstructures.ZHQueue#peek()
   */
  public ElementType peek() {
    if (this.isEmpty()) throw new NoSuchElementException();
    return elements.get(0);
    
  }

  /* (non-Javadoc)
   * @see zhstructures.ZHQueue#contains()
   */
  public boolean contains(ElementType element) {
    return elements.contains(element);
  }

  /* (non-Javadoc)
   * @see zhstructures.ZHQueue#isEmpty()
   */
  public boolean isEmpty() {
    return elements.isEmpty();
  }

  /* (non-Javadoc)
   * @see zhstructures.ZHQueue#iterator()
   */
  public Iterator<ElementType> iterator() {
    return elements.iterator();
  }

}
