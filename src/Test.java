import queue.MyQueue;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println(1/3);
        HashSet set = new HashSet();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        set.add("e");
        set.add("aa");
        Iterator iter = set.iterator();
        while(iter.hasNext()){
            String value = (String)iter.next();
            System.out.println(value);
        }
    }
}
