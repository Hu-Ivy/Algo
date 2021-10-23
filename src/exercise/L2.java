package exercise;

public class L2 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(9);
        ListNode node7 = new ListNode(9);

        ListNode node8 = new ListNode(9);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(9);
        ListNode node11 = new ListNode(9);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        node8.next = node9;
        node9.next = node10;
        node10.next = node11;


        ListNode res = addTwoNumbers(node1, node8);
        while (res!=null) {
            System.out.println(res.val);
            res=res.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode head = null;
        int carry = 0;

        while (l1!=null||l2!=null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;

            if (dummyNode.next==null) {
                head=new ListNode((n1+n2+carry)%10);
                dummyNode.next=head;

            }else {
                head.next=new ListNode((n1+n2+carry)%10);
                head= head.next;
            }

            carry = (n1+n2+carry)/10;

            //如果l1l2到尾部了，就不next了。
            if (l1!=null) {
                l1=l1.next;
            }

            if (l2!=null) {
                l2=l2.next;
            }

        }

        if (carry>0) {
            head.next=new ListNode(carry);
        }
        return dummyNode.next;
    }
}
