package exercise;

import java.util.List;

public class L203 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(0);
        ListNode node5 = new ListNode(-4);


        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;

        ListNode res = removeElements(node1,0);
        System.out.println(res.val);
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head==null) {
            return head;
        }

        head.next = removeElements(head.next,val);

        return head.val==val?head.next:head;
    }
}
