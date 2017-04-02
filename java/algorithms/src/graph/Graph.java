package graph;

/**
 * Graph interface.
 */
public interface Graph {
    /**
     * Returns number of graph's vertices.
     *
     * @return number of vertices
     */
    public int getNumberOfVertices();

    /**
     * Returns number of graph's edges.
     *
     * @return number of edges.
     */
    public int getNumberOfEdges();

    /**
     * Adds edge connecting @p vertex1 and @p vertex2.
     *
     * @param vertex1 first vertex
     * @param vertex2 second vertex
     */
    public void addEdge(int vertex1, int vertex2);

    /**
     * Increase number of vertices.
     */
    public void addVertex();

    /**
     * Returns adjacent vertices.
     *
     * @param v beginning vertex
     * @return returns adjacent vertices
     */
    public Iterable<Integer> vertices(int v);
}
