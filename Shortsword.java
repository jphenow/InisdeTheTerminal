/**
 * File: Shortsword.java
 * Class for the weapon Shortsword
 */
public class Shortsword extends Possession implements Weapons{
	
	/**
	 * int for damage that can be done by Shortsword
	 */
	int damage = 1;
	/**
	 * int for price value to be sold at
	 */
  	int price;
	/**
	 * String to hold the name of the possession
	 */
  	String name;
	/**
	 * boolean for storing whether or not the possession is being held at the time.
	 */
  	boolean isEquiped = false;
  	
	/**
	 * Shortsword contructor which calls to Possession class
	 */
  	public Shortsword(){
    		super("Shortsword", 2);
  	}	
  	
	/**
	 * use method which calls the equip method in Character class
	 * @param c character being applied to
	 */
  	public void use(Character c){
  		c.equip(this);  
  	}
  	
	/**
	 * return the damage that the Shortsword evokes
	 * @return int damage that Shortsword evokes on others
	 */
  	public int getDamage(){
    		return damage;
  	}
  	
	/**
	 * boolean for whether or not the item is equipped
	 *
	 * @return boolean for whether or not the item is equipped
	 */
  	public boolean isEquiped(){
    	return isEquiped;
  	}
 
}
