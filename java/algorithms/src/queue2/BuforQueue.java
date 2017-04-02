package queue2;

import queue1.ListFifoQueue;;

public class BuforQueue implements Queue{

	private final int _size;
	private Object tab[];
	ListFifoQueue zapasowa = new ListFifoQueue();
	int indeksKoncowy = 0;
	int indeksPoczatkowy = 0;
	
	
	public BuforQueue(int size)
	{
		_size = size;
		tab = new Object[_size];
	}
	
	public void enqueue(Object value)
	{
		if (tab[indeksKoncowy] == null) {
			tab[indeksKoncowy++]=value;
			if(indeksKoncowy>=_size) indeksKoncowy=0;
			System.out.println("Dodano do bufora: "+value);
		}
		else {
			System.out.println("Brak miejsca w buforze! Dodano do oczekujacych: " + value);
			zapasowa.enqueue(value);
		}
	}
	
	@Override
	public Object dequeue() throws EmptyQueueException {
		if (isEmpty())
			throw new EmptyQueueException();
		Object o = tab[indeksPoczatkowy];
		tab[indeksPoczatkowy]=null;
		if(indeksPoczatkowy<_size-1)
			indeksPoczatkowy++;
		else
			indeksPoczatkowy = 0;
		if (!zapasowa.isEmpty())
		{
			Object temp=zapasowa.dequeue();
			tab[indeksKoncowy++]=temp;
			if(indeksKoncowy>=_size) indeksKoncowy=0;
			System.out.println("Usunieto z bufora: " + o + " oraz wstawiono " + temp + " z listy oczekujacych");
		}
		else
		{
			System.out.println("Usunieto z bufora: "+ o);
		}
		
		return o;
	}

	@Override
	public void clear() {
		for (int i = 0; i < tab.length; i++)
			tab[i]=null;
		indeksKoncowy = indeksPoczatkowy = 0;
	}

	@Override
	public int size() {
		return tab.length;
	}

	@Override
	public boolean isFull() {
		int licznik = 0;
		for (int i = 0; i < tab.length; i++)
		{
			if (tab[i]!=null)
				licznik++;
		}
		return licznik == _size;
	}
	
	public void showBufor()
	{
		System.out.println();
		for (int i = 0; i < tab.length; i++)
		{
			System.out.print(tab[i]+" ");
		}
		System.out.println("\n");
	}
	
	public void showWait()
	{
		System.out.println("Lista oczekujacych: ");
		zapasowa.showQueue();
		System.out.println();
	}

	@Override
	public boolean isEmpty() {
		int licznik = 0;
		
		for (int i = 0; i < tab.length; i++) {
			if (tab[i]==null)
				licznik++;
		}

		return licznik == _size;
	}
	
}
