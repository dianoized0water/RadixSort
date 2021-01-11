import java.util.*;

public class MyLinkedList{
  private int size;
  private Node start, end;

  public MyLinkedList(){
    size = 0;
  }

  public int size(){
    return size;
  }

  public boolean add(String value){
    if (size == 0){
      Node n = new Node(value, null, null);
      size++;
      start = n;
      end = n;
      return true;
    }
    else {
      Node n = new Node(value, end, null);
      size = size + 1;
      end.setNext(n);
      end = n;
      return true;
    }
  }

  private Node getNode(int index){
    Node n = start;
    for (int i=0; n!=null && i<index; i++){
      n = n.getNext();
    }
    return n;
  }

  public void add(int index,String value) {
    if(index > size || index < 0){
      throw new IndexOutOfBoundsException();
    }
    if(size==index){
      add(value);
    }
    else if(index == 0) {
      Node newStart = new Node(value, null, start);
      start.setPrev(newStart);
      start = newStart;
      size++;
    }
    else {
      Node n = new Node(value, getNode(index-1), getNode(index));
      n.getPrev().setNext(n);
      n.getNext().setPrev(n);
      size++;
    }
  }

  public String get(int index){
    if (index<0 || index>size-1){
      throw new IndexOutOfBoundsException();
    }
    return getNode(index).getValue();
  }

  public String set(int index, String value){
    if (index<0 || index>size-1){
      throw new IndexOutOfBoundsException();
    }
    String original = getNode(index).getValue();
    getNode(index).setValue(value);
    return original;
  }

  public String toString(){
    String str = "";
    Node n = start;
    for (int i=0; i<size; i++){
      str += n.getValue();
      if (n.getNext() != null){
        str= str + ", ";
      }
      n = n.getNext();
    }
    return "[" + str + "]";
  }

  public String toStringReversed(){
    String str = "";
    Node n = end;
    for (int i=0; i<size; i++){
      str += n.getValue();
      if (n.getPrev() != null){
        str= str + ", ";
      }
      n = n.getPrev();
    }
    return "[" + str + "]";
  }

  public String remove(int index){
    if (index>size-1 || index<0){
      throw new IndexOutOfBoundsException();
    }
    String org = start.getValue();
    if (size==1){
      start = null;
      end = null;
    }
    else if (index==0){
      start = start.getNext();
      start.setPrev(null);
    }
    else if (index==size-1){
      end = end.getPrev();
      end.setNext(null);
    }
    else{
      getNode(index+1).setPrev(getNode(index-1));
      getNode(index-1).setNext(getNode(index+1));
    }
    size--;
    return org;
  }

  public void extend(MyLinkedList other){
    if (size==0){
      start = other.start;
    }
    else if (other.size != 0){
      this.end.setNext(other.start);
      other.start.setPrev(this.end);
      this.end = other.end;
      size = size + other.size;
    }
    other.start = null;
    other.end = null;
    other.size = 0;
  }
}
