package zhstructures;

import junit.framework.*;

/**
 * A JUnit test case class for the ZHArraySet class.
 */

public class ZHArraySetTest extends TestCase{
  
  private ZHArraySet set1, set2;
  
  public void setUp(){
    set1 = new ZHArraySet<String>();
    set2 = new ZHArraySet<String>(4);
  }
  public void testEmptySet(){
    assertTrue("set should initially be empty",set1.isEmpty());
  }
  public void testAddToEmptySet(){
    set1.add("test");
    assertTrue("Should contain added element",set1.contains("test"));
  }
  public void testAddSame(){
    set1.add("test");
    set1.add("test");
    assertFalse("should return false when added identical elements",set1.add("test"));
    assertEquals("size of array should only be 1",set1.size(),1);
  }
  public void testRemove(){
    set1.add("test");
    assertTrue("should return true when test is removed",set1.remove("test"));
    assertFalse("set should not contain element removed",set1.contains("test"));
  }
  public void testIntersection(){
      set1.add("test");
      set1.add("blah");
      set2.add("test");
      set2.add("yay");
      ZHSet set3 =set1.intersection(set2);
      assertTrue("new set should only have the element 'test'",set3.contains("test"));
      assertEquals("size of set3 should be only 1",set3.size(),1);
    }
  public void testUnion(){
    set1.add("test");
    set1.add("hey");
    set2.add("test");
    set2.add("yay");
    ZHSet set3 = set1.union(set2);
    assertEquals("Size of set 3 should be 3",set3.size(),3);
  }
  public void testSubset(){
    set1.add("test");
    set2.add("test");
    set1.add("bob");
    assertTrue("set2 is a subset of set 1",set1.subset(set2));
  }
  public void testEquals(){
    assertTrue("set1 and set 2 should be equal",set1.equals(set2));
  }
}
                