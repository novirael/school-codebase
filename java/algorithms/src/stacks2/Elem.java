package stacks2;


public class Elem {
    int wartosc;
    Elem nastepnyElem;

    public Elem(int wartoscNowego){
        this.wartosc = wartoscNowego;
        this.nastepnyElem = null;
    }

    public int getWartosc() {
        return wartosc;
    }

    public Elem getNastepnyElem() {
        return nastepnyElem;
    }

    public void setNastepnyElem(Elem nastepnyElem) {
        this.nastepnyElem = nastepnyElem;
    }
}
