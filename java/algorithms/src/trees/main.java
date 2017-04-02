package trees;


public class main {
    public static void main(String[] args){

        Drzewo drzewo = new Drzewo();

        drzewo.dodawanieDoDrzewa(5);
        drzewo.dodawanieDoDrzewa(4);
        drzewo.dodawanieDoDrzewa(6);
        drzewo.dodawanieDoDrzewa(2);
        drzewo.dodawanieDoDrzewa(3);
        drzewo.dodawanieDoDrzewa(7);

        WypisywanieDrzewa wypisz = new WypisywanieDrzewa();
        wypisz.drukowanieWierzcholkow(drzewo);

        System.out.println(drzewo.minimalny());
        System.out.println(drzewo.maksymalny());

        drzewo.preOrder(drzewo.getPierwszy());
        System.out.println();
        drzewo.inOrder(drzewo.getPierwszy());
        System.out.println();
        drzewo.postOrder(drzewo.getPierwszy());

        drzewo.szukaj(10);

        System.out.print(drzewo.nastepnik(3).getWartosc());

        drzewo.remove(5);

        wypisz.drukowanieWierzcholkow(drzewo);


    }

}

