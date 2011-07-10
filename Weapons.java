/**
 * File: Weapons.java
 * Interface used for weapons so we can display the damage for all weapons
 */
public interface Weapons extends Seeable{
  
 /**
  * Returns the damage count for a weapon
  * @return int for the damage count for a weapon
  */
   public int getDamage();
 
  
}
