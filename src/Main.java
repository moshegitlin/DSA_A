import L06.MyArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3,5);
        list.remove(0);
        list.indexOf(3);
        System.out.println(list);
        System.out.println(list.get(3)==null);
//        System.out.println(list.size()+"before");
//        list.set(3, 4);
//        System.out.println(list.size());
//        System.out.println(list.get(0));
//       boolean r = list.remove(list.get(0));
//        System.out.println(r);
//        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
//        myArrayList.add(4);
//        System.out.println(myArrayList.get(4));

    }
}
