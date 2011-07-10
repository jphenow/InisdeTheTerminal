/**
 * Inside the Terminal
 * 
 */

import zhstructures.*;
import javax.swing.*;

/**
 * Class to actually display and use the game
 */
public class InsideTheTerminal{
  
	/**
	 * Player variable to hold player
	 */
  Player player;
  /**
   * various variables for places
   */
  Place start,bossRoom,hallway,library,tower,libraryBasement,prison,courtyard;
  /**
   * NPC variables
   */
  NPC merchant, salesman;
  /**
   * Variables
   */
  Enemy boss,wolf,zombie,ogre,theLibrarian,bird,undeadPrisoner;

  /**
   * Possession variables
   */
  Possession axe,firesword,butchersKnife,longsword,shortsword,majorHealth, minorHealth, epicHealth, minorPoison, epicPoison, claw, beak, hand, pencil, pwnBossThing;
  /**
   * connection variables
   */
  Connection sH,sL,hL,lB,hT,lc,bC,lP, pF;
  
  /**
   * sets up the game, connections and rooms for the games
   */
  public InsideTheTerminal(){
    start = new Place("start");
    hallway = new Place("hallway");
    library = new Place("library");
    libraryBasement = new Place("library basement");
    prison = new Place("prison");
    courtyard = new Place("courtyard");
    tower = new Place("tower");
    bossRoom = new Place("boss room");
    axe = new Axe();
    claw = new Shortsword();
    pencil = new Longsword();
    beak = new Shortsword();
    hand = new Longsword();
    pwnBossThing = new ButchersKnife();
    butchersKnife = new ButchersKnife();
    longsword = new Longsword();
    shortsword = new Shortsword();
    firesword = new Firesword();
    minorHealth = new MinorHealthPotion();
    majorHealth = new MajorHealthPotion();
    epicPoison = new EpicPoison();
    sH=new Connection(start,hallway);
    sL=new Connection(start,library);
    hL=new Connection(hallway,library);
    lB=new Connection(library,libraryBasement);
    lc=new Connection(library, courtyard);
    lP=new Connection(libraryBasement, prison);
    bC= new Connection(libraryBasement, courtyard);
    pF= new Connection(prison,bossRoom);
    hT=new Connection(hallway,tower);
    start.addConnection(sH,0);
    start.addConnection(sL,1);
    hallway.addConnection(sH,0);
    library.addConnection(sL,0);
    library.addConnection(hL,0);
    hallway.addConnection(hL,0);
    hallway.addConnection(hT,1);
    library.addConnection(lB,1);
    libraryBasement.addConnection(lB,0);
    libraryBasement.addConnection(lP,1);
    library.addConnection(lc,2);
    libraryBasement.addConnection(lc,2);
    courtyard.addConnection(lc,0);
    courtyard.addConnection(bC,1);
    prison.addConnection(lP,0);
    prison.addConnection(pF,1);
    tower.addConnection(hT,0);
                        
    String s = JOptionPane.showInputDialog("What is your character's name? ");
    player = new Player(s,0,1,1,start);
    boss= new Enemy("Final Boss", 4,3,3,bossRoom);
    wolf = new Enemy("Wolf",0,1,1,library);
    theLibrarian = new Enemy("The Librarian",2,1,1,libraryBasement);
    undeadPrisoner = new Enemy("Undead Prisoner",3,2,2,prison);
    bird = new Enemy("Bird",1,1,1, courtyard);
    merchant=new NPC("Merchant",0,0,0,library);
    library.addSeeable(merchant);
    library.addSeeable(wolf);
    libraryBasement.addSeeable(merchant);
    libraryBasement.addSeeable(theLibrarian);
    libraryBasement.addSeeable(axe);
    prison.addSeeable(undeadPrisoner);
    prison.addSeeable(epicPoison);
    courtyard.addSeeable(majorHealth);
    courtyard.addSeeable(bird);
    merchant.pickUp(axe);
    merchant.pickUp(butchersKnife);
    merchant.pickUp(shortsword);
    wolf.pickUp(claw);
    wolf.useItem(claw);
    undeadPrisoner.pickUp(hand);
    undeadPrisoner.useItem(hand);
    theLibrarian.pickUp(pencil);
    theLibrarian.useItem(pencil);
    boss.pickUp(pwnBossThing);
    boss.useItem(pwnBossThing);
    bird.pickUp(beak);
    bird.useItem(beak);
    player.pickUp(longsword);
    player.useItem(longsword);
    player.pickUp(minorHealth);
    start.addSeeable(player);
    bossRoom.addSeeable(boss);
    bossRoom.addSeeable(firesword);
  }

  /**
   * after setting up the game this method actually allows the running, so the player may play the game
   */
  public void run(){
    System.out.println("Welcome "+player.getName());
    while(boss.getHealth()>0 && player.getHealth()>0){
 
 displayMenu();
 String s = JOptionPane.showInputDialog("Enter Command: ");
 char cmd = s.charAt(0);
 doCommand(cmd);
     }
    if(boss.getHealth()<=0) System.out.println("Congradulations! You Win!");
    else System.out.println("GAME OVER");
  }

  /**
   * checks what command is typed so the user may do various actions
   */
  public void doCommand(char cmd){
    switch(cmd){
      case 'l':case 'L':
        player.look();
        break;
      case'm':case 'M':
        move(player.getRoom());
        break;
      case 'i':case 'I':
        if(player.getInventory().isEmpty()) System.out.println("You have no items to use");
        else{ 
           Possession p = player.selectItem();
           if (p!=null)   player.useItem(p,player);
          }
        break;
      case 'd':case 'D':
        drop(player.getRoom());
        break;
      case 'P':case 'p':
        pickUp(player.getRoom());
        break;
      case 'a':case 'A':
        battle(player.getRoom());
        break;
      case 's':case 'S':
        speak(player.getRoom());
        break;
      case 'g':case 'G':
        player.displayInventory();
        break;
    }
  }

  /**
   * displays menu so user knows what commands are available
   */
  public void displayMenu(){
     System.out.println("You are at the "+player.getRoom().getName());
     System.out.println("What would you like to do?");
 System.out.println();
 System.out.println("\tL Look");
 System.out.println("\tM Move");
 System.out.println("\tI use Item");
 System.out.println("\tD Drop item");
 System.out.println("\tP Pick up item");
 System.out.println("\tA Attack");
 System.out.println("\tS Speak to character");
        System.out.println("\tG Get Inventory");
    }

  /**
   * allows players to use connections and connect to various connected rooms
   * @param r place the user is attempting to move
   *
   */
  public void move(Place r){
 String s = JOptionPane.showInputDialog("Enter the Number of the room you want to move to: ");
        try{
        int i = Integer.parseInt(s);
        player.move(r.getConnection(i));
        }
        catch(NumberFormatException nfe){
          System.out.println("Please Type the number of the corresponding room");
       }
    }

  /**
   * allows users to interact with various NPCs who do not attack
   * @param r place in which the person they are speaking to is
   */
  public void speak(Place r){
    String s = JOptionPane.showInputDialog("Who would you like to speak to?");
    if(!(s.equals("q")) && !(s.equals("Q"))){
      if(r.getContents().containsKey(s)){
       try{ 
        Character c = (Character) r.getContents().get(s);
        player.interact(c);
        }
       catch(ClassCastException cce){
         System.out.println("That is not a character");
         }
       }
      else System.out.println("That Character is not in the area");
  }
}

/**
 * allows an actual battle to take place 
 *
 * @param r Place in which the battle takes place 
 */
  public void battle(Place r){
   String s = JOptionPane.showInputDialog("Who would you like to attack?");
   if(!(s.equals("q")) && !(s.equals("Q"))){
      if(r.getContents().containsKey(s)){
       try{ 
        Enemy e = (Enemy) r.getContents().get(s);
        player.battle(e, true);
        }
       catch(ClassCastException cce){
         System.out.println("That is not an Enemy");
         }
       }
      else System.out.println("That Character is not in the area");
  }
}

/**
 * allows user to pick up various items
 * @param r Place where the item is held
 */
  public void pickUp(Place r){
    String s = JOptionPane.showInputDialog("What Would you like to pick up?");
    if(!(r.getContents().containsKey(s))) System.out.println("No such item in this room");
    else if(r.getContents().get(s) instanceof Possession){
        Possession p = (Possession) r.getContents().get(s);
        player.pickUp(p);
        r.removeSeeable(r.getContents().get(s));
      }
     else System.out.println("That is not a possession");
   }

/**
 * drop an item somewhere
 * @param r Place in which thing is being dropped
 */
  public void drop(Place r){
    String s = JOptionPane.showInputDialog("What would you like to drop?");
    r.addSeeable(player.dropItem(s));
    
   }

/**
 * Main method to run the game
 */
    public static void main(String  args[] ){
      InsideTheTerminal game = new InsideTheTerminal();
      game.run();
} 
    
}
