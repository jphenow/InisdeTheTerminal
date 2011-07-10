/**
 * File: Axe.java
 * A class that makes an axe possesion
 */
public class Axe extends Possession implements Weapons{
  /**
   * The amount of damage the axe does
   */
  int damage = 3;
  /**
   * The price of the axe
   */
  int price;
  /**
   * The name of the Weapon
   */
  String name;
  /**
   * The class that makes the Axe
   */
  public Axe(){
    super("Axe", 5);
  }
  /**
   * A method that uses the weapon by equipping it to the character
   * @param Character c The character that is using the weapon
   */
  public void use(Character c){
    c.equip(this);
  }
  /**
   * A method that gets the DAmage of the Weapon
   * @return damage The amount of damage
   */
  public int getDamage(){
    return damage;
  }
  
}
