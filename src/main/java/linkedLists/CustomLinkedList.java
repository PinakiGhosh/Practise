package main.java.linkedLists;

import main.java.linkedLists.exceptions.ElementNotFoundException;
import main.java.linkedLists.exceptions.EmptyListException;

/**
 * Created by pinaki on 19/1/18.
 */
public interface CustomLinkedList<T> {

    public void addElementAtFirst(T data);
    public void addElementAtEnd(T data);
    public void addElementAfter(T data, T elementAfter) throws ElementNotFoundException, EmptyListException;
    public void deleteElementAtEnd() throws EmptyListException;
    public void deleteElementAtFirst() throws EmptyListException;
    public void deleteElement(T data) throws ElementNotFoundException, EmptyListException;
    public int deleteAllMatchingElements(T data) throws EmptyListException;
    public int size();
    public Node<T> getHeadValue();
    public Node<T> getLastValue();
}
