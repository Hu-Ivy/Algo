package exercise;


import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Hash_L141 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);


        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        //node4.next=node2;

        boolean res = hasCycle(node1);
        System.out.println(res);
    }

    public static boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        while (head!=null) {
            if (!set.add(head)) {
                return true;
            }
            head=head.next;
        }
        return false;
    }
}
