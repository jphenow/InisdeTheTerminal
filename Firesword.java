/**
 * File: Firesword.java
 * A class that makes the firesword
 */
public class Firesword extends Possession implements Weapons{
  /**
   * The damage of the firesword
   */
  int damage = 12;
  /**
   * The price of the sword
   */
  int price;
  /**
   * The name of the sword
   */
  String name;
  /**
   * Tells if the weapon is equipped or not
   */
  boolean isEquiped = false;
  /**
   * Creates the firesword
   */
  public Firesword(){
    super("Firesword", 12);
  }
  /**
   * Uses the Firesword
   * @param Character c the character that is using the weapon
   */
  public void use(Character c){
    c.equip(this);
  }
  /**
   * Gets the damage of the sword
   * @return int Damage
   */
  
  public int getDamage(){
    return damage;
  }
  
}
