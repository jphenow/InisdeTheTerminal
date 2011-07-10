/*
 * File: BagTester.java
 */

import zhstructures.*;
import java.util.*;
import javax.swing.*;

/**
 * This class implements a program that tests a class implementing the ZHBag interface
 * 
 * @author J. Andrew Holey
 * @version February 16, 2009
 */
public class BagTester{

  private ZHBag<Integer> bag;
  
  public BagTester(){
    System.out.println("Welcome to the Bag Tester");
    bag = new ZHArrayBag<Integer>();
  }
  
  public void runTester() {
    char cmd;
    do
    {
      menu ();
      cmd = acceptCommand ();
      doCommand (cmd);
    }
    while ((cmd != 'q') && (cmd != 'Q'));
  }
  
  private void menu() {
    System.out.println();
    System.out.println("\tE is the bag Empty?");
    System.out.println("\tC what is the Count of the specified element?");
    System.out.println("\tA Add an element");
    System.out.println("\tR Remove an element");
    System.out.println("\tL List the elements of the bag using its iterator");
    System.out.println("\tQ Quit the program");
    System.out.println();
  }
  
  private char acceptCommand() {
    char cmd;
    String s = JOptionPane.showInputDialog("Enter command: ");;
    cmd = s.charAt(0);
    return cmd;
  }
  
  private void doCommand(char cmd) {
    switch (cmd)
    {
      case 'e': case 'E':
        empty();
        break;
      case 'c': case 'C':
        count();
        break;
      case 'l': case 'L':
        list();
        break;
      case 'a': case 'A':
        add();
        break;
      case 'r': case 'R':
        remove();
        break;
      case 'q': case 'Q':
        quit ();
        break;
      default:
        System.out.println("Invalid command--try again");
    }
  }
  
  /** empty
    * 
    * Report whether the bag is empty or not using the isEmpty() method
    */
  private void empty() {
    if (bag.isEmpty()) {
      System.out.println("The bag is empty.");
    }
    else {
      System.out.println("The bag is not empty.");
    }
  }
  
  /** count
    * 
    * Report the count a given element in the bag
    */
  private void count() {
    Integer element;
    try {
      String s = JOptionPane.showInputDialog("Enter an integer to test for bag count: ");;
      element = new Integer(s);
      System.out.println("The bag contains element " + element + ", " + bag.count(element) + " times");
    }
    catch (NumberFormatException nfe) {
      System.out.println("Entry was not in integer format.");
    }
  }
  
  /** list
    * 
    * List the contents of the bag using the iterator
    */
  private void list() {
    System.out.print("The bag contains: {");
    for (Integer element : bag) {
      System.out.print(" " + element);
    }
    System.out.println(" }");
  }
  
  /** add
    *
    * Prompt the user for an element to add and add the element to the bag.
    */
  private void add() {
    Integer element;
    try {
      String s = JOptionPane.showInputDialog("Enter an integer to add to the bag: ");
      element = new Integer(s);
      bag.add(element);
    }
    catch (NumberFormatException nfe) {
      System.out.println("Last input was not valid; nothing added");
    }
  }

  /** remove 
    * 
    * Remove an element from the bag
    */
  private void remove() {
    Integer element;
    try {
      String s = JOptionPane.showInputDialog("Enter an integer to remove from the bag: ");
      element = new Integer(s);
      if (bag.remove(element)) {
        System.out.println("Element " + element + " was removed once from the bag");
      }
      else {
        System.out.println("Element " + element + " was not found in the bag");
      }
    }
    catch (NumberFormatException nfe) {
      System.out.println("Last input was not valid; nothing removed");
    }
  }

  /** quit
    * 
    * Method to terminate the BagTester program
    */
  private void quit() {        
    System.out.println("Now exiting the Bag Tester\n");
  }
  
  /** Main program--creates and runs BagTester
    * @param args the command line arguments (not used)
    */
  public static void main (String args[]) {
    BagTester tester = new BagTester ();
    tester.runTester();
  }
}