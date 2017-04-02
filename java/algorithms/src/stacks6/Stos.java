package stacks6;


public class Stos {

    private int [] stos;
    private int wskaznik;
    private int max;
    private int ilosc;

    public Stos(int rozmiar) {
        stos = new int[rozmiar];
        wskaznik = 0;
        max = rozmiar;
        ilosc = 0;
    }


    public int pobierzZeStosu() throws PustyStosException {
        if (ilosc - 1 <= 0) {
            throw new PustyStosException();
        }
        if (wskaznik < 0) {
            wskaznik = max - 1;
        }
        int wynik = stos[wskaznik];
        wskaznik -= 1;
        ilosc -= 1;

        return wynik;
    }

    public void dodajNaStos(int element) {
        wskaznik += 1;
        ilosc += 1;
        if (wskaznik >= max) {
            wskaznik = 0;
        }
        stos[wskaznik] = element;

    }
}
