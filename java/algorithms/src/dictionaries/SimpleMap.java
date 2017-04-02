package dictionaries;


public class SimpleMap {
    private final static int TABLE_SIZE = 128;

    Integer[] table;

    SimpleMap() {
        table = new Integer[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
    }

    public boolean hasKey(int key) {
        return key >= 0 && key <= TABLE_SIZE && table[key] != null;
    }

    public int get(int key) {
        if (!this.hasKey(key))
            return -1;
        else
            return table[key];
    }

    public boolean remove(int key) {
        if (!this.hasKey(key))
            return false;
        else {
            table[key] = null;
            return true;
        }
    }

    public void put(int key, int value) {
        if (key > TABLE_SIZE || key < 0)
            System.out.println("Keys should be from range <0," + TABLE_SIZE + ">");
        else {
            System.out.println("Adding " + key + " : " + value);
            table[key] = value;
        }
    }

    public void printMap() {
        for (int i=0; i < TABLE_SIZE; i++) {
            if (table[i] != null)
                System.out.println(i + " : " + table[i]);
        }
    }
}