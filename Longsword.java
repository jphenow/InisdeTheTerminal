/**
 * File: Longsword.java
 * Creates the Longsword class
 */
public class Longsword extends Possession implements Weapons{
  /**
   * The damage of the sword
   */
  int damage = 2;
  /**
   * The price of the sword
   */
  int price;
  /**
   * The name of the sword
   */
  String name;
  /**
   * Creates the longsword class
   */
  public Longsword(){
    super("Longsword", 4);
  }
  /**
   * uses the Longsword
   * @param Character c
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
