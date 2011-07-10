/*
 * ZHLinkedBinarySearchTree.java
 */
package zhstructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class implementing the ZHBinarySearchTree interface as a ZHBinaryTreeStructure.
 * 
 * @author J. Andrew Holey and <your name here>
 * @version October 27, 2008
 */
public class ZHLinkedBinarySearchTree<ElementType extends Comparable<ElementType>>
extends ZHBinaryTreeStructure<ElementType, ZHLinkedBinarySearchTree<ElementType>>
implements ZHBinarySearchTree<ElementType> {

  /**
   * Creates a new empty tree.
   */
  public ZHLinkedBinarySearchTree() {
    super();
  }
  public ElementType get(ElementType element){
    if(this.contains(element)){
      for(ElementType e:this){
        if(e.equals(element)) return e;
      }
    }
    return element;
         
  }
  /* (non-Javadoc)
   * @see zhstructures.ZHBinarySearchTree#add(java.lang.Comparable)
   */
  @Override
  public boolean add(ElementType element) {
    if(this.isEmpty()){
      this.state = ZHComponentState.NOT_EMPTY;
      this.element=element;
      this.leftChild=new ZHLinkedBinarySearchTree<ElementType>();
      this.rightChild=new ZHLinkedBinarySearchTree<ElementType>();
      return true;
    }
    else {
      int comp = this.element.compareTo(element);
      if (comp==0) return false;
      if(comp<0)return this.rightChild.add(element);
      else return this.leftChild.add(element);
    }
  }
      
  

  /* (non-Javadoc)
   * @see zhstructures.ZHBinarySearchTree#contains(java.lang.Comparable)
   */
  @Override
  public boolean contains(ElementType element) {
    if(this.isEmpty()){
      return false;
    }
    else {
      int comp = this.element.compareTo(element);
      if(comp==0) return true;
      if(comp<0) return this.rightChild.contains(element);
      else return this.leftChild.contains(element);
    }
        
        
  }

  /* (non-Javadoc)
   * @see zhstructures.ZHBinarySearchTree#iterator()
   */
  @Override
  public Iterator<ElementType> iterator() {
    return this.inorderIterator();
  }

  /* (non-Javadoc)
   * @see zhstructures.ZHBinarySearchTree#remove(java.lang.Comparable)
   */
  @Override
  public boolean remove(ElementType element) {
    if(this.isEmpty()) return false;
    else{
      int comp = this.element.compareTo(element);
      if(comp==0){
        if(this.leftChild.isEmpty()){
          this.copyNodeToThis(this.rightChild);
        }
        else if(this.rightChild.isEmpty()){
          this.copyNodeToThis(this.leftChild);
        }
        else{
          this.element = this.rightChild.removeAndReturnLeftmost();
        }
        return true;
      }
      if(comp<0) return this.rightChild.remove(element);
      else return this.leftChild.remove(element);
    }
  }

  /**
   * Removes and returns the leftmost element in this structure.
   * 
   * @return the former leftmost element in this structure
   * @throws NoSuchElementException if this structure is empty
   */
  protected ElementType removeAndReturnLeftmost() {
    if (this.isEmpty()) throw new NoSuchElementException();
    else{
      if(this.leftChild.isEmpty()){
        ElementType e = this.element;
        this.copyNodeToThis(this.rightChild);
        return e;
      }      
    }
    return this.leftChild.removeAndReturnLeftmost();
  }

  protected void copyNodeToThis(ZHLinkedBinarySearchTree<ElementType> otherNode) {
    this.element    = otherNode.element;
    this.leftChild  = otherNode.leftChild;
    this.rightChild = otherNode.rightChild;
    this.state      = otherNode.state;
  }
  
}
