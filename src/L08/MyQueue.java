package L08;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyQueue<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] objects;
    private int size;
    private int indexToInsert;
    private int indexToRemove;
    /*
    * num1 num2 num3 num4 num5
    * add =0
    * remove=0
    * Queue.add(num1)
    * [num1,null,null,null,null]
    * add=1
    * remove=0
    * Queue.add(num2)
    * [num1,num2,null,null,null]
    * add=2
    *  remove=0
    * Queue.remove()
    * [null,num2,null,null,null]
    * add=2
    * remove=1
    * Queue.add(num3)
    *  [null,num2,num3,null,null]
    * add=3
    * remove=1
    * Queue.remove()
    * [null,null,num3,null,null]
    * add=3
    * remove=2
    * Queue.add(num4)
    * [null,null,num3,num4,null]
    * add=4
    * remove=2

     */





    public MyQueue() {
        this.objects =new Object[DEFAULT_CAPACITY];
        this.size=0;
        this.indexToInsert=this.indexToRemove=0;
    }

    public MyQueue(int capacity) {
        if(capacity<=0)
            throw new IllegalArgumentException();
        this.objects =new Object[capacity];
        this.size=0;
        this.indexToInsert=this.indexToRemove=0;
    }

    // insert()
    public synchronized boolean add(E e){
        if(size==objects.length)
            initialize();
        objects[indexToInsert]=e;
        indexToInsert =(indexToInsert+1)%objects.length;
        size++;
        // indexToInsert =(indexToInsert==objects.length)?0:indexToInsert+1 ;
       return true;

    }

    public E remove(){

       E item = peek();
        objects[indexToRemove]=null;
        indexToRemove =(indexToRemove+1)%objects.length;
        size--;
        return item;


    }
    // top()
    public E peek() {
        if (isEmpty())
            throw new NoSuchElementException();
        return (E) objects[indexToRemove];
    }

    public boolean isEmpty(){
        return size==0;
    }
private void initialize(){
    Object[] temp = new Object[objects.length+10];
    int sizeValues = this.size;
    for (int i = indexToRemove;sizeValues!=0; i=(i+1)%objects.length,sizeValues--) {
        temp[i]=objects[i];
    }
    objects=temp;
    indexToRemove=0;
    indexToInsert=size;
}
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        int sizeValues = this.size;
        for (int i = indexToRemove;sizeValues!=0; i=(i+1)%objects.length,sizeValues--) {
            s.append(objects[i]+((sizeValues==1)?"":", "));
        }
        s.append("]");
        return s.toString();
    }
}

