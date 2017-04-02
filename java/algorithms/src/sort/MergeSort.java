package sort;

import java.util.Arrays;


public class MergeSort {
    int liczbaPorownan = 0;
    int liczbaPrzestawien = 0;

    int[] tablica;

    public MergeSort(int[] tablicaDoPosortowania) {
        this.tablica = tablicaDoPosortowania;
    }

    public int[] mergeSort() {
        if (tablica.length > 1) {
            int[] tablicaLewa = Arrays.copyOfRange(tablica, 0, (tablica.length) / 2);
            int[] tablicaPrawa = Arrays.copyOfRange(tablica, ((tablica.length) / 2), tablica.length);

            MergeSort right = new MergeSort(tablicaPrawa);
            MergeSort left = new MergeSort(tablicaLewa);
            right.mergeSort();
            left.mergeSort();

            return merge(tablica, tablicaLewa, tablicaPrawa);
        }

        return tablica;
    }

    public int[] merge(int[] wynikowa, int[] lewa, int[] prawa) {
        int liczbaElementow = lewa.length + prawa.length;
        int indeksWynikowej, indeksLewej, indeksPrawej;
        indeksWynikowej = indeksLewej = indeksPrawej = 0;

        while (indeksWynikowej < liczbaElementow) {
            if ((indeksLewej < lewa.length) && (indeksPrawej < prawa.length)) {
                this.liczbaPorownan += 1;

                if (lewa[indeksLewej] < prawa[indeksPrawej]) {
                    this.liczbaPorownan += 1;
                    wynikowa[indeksWynikowej] = lewa[indeksLewej];
                    this.liczbaPrzestawien += 1;
                    indeksWynikowej++;
                    indeksLewej++;
                } else {
                    wynikowa[indeksWynikowej] = prawa[indeksPrawej];
                    this.liczbaPrzestawien += 1;
                    indeksWynikowej++;
                    indeksPrawej++;
                }
            } else {
                if (indeksLewej >= lewa.length) {
                    this.liczbaPorownan += 1;
                    while (indeksPrawej < prawa.length) {
                        this.liczbaPorownan += 1;
                        wynikowa[indeksWynikowej] = prawa[indeksPrawej];
                        this.liczbaPrzestawien += 1;
                        indeksWynikowej++;
                        indeksPrawej++;
                    }

                }
                if (indeksPrawej >= prawa.length) {
                    this.liczbaPorownan += 1;
                    while (indeksLewej < lewa.length) {
                        wynikowa[indeksWynikowej] = lewa[indeksLewej];
                        this.liczbaPrzestawien += 1;
                        this.liczbaPorownan += 1;
                        indeksLewej++;
                        indeksWynikowej++;
                    }
                }
            }
        }

        return wynikowa;
    }

}