package queue3;

public class Klient{
    private int numer;
    private int czasSprawy;
    
    public Klient(int numer, int czasSprawy){
        this.numer = numer;
        this.czasSprawy = czasSprawy;
    }
    
    public int getNumer(){
        return numer;
    }
    
    public void setNumer(int nr){
        numer = nr;
    }
    
    public int getCzasSprawy(){
        return czasSprawy;
    }
    
    public void setCzasSprawy(int czassp){
        czasSprawy = czassp;
    }
    
    public String toString(){
        return "nr klienta: "+numer+" czas sprawy: "+czasSprawy; 
    }

}