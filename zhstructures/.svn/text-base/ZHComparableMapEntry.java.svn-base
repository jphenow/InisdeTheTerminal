/*
 * File: ZHComparableMapEntry.java 
 */

package zhstructures;

/**
 * Class implementing a key/value pair for map entries with comparable keys.
 * 
 * @author J. Andrew Holey
 * @version October 31, 2008
 */
public class ZHComparableMapEntry<KeyType extends Comparable<KeyType>, ValueType>
extends ZHMapEntry<KeyType, ValueType>
implements Comparable<ZHComparableMapEntry<KeyType, ValueType>>{

 /**
  * Creates a new map entry with the specified key and value
  * 
  * @param key the key element in this pair
  * @param value the value element in this pair
  */
 public ZHComparableMapEntry(KeyType key, ValueType value) {
  super(key, value);
 }

 /* (non-Javadoc)
  * @see java.lang.Comparable#compareTo(java.lang.Object)
  */
 @Override
 public int compareTo(ZHComparableMapEntry<KeyType, ValueType> otherEntry) {
  return this.key.compareTo(otherEntry.key);
 }
 

 
}
