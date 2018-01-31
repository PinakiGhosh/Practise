package graphs;

/**
 * Created by pinaki on 30/1/18.
 */
public class DFS {

    public static void main(String[] args) {
        Graph g=new Graph(8,false);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,3);
        g.addEdge(1,4);
        g.addEdge(4,7);
        g.addEdge(7,5);
        g.addEdge(7,6);
        g.addEdge(5,2);
        g.addEdge(3,6);
//        g.printAdjacencyList();
        System.out.println(g.dfs(0));
    }
}
