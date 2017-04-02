package graph;

/* Zad. 2 */
public class AListsDirectedGraph extends AListsUndirectedGraph {
    public AListsDirectedGraph(int vertices) {
        super(vertices);
    }

    @Override
    public void addEdge(int vertex1, int vertex2) {
        if (vertex1 < 0 || vertex1 >= vertices) throw new IndexOutOfBoundsException();
        if (vertex2 < 0 || vertex2 >= vertices) throw new IndexOutOfBoundsException();

        if (!alists[vertex1].contains(vertex2)) {
            alists[vertex1].add(vertex2);
            edges++;
        }
    }
}
