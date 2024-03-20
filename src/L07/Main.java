package L07;

import java.util.Random;
import java.util.Stack;

public class Main {

    static Random rd = new Random();
    public static void main(String[] args) {
//        Stack<Integer> st = new Stack<>(){{
//            for (int i = 0; i < 5; i++) {
//                push(i);
//            }
//        }};
//
//        System.out.println(st);
//
//        String s = "1*(2-6)+(6*(2-1))";
//        boolean bool;
//        System.out.println(s);
//        bool = balancedBrackets(s);
//        System.out.println("balancedBrackets -> "+bool);
//        for (int i = 0; i < 10; i++) {
//            s="";
//            for (int j = 0; j < 10; j++) {
//                s+=(rd.nextBoolean())?"(":")";
//            }
//            System.out.println(s);
//            bool = balanced(s);
//            System.out.println("balance -> "+bool);
//            bool = balancedBrackets(s);
//            System.out.println("balancedBrackets -> "+bool);
//        }
//
        MyStack<Integer> mst = new MyStack<>();
        for (int i = 1; i < 8 ; i++) {
            mst.push(i);
        }

        System.out.println(mst);
        System.out.println(mst.RemoveItemAt(10));
        System.out.println(mst);
        Stack <Integer> st = new Stack<>(){{
            push(2);
            push(6);
            push(5);
            push(3);

        }};
        Stack <Integer> st1 = new Stack<>(){{
            push(2);
            push(6);
            push(5);
            push(1);

        }};
//        System.out.println(st);
//        System.out.println(getKthFromTop3(st, 3));
//        System.out.println(st);
//        System.out.println(Q3(st1));

    }
    private static boolean balanced(String s) {
    if(s==null || s.isEmpty() || s.length()%2!=0 || s.charAt(0)!='(')
        return false;
        //((())
        // st -> (
        //(()))
        // st -> (
        // ())(
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='(')
                st.push('(');
            else if(st.isEmpty())
                return false;
            else
                st.pop();
        }

        return st.isEmpty() ;
    }

    private static boolean balancedBrackets(String s) {
        if(s==null || s.length()==0)
            return false;

        // 1*(2-6)+(6*(2-1)))
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='(')
                st.push('(');
            else if(st.isEmpty() && s.charAt(i)==')' )
                return false;
            else if(s.charAt(i)==')')
                st.pop();
        }
        return st.isEmpty() ;
    }
    public static void rearrangeStack(Stack<Integer> stack) throws Exception {
        if (stack.isEmpty()) { // בדיקה אם המחסנית ריקה
            throw new Exception("The stack is empty");
        }

        int min = Integer.MAX_VALUE; // הגדרת משתנה למציאת הערך הקטן ביותר
        int max = Integer.MIN_VALUE; // הגדרת משתנה למציאת הערך הגדול ביותר

        // מציאת הערך הקטן ביותר והגדול ביותר במחסנית
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (current < min) {
                min = current;
            }
            if (current > max) {
                max = current;
            }
            temp.push(current);
        }
        stack.push(min);
        // יצירת מחסנית זמנית

        // העברת הערכים הקטנים מהמחסנית המקורית למחסנית הזמנית
        while (!temp.isEmpty()) {
            int current = temp.pop();
            if (current != min && current != max) {
                stack.push(current);
            }
        }

        // העברת הערך הגדול ביותר לתחתית המחסנית המקורית
        stack.push(max);
    }
    /**
     * This function returns the kth element from the top of the stack.
     * It throws a RuntimeException if the stack is empty or if k is larger than the stack size.
     * The function does not modify the original stack.
     *
     * @param stack The original stack.
     * @param k The position from the top of the stack.
     * @return The kth element from the top of the stack.
     * @throws RuntimeException if the stack is empty or if k is larger than the stack size.
     **/
    public static char getKthFromTopC(Stack<Character> stack, int k) {
        if (stack.isEmpty() || k < 0) {
            throw new RuntimeException("k is bigger than the stack size");
        }
        Stack<Character> temp = new Stack<>();
        char c = ' ';
        while (!stack.isEmpty() && k > 0) {
            c = stack.pop();
            temp.push(c);
            k--;
        }
        if (k > 0)
            throw new RuntimeException("k is bigger than the stack size");
        while (!temp.isEmpty()) {
            stack.push(temp.pop());

        }
        return c;
    }
    public static int getKthFromTop(Stack<Integer> stack, int k) {
        System.out.println();
        if (stack.isEmpty() || k < 0) {
            throw new RuntimeException("k is bigger than the stack size");
        }
        Stack<Integer> temp = new Stack<>();
        int num = getKthFromTopTest1(stack,temp,k,0);
        getKthFromTopTest2(stack,temp);
        return num;
    }
    private static int getKthFromTopTest1(Stack<Integer> stack,Stack<Integer> temp, int k, int num){

        if(stack.isEmpty() || k<1) {
            if (stack.isEmpty()&& k > 0)
                throw new RuntimeException("k is bigger than the stack size");
            return num;
        }
        num = stack.pop();
        temp.push(num);
        k--;

        return getKthFromTopTest1(stack,temp,k,num);
    }
    private static void getKthFromTopTest2(Stack<Integer> stack,Stack<Integer> temp){
        if(temp.isEmpty()) return;
        stack.push(temp.pop());
        getKthFromTopTest2(stack,temp);
    }
    public static int getKthFromTop3(Stack<Integer> stack, int k) {
        if (stack.isEmpty() || k < 0) {
            throw new RuntimeException("k is bigger than the stack size");
        }
        int element = stack.pop();
        if (k == 0) {
            stack.push(element);
            return element;
        }
        int result = getKthFromTop3(stack, k - 1);
        stack.push(element);
        return result;
    }
public static boolean Q3(Stack<Integer> stack){

        if(stack == null || stack.isEmpty() || stack.size() % 2 != 0)
            return false;
        Stack<Integer> temp = new Stack<>();
        int sumEven = 0;
        int sumOdd = 0;
        int counter = 0;
        while(!stack.isEmpty()){
            if(counter % 2 == 0){
                sumEven += temp.push(stack.pop());
            }
            else{
                sumOdd += temp.push(stack.pop());
            }
            counter++;
        }
        while(!temp.isEmpty()){
            stack.push(temp.pop());
        }
    System.out.println(sumEven + " " + sumOdd);
        return sumEven == sumOdd;
}


}
