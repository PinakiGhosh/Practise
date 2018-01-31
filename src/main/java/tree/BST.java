package main.java.tree;

import main.java.tree.exceptions.DuplicateElementException;

import java.util.ArrayList;

/**
 * Created by pinaki on 30/1/18.
 */
public class BST implements Tree{

    private Node root;

    public BST(){
        this.root=null;
    }

    BST(int data){
        Node node=new Node(data);
        this.root=node;
    }

    public Node getRoot() {
        return this.root;
    }

    public void insertNode(Node node) throws DuplicateElementException {
        if(this.root==null){
            setRootNode(node);
        }else{
            Node temp=this.root;
            while (true){
                if(temp.getData() > node.getData()){
                    if(temp.getlChild()==null){
                        temp.setlChild(node);
                        break;
                    }else{
                        temp=temp.getlChild();
                    }
                }else if(temp.getData() < node.getData()){
                    if(temp.getrChild()==null){
                        temp.setrChild(node);
                        break;
                    }else{
                        temp=temp.getrChild();
                    }
                }else {
                    throw new DuplicateElementException("Element "+node.getData()+ " already present");
                }
            }
        }
    }

    public void insertNode(int data) throws DuplicateElementException{
        Node node=new Node(data);
        insertNode(node);
    }

    public void setRootNode(Node node) {
        this.root=node;
    }

    public void setRootNode(int data) {
        Node node=new Node(data);
        setRootNode(node);
    }

    public void deleteNode(int element) {

    }

    public boolean isElementPresent(int element) {
        Node temp=this.root;
        boolean elementPresent=false;
        if(this.root.getData()==element){
            return true;
        }
        while (true){
            if(temp.getData() > element){
                if(temp.getlChild()==null){
                    break;
                }else{
                    temp=temp.getlChild();
                }
            }else if(temp.getData() < element){
                if(temp.getrChild()==null){
                    break;
                }else{
                    temp=temp.getrChild();
                }
            }else {
                elementPresent=true;
                break;
            }
        }
        return elementPresent;
    }

    public ArrayList<Integer> preOrderTraversal() {
        return traversePreorder(this.root);
    }

    public ArrayList<Integer> postOrderTraversal() {
        return traversePostorder(this.root);
    }

    public ArrayList<Integer> inOrderTraversal() {
        return traverseInorder(this.root);
    }

    protected ArrayList<Integer> traverseInorder(Node start){
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(start.getlChild()==null && start.getrChild()==null){
            list.add(start.getData());
        }else{
            if(start.getlChild()!=null){
                list.addAll(traverseInorder(start.getlChild()));
            }
            list.add(start.getData());
            if(start.getrChild()!=null){
                list.addAll(traverseInorder(start.getrChild()));
            }
        }
        return list;
    }

    protected ArrayList<Integer> traversePreorder(Node start){
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(start.getlChild()==null && start.getrChild()==null){
            list.add(start.getData());
        }else{
            list.add(start.getData());
            if(start.getlChild()!=null){
                list.addAll(traversePreorder(start.getlChild()));
            }
            if(start.getrChild()!=null){
                list.addAll(traversePreorder(start.getrChild()));
            }
        }
        return list;
    }

    protected ArrayList<Integer> traversePostorder(Node start){
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(start.getlChild()==null && start.getrChild()==null){
            list.add(start.getData());
        }else{
            if(start.getlChild()!=null){
                list.addAll(traversePostorder(start.getlChild()));
            }
            if(start.getrChild()!=null){
                list.addAll(traversePostorder(start.getrChild()));
            }
            list.add(start.getData());
        }
        return list;
    }

    public ArrayList<Integer> bfsTraversal(){
        return null;
    }

    public int getLevelOfTree(Node node){
        int level=0;
        if(node==null){
            level=0;
        }else{
            int leftHeight=getLevelOfTree(node.getlChild());
            int rightHeight=getLevelOfTree(node.getrChild());
            level = leftHeight > rightHeight ? leftHeight : rightHeight;
        }
        return level+1;
    }



}
