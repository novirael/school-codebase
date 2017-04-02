package sort2;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;


public class HeapOrderedListPriorityQueue implements Queue {
    private final List _list;
    private final Comparator<Object> _comparator;

    public int liczbaPorownan = 0;
    public int liczbaPrzestawien = 0;

    public HeapOrderedListPriorityQueue(Comparator<Object> comparator) {
        _comparator = comparator;
        _list = new ArrayList<Integer>();
    }

    public void enqueue(Object value) { // dołączenie elementu _list.add(value);
        _list.add(value);
        swim(_list.size() - 1); // wynurzenie (wyniesienie) elementu
    }

    private void swim(int index) { // wynurzanie elementu (wynoszenie elementu w górę)
        int parent;

        while(index != 0 &&  _comparator.compare(_list.get(index), _list.get(parent= (index - 1) / 2)) > 0) {
            swap(index, parent);
            index=parent;
        } // wersja iteracyjna; w [Harris, Ross] jest wersja rekurencyjna
    }

    private void swap(int index1, int index2) { // zamiana miejscami dwóch elementów
        Object temp = _list.get(index1);
        _list.set(index1, _list.get(index2));
        _list.set(index2, temp);
    }

    public Object dequeue() throws EmptyQueueException { // pobranie/usunięcie elementu
        if (isEmpty()) throw new EmptyQueueException();

        Object result = _list.get(0);

        if (_list.size() > 1) {
            _list.set(0, _list.get(_list.size() - 1));
            sink(0);
        }
        _list.remove(_list.size() - 1);

        return result;
    }

    private void sink(int index) { // zatapianie (opuszczanie) elementu
        boolean isDone=false;
        int child;

        while(!isDone && (child=2*index+ 1 ) < _list.size()) {
            if (child < _list.size()-1 && _comparator.compare(_list.get(child), _list.get(child+1)) < 0)
                ++child;
            if (_comparator.compare(_list.get(index), _list.get(child)) < 0)
                swap(index, child); else isDone=true;
            index = child; }
    }

    public void clear() {
        _list.clear();
    }

    public int size() {
        return _list.size();
    }

    public boolean isEmpty() {
        return _list.isEmpty();
    }

    private static int n;

    public void maxheap(int i) {
        int left, right, largest;

        left=2*i;
        right=2*i+1;
        largest = i;

        if(right <= n) {
            liczbaPorownan += 1;
            if ((int) _list.get(left) > (int) _list.get(largest)) {
                largest = left;
            }
            else if ((int) _list.get(right) > (int) _list.get(largest)) {
                largest = right;
            }
        }

        if(largest!=i) {
            swap(i,largest);
            maxheap(largest);
        }
    }

    public void sort() {
        liczbaPorownan = 0;
        liczbaPrzestawien = 0;

        n = _list.size() - 1;
        for(int i=n;i>0;i--){
            swap(0, i);
            liczbaPrzestawien += 1;
            n=n-1;
            maxheap(0);
        }

        System.out.println("Porownania: " + liczbaPorownan);
        System.out.println("Przestawiania: " + liczbaPrzestawien);
    }

    public void printList() {
        Object all[] = _list.toArray();

        for (int i=0;i < all.length;i++) {
            System.out.print((int) all[i] + " ");
        }

        System.out.println();

    }
}