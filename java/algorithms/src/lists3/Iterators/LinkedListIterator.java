package lists3.Iterators;

import lists3.LinkedList;

public class LinkedListIterator implements Iterator {
	private LinkedList singleLinkedList;
	private int current = -1;
	private int first;
	private int last;

	public LinkedListIterator(LinkedList linkedList) {
		this.singleLinkedList = linkedList;
		first = 0;
		last = linkedList.size() - 1;
	}

	@Override
	public void next() {
		current++;
	}

	@Override
	public boolean isDone() {
		return current < first || current > last;
	}

	@Override
	public void first() {
		current = first;
	}

	@Override
	public void last() {
		current = last;
	}

	@Override
	public Object current() throws IndexOutOfBoundsException {
		return singleLinkedList.get(current);
	}

	@Override
	public void previous() {
		current--;
	}
}