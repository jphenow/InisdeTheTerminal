/**
 * File: Items.java
 * An epic potion to heal the character
 */
public class EpicHealthPotion extends Possession implements Items{
  /**
   * Tells wheter the Potion has been used or not
   */
  boolean used = false;
  /**
   * Constructs the EpicHealthPotion
   */
  public EpicHealthPotion(){
    super("Epic Health Potion", 30);
  }
    
    /**
   * Uses the item
   * @param Character c the character that is using the item
   */
  public void use(Character c){
    if(c.getHealth() >= c.getMaxHealth()-50){
      c.modifyHealth(c.getMaxHealth() - c.getHealth());
    }
    else{
      c.modifyHealth(50);
    }
  }
    
  /**
   * Tells whether the item has been used
   * @return boolean used
   */
  public boolean isUsed(){
    used = true;
    return used;
  }
}
