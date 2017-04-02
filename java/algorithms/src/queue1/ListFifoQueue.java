package queue1;


public class ListFifoQueue implements Queue {

	private Element head;
	private int size;

	public ListFifoQueue() {
		head = new Element(null);
		size = 0;
	}

	private static final class Element {
		private Element next;
		private Object value;

		public Element(Object value) {
			this.value = value;
			next = null;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			this.value = value;
		}

		public Element getNext() {
			return next;
		}

		public void setNext(Element nextValue) {
			next = nextValue;
		}

		@Override
		public String toString() {
			return value + "";
		}
	}

	@Override
	public void enqueue(Object data) {
		Element temp = new Element(data);
		Element current = head;

		while (current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(temp);
		size++;
	}

	@Override
	public Object dequeue() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		Element removed = head.getNext();
		head.setNext(removed.getNext());
		size--;

		return removed;
	}

	public int size() {
		return size;
	}

	public void showQueue() {
		Element current = head.getNext();
		while (current != null) {
			System.out.println(current.getValue().toString());
			current = current.getNext();
		}
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
