/**
 * File:ZHArraySet<ElementType>.java
 */
package zhstructures;

import java.util.Iterator;
import java.io.*;

/**
 * Class for Array Sets
 * @author Lee B, Jake W, Jon P
 * @version February 2, 2009
 */

public class ZHArraySet<ElementType> implements ZHSet<ElementType>,Serializable{
  /**
   * Instance Variable to store elements.
   */
  
  ZHArrayStructure<ElementType> elements;
  /**
   * creates an array set
   */
  public ZHArraySet(){
   elements = new ZHArrayStructure();
  }
  public ZHArraySet(int c){
    elements = new ZHArrayStructure(c);
  }
  /**
   * Determines of a array set contains an element
   * @return boolean true if element is in array set false if it isn't
   * @param ElementType element The element being tested
   */
  public boolean contains(ElementType element) {
    return elements.contains(element);
  }
  /**
   * determines of array set is empty
   * @return boolean true of set is empty, false if not empty
   */
  public boolean isEmpty() {
    return elements.isEmpty();
  }
  /**
   * returns size of the array set
   * @return int size of array set
   */
  public int size() {
    return (elements.next - elements.first);
  }
  /**
   * returns iterator of the Array Structure
   * @return iterator
   */
  public Iterator<ElementType> iterator() {
    return elements.iterator();
  }
  /**
   * if the element specified is not in the set adds it to set
   * @return boolean true of added false if not added
   * @param ElementType element element to be added
   */
  public boolean add(ElementType element){
    if(!(elements.contains(element))){
      elements.addLast(element);
      return true;
    }
    else return false;
  }
  /**
   * removes specified element from the set if element is in the set
   * @return boolean false if element not in list, true if element is removed
   * @param ElementType element the element being removed
   */
  public boolean remove(ElementType element){
    if(!(elements.contains(element))) return false;
    else{
      elements.set(elements.find(element),elements.get(elements.size()-1));
      elements.set(elements.size()-1,null);
      return true;
    }
  }
  /**
   * Returns a set of elements contained by this set and the set specified
   * @return ZHSet<ElementType> set containing all intersecting elements
   * @param ZHSet<ElementType> set being compared to this set
   */
  public ZHSet<ElementType> intersection(ZHSet<ElementType> other){
    ZHArraySet<ElementType> result = new ZHArraySet<ElementType>();
    for(ElementType element: elements){
      if(other.contains(element)){
        result.add(element);
      }
    }
    return result;
  }
  /**
   * returns a set of all elements not in other set
   * @return ZHSet<ElementType> set containing elements not in other set
   * @param ZHSet<ElementType> other set
   */
  public ZHSet<ElementType> difference(ZHSet<ElementType> other){
    ZHArraySet<ElementType> result = new ZHArraySet<ElementType>();
    for(ElementType element: elements){
      if(!(other.contains(element))){
        result.add(element);
      }
    }
    return result;
  }
  /**
   * returns a set of every element in each set
   * @return ZHSet<ElementType> set containing all elements
   * @param ZHSet<ElementType> other set
   */
  public ZHSet<ElementType> union(ZHSet<ElementType> other){
    ZHArraySet<ElementType> result = new ZHArraySet<ElementType>();
    for(ElementType element: elements){
      result.add(element);
    }
    for(ElementType element: other){
      result.add(element);
    }
    return result;
  }
  /**
   * determines if other set is a subset of this set
   * @return boolean true if it is a subset, false if it is not a subset
   * @param ZHSet<ElementType> other set
   */
  public boolean subset(ZHSet<ElementType> other){
    for(ElementType element: other){
      if(!(elements.contains(element))){
        return false;
      }
    }
    return true;
  }
   /**
   * equals(Object o) returns true if o is a ZHSet with the same
   * elements as this set. Otherwise it returns false.
   */
  @SuppressWarnings("unchecked")
  public boolean equals(Object o) {
    ZHSet<ElementType> otherSet;
    try {
      otherSet=(ZHSet<ElementType>) o;
      return(this.subset(otherSet) && otherSet.subset(this));
    }
    catch(ClassCastException e) {
      return(false);
    }
  }
}
    