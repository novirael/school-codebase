package lists3.Iterators;

public interface Iterator {
	public void next();
	public boolean isDone();
	public void first();
	public void previous();
	public void last();
	public Object current() throws IndexOutOfBoundsException;
}