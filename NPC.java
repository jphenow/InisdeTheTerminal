/*
 * NPC.java TEST
 */
import javax.swing.*;
import zhstructures.*;

public class NPC extends Character{
  private ZHTreeMap<String, Possession> inventory;
  
  private int money;
  
  private String name;
  
  private int exp;
  
  private int level;
  
  private int strength;
  
  private int defense;
  
  private int health;
  
  private Place room;
  
  public NPC(String name, int level, int strength, int defense, Place room){
    super(name,level,strength,defense,room);
    inventory=super.inventory;
  }
  
  public void startMenu(Player c){
    char cmd;
    do{
      
    System.out.println("Hello, how can I help you?");
    System.out.println();
    System.out.println("\tB Buy items");
    System.out.println("\tS Sell items");
    System.out.println("\tL Leave");
    String s = JOptionPane.showInputDialog("Enter Command: ");
    cmd = s.charAt(0);
    doCommand(cmd,c);
    }
    while((cmd != 'l') && (cmd !='L'));
  }
  public void doCommand(char cmd, Player c){
    switch (cmd){
      case 'b': case 'B':
        buy(c);
        break;
      case 's': case 'S':
        sell(c);
        break;        
    }
  }
  public void buy(Player c){
     if(inventory.isEmpty()){
          System.out.println("Sorry I have nothing to sell");
       }
    else{
    
    String s;
    Possession i;
    do{
      ZHArraySet<String> names = inventory.keySet();
      
      for(String n:names){
        int p = inventory.get(n).getPrice();
        System.out.println(n+"\t"+p);
      }
      System.out.println();
      System.out.println("\tQ Quit");
      s=JOptionPane.showInputDialog("What would you like to buy? ");
      if(!(inventory.containsKey(s))) System.out.println("I Don't have that Item");
      else if(inventory.containsKey(s) && inventory.get(s).getPrice()<=c.getCash()){
        i= dropItem(s);
        c.pickUp(i);
        c.setCash(-i.getPrice());
        System.out.println();
        System.out.println("Thank you for shopping!");
      
        
      }
      else if (inventory.get(s).getPrice()>c.getCash()) System.out.println("You do not have enough money");
      

    }
    while(!(s.equals("q")) && !(s.equals("Q")));
  }
}
  
    
  public void sell(Player c){
     if(c.getInventory().isEmpty()){
         System.out.println("You have nothing to sell");
       }
     else{
    
    String s;
    Possession i;
    do{
      ZHArraySet<String> names = c.getInventory().keySet();
      for(String n:names){
        int p = c.getInventory().get(n).getPrice();
        System.out.println(n+"\t"+p);
      }
      System.out.println();
      System.out.println("\tQ Quit");
      s = JOptionPane.showInputDialog("What would you like to sell? ");
      if(c.getInventory().containsKey(s)){
        i=c.dropItem(s);
        this.pickUp(i);
        c.setCash(i.getPrice());
      }
    }
    while(!(s.equals("q")) && !(s.equals("Q")));
    }
  }
  public void useItem(Possession p, Character c){
    p.use(c);
  }
  
  public void move(Connection c){
    this.room=c.move(this);
  }
}
