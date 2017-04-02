package sort;

import java.util.ArrayList;
import java.util.Collections;

public class Sortowanie{

    public int liczbaPorownan = 0;
    public int liczbaPrzestawien = 0;

    public void boobleSort(ArrayList<Integer> lista) {
        int i, j = 0, liczbaPorownan = 0, liczbaPrzestawien = 0;
        int jakDlugoPorownywac = lista.size() - 1;
        boolean bezPrzestawienia;

        while (true) {
            bezPrzestawienia = true;

            for (j = 0; j < jakDlugoPorownywac; j++) {
                if (lista.get(j) > lista.get(j + 1)) {
                    liczbaPrzestawien += 1;
                    bezPrzestawienia = false;
                    int wiekszy = lista.get(j);

                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, wiekszy);
                }
                liczbaPorownan += 1;
            }
            if (bezPrzestawienia) {
                break;
            }
            jakDlugoPorownywac -= 1;
        }
        System.out.println(String.format(" Porówn %2d Przest. %2d", liczbaPorownan, liczbaPrzestawien));
    }

    public void selectSort(ArrayList<Integer> lista) {
        int min = lista.get(0);
        int liczbaPorownan = 0;
        int liczbaPrzestawien = 0;
        int temp = 0;

        for (int j = 0; j < lista.size() - 1; j++) {
            for (int i = j; i < lista.size(); i++) {
                if (lista.get(i) < min) {
                    min = lista.get(i);
                    temp = i;

                }
                liczbaPorownan += 1;
            }
            if (min != lista.get(j)) {
                Collections.swap(lista, temp, j);
                liczbaPrzestawien += 1;
            }
            min = lista.get(j + 1);

        }
        System.out.println(String.format(" Porówn %2d Przest %2d", liczbaPorownan, liczbaPrzestawien));
    }


    public void insertSort(ArrayList<Integer> lista){

        for(int i=1; i<lista.size(); i++){
            int liczba = lista.get(i);
            int j=i;
            this.liczbaPorownan += 1;

            while ((j > 0) && (lista.get(j-1) > liczba)){
                lista.set(j, lista.get(j-1));
                j--;
                this.liczbaPorownan += 1;
                this.liczbaPrzestawien += 1;
            }
            lista.set(j, liczba);
        }

    }

    public ArrayList<Integer> wyznaczaniePrzyrostu(ArrayList<Integer> lista){
        int dlugoscListy = lista.size();
        int aktualnyPrzyrost = 1;
        ArrayList<Integer> listaPrzyrostow = new ArrayList<Integer>();

        while(true){
            if(aktualnyPrzyrost > dlugoscListy){
                break;
            }
            listaPrzyrostow.add(aktualnyPrzyrost);
            aktualnyPrzyrost = (aktualnyPrzyrost*3)+1;

        }
        return listaPrzyrostow;

    }

    public ArrayList<Integer> wyznaczanieLiczbListyZPrzyrostu(int przesuniecie, int przyrost, ArrayList<Integer> listaDoSortowania){
        ArrayList<Integer> przedzialListy = new ArrayList<Integer>();

        try {
            for (int i = 0; i < listaDoSortowania.size(); i++) {
                // dodawanie poszczegolnych wyrazow wg nastepnych elementow z listy (przesuniecie)
                if (((i * przyrost) + przesuniecie) > listaDoSortowania.size()) {
                    break;
                }
                przedzialListy.add(listaDoSortowania.get(i * przyrost + przesuniecie));
            }
        }
        catch(IndexOutOfBoundsException wyjsciePozaCiag){ }

        return przedzialListy;
    }

    public ArrayList<Integer> shellSort(ArrayList<Integer> listaDoSortowania){
        ArrayList<Integer> listaPrzyrostow = wyznaczaniePrzyrostu(listaDoSortowania);

        for(int i=0; i < listaPrzyrostow.size()-1; i++){
            int aktualnyPrzyrost = listaPrzyrostow.get(listaPrzyrostow.size()-1-i);

            for(int j=0; j<aktualnyPrzyrost; j++){
                // wyznaczenie podciągu do posortowania
                ArrayList<Integer> wyznaczonyPodciag = wyznaczanieLiczbListyZPrzyrostu(j, aktualnyPrzyrost, listaDoSortowania);

                // sortowanie podciągu
                insertSort(wyznaczonyPodciag);

                // wstawianie posortowanego podciagu do listy sortowanej
                for(int k=0; k<wyznaczonyPodciag.size(); k++){
                    listaDoSortowania.set(k*aktualnyPrzyrost+j,wyznaczonyPodciag.get(k));
                }
            }
        }

        return listaDoSortowania;
    }

    public void quickSort(ArrayList<Integer> listaDoSortowania, int lewy, int prawy){
        if(prawy-lewy <= 0){
            return;
        }

        int pivot, l;
        int j = lewy;
        int i = lewy;

        l = elemSrodkowy(lewy, prawy);
        pivot = listaDoSortowania.get(l);

        Collections.swap(listaDoSortowania, l, prawy);
        this.liczbaPrzestawien += 1;

        while(true){
            if(i>prawy-1){
                break;
            }
            if(listaDoSortowania.get(i) < pivot){
                this.liczbaPorownan += 1;
                Collections.swap(listaDoSortowania, j, i);
                this.liczbaPrzestawien += 1;
                j+=1;
                i+=1;
            }
            else{
                i+=1;
            }
        }

        Collections.swap(listaDoSortowania,j, prawy);
        this.liczbaPrzestawien += 1;

        quickSort(listaDoSortowania,lewy, j-1);
        quickSort(listaDoSortowania, j+1, prawy);
    }

    public int elemSrodkowy(int lewy, int prawy){
        return (lewy+prawy)/2;
    }


}
