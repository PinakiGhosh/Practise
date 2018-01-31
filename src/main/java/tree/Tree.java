package tree;

import tree.exceptions.DuplicateElementException;

import java.util.ArrayList;

/**
 * Created by pinaki on 30/1/18.
 */
public interface Tree {

    public Node getRoot();
    public void insertNode(Node node) throws DuplicateElementException;
    public void insertNode(int data) throws DuplicateElementException;
    public void setRootNode(Node node);
    public void setRootNode(int data);
    public void deleteNode(int element);
    public boolean isElementPresent(int element);
    public ArrayList<Integer> preOrderTraversal();
    public ArrayList<Integer> postOrderTraversal();
    public ArrayList<Integer> inOrderTraversal();

}
