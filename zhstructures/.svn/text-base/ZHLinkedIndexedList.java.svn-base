/*
 * File: ZHLinkedIndexedList.java
 */

package zhstructures;

import java.util.Iterator;

/**
 * Class implementing the ZHIndexedList interface using an internal linked
 * structure.
 * 
 * @author J. Andrew Holey and Lee B.
 * @version February 26, 2009
 */
public class ZHLinkedIndexedList<ElementType> implements
  ZHIndexedList<ElementType> {

  protected ListStructure head;
  protected int size = 0;

  /**
   * Creates a new empty list.
   */
  public ZHLinkedIndexedList() {
    head = new ListStructure();
  }

  /* (non-Javadoc)
   * @see zhstructures.ZHIndexedList#addElementAt(int, java.lang.Object)
   */
  @Override
  public void addElementAt(int index, ElementType element) {
    size++;
    head.addAt(index, element);

  }

  /* (non-Javadoc)
   * @see zhstructures.ZHIndexedList#contains(java.lang.Object)
   */
  @Override
  public boolean contains(ElementType element) {
    return head.contains(element);

  }

  /* (non-Javadoc)
   * @see zhstructures.ZHIndexedList#get(int)
   */
  @Override
  public ElementType get(int index) {
    return head.get(index);

  }

  /* (non-Javadoc)
   * @see zhstructures.ZHIndexedList#isEmpty()
   */
  @Override
  public boolean isEmpty() {
    return head.isEmpty();

  }

  /* (non-Javadoc)
   * @see zhstructures.ZHIndexedList#iterator()
   */
  @Override
  public Iterator<ElementType> iterator() {
    return head.iterator();

  }

  /* (non-Javadoc)
   * @see zhstructures.ZHIndexedList#removeElementAt(int)
   */
  @Override
  public ElementType removeElementAt(int index) {
    size--;
    return head.removeAt(index);
  }

  /* (non-Javadoc)
   * @see zhstructures.ZHIndexedList#search(java.lang.Object)
   */
  @Override
  public int search(ElementType element) {
    return head.search(element);
    
  }

  /* (non-Javadoc)
   * @see zhstructures.ZHIndexedList#set(int, java.lang.Object)
   */
  @Override
  public ElementType set(int index, ElementType newValue) {
    return head.set(index,newValue);

  }

  /* (non-Javadoc)
   * @see zhstructures.ZHIndexedList#size()
   */
  @Override
  public int size() {
    return this.size;

  }

  protected class ListStructure 
  extends ZHOneWayLinkedStructure<ElementType, ListStructure> {
    int ctr=0;
    // TODO Fill in the two constructors and recursive versions of the
    // get(), set(), addElementAt(), removeElementAt() and search()
    // methods.
    public ListStructure(){
      super();
    }
    public ListStructure(ElementType element, ListStructure next){
      super(element,next);
    }
    public Iterator<ElementType> iterator(){
      return super.iterator();
    }
    public boolean contains(ElementType element){
      return super.contains(element);
    }
    public boolean isEmpty(){
      return super.isEmpty();
    }
    public void addAt(int index, ElementType element){
      if (index==0){
        ListStructure component = new ListStructure(this.element,this.next);
        component.state=this.state;
        this.state=ZHComponentState.NOT_EMPTY;
        this.element=element;
        this.next=component;     
      }
      else{
        this.next.addAt(index-1,element);
      }
      

    }
    public ElementType removeAt(int index){
      if(index==0){
        ElementType old = this.element;
        this.element = this.next.element;
        this.next=this.next.next;
        return old;
      }
      else{
        return this.next.removeAt(index-1);
      }
      
    }
    public ElementType set(int index, ElementType element){
      if (index==0){
        ElementType old = this.element;
        this.element=element;
        return old;
      }
      else return head.next.set(index-1,element);
    }
    public ElementType get(int index){
      if (index==0){
        return this.element;
      }
      else{
        return this.next.get(index-1);
      }
    }
    public int search(ElementType element){
      int finalCtr;
      if(this.element.equals(element)){
        finalCtr=ctr;
        ctr=0;
        return finalCtr;
      }
      else{
        ctr++;
        return this.next.search(element);
      }
    }
         
  }
  
}

