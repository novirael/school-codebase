package stacks1;


public class Stos {
    Integer[] stos;
    int wskaznik;

    public Stos(int rozmiarStosu) {
        this.stos = new Integer[rozmiarStosu];
        this.wskaznik = 0;
    }

    public void dodajNaStos(int element) throws StosPelnyException {
        if(wskaznik == stos.length) {
            throw new StosPelnyException();
        }
        stos[wskaznik] = element;
        wskaznik += 1;
    }

    public int pobierzZeStosu() throws PustyStosException {
        if(wskaznik == 0) {
            throw new PustyStosException();
        }
        wskaznik -= 1;
        return stos[wskaznik];
    }
}
