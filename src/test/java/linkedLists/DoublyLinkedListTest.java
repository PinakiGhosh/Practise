package test.java.linkedLists;

import main.java.linkedLists.DoublyLinkedList;
import main.java.linkedLists.exceptions.ElementNotFoundException;
import main.java.linkedLists.exceptions.EmptyListException;

/**
 * Created by pinaki on 22/1/18.
 */
public class DoublyLinkedListTest {

    public static void main(String[] args) throws ElementNotFoundException, EmptyListException {
        DoublyLinkedList<Integer> doublyLinkedList=new DoublyLinkedList<Integer>();

        doublyLinkedList.addElementAtFirst(1);
        doublyLinkedList.addElementAtFirst(0);
        doublyLinkedList.addElementAtFirst(0);
        doublyLinkedList.addElementAtEnd(4);
        doublyLinkedList.addElementAfter(2,1);
        doublyLinkedList.addElementAfter(5,4);
        System.out.println(doublyLinkedList);

        doublyLinkedList.deleteElementAtEnd();
        doublyLinkedList.deleteElementAtFirst();
        System.out.println(doublyLinkedList);

        doublyLinkedList.deleteElement(2);
        System.out.println(doublyLinkedList);

        doublyLinkedList.addElementAtFirst(0);
        doublyLinkedList.addElementAtFirst(0);
        doublyLinkedList.addElementAtFirst(0);
        doublyLinkedList.addElementAtEnd(0);
        doublyLinkedList.addElementAtEnd(0);
        doublyLinkedList.addElementAtEnd(0);
        System.out.println(doublyLinkedList);
        System.out.println(doublyLinkedList.deleteAllMatchingElements(0));
        System.out.println(doublyLinkedList);

    }
}
