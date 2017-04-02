package trees;


public class Drzewo {
    private Wierzcholek Pierwszy = null;

    public Wierzcholek getPierwszy() {
        return Pierwszy;
    }

    public void setPierwszy(Wierzcholek pierwszy) {
        Pierwszy = pierwszy;
    }

    public void dodawanieDoDrzewa(int wartoscNowegoElementu){
        Wierzcholek nowyElement = new Wierzcholek(null, null, null, wartoscNowegoElementu);

        if(getPierwszy() == null) {
            setPierwszy(nowyElement);
        }
        else{
            Wierzcholek aktualny = getPierwszy();
            while(true) {
                if(nowyElement.getWartosc() == aktualny.getWartosc()){
                    System.out.println("już jest taki element");
                    break;
                }
                if(nowyElement.getWartosc() < aktualny.getWartosc()){
                    if(aktualny.getLewy() == null){
                        aktualny.setLewy(nowyElement);
                        nowyElement.setOjciec(aktualny);
                        break;
                    }
                    aktualny = aktualny.getLewy();
                }
                else{
                    if(aktualny.getPrawy() == null){
                        aktualny.setPrawy(nowyElement);
                        nowyElement.setOjciec(aktualny);
                        break;
                    }
                    aktualny = aktualny.getPrawy();
                }
            }
        }
    }

    public int minimalny(){
        if(getPierwszy() == null){
            System.out.println("Nie ma minimalnego elem");
            return -1;
        }
        Wierzcholek aktualny = getPierwszy();
        while(true){
            if(aktualny.getLewy() != null){
                aktualny = aktualny.getLewy();
            }
            else {
                return aktualny.getWartosc();
            }
        }
    }
    public int maksymalny(){
        if(getPierwszy() == null){
            System.out.println("Nie ma maksymalnego elem");
            return -1;
        }
        Wierzcholek aktualny = getPierwszy();
        while(true){
            if(aktualny.getPrawy() != null){
                aktualny = aktualny.getPrawy();
            }
            else {
                return aktualny.getWartosc();
            }
        }
    }

    public Wierzcholek szukaj(int szukany){
        Wierzcholek aktualny = getPierwszy();

        if(getPierwszy() == null) {
            System.out.println("nie ma elementow");
            return null;
        }

        while(true){
            if(aktualny.getWartosc() == szukany){
                return aktualny;
            }
            if(szukany < aktualny.getWartosc() && aktualny.getLewy() != null){
                aktualny = aktualny.getLewy();
                continue;
            }
            if(szukany > aktualny.getWartosc() && aktualny.getPrawy() != null){
                aktualny = aktualny.getPrawy();
                continue;
            }
            aktualny = null;
            System.out.println("Nie ma takiego elementu");
            return aktualny;
        }
    }

    public Wierzcholek nastepnik(int wartosc){
        Wierzcholek aktualny = szukaj(wartosc);

        if (aktualny == null){
            System.out.println("Nie posiada takiego elementu");
            return null;
        }

        if(aktualny.getPrawy() != null){
            aktualny = aktualny.getPrawy();
            while(true){
                if(aktualny.getLewy() != null){
                    aktualny = aktualny.getLewy();
                }
                else {
                    return aktualny;
                }
            }
        }

        while (true){
            if(aktualny.getOjciec() == null){
                System.out.println("nie ma nastepnika");
                return aktualny.getOjciec();
            }
            if(aktualny.getOjciec().getLewy() == aktualny){
                return aktualny.getOjciec();
            }
            aktualny = aktualny.getOjciec();
        }
    }

    public Wierzcholek poprzednik(int wartosc){
        Wierzcholek aktualny = szukaj(wartosc);
        if (aktualny == null){
            System.out.println("Nie posiada takiego elementu");
            return null;
        }

        if(aktualny.getLewy() != null){
            aktualny = aktualny.getLewy();
            while(true){
                if(aktualny.getPrawy() != null){
                    aktualny = aktualny.getPrawy();
                }
                else {
                    return aktualny;
                }
            }
        }

        while (true){
            if(aktualny.getOjciec() == null){
                System.out.println("nie ma nastepnika");
                return aktualny.getOjciec();
            }
            if(aktualny.getOjciec().getPrawy() == aktualny){
                return aktualny.getOjciec();
            }
            aktualny = aktualny.getOjciec();
        }
    }

    public boolean remove(int value) {
        if (getPierwszy() == null)
            return false;
        else {
            if (getPierwszy().getWartosc() == value) {
                Wierzcholek auxRoot = new Wierzcholek(null, null, null, 0);
                auxRoot.setLewy(getPierwszy());
                boolean result = getPierwszy().remove(value, auxRoot);
                setPierwszy(auxRoot.getLewy());
                return result;
            } else {
                return getPierwszy().remove(value, null);
            }
        }
    }


    public void inOrder(Wierzcholek pierwszy){
        if(pierwszy.getLewy() != null){
            inOrder(pierwszy.getLewy());
        }
        System.out.print(pierwszy.getWartosc() + " ");
        if(pierwszy.getPrawy() != null){
            inOrder(pierwszy.getPrawy());
        }
    }

    public void preOrder(Wierzcholek pierwszy){
        System.out.print(pierwszy.getWartosc() + " ");
        if(pierwszy.getLewy() != null){
            preOrder(pierwszy.getLewy());
        }
        if(pierwszy.getPrawy() != null){
            preOrder(pierwszy.getPrawy());
        }
    }

    public void postOrder(Wierzcholek pierwszy){
        if(pierwszy.getLewy() != null){
            postOrder(pierwszy.getLewy());
        }
        if(pierwszy.getPrawy() != null){
            postOrder(pierwszy.getPrawy());
        }
        System.out.print(pierwszy.getWartosc() + " ");
    }
}

