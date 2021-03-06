/**
 * File: Items.java
 * A poison to hurt your enemies!!!
 */
public class EpicPoison extends Possession implements Items{
  /**
   * Tells wheter the Poison has been used or not
   */
  boolean used = false;
  /**
   * Constructs the Poison
   */
  public EpicPoison(){
    super("Poison", 5);
  }
  /**
   * Uses the item
   * @param Character c the character that is using the item
   */
  public void use(Character c){
      c.modifyHealth(-50);
  }
    
  /**
   * Tells whether the item has been used
   * @return boolean used
   */
  public boolean isUsed(){
   return used = true;
  }
}
