/**
 * File: ButchersKnife.java
 * A class that makes the butchersknife weapon
 */
public class ButchersKnife extends Possession implements Weapons{
  /**
   * That amount of damage the Butchers Knife can do
   */
  int damage = 5;
  /**
   * The price of the Butchers Knife
   */
  int price;
  /**
   * The name of the Weapon
   */
  String name;
  /**
   * The method that creates the butchers knife.
   */
  public ButchersKnife(){
    super("ButchersKnife", 7);
  }
  /**
   * A method for the character to use the weapon
   * @param Character c the character that uses the weapon.
   */
  public void use(Character c){
    c.equip(this);
  }
  /**
   * Gets the amount of damage the weapon does
   */
  public int getDamage(){
    return damage;
  }
  
  
}
