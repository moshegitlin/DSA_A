package L09;

import java.util.LinkedList;
import java.util.Queue;

public class Test {


    public static void main(String[] args) {
    Queue<Integer> q = new LinkedList<>() ;
        q.add(1);
        q.add(2);
        q.add(4);
        System.out.println(q);
        q.remove();
        System.out.println(q);
//
//        Node n = new Node(1);
//        n.next = new Node(2);
//        n.next.next=new Node(3);
//        n.next.next.next=new Node(4);
//        n.next.next.next.next=new Node(5);
//        n.next.next.next.next.next=new Node(6);
//
//        //head ->[11]->[7]->[5]->[3]->[2]->[1]->null
//        // temp=head;
//        // temp.next=null
//        //head=head.next
//        //head ->[7]->[5]->[3]->[2]->[1]->null
//
//
//        Node chain = new Node(1);
//        Node newNode = new Node(2);
//        newNode.next=chain;
//        chain=newNode;
//        newNode= new Node(3);
//        newNode.next=chain;
//        chain=newNode;

    }

    static class Node{
         int value;
         Node next;

        public Node(int value) {
            this.value = value;
            this.next=null;
        }
    }

}
