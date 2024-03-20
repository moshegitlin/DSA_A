package L08;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main {
    static Random rd = new Random();

    public static void main(String[] args) {
        

        Queue<Integer> q = new LinkedList<>() {{
            int size = rd.nextInt(10) + 2;
            for (int i = 0; i < size; i++)
                add(rd.nextInt(20));
        }};

        System.out.println(q);
        System.out.println(q.peek());
        System.out.println(q.poll());
        System.out.println(q.peek());
        System.out.println(q);
        //[ 1 ,2, 3 ,4,5,6,7] ->>
        //  |                  |
        //  r                  i
        //[ null ,null, 3 ,4,5,6,7]
        //   |          |
        //   i          r
        //add(8)
        //add(9)
        //[ 8 ,9, 3 ,4,5,6,7]
        //       ||
        //       ir
        //[ 8 ,9 ->>, 3 ,4,5,6,7]
        //       ||
        //       ir
        //add(10)
        //[ 8 ,9,10,null 3 ,4,5,6,7]
        //          |    |
        //          i    r

        System.out.println("---------------MyQueue------------------");
        MyQueue<Integer> mq = new MyQueue<>(14){{
            for (int i = -3; i <15 ; i++) {
            add(i);
            }
        }};
        System.out.println(mq);
        mq.remove();
        mq.remove();
        mq.remove();
        mq.remove();
        System.out.println(mq);

        mq.add(11);
        mq.add(12);
        mq.add(13);
        mq.add(14);

        System.out.println(mq);



    }
    private static boolean is_thor(Queue<Integer> q, int num){
        if(num <= 0){
            throw new IllegalArgumentException();
        }
        Queue<Integer> temp =  return_thor(num);
        while(!temp.isEmpty() && !q.isEmpty()){
            if(temp.poll() != q.poll()){
                return false;
            }
        }
        return !q.isEmpty() || !temp.isEmpty();
    }
    private static Queue<Integer> return_thor(int num){
        if(num <= 0){
            throw new IllegalArgumentException();
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <=num ; i++) {
            int element = (int) Math.pow(i, 2);
            for (int j = 0; j <element ; j++) {
                q.add(i);
            }
        }
        return q;
    }


}
