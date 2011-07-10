/**
 * Connection.java
 * The class that puts a connection betweens two places
 */
public class Connection{
  /**
   * The two places
   */
  private Place here,there;
  
  /**
   * Makes the connection
   * @param Place here
   * @param Place there
   */
  public Connection(Place here, Place there){
    this.here=here;
    this.there=there;
  }
  /**
   * Gets the name of the connection
   * @param Place p
   * @returns String the name
   */
  public String getName(Place p){
    if (p.getName().equals(here.getName())){
      return there.getName();
    }
    else return here.getName();
  }
  /**
   * Moves the Character to a certain Place
   * @param Character c the character to move
   * @return Place the place
   */
  public Place move(Character c){
    if (c.getRoom().equals(here)){
      return there;
    }
    else return here;
  }
  public static void main(String args[]){
    }
}
    
