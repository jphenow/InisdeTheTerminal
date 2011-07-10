/*
 * File: ZHLinkedHealTailList.java
 */

package zhstructures;

/**
 * Class implementing the ZHHeadTailList interface as a ZHOneWayLinkedStructure.
 *
 * @author J. Andrew Holey and Lee Buermann
 * @version February 24,2009
 */
public class ZHLinkedHeadTailList<ElementType>
       extends ZHOneWayLinkedStructure<ElementType, ZHLinkedHeadTailList<ElementType>>
       implements ZHHeadTailList<ElementType> {

 /**
  * Creates a new empty list.
  */
  public ZHLinkedHeadTailList(){
    super();
  }

 /**
  * Creates a new list with the specified head element and tail.
  * 
  * @param headElement the element to be at the head of the new list
  * @param tail the list to be the tail of the new list
  */
  public ZHLinkedHeadTailList(ElementType head,ZHLinkedHeadTailList tail){
    super(head,tail);
    
  }

 /* (non-Javadoc)
  * @see zhstructures.ZHHeadTailList#head()
  */
 @Override
 public ElementType head(){
   return this.element;
 }

 /* (non-Javadoc)
  * @see zhstructures.ZHHeadTailList#tail()
  */
 @Override
 public ZHHeadTailList<ElementType> tail(){
   return this.next;
 }

}
