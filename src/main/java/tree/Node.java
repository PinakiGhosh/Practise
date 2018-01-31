package main.java.tree;

/**
 * Created by pinaki on 30/1/18.
 */
public class Node {

    private int data;
    private Node lChild;
    private Node rChild;

    Node(int data){
        this.data=data;
        this.lChild=null;
        this.rChild=null;
    }

    public int getData() {
        return data;
    }

    public Node getlChild() {
        return lChild;
    }

    public void setlChild(Node lChild) {
        this.lChild = lChild;
    }

    public Node getrChild() {
        return rChild;
    }

    public void setrChild(Node rChild) {
        this.rChild = rChild;
    }

    public String toString(){
        String lpointer=null,rpointer=null;
        if(this.lChild!=null){
            lpointer=this.lChild.getData()+"";
        }
        if(this.rChild!=null){
            rpointer=this.rChild.getData()+"";
        }
        return lpointer+"<-"+this.data+"->"+rpointer;
    }
}
