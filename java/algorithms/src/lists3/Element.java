package lists3;



public class Element {
	private Element next;
	private Element previous;
	private Object value;

	public Element(Object value) {
		this.value = value;
		next = null;
		previous = null;
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
	
	public Element getPrevious() {
		return previous;
	}

	public void setNext(Element next) {
		this.next = next;
	}
	
	public void setPrevious(Element previous) {
		this.previous = previous;
	}
	
	@Override
	public String toString() {
		return value + "";
	}
}