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

  public static void merge(SortableLinkedList original, SortableLinkedList[] buckets){
    for (int i=0; i<buckets.length; i++){
      original.extend(buckets[i]);
    }
  }

  private static int largest(SortableLinkedList data){
    if (data.size()==0){
      return 0;
    }
    int m = Math.abs(data.get(0));
    for (int i=1; i<data.size(); i++){
      m = Math.max(m, Math.abs(data.get(i)));
    }
    return length(m);
  }

  public static void radixSortSimple(SortableLinkedList data){
    int m = 1;
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    for(int i=0; i<buckets.length; i++){
      buckets[i] = new SortableLinkedList();
    }
    for (int i=0; i<m; i++){
      while(data.size()>0){
        int value = data.remove(0);
        buckets[nth(value, i)].add(value);
        if (i==0){
          m = Math.max(m, length(value));
        }
      }
      merge(data, buckets);
    }
  }

  public static void radixSort(SortableLinkedList data){
    SortableLinkedList p = new SortableLinkedList();
    SortableLinkedList n = new SortableLinkedList();
    while (data.size()>0){
      int value = data.remove(0);
      if(value>=0){
        p.add(value);
      }
      else{
        n.add(value);
      }
    }
    radixSortSimple(p);
    radixSortSimple(n);
    while(n.size()>0){
      data.add(n.remove(n.size()-1));
    }
    data.extend(p);
  }
}
