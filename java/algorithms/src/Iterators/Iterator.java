package Iterators;

public interface Iterator {
	public void next();
	public boolean isDone();
	public void first();
	public void last();
	public Object current() throws IndexOutOfBoundsException;
}