package lists1;


public class Element {
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
