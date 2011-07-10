/*
 * File: ZHTreeMap.java 
 */

package zhstructures;

import java.util.Iterator;

/**
 * Class implementing the ZHMap interface using an internal binary search tree.
 * 
 * @author J. Andrew Holey
 * @version November 3, 2008
 */
public class ZHTreeMap<KeyType extends Comparable<KeyType>, ValueType>
implements ZHMap<KeyType, ValueType> {
 
  /**
   * The number of entries in this map.
   */
  protected int size;

  /**
   * A binary search tree containing the entries of this map.
   */
  protected ZHLinkedBinarySearchTree<ZHComparableMapEntry<KeyType, ValueType>> tree;
 
  /**
   * Creates a new empty tree map.
   */
  public ZHTreeMap() {
    size = 0;
    tree = new ZHLinkedBinarySearchTree<ZHComparableMapEntry<KeyType, ValueType>>();
  }
 
  /* (non-Javadoc)
   * @see zhstructures.ZHMap#containsKey(java.lang.Object)
   */
  @Override
  public boolean containsKey(KeyType key) {
    return tree.contains(new ZHComparableMapEntry<KeyType, ValueType>(key, null));
      // an entry with a null value will match an entry with the same key
  }

  /* (non-Javadoc)
   * @see zhstructures.ZHMap#get(java.lang.Object)
   */
  @Override
  public ValueType get(KeyType key) {
    ZHComparableMapEntry<KeyType, ValueType> searchEntry =
                          new ZHComparableMapEntry<KeyType, ValueType>(key, null);
    ZHComparableMapEntry<KeyType, ValueType> gotEntry = tree.get(searchEntry);
    if (gotEntry == null) return null;
    return gotEntry.getValue();
  }

  /* (non-Javadoc)
   * @see zhstructures.ZHMap#isEmpty()
   */
  @Override
  public boolean isEmpty() {
    return tree.isEmpty();
  }

  /* (non-Javadoc)
   * @see zhstructures.ZHMap#keySet()
   */
  @Override
  public ZHArraySet<KeyType> keySet() {
    ZHArraySet<KeyType> result = new ZHArraySet<KeyType>();
    Iterator<ZHComparableMapEntry<KeyType, ValueType>> iter = tree.preorderIterator();
    while (iter.hasNext()) {
      result.add(iter.next().getKey());
    }
    return result;
  }

  /* (non-Javadoc)
   * @see zhstructures.ZHMap#put(java.lang.Object, java.lang.Object)
   */
  @Override
  public ValueType put(KeyType key, ValueType value) {
    ValueType result = this.remove(key);
    tree.add(new ZHComparableMapEntry<KeyType, ValueType>(key, value));
    if (result == null) size++;
    return result;
  }

  /* (non-Javadoc)
   * @see zhstructures.ZHMap#remove(java.lang.Object)
   */
  @Override
  public ValueType remove(KeyType key) {
    ValueType result = this.get(key);
    tree.remove(new ZHComparableMapEntry<KeyType, ValueType>(key, null));
    if (result != null) size--;
    return result;
  }

  /* (non-Javadoc)
   * @see zhstructures.ZHMap#size()
   */
  @Override
  public int size() {
    return size;
  }

}
