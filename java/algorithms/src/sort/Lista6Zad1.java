package sort;

import java.util.ArrayList;


public class Lista6Zad1 {
    public int[] generowanieTablicy(){
        int[] tablica = new int[8];
        for(int i=0; i<8; i++){
            if(i%10 == 0){
                tablica[i]= i*17;

            }
            else{
                tablica[i] = i*2;
            }
            if(i%8 == 0){
                tablica[i] = (i*5-i*13);

            }
            else{
                tablica[i] = (i*25-i*19);

            }
        }

        return tablica;
    }

    public ArrayList<Integer> generowanieListy(){
        ArrayList<Integer> lista = new ArrayList<Integer>();
        for(int i=0; i<8; i++){
            if(i%10 == 0 ){
                lista.add(i*17);
            }
            else if(i%8 == 0){
                lista.add(i*2);

            }
            else{
                lista.add(i*25-i*19);
            }
        }

        return lista;
    }

    public void zad1() {
        ArrayList<Integer> lista;

        Sortowanie sortuj7 = new Sortowanie();
        lista = this.generowanieListy();

        System.out.println("Booble Sort:");
        sortuj7.boobleSort(lista);

        Sortowanie sortuj8 = new Sortowanie();
        lista = this.generowanieListy();
        System.out.println(lista);


        System.out.println("Select Sort:");
        sortuj8.selectSort(lista);
        System.out.println();

        Sortowanie sortuj1 = new Sortowanie();
        lista = this.generowanieListy();
        sortuj1.insertSort(lista);

        System.out.println("Insert Sort:");
        System.out.println(String.format(" Porówn %8d Przest %8d", sortuj1.liczbaPorownan, sortuj1.liczbaPrzestawien));
        System.out.println();

        Sortowanie sortuj2 = new Sortowanie();
        lista = this.generowanieListy();
        sortuj2.insertSort(sortuj2.shellSort(lista));

        System.out.println("Shell Sort:");
        System.out.print(String.format(" Porówn %8d Przest %8d", sortuj2.liczbaPorownan, sortuj2.liczbaPrzestawien));
        System.out.println();

        Sortowanie sortuj3 = new Sortowanie();
        lista = this.generowanieListy();
        sortuj3.quickSort(lista, 0, lista.size()-1);

        System.out.println();
        System.out.println("Quick Sort:");
        System.out.println(String.format(" Porówn %8d Przest %8d", sortuj3.liczbaPorownan, sortuj3.liczbaPrzestawien));
        System.out.println();

        int[] lista3 = this.generowanieTablicy();
        MergeSort sortuj6 = new MergeSort(lista3);

        System.out.println("Merge Sort:");
        sortuj6.mergeSort();
        System.out.println(String.format(" Porówn %8d Przest %8d", sortuj6.liczbaPorownan, sortuj6.liczbaPrzestawien));

    }

}
