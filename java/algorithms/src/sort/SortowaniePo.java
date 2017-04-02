package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class SortowaniePo {
    public void boobleSort(ArrayList<Student> lista, Comparator<Student> comparator) {
        int j = 0;
        int jakDlugoPorownywac = lista.size() - 1;

        while (true) {
            boolean bezPrzestawienia = true;
            for (j = 0; j < jakDlugoPorownywac; j++) {
                if (comparator.compare(lista.get(j), lista.get(j + 1)) > 0)  {
                    bezPrzestawienia = false;
                    Student wiekszy = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, wiekszy);
                }
            }
            if (bezPrzestawienia) {
                break;
            }
            jakDlugoPorownywac -= 1;
        }
    }

    public void selectSort(ArrayList<Student> lista, Comparator<Student> comparator) {
        Student min = lista.get(0);
        int temp = 0;
        for (int j = 0; j < lista.size() - 1; j++) {
            for (int i = j; i < lista.size(); i++) {
                if (comparator.compare(lista.get(i), min) < 0 ) {
                    min = lista.get(i);
                    temp = i;
                }
            }
            if (min != lista.get(j)) {
                Collections.swap(lista, temp, j);
            }
            min = lista.get(j + 1);
        }
    }

    public void insertSort(ArrayList<Student> lista, Comparator<Student> comparator){
        for(int i=1; i<lista.size(); i++){
            Student student = lista.get(i);
            int j=i;
            while ((j > 0) && comparator.compare(lista.get(j-1), student) > 0){
                lista.set(j, lista.get(j-1));
                j--;
            }
            lista.set(j, student);
        }
    }
}
