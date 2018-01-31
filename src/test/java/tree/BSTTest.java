package test.java.tree;

import main.java.tree.BST;
import main.java.tree.exceptions.DuplicateElementException;

/**
 * Created by pinaki on 30/1/18.
 */
public class BSTTest {

    public static void main(String[] args) throws DuplicateElementException {
        BST bst=new BST();
        bst.insertNode(10);
        bst.insertNode(5);
        bst.insertNode(15);
        bst.insertNode(2);
        bst.insertNode(7);
        bst.insertNode(13);
        bst.insertNode(18);
        bst.insertNode(6);
//        System.out.println(bst.bfs());
//        System.out.println(bst.dfs());
//        System.out.println(bst.inOrderTraversal());
//        System.out.println(bst.postOrderTraversal());
//        System.out.println(bst.preOrderTraversal());
//        System.out.println(bst.getLowestCommonAncestor(13,18));
//        System.out.println(bst.getLowestCommonAncestor(2,6));
//        System.out.println(bst.getLowestCommonAncestor(18,6));
//        System.out.println(bst.findLevel(18));
//        System.out.println(bst.findLevel(10));
//        System.out.println(bst.findLevel(5));
        System.out.println(bst.findDistance(2,18));
    }
}
