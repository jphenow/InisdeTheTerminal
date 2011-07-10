/*
 * File: ZHMapEntry.java
 */

package zhstructures;

/**
 * Class implements key/value pairs for map entries.
 * 
 * @author J. Andrew Holey
 * @version October 31, 2008
 */
public class ZHMapEntry<KeyType, ValueType> {

  protected KeyType key;
  protected ValueType value;

  /**
   * Constructs a new pair from the specified elements.
   * 
   * @param key the first element
   * @param value the second element
   */
  public ZHMapEntry(KeyType key, ValueType value) {
    this.key = key;
    this.value = value;
  }

  /**
   * Returns the key in this pair.
   * 
   * @return the key in this pair
   */
  public KeyType getKey() {
    return this.key;
  }

  /**
   * Returns the value in this pair.
   * 
   * @return the value in this pair
   */
  public ValueType getValue() {
    return this.value;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @SuppressWarnings("unchecked")
  @Override
  public boolean equals(Object otherObject) {
    if (!(otherObject instanceof ZHMapEntry)) return false;
    ZHMapEntry otherEntry = (ZHMapEntry) otherObject;
    return this.key.equals(otherEntry.getKey());
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return this.key.hashCode();
  }
	
}
