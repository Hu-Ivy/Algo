package exercise;

public class JZ27 {
    private static ListNode frontPointer;
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(0);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(3);


        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;

        boolean res = isPalindrome(node1);
        System.out.println(res);
    }
    public static boolean recursive(ListNode curNode) {

        if (curNode==null) {
            return true;
        }
        recursive(curNode.next);
        if (frontPointer.val==curNode.val) {
            frontPointer=frontPointer.next;
            return true;
        }else {
            return false;
        }

    }

    public static boolean isPalindrome(ListNode head) {
        frontPointer=head;
        return recursive(frontPointer);
    }
}
