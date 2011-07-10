/**
 * File: Items.java
 * An Interface to control the items
 */
public interface Items{
  /**
   * Uses the item
   */
  public void use(Character c);
  /**
   * Tells whether the item has been used
   * @return boolean used
   */
  public boolean isUsed();

  
}
