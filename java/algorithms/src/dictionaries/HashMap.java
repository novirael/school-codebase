package dictionaries;


import java.util.ArrayList;

public class HashMap {
    private final static int TABLE_SIZE = 128;

    HashEntry[] table;

    HashMap() {
        table = new HashEntry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
    }

    private int hashed(int key) {
        int hash = (key % TABLE_SIZE);
        while (table[hash] != null && table[hash].getKey() != key)
            hash = (hash + 1) % TABLE_SIZE;
        return hash;
    }

    public int get(int key) {
        int hash = hashed(key);

        if (table[hash] == null)
            return -1;
        else
            return table[hash].getValue();
    }

    public boolean remove(int key) {
        int hash = hashed(key);
        if (table[hash] == null)
            return false;
        else {
            table[hash] = null;
            return true;
        }
    }

    public void put(int key, int value) {
        int hash = hashed(key);
        System.out.println("Adding " + key + " : " + value + " hashed by " + hash);
        table[hash] = new HashEntry(key, value);
    }

    private void insertSort(ArrayList<Integer> lista){
        for(int i=1; i<lista.size(); i++){
            int liczba = lista.get(i);
            int j=i;

            while ((j > 0) && (lista.get(j-1) > liczba)){
                lista.set(j, lista.get(j-1));
                j--;
            }
            lista.set(j, liczba);
        }
    }

    private ArrayList<Integer> getSortedKeys() {
        ArrayList<Integer> keys = new ArrayList<>();

        for (int i=0; i < TABLE_SIZE - 1; i++) {
            if (table[i] != null)
                keys.add(table[i].getKey());
        }
        this.insertSort(keys);
        return keys;
    }

    public void printMap() {
        ArrayList<Integer> sortedKeys = this.getSortedKeys();
        for (Integer sortedKey : sortedKeys)
            System.out.println(sortedKey + " : " + this.get(sortedKey));
    }
}