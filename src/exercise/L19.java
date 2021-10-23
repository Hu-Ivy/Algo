package exercise;

public class L19 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode res = removeNthFromEnd(node1,2);
        while (res!=null) {
            System.out.println(res.val);
            res=res.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //双指针
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;


        ListNode left=dummyNode;
        ListNode right=head;


        //左右指针中间有n个节点。一起移动。
        for (int i = 0; i < n; i++) {
            right= right.next;
        }

        while (right!=null) {
            left=left.next;
            right=right.next;

        }
        //left则为删除节点的上一个节点。
        ListNode temp = left.next;
        left.next=temp.next;
        temp.next=null;

        return dummyNode.next;
    }
}
