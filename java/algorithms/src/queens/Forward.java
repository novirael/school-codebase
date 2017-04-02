package queens;

import java.util.ArrayList;


public class Forward {

    int[][] szachownica;
    static final int N=11;
    int glebokosc;
    ArrayList<int[][]> wszystkieRozwiazania;
    public Forward()
    {
        szachownica = new int[N][N];
        int glebokosc=0;
        wszystkieRozwiazania = new ArrayList<int[][]>();
    }
    public void ustaw(int wiersz, int kolumna, int var)
    {
        for(int i=wiersz;i<N;i++)
        {
            if(szachownica[i][kolumna]==0)
            {
                szachownica[i][kolumna]=var;
            }
        }
        for(int i=kolumna;i<N;i++)
        {
            if(szachownica[wiersz][i]==0)
            {
                szachownica[wiersz][i]=var;
            }
        }
        for(int i=wiersz, j=kolumna;i<N&&j<N;i++,j++)
        {
            if(szachownica[i][j]==0)
            {
                szachownica[i][j]=var;
            }
        }
        for(int i=wiersz, j=kolumna;i>=0&&j<N;i--,j++)
        {
            if(szachownica[i][j]==0)
            {
                szachownica[i][j]=var;
            }
        }
    }
    public boolean sprawdzDostepnosc(int kolumna)
    {
        if(kolumna>=N) return true;
        for(int i=0;i<N;i++)
        {
            if(szachownica[i][kolumna]==0)
            {
                return true;
            }
        }
        return false;
    }

    public boolean czyMiejsce(int kolumna)
    {
        for(int i=0;i<N;i++)
        {
            if(szachownica[i][kolumna]==0)
            {
                return true;
            }
        }
        return false;
    }
    public boolean czyMozna(int wiersz, int kolumna)
    {
        if(kolumna>=N){return true;}
        for(int i=0;i<kolumna;i++)
        {
            if(szachownica[wiersz][i]==1)
            {
                return false;
            }
        }
        for(int i=wiersz,j=kolumna;i>=0&&j>=0;i--,j--)
        {
            if(szachownica[i][j]==1)
            {
                return false;
            }
        }
        for (int i = wiersz,j=kolumna;j>=0&&i<N;i++,j--)
        {
            if (szachownica[i][j]==1)
            {
                return false;
            }
        }
        return true;
    }
    public void RozwiazProblemWszystkie(int kolumna)
    {
        glebokosc++;
        if(kolumna == N)
        {
            int[][] rozw = new int[N][N];
            for(int i=0;i<rozw.length;i++)
            {
                for(int j=0;j<rozw.length;j++)
                {
                    rozw[i][j]=szachownica[i][j];
                }
            }
            wszystkieRozwiazania.add(rozw);
        }
        else{
            if(czyMiejsce(kolumna))
            {
                for(int i=0;i<N;i++)
                {
                    if(szachownica[i][kolumna]==0)
                    {
                        szachownica[i][kolumna]=1;
                        ustaw(i, kolumna, kolumna+2);
                        if(sprawdzDostepnosc(kolumna+1))
                        {
                            RozwiazProblemWszystkie(kolumna+1);
                        }
                        szachownica[i][kolumna]=0;
                        cofnij(i, kolumna, kolumna+2);
                    }
                }
            }
        }
    }
    public boolean Solve(int kolumna)
    {
        glebokosc++;
        if(kolumna >= N)
        {
            return true;
        }

        if(!czyMiejsce(kolumna))
        {
            return false;
        }
        for(int i=0;i<N;i++)
        {
            if(szachownica[i][kolumna]==0)
            {
                szachownica[i][kolumna]=1;
                ustaw(i, kolumna, kolumna+2);
                if(sprawdzDostepnosc(kolumna+1))
                {
                    if(Solve(kolumna+1))
                    {
                        return true;
                    }
                }
                szachownica[i][kolumna]=0;
                cofnij(i, kolumna, kolumna+2);
            }
        }
        return false;
    }

    public void cofnij(int wiersz, int kolumna, int var)
    {
        for(int i=wiersz;i<N;i++)
        {
            if(szachownica[i][kolumna]==var)
            {
                szachownica[i][kolumna]=0;
            }
        }
        for(int i=kolumna;i<N;i++)
        {
            if(szachownica[wiersz][i]==var)
            {
                szachownica[wiersz][i]=0;
            }
        }
        for(int i=wiersz, j=kolumna;i<N&&j<N;i++,j++)
        {
            if(szachownica[i][j]==var)
            {
                szachownica[i][j]=0;
            }
        }
        for(int i=wiersz, j=kolumna;i>=0&&j<N;i--,j++)
        {
            if(szachownica[i][j]==var)
            {
                szachownica[i][j]=0;
            }
        }
    }

    public void RozwiazWszystkie()
    {
        System.out.println("ULEPSZONY FORWARD CHECKING");
        long czas1=System.nanoTime();
        RozwiazProblemWszystkie(0);
        long czas2 = System.nanoTime();
        if(wszystkieRozwiazania.isEmpty())
        {
            brak();
        }
        else{
            double wynik= (czas2-czas1)/1000000000.0;
            System.out.println("Znaleziono rozwi¹zanie w "+wynik+" sekund(y). Glebokosc wyniosla: "+glebokosc);
            System.out.println("Wszystkich rozwiazan: "+wszystkieRozwiazania.size());
            //wypiszWszystkie();
        }
        System.out.println("-------------");
    }
    public void Rozwiaz()
    {
        System.out.println("ULEPSZONY FORWARD CHECKING");
        long czas1 = System.nanoTime();
        if(Solve(0))
        {

            wypisz();
        }
        else{
            brak();
        }
        long czas2 = System.nanoTime();
        double wynik= (czas2-czas1)/1000000000.0;
        System.out.println("Znaleziono rozwi¹zanie w "+wynik+" sekund(y). Glebokosc wyniosla: "+glebokosc);
        wyzeruj();
        System.out.println("-------------");
    }
    public void wyzeruj()
    {
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(szachownica[i][j]!=0&&szachownica[i][j]!=1)
                {
                    szachownica[i][j]=0;
                }
            }
        }
    }
    public void wypisz()
    {
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                System.out.print(szachownica[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void brak()
    {
        System.out.println("Brak rozwiazania dla N="+N);
    }

}
