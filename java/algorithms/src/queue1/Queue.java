package queue1;

public interface Queue {
	public void enqueue(Object value);
	public Object dequeue() throws EmptyQueueException;
	public void clear();
	public int size();
	public boolean isEmpty();
}
