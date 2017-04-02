package lists1;

import lists1.Element;
import lists1.ListInterface;
import lists1.Iterators.Iterator;
import lists1.Iterators.ListIterator;

public class SingleLinkedList implements ListInterface {
	
	private Element head;
	private int size;

	public SingleLinkedList() {
		head = new Element(null);
		size = 0;
	}

	public void add(Object data) {
		Element temp = new Element(data);
		Element current = head;

		while (current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(temp);
		size++;
	}

	@Override
	public void insert(int index, Object value) throws IndexOutOfBoundsException {
		if(index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		Element temp = new Element(value);
		Element current = head;
		for (int i = 0; i < index && current.getNext() != null; i++) {
			current = current.getNext();
		}
		temp.setNext(current.getNext());
		current.setNext(temp);
		size++;
	}

	public Object get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Element current = head.getNext();
		for (int i = 0; i < index; i++) {
			if (current.getNext() == null) {
				return null;
			}
			current = current.getNext();
		}
		return current.getValue();
	}
	
	@Override
	public boolean delete(Object value) throws IndexOutOfBoundsException {
		if(!contains(value)) {
			return false;
		}
		int index = indexOf(value);
		try {
			delete(index);
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}
	
	@Override
	public Element delete(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Element current = head;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		Element removed = current.getNext();
		current.setNext(removed.getNext());
		size--;
		
		return removed;
	}

	public int size() {
		return size;
	}

	public void showList() {
		Element current = head.getNext();
		while (current != null) {
			System.out.println(current.getValue().toString());
			current = current.getNext();
		}
	}

	@Override
	public Iterator iterator() {
		return new ListIterator(this);
	}

	@Override
	public Object set(int index, Object value) throws IndexOutOfBoundsException {
		if(index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		Element current = head;
		for (int i = 0; i <= index; i++) {
            current = current.getNext();
        }
		current.setValue(value);
        Element result = current;
        return result;
	}

	@Override
	public boolean contains(Object value) {
		return indexOf(value) != -1;
	}

	@Override
	public int indexOf(Object value) {
		int index = 0;
		Element e = head.getNext();
		while(e != head && !value.equals(e.getValue())) { 
			e = e.getNext(); 
			++index; 
			if(e == null) {
				return -1;
			}
		}
		return e != head ? index : -1;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		size = 0;
		head.setNext(null);
	}
}