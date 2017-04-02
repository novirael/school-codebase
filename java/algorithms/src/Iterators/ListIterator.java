package Iterators;

import queue1.SingleLinkedList;

public class ListIterator implements Iterator{

	private SingleLinkedList singleLinkedList;
	private int current = -1;
	private int first;
	private int last;
	

	public ListIterator(SingleLinkedList singleLinkedList) {
		this.singleLinkedList = singleLinkedList;
		first = 0;
		last = singleLinkedList.size() - 1;
	}
	
	@Override
	public void next() {
		current++;
	}

	@Override
	public boolean isDone() {
		return current < first ||current > last;
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
	

}
