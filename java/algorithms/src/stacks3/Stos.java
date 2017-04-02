package stacks3;


public class Stos {

    private String[] stos;
    private int wskaznikNaOstatniElement;

    public Stos (){
        // nic nie bylo powiedziane wiec zaczynam sobie od 4
        this.stos = new String[4];
    }

    public void dodajDoStosu(String element){
        this.stos[wskaznikNaOstatniElement] = element;
        this.wskaznikNaOstatniElement += 1;

        // zwykle dodanie bez sprawdzania wychodzenia za tablice bo nigdy ssie to nie zdarzy
        if (wskaznikNaOstatniElement == (stos.length / 4 * 3)  ){
            zmienRozmiarStosu(stos.length * 2);
        }

    }

    public String pobierzZeStosu() throws PustyStosException {

        if (wskaznikNaOstatniElement == 0){
            throw new PustyStosException();
        }
        this.wskaznikNaOstatniElement -= 1;
        String temp = stos[wskaznikNaOstatniElement];
        if (wskaznikNaOstatniElement == stos.length / 4){
            zmienRozmiarStosu(stos.length/2);
        }
        return temp;
    }

    // prywatna do uzytku tylko przez metody stosu
    private void zmienRozmiarStosu(int NowyRozmiarStosu){
        String[] nowyStos = new String[NowyRozmiarStosu];
        for (int i = 0; i < wskaznikNaOstatniElement; i++){
            nowyStos[i] = stos[i];
        }
        this.stos = nowyStos;
    }

    //tylko do testow
    public void wypiszWielkoscStosu(){
        System.out.println(String.format("Stos obecnie ma wielkosc : %d przy %d elementach", this.stos.length, this.wskaznikNaOstatniElement ));
    }

}
