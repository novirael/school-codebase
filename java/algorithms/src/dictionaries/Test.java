package dictionaries;

public class Test {
    public static void main(String[]args) {
        SimpleMap simpleMap = new SimpleMap();

        simpleMap.put(1, 'a');
        simpleMap.put(2, 'a');
        simpleMap.put(130, 'a');

        simpleMap.printMap();
        System.out.println(simpleMap.hasKey(100));
        System.out.println(simpleMap.hasKey(2));
        simpleMap.remove(2);
        simpleMap.printMap();


        HashMap hashMap = new HashMap();

        hashMap.put(1, 'a');
        hashMap.put(2, 'b');
        hashMap.put(3, 'c');
        hashMap.put(129, 'd');
        hashMap.put(4, 'e');

        hashMap.printMap();

    }
}