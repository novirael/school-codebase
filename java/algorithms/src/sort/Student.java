package sort;

import java.util.Comparator;


public class Student  {
    private int nrIndeksu;
    private int wiek;
    private int wzrost;

    public Student(int nrIndeksu, int wiek, int wzrost) {
        this.nrIndeksu = nrIndeksu;
        this.wiek = wiek;
        this.wzrost = wzrost;
    }

    public int getNrIndeksu() {
        return nrIndeksu;
    }

    public void setNrIndeksu(int nrIndeksu) {
        this.nrIndeksu = nrIndeksu;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public int getWzrost() {
        return wzrost;
    }

    public void setWzrost(int wzrost) {
        this.wzrost = wzrost;
    }

    @Override
    public String toString(){
        return "   Indeks: " + this.getNrIndeksu() + "   Wiek: " + this.getWiek() + "   Wzrost: " + this.getWzrost();
    }

    public static Comparator<Student> porownajWiek = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return (int) (o1.getWiek() - o2.getWiek());
        }
    };

    public static Comparator<Student> porownajWzrost = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return (int) (o1.getWzrost() - o2.getWzrost());
        }
    };

    public static Comparator<Student> porownajIndeks = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return (int) (o1.getNrIndeksu() - o2.getNrIndeksu());
        }
    }; //Todo compaund wiele
}
