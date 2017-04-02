package queue2;

public class Test {

	public static void main (String[] args)
	{
		int buffersize = 4;
		
		BuforQueue bufor = new BuforQueue(buffersize);
		System.out.println("Utworzenie bufora " + bufor.size() + " elementowego");
		System.out.println("Czy bufor jest pelny? " + bufor.isFull());
		System.out.println("Czy bufor jest pusty? " + bufor.isEmpty());
		
		System.out.println("###############################");
		System.out.println("Dodanie 2 elementow do bufora");
		bufor.enqueue(1);
		bufor.enqueue(2);

		System.out.println("###############################");
		System.out.println("Usuniecie 1 elementu z bufora");
		bufor.dequeue();
		bufor.showBufor();

		System.out.println("Czy bufor jest pelny? " + bufor.isFull());
		System.out.println("Czy bufor jest pusty? " + bufor.isEmpty());

		System.out.println("###############################");
		System.out.println("Dodanie 3 elementow do bufora");
		bufor.enqueue(3);
		bufor.enqueue(4);
		bufor.enqueue(5);
		bufor.showBufor();

		System.out.println("###############################");
		System.out.println("Dodanie 1 elementu do bufora");
		bufor.enqueue(6);
		bufor.showBufor();

		System.out.println("###############################");
		System.out.println("Czy bufor jest pelny? " + bufor.isFull());
		System.out.println("Czy bufor jest pusty? " + bufor.isEmpty());
		System.out.println("Dodanie 3 elementow do bufora");
		bufor.enqueue(7);
		bufor.enqueue(8);
		bufor.enqueue(9);

		System.out.println("###############################");
		System.out.println("Wyswietlenie bufora");
		bufor.showBufor();

		System.out.println("###############################");
		System.out.println("Wyswietlenie listy oczekujacych");
		bufor.showWait();
		bufor.dequeue();
		bufor.showBufor();

		for(int i = 0; i < 3; i++) bufor.dequeue();
		System.out.println("Wyswietlenie bufora");
		bufor.showBufor();

		for (int i = 0; i < 4; i++) bufor.dequeue();
		System.out.println("Wyswietlenie bufora");
		bufor.showBufor();

		System.out.println("idx poczatkowy: "+ bufor.indeksPoczatkowy+ " idx koncowy: " + bufor.indeksKoncowy);
		System.out.println("Czy bufor jest pelny? " + bufor.isFull());
		System.out.println("Czy bufor jest pusty? " + bufor.isEmpty());

		System.out.println("###############################");
		System.out.println("Dodanie 1 elementu do bufora");
		bufor.enqueue(10);
		bufor.showBufor();
		bufor.dequeue();

		System.out.println("idx poczatkowy: "+ bufor.indeksPoczatkowy+ " idx koncowy: " + bufor.indeksKoncowy);
		System.out.println("Czy bufor jest pelny? " + bufor.isFull());
		System.out.println("Czy bufor jest pusty? " + bufor.isEmpty());

		System.out.println("###############################");
		System.out.println("\nDodanie 3 elementow do bufora");
		bufor.enqueue(11);
		bufor.enqueue(12);
		bufor.enqueue(13);
		bufor.showBufor();

		System.out.println("###############################");
		System.out.println("Wyczyszczenie bufora");
		bufor.clear();
		System.out.println("Czy bufor jest pelny? " + bufor.isFull());
		System.out.println("Czy bufor jest pusty? " + bufor.isEmpty());
		bufor.showBufor();
	}
}
