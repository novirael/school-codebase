package lists2;

public class Student {
	private int index;
		
		public Student(int index) {
			this.index = index;
		}
		
		public void setIndex(int index) {
			this.index = index;
		}
		
		public int getIndex() {
			return index;
		}
		
		@Override
		public String toString() {
			return "Student, index: " + index;
		}
}
