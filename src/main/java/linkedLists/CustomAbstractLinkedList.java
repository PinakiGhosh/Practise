package main.java.linkedLists;

import main.java.linkedLists.exceptions.EmptyListException;

import java.io.*;

/**
 * Created by pinaki on 19/1/18.
 */
abstract class CustomAbstractLinkedList<T> implements Serializable{

    protected int size;
    protected Node<T> head,lastNode;

    public int size(){
        return this.size;
    }

    public Node<T> getHeadValue(){
        return this.head;
    }

    public Node<T> getLastValue(){
        return this.lastNode;
    }

    protected void incrementSize(){
        this.size++;
    }

    protected void decrementSize(){
        this.size--;
    }

    protected void checkIfEmptyAndThrowException() throws EmptyListException {
        if(this.size==0){
            throw new EmptyListException("List is empty");
        }
    }

    protected boolean isEmpty(){
        return this.size==0;
    }

    public String toString(){
        StringBuffer stringBuffer=new StringBuffer("");
        Node<T> temp=this.head;
        while (temp!=null){
            if(temp.getRightPointer()!=null && temp.getLeftPointer()!=null){
                stringBuffer.append(temp.getData().toString()+"<->");
            }else {
                stringBuffer.append(temp.getData().toString()+"->");
            }
            /*
            else if (temp.getLeftPointer()==null && temp.getRightPointer()!=null){
                stringBuffer.append(temp.getData().toString()+"->");
            }else if(temp.getLeftPointer()!=null && temp.getRightPointer()==null){
                stringBuffer.append(temp.getData().toString()+"<-");
            }*/
            temp=temp.getRightPointer();
        }
        stringBuffer.append("null");
        return stringBuffer.toString();
    }

    public void serialize(String outputFileName) throws IOException{
        FileOutputStream fileOut =new FileOutputStream(outputFileName);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(this);
        out.close();
        fileOut.close();
        System.out.println("Serialized data is saved in "+outputFileName);
    }

    public static CustomLinkedList deSerialise(String inputFileName) throws IOException,ClassNotFoundException{
        FileInputStream fileIn = new FileInputStream(inputFileName);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        CustomLinkedList sll = (CustomLinkedList) in.readObject();
        in.close();
        fileIn.close();
        return sll;
    }

//    public T[] toArray(){
//        T[] returnArray= (T[])new Object[this.size()];
//        Node<T> temp=this.head;
//        int count=0;
//        while (temp!=null){
//            returnArray[count]=temp.getData();
//            temp=temp.getRightPointer();
//            count++;
//        }
//        return returnArray;
//    }
}
