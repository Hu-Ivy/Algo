package linkedlist;

public class ListDemo {
    public static void main(String[] args) {
        RingLinkedList rl = new RingLinkedList();
        rl.addBoy(5);
        rl.showBoy();

        rl.countBoy(1,2,5);
    }

    public void testSingle() {
        Node node1 = new Node(1, "宋江", "及时雨");
        Node node4 = new Node(4, "林冲", "豹子头");
        Node node2 = new Node(2, "卢俊义", "玉麒麟");
        Node node3 = new Node(3, "吴用", "智多星");

        SingleLinkedList ll = new SingleLinkedList();
        ll.addByOrder(node1);
        ll.addByOrder(node4);
        ll.addByOrder(node2);
        ll.addByOrder(node3);


        Node newNode = new Node(2, "卢俊义~~", "玉麒麟~~");
        ll.update(newNode);

        ll.delete(5);
        ll.showList();
    }

    public void testDouble() {
        Node2 node1 = new Node2(1, "宋江", "及时雨");
        Node2 node4 = new Node2(4, "林冲", "豹子头");
        Node2 node2 = new Node2(2, "卢俊义", "玉麒麟");
        Node2 node3 = new Node2(3, "吴用", "智多星");
        Node2 newNode = new Node2(2, "卢俊义~~", "玉麒麟~~");
        DoubleLinedList dl = new DoubleLinedList();

        dl.addByOrder(node1);
        dl.addByOrder(node4);
        dl.addByOrder(node2);
        dl.addByOrder(node3);

        dl.update(newNode);
        dl.delete(3);
        dl.showList();
    }

    public void testRing() {
        RingLinkedList rl = new RingLinkedList();
        rl.addBoy(5);
        rl.showBoy();
    }
}
