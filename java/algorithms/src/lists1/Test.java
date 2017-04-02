package lists1;

import lists1.Iterators.Iterator;


public class Test {
	public static void main(String[]args)
	{
		SingleLinkedList list = new SingleLinkedList();
		
		System.out.println("Rozmiar listy - metoda size(): "+ list.size());
		System.out.println("\nDodaje 3 elementy - metoda add(): alfa, romeo, giulia");
		
		list.add("alfa");
		list.add("romeo");
		list.add("giulia");
		
		System.out.println("\nRozmiar listy - metoda size(): "+ list.size());
		
		System.out.println("\nPokaz liste - metoda showList(): ");
		list.showList();
		
		System.out.println("\nWyswietlenie za pomoca iteratora: ");
		Iterator it = list.iterator();
		for(it.first();!it.isDone();it.next())
		{
			System.out.println(it.current());
		}
		
		System.out.println("\nIterator() - first");
		it.first();
		System.out.println(it.current());
		
		System.out.println("\nIterator - last");
		it.last();
		System.out.println(it.current());
		
		System.out.println("\nMetoda contains() \"alfa\" - " + list.contains("alfa"));
		System.out.println("\nMetoda contains() \"159\" - " + list.contains("159"));
		
		System.out.println("\nUzycie metody get()");
		System.out.println("get(2): " + list.get(2));
		System.out.println("get(1): " + list.get(1));
		System.out.println("get(0): " + list.get(0));
		
		System.out.println("\nUzycie metody indexOf(), jesli nie ma, zwraca -1");
		System.out.println("indexOf(\"alfa\"): " + list.indexOf("alfa"));
		System.out.println("indexOf(\"romeo\"): " + list.indexOf("romeo"));
		System.out.println("indexOf(\"giulia\"): " + list.indexOf("giulia"));
		System.out.println("indexOf(\"159\"): " + list.indexOf("159"));
		
		System.out.println("\nUzycie metody set(2, \"lawecie\")");
		list.set(2, "lawecie");
		System.out.println("Wyswietl liste: ");
		list.showList();
		System.out.println("\nSprawdzenie czy lista jest pusta " +  list.isEmpty());
		System.out.println("\nUzycie metody insert(2, na)");
		list.insert(2, "na");
		list.showList();
		
		System.out.println("\nUzycie metody delete(2): ");
		list.delete(2);
		list.showList();
		
		System.out.println("\nUzycie metody delete() \"alfa\"");
		list.delete("alfa");
		list.showList();
		
		System.out.println("\nUzycie metody clear() - size: " + list.size());
		System.out.println("\nUzycie metody isEmpty() - " + list.isEmpty());
		list.clear();
		System.out.println("\nUzycie metody clear() - size: " + list.size());
		System.out.println("\nUzycie metody isEmpty() - " + list.isEmpty());
	}
}
