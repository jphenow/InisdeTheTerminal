/**
 * File: Items.java
 * A Major potion to heal the character
 */
public class MajorHealthPotion extends Possession implements Items{
  /**
   * Tells wheter the Potion has been used or not
   */
  boolean used = false;
  /**
   * Constructs the MajorHealthPotion
   */
  public MajorHealthPotion(){
    super("Major Health Potion", 3);
  }
  /**
   * Uses the item
   * @param Character c the character that is using the item
   */
  public void use(Character c){
    if(c.getHealth() >= c.getMaxHealth()-10){
      c.modifyHealth(c.getMaxHealth() - c.getHealth());
    }
    else{
      c.modifyHealth(10);
    }
  }
    
  /**
   * Tells whether the item has been used
   * @return boolean used
   */
  public boolean isUsed(){
    return used = true;
  }
}
