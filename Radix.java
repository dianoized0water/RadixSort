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

  }
}
