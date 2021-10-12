package exercise;

public class L24 {
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

        ListNode res = reverseList2(node1);
        System.out.println(res.val);
    }

    public static ListNode reverseList(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode prev=null;
        ListNode cur=head;
        while (cur!=null) {
            cur=head.next;
            head.next=prev;
            prev=head;
            head=cur;
        }

        return prev;
    }
    //递归解法
    public static ListNode reverseList2(ListNode head) {
        if (head==null||head.next==null) return head;
        //需要把-4带过来，所以附了个值。
        ListNode newLast = reverseList2(head.next);
        head.next.next=head;
        head.next=null;
        //
        return newLast;
    }
}
