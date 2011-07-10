/**
 * File: Items.java
 * A minor potion to heal the character
 */
public class MinorHealthPotion extends Possession implements Items{
  /**
   * Tells wheter the Potion has been used or not
   */
  boolean used = false;
  /**
   * Constructs the MinorHealthPotion
   */
  public MinorHealthPotion(){
    super("Minor Health Potion", 1);
  }
    
    /**
   * Uses the item
   * @param Character c the character that is using the item
   */
  public void use(Character c){
    if(c.getHealth() >= c.getMaxHealth()-5){
      c.modifyHealth(c.getMaxHealth() - c.getHealth());
    }
    else{
      c.modifyHealth(5);
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
