package linkedLists;

import linkedLists.exceptions.ElementNotFoundException;
import linkedLists.exceptions.EmptyListException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pinaki on 19/1/18.
 */
public class DoublyLinkedList<T> extends CustomAbstractLinkedList<T> implements CustomLinkedList<T>{

    public void addElementAtFirst(T data) {
        Node<T> node= new Node<T>(data);
        if(this.head==null){
            this.head=node;
        }else{
            node.setRightPointer(this.head);
            this.head.setLeftPointer(node);
            this.head=node;
        }
        incrementSize();
    }

    public void addElementAtEnd(T data) {
        Node<T> node= new Node<T>(data);
        if(this.head==null){
            this.head=node;
        }else{
            Node<T> temp = this.head;
            while (temp.getRightPointer()!=null){
                temp=temp.getRightPointer();
            }
            node.setLeftPointer(temp);
            temp.setRightPointer(node);
        }
        incrementSize();
    }

    public void addElementAfter(T data, T elementAfter) throws ElementNotFoundException, EmptyListException {
        checkIfEmptyAndThrowException();
        Node<T> node= new Node<T>(data);
        boolean elementFound=false;
        Node<T> temp = this.head;
        while (temp!=null){
            if(temp.getData()==elementAfter){
                elementFound=true;
                break;
            }else{
                temp=temp.getRightPointer();
            }
        }
        if(elementFound){
            node.setRightPointer(temp.getRightPointer());
            node.setLeftPointer(temp);
            if(temp.getRightPointer()!=null){
                temp.getRightPointer().setLeftPointer(node);
            }
            temp.setRightPointer(node);
            incrementSize();
        }else{
            throw new ElementNotFoundException("Element "+elementAfter+" not found");
        }
    }

    public void deleteElementAtEnd() throws EmptyListException {
        checkIfEmptyAndThrowException();
        Node<T> temp = this.head;
        while (temp.getRightPointer()!=null){
            temp=temp.getRightPointer();
        }
        temp.getLeftPointer().setRightPointer(null);
        decrementSize();
    }

    public void deleteElementAtFirst() throws EmptyListException {
        checkIfEmptyAndThrowException();
        this.head=this.head.getRightPointer();
        this.head.setLeftPointer(null);
        decrementSize();
    }

    public void deleteElement(T data) throws ElementNotFoundException, EmptyListException {
        checkIfEmptyAndThrowException();
        if(this.head.getData()==data){
            deleteElementAtFirst();
        }else {
            Node<T> temp=this.head;
            boolean elementFound=false;
            while (temp!=null){
                if(temp.getData()==data){
                    elementFound=true;
                    break;
                }else {
                    temp=temp.getRightPointer();
                }
            }
            if(elementFound){
                temp.getLeftPointer().setRightPointer(temp.getRightPointer());
                if(temp.getRightPointer()!=null){
                    temp.getRightPointer().setLeftPointer(temp.getLeftPointer());
                }
                decrementSize();
            }else{
                throw new ElementNotFoundException("Element "+data+" not found");
            }
        }
    }

    public int deleteAllMatchingElements(T data) throws EmptyListException {
        checkIfEmptyAndThrowException();
        int count=0;
        Node<T> temp=this.head;
        while (temp.getData()==data){
            temp=temp.getRightPointer();
            temp.setLeftPointer(null);
            this.head=temp;
            count++;
            decrementSize();
        }
        while (temp!=null){
            if(temp.getData()==data){
                temp.getLeftPointer().setRightPointer(temp.getRightPointer());
                if(temp.getRightPointer()!=null){
                    temp.getRightPointer().setLeftPointer(temp.getLeftPointer());
                }
                count++;
                decrementSize();
            }
            temp=temp.getRightPointer();
        }
        return count;
    }

    public List<String> getValuesAsList(){
        List<String> list=new ArrayList<String>();
        Node<T> temp=this.head;
        while (temp!=null){
            list.add(temp.toString());
            temp=temp.getRightPointer();
        }
        return list;
    }
}
