package training;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import static training.func.*;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> q =new LinkedList<>(){{
            for (int i=1; i<7; i++){
                add(i);
            }
        }};
//        System.out.println(q);
//        System.out.println(size(q));
//        System.out.println(q);
        Stack<Integer> s = new Stack<>(){{
            for (int i=1; i<7; i++){
                push(i);
            }
        }};
        Stack<Integer> s2 = new Stack<>(){{
            for (int i=5; i<10; i++){
                push(i);
            }
        }};
        Stack<Integer> s3 = new Stack<>(){{
            for (int i=10; i<20; i++){
                push(i);
            }
        }};
//        System.out.println(s);
//        System.out.println(size(s));
//        System.out.println(s);
        Queue<Character> q1 =new LinkedList<>(){{
            for (int i=0; i<8; i++){
                add((char) ('A'+ i));
            }
        }};
//        System.out.println(q1);
//        System.out.println(CloneQueue(q1));
//        System.out.println(q1);

        Stack<String> s1 = new Stack<>(){{
            push("moshe");
            push("david");
            push("liad");
            push("avi");

        }};
//        System.out.println(s1);
//        System.out.println(getStringLength(s1));
//        System.out.println(s1);

//        System.out.println(s.peek());
//        System.out.println(s2.peek());
//        System.out.println(s3.peek());
        Stack<Integer>[] stacks = new Stack[3];
        stacks[0] = s;
        stacks[1] = s2;
        stacks[2] = s3;
//
//        System.out.println(getTopsSum(stacks));
        String str ="((a+b)+c)*[2*(5-a)]";
        String str1 ="q-(r-(s+2))*q)";
        String str2 ="(a-(i) (a*3]]+[a+]]*[b-";
        String str3 ="((a+b)*(g-k))";

//        System.out.println(IsBracketBalanced(str));
//        System.out.println(IsBracketBalanced(str1));
//        System.out.println(IsBracketBalanced(str2));
//        System.out.println(IsBracketBalanced(str3));
        Q19();
    }

}
