package queue1;

public class Test {

	public static void main(String[] args) {
		ListFifoQueue kolejka = new ListFifoQueue();
		System.out.println("Utworzenie kolejki FIFO oraz sprawdzenie czy jest pusta: "+ kolejka.isEmpty());
		
		System.out.println("\nWprowadzanie 6 elementow do kolejki: ");
		kolejka.enqueue("pierwszy");
		kolejka.enqueue("drugi");
		kolejka.enqueue("trzeci");
		kolejka.enqueue("czwarty");
		kolejka.enqueue("piaty");
		kolejka.enqueue("szosty");

		System.out.println("\nWyswietlenie kolejki:");
		kolejka.showQueue();

		System.out.println("\nUsuniecie 4 elementow z kolejki:");
		for (int i = 0; i < 4; i++) kolejka.dequeue();
		kolejka.showQueue();
		
		System.out.println("\nDodanie 5 elementow do kolejki: ");
		for(int i = 0; i < 5; i++) kolejka.enqueue("klient "+ (i+1));

		System.out.println("Wyswietlenie kolejki: ");
		kolejka.showQueue();
		
		System.out.println("\nWyczyszczenie kolejki: ");
		System.out.println("Przed. Czy pusta: "+ kolejka.isEmpty());

		System.out.println("Rozmiar: " + kolejka.size());
		System.out.println("Czyszcze...");
		kolejka.clear();
		System.out.println("Po. Czy pusta: " + kolejka.isEmpty());
		System.out.println("Rozmiar: "+ kolejka.size());
		// Todo

	}

}
