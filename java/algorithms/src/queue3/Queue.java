package queue3;

public interface Queue {      
    public void enqueue(Klient klient);
    public Klient dequeue() throws EmptyQueueException; 
    public void clear();
    public int size(); 
    public boolean isEmpty(); 
}