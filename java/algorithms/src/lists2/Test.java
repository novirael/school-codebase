package lists2;

import lists1.SingleLinkedList;
import lists2.Operations;

public class Test {

	public static void main(String[] args) {
		System.out.println("Lista pierwsza: ");
		SingleLinkedList students = new SingleLinkedList();
		students.add(new Student(1));
		students.add(new Student(2));
		students.add(new Student(3));
		students.add(new Student(7));
		students.add(new Student(8));
		students.add(new Student(9));
		students.showList();

		System.out.println("\nDruga lista: ");
		SingleLinkedList secondStudents = new SingleLinkedList();
		secondStudents.add(new Student(4));
		secondStudents.add(new Student(5));
		secondStudents.add(new Student(6));
		secondStudents.add(new Student(10));
		secondStudents.add(new Student(11));
		secondStudents.showList();
		
		System.out.println("\nLaczenie i sortowanie list");
		System.out.println("____________________");
		SingleLinkedList result = Operations.concatListSorted(students, secondStudents);
		result.showList();
	}

}
