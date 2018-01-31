package linkedLists;

import java.io.Serializable;

/**
 * Created by pinaki on 19/1/18.
 */
public class Node<T> implements Serializable{

    private Node leftPointer,rightPointer;
    private T data;

    public Node(T data){
        this.data=data;
        this.leftPointer=null;
        this.rightPointer=null;
    }

    public Node(){
        this.data=null;
        this.leftPointer=null;
        this.rightPointer=null;
    }

    public Node getLeftPointer() {
        return leftPointer;
    }

    public void setLeftPointer(Node leftPointer) {
        this.leftPointer = leftPointer;
    }

    public Node getRightPointer() {
        return rightPointer;
    }

    public void setRightPointer(Node rightPointer) {
        this.rightPointer = rightPointer;
    }

    public T getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = (T)data;
    }

    public String toString(){
        String lpointer=null,rpointer=null;
        if(this.leftPointer!=null){
            lpointer=this.getLeftPointer().getData().toString();
        }
        if(this.rightPointer!=null){
            rpointer=this.getRightPointer().getData().toString();
        }
        return lpointer+"<-"+this.data.toString()+"->"+rpointer;
    }
}
