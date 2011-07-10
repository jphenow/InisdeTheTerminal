/**
 * Place.java Testing svn
 */
import zhstructures.*;

/**
 * Place class for managing various places
 */
public class Place{
  
	/**
	 * String for storing names of places
	 */
  private String name;
  
  /**
   * Tree map is returned when looking at contents of a place
   *
   * @return ZHTreeMap<String, Seeable> of the contents stored in place
   */
  private ZHTreeMap<String, Seeable> contents;
  
  /**
   * ZHLinkedIndexList<Connection> for a list of connections to the Place
   * @return ZHLinkedIndexedList<Connection> for a list of the connections
   */
  private ZHLinkedIndexedList<Connection> connections;
  
  /**
   * constructor for the place
   * @param name name of the place
   */
  public Place(String name){
    this.name=name;
    contents= new ZHTreeMap<String,Seeable>();
    connections= new ZHLinkedIndexedList<Connection>();
  }
  
  /**
   * Displays the contents of the place
   */
  public void display(){
int i =0;
    ZHArraySet<String> names = contents.keySet();
    for(String s: names){
      System.out.println(s);
    }
    System.out.println();
    for(Connection c:connections){
      System.out.println(i+"\t"+c.getName(this));
	i++;	
    }
  }

  /**
   * returns the name of the place
   * @return String for the name of place
   */
  public String getName(){
    return name;
  }

  /**
   * Adds a seeable item to the place
   *
   * @param s Seeable item being added
   */
  public void addSeeable(Seeable s){
    contents.put(s.getName(),s);
  }

  /**
   * removes a seeable item from the contents of the place 
   *
   * @param s Seeable item
   */
  public void removeSeeable(Seeable s){
     contents.remove(s.getName());
  }

  /**
   * removes possession from the place 
   *
   * @param p possession being removed
   */
  public void removePossession(Possession p){
    contents.remove(p.getName());
  }

  /**
   * adds connection to the place
   *
   * @param c Connection being given to the place
   * @param i int that the user can use to gain access to the connection
   */
  public void addConnection(Connection c,int i){
    connections.addElementAt(i,c);
  }

  /**
   * Connection is being got at the number i
   * @return Connection being got at i
   * @param i number Connection may be found at
   */
  public Connection getConnection(int i){
    return connections.get(i);
  }

  /**
   * Tree map is returned that displays the contents of the place
   *
   * @return ZHTreeMap<String, Seeable> that contains the contents
   */
  public ZHTreeMap<String, Seeable> getContents(){
    return contents;
  }
}
  
  
