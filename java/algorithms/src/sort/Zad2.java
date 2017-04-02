package sort;

import java.util.ArrayList;
import java.util.Comparator;


public class Zad2 {

    public ArrayList<Student> tworzenieListyStudentow() {
        ArrayList<Student> listaStudentow = new ArrayList<Student>();

        Student st1 = new Student(74, 18, 180);
        Student st2 = new Student(75, 20, 160);
        Student st3 = new Student(76, 20, 173);
        Student st4 = new Student(77, 30, 177);
        Student st5 = new Student(78, 29, 171);
        Student st6 = new Student(79, 28, 165);
        Student st7 = new Student(90, 27, 159);
        Student st8 = new Student(91, 27, 190);
        Student st9 = new Student(62, 25, 178);
        Student st10 = new Student(63, 24, 176);


        listaStudentow.add(st1);
        listaStudentow.add(st2);
        listaStudentow.add(st3);
        listaStudentow.add(st4);
        listaStudentow.add(st5);
        listaStudentow.add(st6);
        listaStudentow.add(st7);
        listaStudentow.add(st8);
        listaStudentow.add(st9);
        listaStudentow.add(st10);

        return listaStudentow;
    }
    public void sortowanieBooble(ArrayList<Student> lista, Comparator<Student> comparator){
        SortowaniePo sortuj = new SortowaniePo();
        sortuj.boobleSort(lista, comparator);
        wyswietlListeStudentow(lista);
    }
    public void sortowanieSelect(ArrayList<Student> lista, Comparator<Student> comparator){
        SortowaniePo sortuj = new SortowaniePo();
        sortuj.selectSort(lista, comparator);
        System.out.println();
        wyswietlListeStudentow(lista);
    }

    public void sortowanieInsert(ArrayList<Student> lista, Comparator<Student> comparator){
        SortowaniePo sortuj = new SortowaniePo();
        sortuj.insertSort(lista, comparator);
        System.out.println();
        wyswietlListeStudentow(lista);
    }

    public void wyswietlListeStudentow(ArrayList<Student> lista){
        for(int i=0; i<lista.size(); i++){
            System.out.println(lista.get(i));
        }
        System.out.println();
        System.out.println("-------------------------");
    }

}
