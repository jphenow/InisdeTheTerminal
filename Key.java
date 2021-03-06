/**
 * File: Items.java
 * A Key Class
 */
public class Key extends Possession implements Items{
  /**
   * Tells whether the key has been used
   */
  boolean used = false;
  /**
   * Constructs the Key
   */
  public Key(String name, int price){
    super(name, price);
  }
  /**
   * Uses the item
   * @param Character c the character that is using the item
   */
  public void use(Character c){}
    
  /**
   * Tells whether the item has been used
   * @return boolean used
   */
  public boolean isUsed(){
    return used = true;
  }
}
