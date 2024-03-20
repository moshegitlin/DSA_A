package training;

import java.util.*;

public class func {
    public static int size(Queue<Integer> q){
        if(q == null) return -1;
        Queue<Integer> temp = new LinkedList<>();
        int count =0;
        while (!q.isEmpty()){
            temp.add(q.remove());
            count++;
        }
        while (!temp.isEmpty()){
            q.add(temp.remove());
        }
        return count;
    }
    public static int size(Stack<Integer> s){
    if(s.isEmpty()) return 0;
    int element = s.pop();
    int count = size(s)+1;
    s.push(element);
    return count;
    }
    public static Queue<Character> CloneQueue(Queue<Character> q){
        if(q==null||q.isEmpty()) return null;
        Queue<Character> temp = new LinkedList<>();
        Queue<Character> copy = new LinkedList<>();
        while (!q.isEmpty()){
            char c = q.remove();
            temp.add(c);
            copy.add(c);
        }
        while (!temp.isEmpty()){
            char c = temp.remove();
            q.add(c);
        }
        return copy;
    }
    public static Stack<Integer> getStringLength(Stack<String> s){
        if(s==null||s.isEmpty()) return null;
        Stack<String> temp =new Stack<>();
        Stack<Integer> res = new Stack<>();
        while (!s.isEmpty()){
            String str = s.pop();
            temp.push(str);

        }
        while (!temp.isEmpty()){
            String str = temp.pop();
            s.push(str);
            res.push(str.length());
        }
        return res;
    }
    public static int getTopsSum(Stack<Integer>[] stacks){
        if(stacks == null || stacks.length ==0) return -1;
        int count=0;
        for (Stack<Integer> s:stacks){
            if(s.isEmpty()) continue;
            count+=s.peek();
        }
        return count;

    }
    public static boolean IsBracketBalanced(String str){
        if(str == null || str.length() <2) return false;
        Stack<Character> temp = new Stack<>();
        for (int i=0; i< str.length();i++){
        if (str.charAt(i) == '(' ||str.charAt(i) =='{'|| str.charAt(i) =='[')temp.push(str.charAt(i));
        else if (str.charAt(i) == ')' ||str.charAt(i) =='}'|| str.charAt(i) ==']'){
            if (temp.isEmpty()) return false;
            char c = temp.pop();
            if(c =='(' && str.charAt(i)!=')') return false;
            if(c =='{' && str.charAt(i)!='}') return false;
            if(c =='[' && str.charAt(i)!=']') return false;

        }

        }
        return temp.isEmpty();
    }
    public static class ReversePrint {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Stack<Character> stack = new Stack<>();
            boolean reverse = false;

            System.out.println("Enter characters and press Enter to finish:");
            String input = scanner.nextLine();

            for (char ch : input.toCharArray()) {
                if (ch == '@') {
                    // Toggle the reverse flag and print the stack if needed
                    if (reverse) {
                        while (!stack.isEmpty()) {
                            System.out.print(stack.pop());
                        }
                    }
                    reverse = !reverse;
                } else {
                    // If reverse is true, push to stack, else print the character
                    if (reverse) {
                        stack.push(ch);
                    } else {
                        System.out.print(ch);
                    }
                }
            }

            // Print the remaining characters in the stack
            while (!stack.isEmpty()) {
                System.out.print(stack.pop());
            }

            scanner.close();
        }
    }
        public static Queue<Integer> queCouples(Queue<Integer> queue) {
            Queue<Integer> newQueue = new LinkedList<>();
            HashMap<Integer, Integer> countMap = new HashMap<>();

            // ספירת מופעים של כל איבר
            for (int num : queue) {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }

            // הוספת איברים עם בדיוק שני מופעים לתור החדש
            for (int num : queue) {
                if (countMap.get(num) == 2) {
                    newQueue.add(num);
                    // הסרת האיבר מהמפה כדי שלא יוסף שוב
                    countMap.remove(num);
                }
            }

            return newQueue;
        }
        public static Queue<Integer> longNumber(Queue<Integer>num1,Queue<Integer>num2){
        if(num1== null|| num2 ==null)return null;
        Queue<Integer> temp1 = new LinkedList<>();
        Queue<Integer> temp2 = new LinkedList<>();
        Queue<Integer> res = new LinkedList<>();
        int number1 = 0;
        int number2 =0;
        while (!num1.isEmpty()){
            int num = num1.remove();
            number1 =(number1*10)+num;
            temp1.add(num);
        }
            while (!num2.isEmpty()){
                int num = num2.remove();
                number2 =(number2*10)+num;
                temp2.add(num);
            }
            int sum = number1+number2;
            Stack<Integer> st = new Stack<>();
            while (sum>0){
                st.push(sum%10);
                sum/=10;
            }
            while (!temp1.isEmpty()){
                num1.add(temp1.remove());
            }
            while (!num2.isEmpty()){
                num2.add(temp2.remove());
            }
            while (!st.isEmpty()){
                res.add(st.pop());
            }
            return res;
        }

        public static Queue<Integer> reverseQueueWithStack(Queue<Integer> queue) {
            Stack<Integer> stack = new Stack<>();
            while (!queue.isEmpty()) {
                stack.push(queue.remove());
            }
            while (!stack.isEmpty()) {
                queue.add(stack.pop());
            }
            return queue;
        }

        public static Queue<Integer> reverseQueueRecursively(Queue<Integer> queue) {
            if (queue.isEmpty()) {
                return queue;
            }
            int data = queue.remove();
            queue = reverseQueueRecursively(queue);
            queue.add(data);
            return queue;
        }
    }

