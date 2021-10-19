package exercise;

public class L206 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(6);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);


        node1.next=node2;
        node2.next=node3;
        node3.next=node4;

        ListNode res = reverseList(node1);
        System.out.println(res.val);
    }

    public static ListNode reverseList(ListNode head) {
        if (head==null||head.next==null) return head;

        ListNode newHead = reverseList(head.next);
        head.next.next=head;
        head.next=null;

        return newHead;
    }
}
