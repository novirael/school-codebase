package queue1;

import Iterators.Iterable;

public interface List extends Iterable {
	public int size();
	public void insert(int index, Object value) throws IndexOutOfBoundsException;
	public boolean delete(Object value);
	public Object delete(int index) throws IndexOutOfBoundsException;
	public Object get(int index) throws IndexOutOfBoundsException;
	public Object set(int index, Object value) throws IndexOutOfBoundsException;
	public void add(Object value);
	public boolean contains(Object value);
	public int indexOf(Object value);
	public boolean isEmpty();
	public void clear();
}
