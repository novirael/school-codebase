package lists3;

import lists3.Iterators.Iterator;
import lists3.LinkedList;
import lists3.Operations;

public class Test {
	public static void main(String[] args) {
		LinkedList s = new LinkedList();
		System.out.println("Rozmiar listy - metoda size(): " + s.size());
		System.out.println("\nDodaje 3 elementy - metoda add(): alfa, romeo, giulia");
		
		s.add("alfa");
		s.add("romeo");
		s.add("159");
		System.out.println("Rozmiar listy - metoda size():: " + s.size());

		System.out.println("\nPokaz liste - metoda showList():");
		s.showList();
		
		System.out.println("\nWyswietlenie za pomoca iteratora: ");
		
		Iterator it = s.iterator();
		for(it.first(); !it.isDone(); it.next()){
			System.out.println(it.current());
		}
		
		System.out.println("\nIterator() - first");
		it.first();
		System.out.println(it.current());
		
		System.out.println("\nIterator() - last");
		it.last();
		System.out.println(it.current());
		
		System.out.println("\nMetoda contains() \"alfa\" - " + s.contains("alfa"));
		System.out.println("\nMetoda contains() \"159\" - " + s.contains("159"));
		
		System.out.println("\nUzycie metody get()");
		System.out.println("get(2): " + s.get(2));
		System.out.println("get(1): " + s.get(1));
		System.out.println("get(0): " + s.get(0));
		
		System.out.println("\nUzycie metody indexOf(), jesli nie ma, zwraca -1");
		System.out.println("indexOf(\"alfa\"): "+s.indexOf("alfa"));
		System.out.println("indexOf(\"romeo\"): "+s.indexOf("romeo"));
		System.out.println("indexOf(\"giulia\")"+s.indexOf("giulia"));
		System.out.println("indexOf(\"159\"): "+s.indexOf("159"));
		
		System.out.println("\nUzycie metody set(2, \"lawecie\")");
		s.set(2, "lawecie");
		System.out.println("Wyswietl liste: ");
		s.showList();
		System.out.println("\nSprawdzenie czy lista jest pusta " +  s.isEmpty());
		System.out.println("\nUzycie metody insert(2, na)");
		s.insert(2, "na");
		s.showList();
		System.out.println("\nUzycie metody delete(2): ");
		s.delete(2);
		s.showList();
		
		System.out.println("\nMetoda delete() \"alfa\"");
		s.delete("alfa");
		s.showList();
		
		System.out.println("\nUzycie metody clear() - size: " + s.size());
		System.out.println("\nUzycie metody isEmpty() - " + s.isEmpty());
		s.clear();
		System.out.println("\nUzycie metody clear() - size: " + s.size());
		System.out.println("\nUzycie metody isEmpty() - " + s.isEmpty());
		
		s.add("nowy1");
		s.add("nowy2");
		s.add("nowy3");
		
		LinkedList nowa = new LinkedList();
		nowa.add("1");
		nowa.add("2");
		nowa.add("3");
		nowa.add("4");
		nowa.add("5");
		
		System.out.println("\nDodawanie listy przed index = 3");
		LinkedList insertIntoList = Operations.insertIntoListBeforeIndex(3, s, nowa);
		insertIntoList.showList();
		
		System.out.println("\nDodawanie listy przed element = 3");
		LinkedList insertIntoListBeforeValue = Operations.insertIntoListBeforeValue("3", s, nowa);
		insertIntoListBeforeValue.showList();
		
		System.out.println("\nKonkatenacja list");
		LinkedList concat = Operations.concatLists(s, nowa);
		concat.showList();
	}
}