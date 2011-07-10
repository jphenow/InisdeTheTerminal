import zhstructures.*;

public class Enemy extends Character{
  /**
   * The inventory of the enemy
   */
  ZHTreeMap<String,Possession> inventory;
  
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
   * Makes the enemy 
   * @param name
   * @param int level
   * @param int strength
   * @param int defense
   * @param Place room
   */
  public Enemy(String name, int level, int strength, int defense, Place room){
    super(name,level,strength,defense,room);
    inventory=super.inventory;
  }
  /**
   * "uses" item to certain character
   *
   * @param p possession being used
   * @param c character it is being applied to
   */
  public void useItem(Possession p, Character c){
  p.use(c);
  }

  /**
   * "uses" item on a certain player
   *
   * @param p possession being used
   * @param c player it is being applied to
   */
  public void useItem(Possession p){
   p.use(this);
  }
  /**
   * Moves the charcter to a different room
   * @param Connection c
   */
  public void move(Connection c){
    this.room=c.move(this);
  }
/**
 * Attacks with the weapon against the player
 * @param Player p
 * @param int 
 */
  public int attack(Player p){
     int weapDmg=getEquippedStr();
     return -1*(weapDmg+getStrength()-p.getDefense());
  }
  /**
   * Resets the stats of the enemy
   */
 public void resetStats(){
  int i = getMaxHealth()-getHealth();
  modifyHealth(i);
 }
}
