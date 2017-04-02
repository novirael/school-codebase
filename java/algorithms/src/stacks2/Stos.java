package stacks2;


public class Stos {

    private ListaPojWiaz stos;

    public Stos() {
        this.stos = new ListaPojWiaz();
    }

    public int pobierzZeStosu() throws StosPustyException {
        try {
            return stos.usuwanieZPoczatek();
        }
        catch (ListaPustaException e){
            throw new StosPustyException();
        }

    }

    public void dodajNaStos(int nowyElement) {
        stos.dodajNaPocz(nowyElement);
    }
}
