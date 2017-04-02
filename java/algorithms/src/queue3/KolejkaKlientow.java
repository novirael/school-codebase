package queue3;

import java.util.Random;
public class KolejkaKlientow {
    private ArrayFifoQueue kolejka;
    private final int _max; 
    private int zegar;

    Stanowisko stanowiskoA = new Stanowisko();
    Stanowisko stanowiskoB = new Stanowisko();
    Stanowisko stanowiskoC = new Stanowisko();
    
    public KolejkaKlientow (int max) {
        _max = max;
        kolejka = new ArrayFifoQueue(_max);
        zegar = 0;
    }
    
    public ArrayFifoQueue przyjmijObsluzKolejke (){
        int zbior = 10;
        Random rand = new Random();
        int nr=1;
        int t;
        
        for (int i=0; i<_max; i++){
            t = rand.nextInt( zbior+1 ) + zegar;
            while (zegar < t){
                if (! kolejka.isEmpty()){
                    obsluz(kolejka);
                }
                if (! kolejka.isEmpty()){
                    obsluz(kolejka);
                }
                if (! kolejka.isEmpty()){
                    obsluz(kolejka);
                }
                zegar++;        
            }
            Klient k = new Klient(nr, rand.nextInt(3*(zbior )+1));
            kolejka.enqueue(k);
            System.out.println("\nklient nr: " + nr + " zostal dolczony do kolejki w czasie " + zegar);
            nr++;
        
        }
        return kolejka;
    }
    
    public void obsluzStanowisko ( Stanowisko st ) {
        Klient k  = kolejka.dequeue();
        System.out.println("klient nr: " + k.getNumer() + " o czasie sprawy " + k.getCzasSprawy() + " podszedl do stanowiska w minucie " + zegar);
        st.setZegarSt(zegar + k.getCzasSprawy()); 
    }
    
    public ArrayFifoQueue obsluz ( ArrayFifoQueue kolejka) {

        if (wolne(stanowiskoA)) {
            System.out.println("\nstanowisko A:");
            obsluzStanowisko(stanowiskoA) ;            
        }
        else if (wolne(stanowiskoB)) {
            System.out.println("\nstanowisko B:");
            obsluzStanowisko(stanowiskoB);
        }
        else if(wolne(stanowiskoC)) {
            System.out.println("\nstanowisko C:");
            obsluzStanowisko(stanowiskoC);
        }

        return kolejka;
    }
    
    private boolean wolne( Stanowisko st ) {
        return zegar >= st.getZegarSt();
    }
}