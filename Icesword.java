/**
 * File: Icesword.java
 * A class that creates the Icesword
 */
public class Icesword extends Possession implements Weapons{
  /**
   * The damage of the sword
   */
  int damage = 10;
  /**
   * The price of the sword
   */
  int price;
  /**
   * The name of the sword
   */
  String name;
  /**
   * Creates the Icesword
   */
  public Icesword(){
    super("Icesword", 10);
  }
  /**
   * Uses the IceSword
   * @param Character c
   */
  public void use(Character c){
    c.equip(this);
  }
  /**
   * Gets the damage of the Sword
   * @return int damage
   */
  public int getDamage(){
    return damage;
  }
  
  
}
