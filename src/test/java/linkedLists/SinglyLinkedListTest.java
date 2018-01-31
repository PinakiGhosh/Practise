package linkedLists;

import linkedLists.exceptions.ElementNotFoundException;
import linkedLists.exceptions.EmptyListException;

import java.io.IOException;

/**
 * Created by pinaki on 19/1/18.
 */
public class SinglyLinkedListTest{

    public static void main(String[] args) throws EmptyListException, ElementNotFoundException, IOException, ClassNotFoundException {
        SinglyLinkedList<Integer> singlyLinkedList=new SinglyLinkedList<Integer>();

        singlyLinkedList.addElementAtFirst(1);
        singlyLinkedList.addElementAtFirst(0);
        singlyLinkedList.addElementAfter(2,0);
        System.out.println(singlyLinkedList);

        System.out.println(singlyLinkedList instanceof CustomLinkedList);

        String outFileName="/home/pinaki/sll.ser";

        singlyLinkedList.serialize(outFileName);

        SinglyLinkedList<Integer> sll= (SinglyLinkedList<Integer>) SinglyLinkedList.deSerialise(outFileName);
        System.out.println(sll);
        /*
        singlyLinkedList.deleteElementAtFirst();
        singlyLinkedList.deleteElement(2);

        singlyLinkedList.addElementAtEnd(1);
        singlyLinkedList.addElementAtEnd(1);
        singlyLinkedList.addElementAtEnd(1);
        System.out.println(singlyLinkedList);

        System.out.println(singlyLinkedList.deleteAllMatchingElements(1));

        System.out.println(singlyLinkedList);

        singlyLinkedList.addElementAtEnd(2);
        //singlyLinkedList.deleteElement(1);
        */
    }
}
