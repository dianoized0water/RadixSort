import java.util.*;

public class Radix{
  public static void main(String[] args){

  }

  public static int nth(int n, int col){
    double a = col * 1.0;
    int b = (int)(n/(Math.pow(10.0, a)));
    return (int) b%10;
  }

  public static int length(int n){
    double a = 1.0 * Math.abs(n);
    return (int)(Math.log10(a)+ 1);
  }

  public static void merge(MyLinkedList original, MyLinkedList[] buckets){
    for (int i=0; i<buckets.length; i++){
      original.extend(buckets[i]);
    }
  }

  public static void radixSort(String[] list){
    MyLinkedList[] buckets = new MyLinkedList[10];
    for (int i=0; i<10; i++){
      buckets[i] = new MyLinkedList();
    }
  }
}
