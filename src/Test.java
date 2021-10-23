import queue.MyQueue;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        System.out.println(1/3);
        HashSet set = new HashSet();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        set.add("e");
        set.add("a");
        Iterator iter = set.iterator();
        while(iter.hasNext()){
            String value = (String)iter.next();
            System.out.println(value);
        }
        System.out.println("************************");
        Map<String, String> registry = new HashMap<>();
        registry.put("d1",null);


        Set<String> devices = registry.keySet();
        for (String d :
                devices) {
            System.out.println(registry.get(d));
        }
    }
}
