/**
 * Character.java
 */

import zhstructures.*;
/**
 * A class that creates the character
 */
public abstract class Character implements Seeable {
  /**
   * A ZHMap that holds all the items and acts as an inventory
   */
  protected ZHTreeMap<String, Possession> inventory = new ZHTreeMap<String,Possession>();
  /**
   * The amount of money the character has
   */
  private int money;
  /**
   * The name of the Character
   */
  private String name;
  /**
   * The amount of exp the character has
   */
  private int exp;
  /**
   * The level of the character
   */
  private int level;
  /**
   * The strength of the Character
   */
  private int strength;
  /**
   * The defense of the Character
   */
  private int defense;
  /**
   * The maximum health of the character
   */
  private int maxHealth;
  /**
   * The health of the chacter currently
   */
  private int health;
  /**
   * The room the character is in at the moment
   */
  private Place room;
 /**
  * The weapons that the character has equipped
  */
  private Weapons equipped;
  /**
   * Makes the character
   * @param String Name the name of the Character
   * @param int Level the level of the Character
   * @param int strength the strength of the Character
   * @param int defense the defense of the Character
   * @param Place room The current room of the character
   */
  public Character(String name, int level, int strength, int defense, Place room){
    this.name=name;
    this.level=level;
    this.strength=strength;
    this.defense=defense;
    exp=0;
    maxHealth = (level*10)+10;
    health=maxHealth;
    this.room=room;
    money=0;
  }
  /**
   * A method to move the Character
   * @param Connection c the place to move to
   */
  public abstract void move(Connection c);
  /**
   * Picks up the possesion near the character
   * @param Possesion p the possesion to pick up
   */
  public void pickUp(Possession p){
    inventory.put(p.getName(),p);
  }
  /**
   * Drops an item in the inventory
   * @param String s the name of the item to drop
   * @retrun Possesion the item that was dropped
   */
  public Possession dropItem(String s){
    if(inventory.get(s).equals(equipped)) equipped = null;
    return inventory.remove(s);
  }
  /**
   * Uses and item in the inventory
   * @param Possesion p the possesion to use
   * @param Character c the character that is using the item
   */
  public abstract void useItem(Possession p, Character c);
  /**
   * Gets the name of the Character
   * @return String name
   */
  public String getName(){
    return name;
  }
  /**
   * Gets the room that the character is in
   * @return Place 
   */
  public Place getRoom(){
    return room;
  }
  /**
   * Gets the current health of the character
   * @return int health
   */
  public int getHealth(){
    return health;
  }
  /**
   * Gets the defense of character
   * @return int defense
   */
  public int getDefense(){
    return defense;
  }
  /**
   * Gets the strength of the Character
   * @return int strength
   */
  public int getStrength(){
   return strength;
   }
  /**
   * Dispalays the description of the room
   */
  public void look(){
    room.display();
  }
  /**
   * Modifies the health of the character
   * @param int i
   */
  public void modifyHealth(int i){
    health+=i;
  }
  /**
   * Gets the maximum Health of the character
   * @return int maxHealth
   */
  public int getMaxHealth(){
    return maxHealth;
  }
  /**
   * Gets the amount of money the character has
   * @return int money
   */
  public int getCash(){
    return money;
  }
  /**
   * Sets the amount of cash the character has
   * @return int i
   */
  public void setCash(int i){
    money+=i;
  }
  /**
   * Sets the room of the character is in
   * @param Place p
   */
  public void setRoom(Place p){
    room.removeSeeable(this);
    this.room=p;
    p.addSeeable(this);
}
  /**
   * Equips the weapon
   * @param Weapons w
   */
 public void equip(Weapons w){
    equipped = w;
  }
 /**
  * Gets the the strength when the weapon is equipped
  * @return int strength
  */
 public int getEquippedStr(){
   if(equipped!=null){
   return equipped.getDamage();
    }
   else return 0;  
}
 /**
  * Gets the equipped weapon
  * @return Weapons equipped
  */
 public Weapons getEquippedWeapon(){
  return equipped;
  }
 /**
  * Increases the Level of the Character
  */
 public void increaseLevel(){
  level+=1;
  }
 /**
  * Updates the maxHealth of the Character
  */
 public void updateHealth(){
   maxHealth+=10;
   health=maxHealth;
 }
}
