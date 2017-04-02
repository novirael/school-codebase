package stacks1;


public class Zad1 {
    public static void main(String[] args){
        Stos stos = new Stos(5);

        try {
            stos.dodajNaStos(5);
            stos.dodajNaStos(5);
            stos.dodajNaStos(5);
            stos.dodajNaStos(5);
            stos.dodajNaStos(5);
            stos.dodajNaStos(5);
        }
        catch (StosPelnyException e){
            System.out.println("Stos jest pełny");
        }

        try {
            System.out.print(stos.pobierzZeStosu());
        }
        catch(PustyStosException e){
            System.out.println("Stos jest pusty");
        }
    }
}
