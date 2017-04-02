package trees;

import java.util.*;


public class WypisywanieDrzewa {

    public void drukowanieWierzcholkow(Drzewo drzewo) {
        Stack globalStack = new Stack();
        Stack localStack;
        int emptyLeaf = 32;
        boolean isRowEmpty = false;

        globalStack.push(drzewo.getPierwszy());

        while (!isRowEmpty) {
            localStack = new Stack();
            isRowEmpty = true;

            for (int j = 0; j < emptyLeaf; j++)
                System.out.print(' ');

            while (!globalStack.isEmpty()) {
                Wierzcholek temp = (Wierzcholek) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.getWartosc());
                    localStack.push(temp.getLewy());
                    localStack.push(temp.getPrawy());
                    if (temp.getLewy() != null || temp.getPrawy() != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }

                for (int j = 0; j < emptyLeaf * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            emptyLeaf /= 2;

            while (!localStack.isEmpty())
                globalStack.push(localStack.pop());
        }
    }
}