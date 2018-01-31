package main.java.linkedLists;

import main.java.linkedLists.exceptions.ElementNotFoundException;
import main.java.linkedLists.exceptions.EmptyListException;

/**
 * Created by pinaki on 19/1/18.
 */
public class SinglyLinkedList<T> extends CustomAbstractLinkedList<T> implements CustomLinkedList<T> {

    public SinglyLinkedList(){
        this.head=null;
        this.lastNode=null;
        this.size=0;
    }

    public void addElementAtFirst(T data) {
        Node<T> node=new Node<T>(data);
        if(this.head==null){
            this.head=node;
        }
        if(this.lastNode==null){
            this.lastNode=node;
        }else{
            node.setRightPointer(head);
            this.head=node;
        }
        incrementSize();
    }

    public void addElementAtEnd(T data){
        Node<T> node=new Node<T>(data);
        if(this.head==null){
            this.head=node;
        }
        if(this.lastNode==null){
            this.lastNode=node;
        }else{
            this.lastNode.setRightPointer(node);
            this.lastNode=node;
        }
        incrementSize();
    }

    public void addElementAfter(T data, T elementAfter) throws ElementNotFoundException, EmptyListException {
        checkIfEmptyAndThrowException();
        Node<T> temp=head;
        boolean elementFound=false;
        while (temp!=null){
            if(temp.getData()==elementAfter){
                elementFound=true;
                break;
            }else{
                temp=temp.getRightPointer();
            }
        }
        if(elementFound){
            Node<T> newNode= new Node<T>(data);
            newNode.setRightPointer(temp.getRightPointer());
            temp.setRightPointer(newNode);
            incrementSize();
        }else{
            throw new ElementNotFoundException("Element "+elementAfter+ "not found in the list");
        }
    }

    public void deleteElementAtEnd() throws EmptyListException{
        checkIfEmptyAndThrowException();
        Node<T> temp=head;
        if(this.size==1){
            deleteElementAtFirst();
        }else{
            while(temp.getRightPointer().getRightPointer()!=null){
                temp=temp.getRightPointer();
            }
            temp.setRightPointer(null);
        }
        decrementSize();
    }

    public void deleteElementAtFirst() throws EmptyListException {
        checkIfEmptyAndThrowException();
        this.head=this.head.getRightPointer();
        decrementSize();
    }

    public void deleteElement(T data) throws EmptyListException, ElementNotFoundException {
        checkIfEmptyAndThrowException();
        Node<T> temp=this.head;
        if(this.head.getData()==data){
            if(this.size==1){
                this.head=null;
            }else{
                this.head=this.head.getRightPointer();
            }
        }else if(this.size()==1 && this.head.getData()!=data){
            throw new ElementNotFoundException("Element "+data+" not found");
        }
        else {
            boolean matched=false;
            while (temp!=null){
                if(temp.getRightPointer().getData()==data){
                    temp.setRightPointer(temp.getRightPointer());
                    matched=true;
                    break;
                }
            }
            if(!matched){
                throw new ElementNotFoundException("Element not found exception");
            }
        }
        decrementSize();
    }

    public int deleteAllMatchingElements(T data) throws EmptyListException{
        checkIfEmptyAndThrowException();
        Node<T> temp=head;
        int count=0;
        if(head.getData()==data){
            if(this.size==1){
                this.head=null;
                count=1;
                decrementSize();
            }else{
                while (this.head!=null){
                    if(this.head.getData()==data){
                        this.head=this.head.getRightPointer();
                        count++;
                        decrementSize();
                    }else{
                        break;
                    }
                }
            }
        }else {
            while (temp!=null){
                if(temp.getRightPointer().getData()==data){
                    temp.setRightPointer(temp.getRightPointer());
                    decrementSize();
                    count++;
                }
            }
        }
        return count;
    }
}
