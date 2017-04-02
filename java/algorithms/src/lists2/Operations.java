package lists2;

import lists1.SingleLinkedList;
import lists1.Iterators.Iterator;

public class Operations {

	public static SingleLinkedList concatList(SingleLinkedList fromList, SingleLinkedList toList) {
		SingleLinkedList temp = new SingleLinkedList();
		Iterator it = toList.iterator();
		for (it.first(); !it.isDone(); it.next()) {
			temp.add(it.current());
		}
		Iterator it2 = fromList.iterator();
		for (it2.first(); !it2.isDone(); it2.next()) {
			temp.add(it2.current());
		}

		return temp;
	}

	public static SingleLinkedList sortListByIndex(SingleLinkedList students) {
		boolean worseSort = true;
		for (int i = students.size() - 1; i > 0 && worseSort; i--) {
			worseSort = false;
			for (int j = 0; j < i; j++) {
				Student s1 = (Student) students.get(j);
				Student s2 = (Student) students.get(j + 1);

				if (s1.getIndex() > s2.getIndex()) {
					Student temp = (Student) students.get(j);
					//System.out.println("s1: "+s1);
					//System.out.println("s2: "+s2);
					//System.out.println("temp: "+temp);
					students.set(j, students.get(j + 1));
					students.set(j + 1, temp);
					worseSort = true;
				}
			}
		}
		return students;
	}

	public static SingleLinkedList concatListSorted(SingleLinkedList fromList, SingleLinkedList toList) {
		// Todo
		SingleLinkedList newList = concatList(fromList, toList);
		return sortListByIndex(newList);
	}
}