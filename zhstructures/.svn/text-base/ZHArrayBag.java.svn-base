/**
 * File:ZHArrayBag<ElementType>.java
 */
package zhstructures;
import java.util.Iterator;

public class ZHArrayBag<ElementType> implements ZHBag<ElementType>{
  
  ZHArrayStructure<ElementType> elements;
  
  public ZHArrayBag(){
    elements=new ZHArrayStructure();
  }
  public boolean isEmpty(){
    return elements.isEmpty();
  }
  public boolean contains(ElementType element){
    return elements.contains(element);
  }
  public Iterator<ElementType> iterator(){
    return elements.iterator();
  }
  public int size(){
    return (elements.next - elements.first);
  }
  public int count(ElementType element){
    int i=0;
    for(ElementType e:elements){
      if(e.equals(element)) i++;
    }
    return i;
  }
  public boolean add(ElementType element){
    elements.addLast(element);
    return true;
  }
  public boolean remove(ElementType element){
    ZHArrayStructure<ElementType> n = new ZHArrayStructure<ElementType>();
    int i = count(element)-1;
    if(!(elements.contains(element))) return false;
    else{
      for(ElementType e:elements){
        if(!(e.equals(element))){
          n.addLast(e);
        }
      }     
      for(int j =0;j<i;j++){
        n.addLast(element);
      }
      elements = n;
      return true;
    }      
  }
  public ZHBag<ElementType> union(ZHBag<ElementType> otherBag){
    ZHBag<ElementType> result = otherBag;
    for(ElementType element:elements){
      result.add(element);
    }
    return result;
  }
  public boolean subbag(ZHBag<ElementType> potentialSubbag){
        for(ElementType element: potentialSubbag){
      if(!(elements.contains(element))){
        return false;
      }
    }
    return true;
  }
  @SuppressWarnings("unchecked")
  public boolean equals(Object o) {
    ZHBag<ElementType> otherBag;
    try {
      otherBag=(ZHBag<ElementType>) o;
      return(this.subbag(otherBag) && otherBag.subbag(this));
    }
    catch(ClassCastException e) {
      return(false);
    }
  }
    
}
        