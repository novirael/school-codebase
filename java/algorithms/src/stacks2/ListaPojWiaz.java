package stacks2;


public class ListaPojWiaz {
    private Elem pierwszy;

    public ListaPojWiaz(){
       this.pierwszy = null;
    }

    public void dodajNaPocz(int wartosc){
        Elem nowyElement = new Elem(wartosc);
        if(this.pierwszy == null){
            this.pierwszy = nowyElement;
        }
        else{
            nowyElement.setNastepnyElem(pierwszy);
            this.pierwszy = nowyElement;
        }
    }
    public int usuwanieZPoczatek() throws ListaPustaException {
        if(pierwszy == null){
            throw new ListaPustaException();
        }
        else {
            Elem element = pierwszy;
            pierwszy = pierwszy.getNastepnyElem();
            return element.getWartosc();
        }
    }
}
