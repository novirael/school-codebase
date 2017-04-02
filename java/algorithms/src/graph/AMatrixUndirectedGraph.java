package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Zad. 2 */
public class AMatrixUndirectedGraph implements Graph {
    protected int vertices;
    protected int edges = 0;
    protected int[][] matrix;

    public AMatrixUndirectedGraph(int vertices) {
        this.vertices = vertices;
        edges = 0;
        matrix = new int[vertices][vertices];
    }

    public static int[][] cloneArray(int[][] src, int newLength) {
        int[][] target = new int[newLength][newLength];
        for (int i = 0; i < newLength -1; i++) {
            System.arraycopy(src[i], 0, target[i], 0, src[i].length);
        }
        return target;
    }

    @Override
    public int getNumberOfVertices() {
        return vertices;
    }

    @Override
    public int getNumberOfEdges() {
        return edges;
    }

    public void addVertex() {
        this.vertices += 1;
        this.matrix = cloneArray(this.matrix, this.vertices);
    }

    @Override
    public void addEdge(int vertex1, int vertex2) {
        if (vertex1 < 0 || vertex1 >= vertices) throw new IndexOutOfBoundsException();
        if (vertex2 < 0 || vertex2 >= vertices) throw new IndexOutOfBoundsException();

        if (matrix[vertex1][vertex2] == 0 && matrix[vertex2][vertex1] == 0) {
            matrix[vertex1][vertex2] = 1;
            matrix[vertex2][vertex1] = 1;
            edges++;
        }
    }

    @Override
    public Iterable<Integer> vertices(int vertex) {
        if (vertex < 0 || vertex >= vertices) throw new IndexOutOfBoundsException();

        List<Integer> list = new ArrayList<>();

        for (int ver = 0; ver < matrix[vertex].length; ver++) {
            if (ver != vertex && matrix[vertex][ver] != 0)
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
                str += ver2 + " ";
            }
            str += "\n";
        }
        return str;
    }
}
