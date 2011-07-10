/**
 * Player.java
 */

import zhstructures.*;
import javax.swing.*;

/**
 * Class for managing players
 */
public class Player extends Character{
  
 /**
  * stores the names and actual possession classes for items in the inventory
  */
  ZHTreeMap<String,Possession> inventory;
  
  /**
   * stores value for how much money is held by the current Player
   */
  private int money;
  
  /**
   * String value to hold the name of the Player
   */
  private String name;
  
  /**
   * int value for holding the total exp gained by player by killing monsters
   */
  private int exp;
  
  /**
   * int value used to hold total level gained during gameplay
   */
  private int level;
  
  /**
   * total strength that the player has attained
   */
  private int strength;
  
  /**
   * total defense that the Player has
   */
  private int defense;
  
  /**
   * int for the health value
   */
  private int health;
  
  /**
   * Place value for the location of the player at a given time
   */
  private Place room;
  
  
  /**
   * Contructor class for creating a player with given attributes
   *
   * @param name String for the name of player
   * @param level  initial level of the new player
   * @param strength initial strength level of the player
   * @param defense initial level for defense
   * @param room initial location for the player
   */
  public Player(String name, int level, int strength, int defense, Place room){
    super(name,level,strength,defense,room);
    inventory=super.inventory;
  }

  /**
   * method for moving player about the Connections and into new rooms
   * @param c connection the player is using to move rooms
   */
  public void move(Connection c){
    setRoom(c.move(this));
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
  public void useItem(Possession p, Player c){
   p.use(c);
  }
  public void useItem(Possession p){
   p.use(this);
  }
  
  /**
   * returns list of inventory
   *
   * @return inventory name list
   */
  public ZHTreeMap<String,Possession> getInventory(){
    return inventory;
  }
  
  /**
   * attacks the given character with the current equipped item
   *
   * @param c character being attacked
   * @return int for the damage being given in the attack
   */
  public int attack(Character c){
    int weapDmg=getEquippedStr();
     return -1*(weapDmg+getStrength()-c.getDefense());
     }

  /**
   * "interacts" with another character and allows a "conversation" or bartering
   *
   * @param c character being interacted with
   */
  public void interact(Character c){
    if(c instanceof NPC){
      NPC n = (NPC) c;
      n.startMenu(this);
    }
    else if(c instanceof Enemy){
      System.out.println("You are under attack!");
      Enemy e = (Enemy) c;
      battle(e, false);
    }
  }

  /**
   * This sets off the ability to attack, defend, or use an item against an enemy
   *
   * @param e enemy being battled with
   * @param surprise whether or not the enemy is "surprising" the user
   */
  public void battle(Enemy e, boolean surprise){
    int ctr =0;
    boolean fighting=true;
    int enemyDmg = e.attack(this);
    if(enemyDmg>0) enemyDmg=0;
    int dmg = attack(e);
    if(dmg>0) dmg=0;
    displayHP(e);
    while (e.getHealth()>0 && this.getHealth()>0 && fighting){
     if(!surprise || ctr==2){
       modifyHealth(enemyDmg);
     System.out.println();
     System.out.println("Enemy Attacked You");
     System.out.println();
       displayHP(e);
     if(getHealth()<=0){
      break;
      }
       surprise=true;
       ctr=0;
     }

     System.out.println();
     System.out.println("\tA Attack");
     System.out.println("\tI use Item");
     System.out.println("\tR Run");
     System.out.println();
     String s=JOptionPane.showInputDialog("What would you like to do?");
     char cmd = s.charAt(0);
     switch(cmd){
       case 'a':case 'A':
         e.modifyHealth(dmg);
         displayHP(e);
     if(e.getHealth()<=0){
       increaseLevel();
       updateHealth();
       System.out.println("Your Level Increased!");
       e.getRoom().removeSeeable(e);
       break;
      }
         break;
       case 'i':case 'I':
         battleItem(e);
         displayHP(e);
         break;
       case 'r':case 'R':
         System.out.println("You ran away");
         move(getRoom().getConnection(0));
         fighting=false;
         e.resetStats();
         break;
     }
     ctr++;
    
        
    }
   }

  /**
   * displays the health points that the player has
   *
   * @param c character being analyzed
   */
  public void displayHP(Character c){
     System.out.println("Your HP= "+this.getHealth()+" of "+getMaxHealth());
     System.out.println("Enemy HP= "+c.getHealth()+" of "+c.getMaxHealth());
    }

  /**
   * Item being used in battle
   *
   * @param e character item is being used on
   */
  public void battleItem(Character e){
    if(inventory.isEmpty()) System.out.println("Inventory is Empty");
else{
    String s = JOptionPane.showInputDialog("Who would you like use the item on?");
    char c = s.charAt(0);
    System.out.println();
    System.out.println("\tE Enemy");
    System.out.println("\tP Player");
    System.out.println();
   if(c=='e' || c== 'E') useItem(selectItem(),e);
   else useItem(selectItem(),this);
  }
}

  /**
   * displays inventory for the Player
   */
  public void displayInventory(){
    String x = "N/A";
    if(getEquippedWeapon()!=null) x = getEquippedWeapon().getName();
    System.out.println();
    System.out.println("HP: "+getHealth()+"/"+getMaxHealth()+"\t \t Money: "+getCash()+"\t \t Equipped Weapon: "+x);
    System.out.println();
    if(inventory.isEmpty()) System.out.println("Empty");
    else{
      ZHArraySet<String> names = inventory.keySet();
      for(String s:names){
        System.out.println(s);
       }
      }
     }

  /**
   * selects an item
   *
   * @return Possession that is selected
   */
  public Possession selectItem(){
   displayInventory();
   char c='f';
   do{
   String s = JOptionPane.showInputDialog("Which Item do you want to use? (enter q to quit)");
   c = s.charAt(0);
   if(inventory.containsKey(s)){
     return inventory.get(s);
    }
   else if(c!='q' &&c!='Q') System.out.println("Item Not Found");
   }
   while(c!='q' && c!='Q');
   return null;     
}
  
}
