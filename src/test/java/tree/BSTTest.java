package tree;

import tree.exceptions.DuplicateElementException;

/**
 * Created by pinaki on 30/1/18.
 */
public class BSTTest {

    public static void main(String[] args) throws DuplicateElementException {
        BST bst=new BST();
//        bst.insertNode(7);
//        bst.insertNode(5);
//        bst.insertNode(9);
//        bst.insertNode(3);
//        bst.insertNode(6);
//        bst.insertNode(8);
//        bst.insertNode(10);
//        System.out.println(bst.inOrderTraversal());
//        System.out.println(bst.preOrderTraversal());
//        System.out.println(bst.postOrderTraversal());

        bst.insertNode(1);
        bst.insertNode(2);
        bst.insertNode(5);
        bst.insertNode(3);
        bst.insertNode(6);
        bst.insertNode(4);
        System.out.println(bst.getLevelOfTree(bst.getRoot()));
        System.out.println(bst.getLevelOfTree(bst.getRoot().getrChild().getrChild().getlChild().getlChild()));

    }
}
