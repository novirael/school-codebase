package sort2;


import java.util.Comparator;

public class HeapSort {

    public static Comparator<Object> simpleComparator = (o1, o2) -> (int) o1 - (int) o2;

    public static void main(String[] args){

        HeapOrderedListPriorityQueue queue = new HeapOrderedListPriorityQueue(simpleComparator);

        int []a1={6,5,3,1,8,7,2,4};
        for(int i=0;i<a1.length;i++) {
            queue.enqueue(a1[i]);
        }

        queue.printList();
        queue.sort();
        System.out.println();
        queue.printList();
    }
}
