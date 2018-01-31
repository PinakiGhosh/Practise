package main.java.tree;

import main.java.tree.exceptions.DuplicateElementException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by pinaki on 30/1/18.
 */
public class BST implements Tree{

    private Node root;

    public BST(){
        this.root=null;
    }

    public BST(int data){
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

    public Node getElement(int element){
        Node temp=this.root;
        boolean elementPresent=false;
        if(temp.getData()==element){
            elementPresent=true;
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
        if(!elementPresent){
            temp=null;
        }
        return temp;
    }

    public boolean isElementPresent(int element) {
        boolean elementPresent=false;
        Node n=getElement(element);
        if(n!=null){
            elementPresent=true;
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

    public ArrayList<Integer> bfs(){
        return bfsTraversal(this.getRoot());
    }

    public ArrayList<Integer> bfsTraversal(Node n){
        Queue<Node> listOfNodes=new LinkedList<>();
        ArrayList<Integer> traversedNodes=new ArrayList<>();
        listOfNodes.add(n);
        Node currentNode;
        while (listOfNodes.size()>0){
            currentNode=listOfNodes.peek();
            traversedNodes.add(currentNode.getData());
            if(currentNode.getlChild()!=null){
                listOfNodes.add(currentNode.getlChild());
            }
            if(currentNode.getrChild()!=null){
                listOfNodes.add(currentNode.getrChild());
            }
            listOfNodes.remove();
        }
        return traversedNodes;
    }

    public ArrayList<Integer> dfs(){
        return dfsTraversal(this.getRoot());
    }

    public ArrayList<Integer> dfsTraversal(Node n){
        Stack<Node> listOfNodes=new Stack<>();
        ArrayList<Integer> traversedNodes=new ArrayList<>();
        listOfNodes.add(n);
        Node currentNode;
        while (listOfNodes.size()>0){
            currentNode=listOfNodes.pop();
            traversedNodes.add(currentNode.getData());
            if(currentNode.getrChild()!=null){
                listOfNodes.add(currentNode.getrChild());
            }
            if(currentNode.getlChild()!=null){
                listOfNodes.add(currentNode.getlChild());
            }
        }
        return traversedNodes;
    }


    public int getHeightOfTree(Node node){
        int level=0;
        if(node==null){
            level=0;
        }else{
            int leftHeight=getHeightOfTree(node.getlChild());
            int rightHeight=getHeightOfTree(node.getrChild());
            level = leftHeight > rightHeight ? leftHeight : rightHeight;
            level=level+1;
        }
        return level;
    }

    public Node getLowestCommonAncestor(int value1,int value2){
        return lcaImpl2(value1,value2,this.root);
//        return lcaImpl(value1,value2,this.root);
    }

    public Node lcaImpl(int value1,int value2,Node n){
        if(n.getData()>value1 && n.getData()>value2){
            return lcaImpl(value1,value2,n.getlChild());
        }else if(n.getData()<value1 && n.getData()<value2){
            return lcaImpl(value1,value2,n.getrChild());
        }else{
            return n;
        }
    }

    public Node lcaImpl2(int value1,int value2,Node n){
        int currentNodeData=n.getData();
        if(value1==currentNodeData || value2==currentNodeData){
            return n;
        }else{
            ArrayList<Integer> arr=traversePreorder(n.getlChild());
            if(arr.contains(value1) && arr.contains(value2)){
                return lcaImpl2(value1,value2,n.getlChild());
            }else {
                ArrayList<Integer> arr1=traversePreorder(n.getrChild());
                if(arr1.contains(value1) && arr1.contains(value2)){
                    return lcaImpl2(value1,value2,n.getrChild());
                }
                else{
                    return n;
                }
            }
        }
    }

    public int findDistance(int value1,int value2){
        Node n1=getElement(value1);
        Node n2=getElement(value2);
        return distance(this.root, n1) + distance(this.root, n2) - 2*distance(this.root, getLowestCommonAncestor(value1,value2));
    }

    public int findLevel(int val){
        return findLevelImpl(this.root,val,0);
    }

    public int findLevelImpl(Node n,int val,int level){
        if(n==null){
            return -1;
        }
        else if(n.getData()==val){
            return level;
        }else{
            int l=findLevelImpl(n.getlChild(),val,level+1);
            if(l!=-1){
                return l;
            }else{
                return findLevelImpl(n.getrChild(),val,level+1);
            }
        }
    }

    public int distance(Node n1,Node n2){
//        distance(n1, n2) = distance(root, n1) + distance(root, n2) - 2*distance(root, lca);
        int distance=-1;
        if(n1.getData()==n2.getData()){
            return 0;
        }else {
            distance=findLevel(n1.getData()) + findLevel(n2.getData()) - 2*findLevel(getLowestCommonAncestor(n1.getData(),n2.getData()).getData());
        }
        return distance;
    }

}
