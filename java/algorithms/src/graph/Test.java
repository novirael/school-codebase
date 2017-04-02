package graph;

public class Test {

    public static void AListUndirectedGraphTest() {
        Graph graph = new AListsUndirectedGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        System.out.println(graph);
    }

    public static void AListsDirectedGraphTest() {
        Graph graph = new AListsDirectedGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 4);

        System.out.println(graph);
    }

    public static void AMatrixUndirectedGraphTest() {
        Graph graph = new AMatrixUndirectedGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        System.out.println(graph);

        graph.addVertex();
        graph.addEdge(5, 0);
        System.out.println(graph);

    }

    public static void AMatrixDirectedGraphTest() {
        Graph graph = new AMatrixDirectedGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 4);

        System.out.println(graph);
    }

    public static void main(String[] args) {
        AListUndirectedGraphTest();
        AListsDirectedGraphTest();
        AMatrixUndirectedGraphTest();
        AMatrixDirectedGraphTest();
    }
}
