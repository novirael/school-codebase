package sort;

import java.util.ArrayList;


public class main {
    public static void main(String[] args){

        System.out.println("--------- ZADANIE 1 ----------");
        System.out.println("------------------------------");

        Zad1 zadanie1 = new Zad1();
        zadanie1.test();

        System.out.println();
        System.out.println("--------- ZADANIE 2 ----------");
        System.out.println("------------------------------");

        Zad2 zadanie2 = new Zad2();

        ArrayList<Student> listaStudentow = zadanie2.tworzenieListyStudentow();
        zadanie2.wyswietlListeStudentow(listaStudentow);

        zadanie2.sortowanieBooble(listaStudentow, Student.porownajWiek);
        zadanie2.sortowanieSelect(listaStudentow, Student.porownajWzrost);
        zadanie2.sortowanieInsert(listaStudentow, Student.porownajIndeks);

        System.out.println();
        System.out.println("--------- ZADANIE 1 ----------");
        System.out.println("------------------------------");

        Lista6Zad1 drukowanieWynikowZad1Lista6 = new Lista6Zad1();
        drukowanieWynikowZad1Lista6.zad1();

    }
}
