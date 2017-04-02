package stacks6;


public class Zad6 {
    public static void main(String[] args){
        Stos stos = new Stos(5);

        stos.dodajNaStos(1);
        stos.dodajNaStos(2);
        stos.dodajNaStos(3);
        stos.dodajNaStos(4);
        stos.dodajNaStos(5);
        stos.dodajNaStos(6);

        try {
            System.out.println(stos.pobierzZeStosu());
            System.out.println(stos.pobierzZeStosu());
            System.out.println(stos.pobierzZeStosu());
            System.out.println(stos.pobierzZeStosu());
            System.out.println(stos.pobierzZeStosu());
            System.out.println(stos.pobierzZeStosu());
            System.out.println(stos.pobierzZeStosu());
            System.out.println(stos.pobierzZeStosu());
        }
        catch(PustyStosException e){
            System.out.println(e.getMessage());
        }

        stos.dodajNaStos(7);
        stos.dodajNaStos(8);

        try {
            System.out.println(stos.pobierzZeStosu());
            System.out.println(stos.pobierzZeStosu());
        } catch(PustyStosException e){
            System.out.println(e.getMessage());
        }
    }
}
