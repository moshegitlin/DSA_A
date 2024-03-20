package L09;
public class Main {

    public static void main(String[] args) {
//
//        Node<String> node = new Node<>("Hasan");
//        node.setNext(new Node<>("Edi"));
//        node.getNext().setNext(new Node<>("Along"));
//        node.getNext().getNext().setNext(new Node<>("rafi"));
//        node.getNext().getNext().getNext().setNext(new Node<>("Mor"));
//
//        print(node);
//        countAndPrint(node);
//
//        Node<Integer> chain = new Node<>(0, new Node<>(1, new Node<>(2, new Node<>(3, new Node<>(4)))));
//        Node<Integer> temp = chain;
//
//        while (temp.hasNext())
//            temp = temp.getNext();
//        temp.setNext(new Node<>(5));
//
//
//        temp = chain;
//        while (temp.hasNext())
//            temp = temp.getNext();
//
//        temp.setNext(new Node<>(6));
//
//        print(chain);
//
//        chain = add(7, chain);
//
//        print(chain);
//
//        Node<Integer> chain1 = null;
//        chain1 = add(0, chain1);
//        print(chain1);
//        for (int i = 1; i <= 10; i++) {
//            chain1 = add(i, chain1);
//            print(chain1);
//        }
//
//        int sum = sumChain(chain1);
//        int sumEven = sumEVChain(chain1);
        Node<Integer> pos = new Node<>(4,new Node<>(6,new Node<>(9)));
        Node <Integer> list1 = new Node<>(5,new Node<>(1,pos));
        Node <Integer> list2 = new Node<>(7,new Node<>(9));
        print(list1);
        list_insert_list(list1,pos,list2);
        print(list1);

    }

    private static int sumEVChain(Node<Integer> chain1) {
        if (chain1 == null)
            return 0;

        int sum = 0;
        while (chain1 != null) {
            sum += (chain1.getValue() % 2 == 0) ? chain1.getValue() : 0;
//            if (chain1.getValue() % 2 == 0)
//                sum += chain1.getValue();
            chain1 = chain1.getNext();
        }
        return sum;
    }

    private static int sumEVIndChain(Node<Integer> chain1) {
        if (chain1 == null)
            return 0;

        int sum = 0;
        boolean bool = true;
        int index = 0;
        while (chain1 != null) {
            sum += (bool) ? chain1.getValue() : 0;
//            sum += (index%2==0) ? chain1.getValue() : 0;
//            index++;
            chain1 = chain1.getNext();
            bool = !bool;
        }
        return sum;
    }

    private static int sumChain(Node<Integer> chain1) {
        if (chain1 == null)
            return 0;

        int sum = 0;
        while (chain1 != null) {
            sum += chain1.getValue();
            chain1 = chain1.getNext();
        }
        return sum;
    }

    private static Node<Integer> add(int value, Node<Integer> chain) {
        Node<Integer> newNode = new Node<>(value);

        if (chain == null)
            return newNode;

        Node<Integer> temp = chain;

        while (temp.hasNext())
            temp = temp.getNext();
        temp.setNext(newNode);

        return chain;

    }

    private static void print(Node<? extends Object> chain) {

        while (chain != null) {
            System.out.print(chain.getValue() + " -> ");
            chain = chain.getNext();
        }
        System.out.println("null");
    }

    private static void countAndPrint(Node<String> chain) {

        Node<String> temp = chain;
        int count = 0;
        while (chain != null) {
            chain = chain.getNext();
            count++;
        }
        System.out.println(count);
        chain = temp;
        while (chain != null) {
            System.out.print(chain.getValue() + " -> ");
            chain = chain.getNext();
        }
        System.out.println("null");
    }
    public static int isSorted(Node<Integer> chain) {
        if (chain == null)
            return -1;
        Node<Integer> temp = chain;
        while (temp.hasNext()) {
            if (temp.getValue() > temp.getNext().getValue())
                return 0;
            temp = temp.getNext();
        }
        return 1;

    }

public static int getLast(Node<Integer> chain){
        if(chain==null)
            return -1;
        int index=0;
        Node<Integer> temp = chain;
        while(temp.hasNext()){
            temp=temp.getNext();
            index++;
        }
        return index;
}
    public static void list_insert_list(Node<Integer> list1, Node<Integer> pos, Node<Integer> list2){
        if(list1== null || pos==null || list2==null)
            return;
        Node<Integer> temp = pos.getNext();
        pos.setNext(list2);

        while(pos.hasNext())
            pos=pos.getNext();

        pos.setNext(temp);
    }

}
