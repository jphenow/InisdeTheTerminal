/*
 * File: ZHBinaryTreeStructure.java
 */

package zhstructures;

import java.util.Iterator;

/**
 * Abstract class that provides a node structure for one-way linked
 * implementations of binary trees.<br>
 * 
 * Implementing classes will typically use this class in one of two ways. They
 * may extend this class, passing their own class name (with the generic
 * ElementType parameter) as the StructureType parameter. In this case,
 * implementing classes should only call constructors of this class from within
 * their own constructors. This method is most often used for a situation in
 * which the implementing class needs a single reference to a fixed starting
 * node. A typical declaration of this type might be:<br>
 * 
 *   public class Foo\<ElementType\>
 *   extends ZHBinaryTreeStructure\<ElementType, Foo\<ElementType\>\> ...<br>
 * 
 * The second way to use this class occurs when the implementing class needs
 * one or more variable references to nodes. In this case, the implementing
 * class declares a protected inner class that extends this class and one or
 * more instance variables of the inner class type. Such an inner class need
 * only implement constructors that match the constructors of this class.<br>
 * 
 * @param ElementType the type of data elements contained in this structure
 * @param StructureType a class extending this class that is to be used in a
 *        particular collection
 * 
 * @author J. Andrew Holey
 * @version August 10, 2008
 */
public abstract class ZHBinaryTreeStructure
<ElementType,
 StructureType extends ZHBinaryTreeStructure<ElementType, StructureType>>
implements ZHCollection<ElementType> {

	
  /**
   * The data element associated with this node, if it is not empty
   */
  protected ElementType element;
  /**
   * The node representing the left subtree of this node,
   * if it is not empty
   */
  protected StructureType leftChild;
  /**
   * The node representing the right subtree of this node,
   * if it is not empty
   */
  protected StructureType rightChild;
  /**
   * The state of this node: either ZHComponentState.EMPTY or ZHComponentState.NOT_EMPTY
   */
  protected ZHComponentState state;
	
  /**
   * Creates a new empty node.
   * 
   * Instance variables--element, leftChild and rightChild--are not used in
   * empty nodes and so are left uninitialized.
   */
  public ZHBinaryTreeStructure() {
    this.state = ZHComponentState.EMPTY;
  }
	
  /**
   * Creates a new non-empty node with the specified element, left child and
   * right child.
   * 
   * @param element the data element associated with this node
   * @param leftChild the node representing the left subtree in this structure,
   * 			should generally be an actual node rather than null
   * @param rightChild the node representing the right subtree in this structure,
   * 			should generally be an actual node rather than null
   */
  public ZHBinaryTreeStructure(ElementType element,
                               StructureType leftChild,
                               StructureType rightChild) {
    this.element    = element;
    this.leftChild  = leftChild;
    this.rightChild = rightChild;
    this.state      = ZHComponentState.NOT_EMPTY;
  }

  /* (non-Javadoc)
   * @see zhstructures.ZHCollection#contains(java.lang.Object)
   */
  @Override
  public boolean contains(ElementType element) {
    switch (this.state) {
      case EMPTY:
        return false;
      case NOT_EMPTY:
        return (this.element.equals(element) ||
                this.leftChild.contains(element) ||
                this.rightChild.contains(element));
      default:
        throw new IllegalStateException();
    }
  }

  /* (non-Javadoc)
   * @see zhstructures.ZHCollection#isEmpty()
   */
  @Override
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
  @Override
  public abstract Iterator<ElementType> iterator();

  public Iterator<ElementType> inorderIterator() {
    ZHQueue<ElementType> queue = new ZHLinkedQueue<ElementType>();
    this.traverseInorder(queue);
    return new ZHIterator<ElementType>(queue.iterator());
  }

  public Iterator<ElementType> postorderIterator() {
    ZHQueue<ElementType> queue = new ZHLinkedQueue<ElementType>();
    this.traversePostorder(queue);
    return new ZHIterator<ElementType>(queue.iterator());
  }

  public Iterator<ElementType> preorderIterator() {
    ZHQueue<ElementType> queue = new ZHLinkedQueue<ElementType>();
    this.traversePreorder(queue);
    return new ZHIterator<ElementType>(queue.iterator());
  }

  private void traverseInorder(ZHQueue<ElementType> queue) {
    switch (this.state) {
      case EMPTY:
        // nothing to add
        break;
      case NOT_EMPTY:
        this.leftChild.traverseInorder(queue);
        queue.enqueue(this.element);
        this.rightChild.traverseInorder(queue);
        break;
      default:
        // this code should never be reached;
        // throwing this exception indicates a programming error in this class
        // or in a subclass
        throw new IllegalStateException();	
    }
  }

  private void traversePostorder(ZHQueue<ElementType> queue) {
    switch (state) {
      case EMPTY:
        // nothing to add
        break;
      case NOT_EMPTY:
        this.leftChild.traversePostorder(queue);
        this.rightChild.traversePostorder(queue);
        queue.enqueue(this.element);
        break;
      default:
        // this code should never be reached;
        // throwing this exception indicates a programming error in this class
        // or in a subclass
        throw new IllegalStateException();	
    }
  }

  private void traversePreorder(ZHQueue<ElementType> queue) {
    switch (state) {
      case EMPTY:
        // nothing to add
        break;
      case NOT_EMPTY:
        queue.enqueue(this.element);
        this.leftChild.traversePreorder(queue);
        this.rightChild.traversePreorder(queue);
        break;
      default:
        // this code should never be reached;
        // throwing this exception indicates a programming error in this class
        // or in a subclass
        throw new IllegalStateException();	
    }
  }

}
