package main.java.graphs;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by pinaki on 22/1/18.
 */
public class Graph {

    private int vertices;
    private ArrayList<Integer>[] adjacencyList;
    private int[][] adjacencyMatrix;
    private boolean directed;

    public Graph(int vertices){
        this(vertices,true);
    }

    public Graph(int vertices,boolean directed){
        this.vertices=vertices;
        this.adjacencyMatrix=new int[vertices][vertices];
        this.directed=directed;
        initAdjacencyList();
    }

    private void initAdjacencyList(){
        this.adjacencyList= new ArrayList[this.vertices];
        for(int i=0;i<this.vertices;i++){
            this.adjacencyList[i]=new ArrayList<Integer>();
        }
    }

    public void addEdge(int v1,int v2){
        this.adjacencyMatrix[v1][v2]=1;
        this.adjacencyList[v1].add(v2);
        if(!this.directed){
            this.adjacencyMatrix[v2][v1]=1;
            this.adjacencyList[v2].add(v1);
        }
    }

    public void printAdjacencyMatrix(){
        for (int i=0;i<this.vertices;i++){
            for (int j=0;j<this.vertices;j++){
                System.out.print(this.adjacencyMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void printAdjacencyList(){
        for (int i=0;i<this.vertices;i++){
            System.out.println(i+ " -> "+this.adjacencyList[i]);
        }
    }

    public ArrayList<Integer> bfs(int startingVertex){
        boolean visited[] = new boolean[this.vertices];
        int parent[] = new int[this.vertices];
        ArrayList<Integer> bfsPath=new ArrayList<Integer>(),childNodes;
        bfsPath.add(startingVertex);
        visited[startingVertex]=true;
        int count=0,parentNode;
        while(nodesLeftToBeTraversed(visited)){
            parentNode=bfsPath.get(count);
            System.out.println("Parent node "+parentNode);
            count++;
            childNodes=this.adjacencyList[parentNode];
            for(int i : childNodes){
                if(!visited[i]){
                    bfsPath.add(i);
                    visited[i]=true;
                    parent[i]=parentNode;
                }
            }
        }
        return bfsPath;
    }

    public boolean nodesLeftToBeTraversed(boolean[] visited){
        boolean flag=false;
        for (int i=0;i<visited.length;i++){
            if(!visited[i]){
                flag=true;
                break;
            }
        }
        return flag;
    }

    public ArrayList<Integer> dfs(int startIndex){
        ArrayList<Integer> traversedPath=new ArrayList<Integer>();
        boolean visited[] = new boolean[this.vertices];
        visited[startIndex]=true;
        int lastTraversedNode=startIndex,nextNodeToTraverse;
        ArrayList<Integer> adjascentNodes;
        Stack<Integer> stack=new Stack<Integer>();
        stack.push(startIndex);
        traversedPath.add(startIndex);
        while (nodesLeftToBeTraversed(visited)){
            adjascentNodes=this.adjacencyList[lastTraversedNode];
            nextNodeToTraverse=getFirstNonTraversedNode(visited,adjascentNodes);
            if(nextNodeToTraverse!=-1){
                stack.push(nextNodeToTraverse);
                lastTraversedNode=nextNodeToTraverse;
                visited[lastTraversedNode]=true;
                traversedPath.add(lastTraversedNode);
            }else {
                lastTraversedNode=stack.pop();
            }
        }
        return traversedPath;
    }

    public int getFirstNonTraversedNode(boolean[] visited,ArrayList<Integer> adjacencyList){
        int node=-1;
        for(int i=0;i<adjacencyList.size();i++){
            if(!visited[adjacencyList.get(i)]){
                node=adjacencyList.get(i);
                break;
            }
        }
        return node;
    }
}
