/*
 * File: ZHMap.java
 */
package zhstructures;

/**
 * Interface for maps that store key/value pairs.
 * 
 * @author J. Andrew Holey
 * @version October 31, 2008
 */
public interface ZHMap<KeyType, ValueType> {
	
  /**
   * Returns true if this map contains no key/value pairs.
   * 
   * @return true if this map contains no key/value pairs
   */
  public boolean isEmpty();

  /**
   * Returns the number of key/value pairs in this map.
   * 
   * @return the number of key/value pairs in this map
   */
  public int size();

  /**
   * Returns true if this map contains a pair with the specified key.
   * 
   * @param key the key to test for presence in this map
   * @return true if this map contains a pair with the specified key
   */
  public boolean containsKey(KeyType key);

  /**
   * Returns the value to which the specified key is mapped,
   * or null if this map contains no mapping for the key.
   * 
   * @param key the key for which to return the associated value
   * @return the value to which the specified key is mapped
   */
  public ValueType get(KeyType key);

  /**
   * Associates the specified value with the specified key in this map.
   * If the map previously contained a mapping for the key, the old value
   * is replaced by the specified value and returned;
   * otherwise, a new entry is added and null returned.
   * 
   * @param key the key with which the specified value is to be associated
   * @param value the value to be associated with the specified key
   * @return the previous value associated with key,
   *         or null if there was no previous mapping for key
   */
  public ValueType put(KeyType key, ValueType value);

  /**
   * Removes the mapping for the specified key from this map and returns
   * the old value of the mapping if such a mapping is present.
   * 
   * @param key the key for which to remove the mapping
   * @return the previous value associated key key,
   * 		   or null if there was no mapping for key
   */
  public ValueType remove(KeyType key);

  /**
   * Returns a set containing the keys with mappings in this map. Unlike the Java
   * Map specification, the set returned by this method is not necessarily backed
   * by the map. That is, this method may be implemented to return a set that is
   * independent of the map; changes to the map during the lifetime of the set do
   * not necessarily result in changes to the set and vice versa.
   * 
   * @return a set containing the keys with mappings in this map
   */
  public ZHSet<KeyType> keySet();

}
