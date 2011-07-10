/**
 * File: Possession.java
 * Class for managing items that a character can own
 */

public abstract class Possession implements Seeable{
 
	/**
	 * String for the name of the possession
	 */
	 
 	String name;

	/**
	 * int for price value of the possession
	 */
  	int price;
  /**
   * contructor for creating the possession
   * @param name String for the name
   * @param price int to store the price value of a Possession
   */
  public Possession(String name, int price){
   this.name=name;
   this.price=price;
  }
  
  /**
   * method for getting the name of a possession
   * @return String of the name of the possession
   */
  public String getName(){
    return name;
  }
  
  /**
   * abstract class to be sure that use method is defined
   * @param c character use is being applied to
   */
  public abstract void use(Character c);
  
  /**
   * returns int for price value
   *
   * @return int price
   */
  public int getPrice(){
   return price; 
  }
  
}
