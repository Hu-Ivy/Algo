package exercise;

public class L92 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node5 = new ListNode(5);

        node1.next = node5;

        int left = 1;
        int right = 2;
        ListNode res = reverseBetween(node1, left, right);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        //哨兵节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next=head;
        ListNode prev = dummyNode;
        ListNode temp;
        for (int i = 0; i < left - 1; i++) {
            prev=prev.next;
        }
        ListNode cur = prev.next;
        //   prev和cur循环后移，然后改变链表指向即可。
        for (int i = left; i < right; i++) {

            temp = cur.next.next;
            cur.next.next = prev.next;
            prev.next = cur.next;
            cur.next = temp;

        }
        //最后返回头结点。
        return dummyNode;
    }
}
