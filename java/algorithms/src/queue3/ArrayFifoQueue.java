package queue3;


public class ArrayFifoQueue implements Queue { 
    private final int _size;
    private Klient tab[];
    int lob;   
    
    public ArrayFifoQueue(int size){
        _size = size;
        tab = new Klient[_size];
        lob = 0;
    }        
    
    public void enqueue(Klient klient){
        tab[lob] = klient;
        lob++;
    }

    public Klient dequeue() throws EmptyQueueException{
        if (isEmpty())
            throw new EmptyQueueException();    
        Klient k = tab[0];
        for (int i=0; i<lob-1; i++)
            tab[i] = tab[i+1];
        tab[lob] = null; 
        lob--;        
        return k;
    }
    
    public void clear(){
        for (int i=0; i<lob; i++)
            tab[i] = null;
        lob = 0;
    }
    
    public int size() {return lob;}
    
    public boolean isEmpty() { return lob == 0;}
    
    
    
    public void show() {
        for (int i=0; i<lob; i++)
            System.out.println(tab[i]);
    }
    
} 