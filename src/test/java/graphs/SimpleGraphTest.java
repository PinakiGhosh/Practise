package test.java.graphs;

import main.java.graphs.Graph;

/**
 * Created by pinaki on 22/1/18.
 */
public class SimpleGraphTest {

    public static void main(String[] args) {
        Graph g=new Graph(4);

//        g.addEdge(2,0);
//        g.addEdge(0,2);
//        g.addEdge(0,1);
//        g.addEdge(1,2);
//        g.addEdge(2,3);
//        g.addEdge(3,3);
//        g.printAdjacencyMatrix();
//        g.printAdjacencyList();
//        System.out.println(g.bfs(2));
        g=new Graph(6);
        g.addEdge(0,1);
        g.addEdge(1,4);
        g.addEdge(4,2);
        g.addEdge(4,5);
        g.addEdge(2,3);
        System.out.println(g.bfs(0));

    }
}
