package graph;

import java.util.ArrayList;

/* Zad. 2 */
public class AListsUndirectedGraph implements Graph {
    protected int vertices;
    protected int edges = 0;
    protected final ArrayList<Integer>[] alists;

    public AListsUndirectedGraph(int vertices) {
        this.vertices = vertices;
        edges = 0;
        alists = new ArrayList[vertices];
        for (int i = 0; i < alists.length; i++) {
            alists[i] = new ArrayList<>();
        }
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
    }

    @Override
    public void addEdge(int vertex1, int vertex2) {
        if (vertex1 < 0 || vertex1 >= vertices) throw new IndexOutOfBoundsException();
        if (vertex2 < 0 || vertex2 >= vertices) throw new IndexOutOfBoundsException();

        if (!alists[vertex1].contains(vertex2) && !alists[vertex2].contains(vertex1)) {
            alists[vertex1].add(vertex2);
            alists[vertex2].add(vertex1);
            edges++;
        }
    }

    @Override
    public Iterable<Integer> vertices(int vertex) {
        if (vertex < 0 || vertex >= vertices) throw new IndexOutOfBoundsException();

        return alists[vertex];
    }

    @Override
    public String toString() {
        String str = "";
        str += vertices + " vertices, " + edges + " edges\n";
        for (int list = 0; list < vertices; list++) {
            str += list + ": ";
            for (int vertex : alists[list]) {
                str += vertex + " ";
            }
            str += "\n";
        }
        return str;
    }
}
