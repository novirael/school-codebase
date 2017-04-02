package graph;

import java.util.ArrayList;
import java.util.List;

/* Zad. 2 */
public class AMatrixDirectedGraph extends AMatrixUndirectedGraph {
    public AMatrixDirectedGraph(int vertices) {
        super(vertices);
    }

    @Override
    public void addEdge(int vertex1, int vertex2) {
        if (vertex1 < 0 || vertex1 >= vertices) throw new IndexOutOfBoundsException();
        if (vertex2 < 0 || vertex2 >= vertices) throw new IndexOutOfBoundsException();

        if (matrix[vertex1][vertex2] == 0 && matrix[vertex2][vertex1] == 0) {
            matrix[vertex1][vertex2] = 1;
            matrix[vertex2][vertex1] = -1;
            edges++;
        }
    }

    @Override
    public Iterable<Integer> vertices(int vertex) {
        if (vertex < 0 || vertex >= vertices) throw new IndexOutOfBoundsException();

        List<Integer> list = new ArrayList<>();

         for (int ver = 0; ver < matrix[vertex].length; ver++) {
            if (ver != vertex && matrix[vertex][ver] == 1)
                list.add(ver);
        }

        return list;
    }

    @Override
    public String toString() {
        String str = "";
        str += vertices + " vertices, " + edges + " edges\n";
        for (int ver1 = 0; ver1 < vertices; ver1++) {
            str += ver1 + ": ";
            for (int ver2 = 0; ver2 < vertices; ver2++) {
                if (matrix[ver1][ver2] == 1)
                    str += ver2 + " ";
            }
            str += "\n";
        }
        return str;
    }

//    public static void main(String[] args) {
//        Graph graph = new AMatrixDirectedGraph(5);
//        graph.addEdge(0, 1);
//        graph.addEdge(0, 2);
//        graph.addEdge(0, 3);
//        graph.addEdge(1, 3);
//        graph.addEdge(2, 4);
//        graph.addEdge(3, 4);
//        graph.addEdge(4, 4);
//
//        System.out.println(graph);
//    }
}
