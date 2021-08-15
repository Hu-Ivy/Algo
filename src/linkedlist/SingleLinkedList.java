package linkedlist;


public class SingleLinkedList {
    //初始化头节点
    private Node head = new Node(0, "", "");

    //添加节点到单向列表
    public void add(Node addNode) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;

        }
        temp.next = addNode;
    }

    //显示链表
    public void showList() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        Node temp = head.next;
        while (temp != null) {
            System.out.println(temp.toString());
            ;
            temp = temp.next;
        }
    }

    //插入节点
    public void addByOrder(Node addNode) {
        Node temp = head;
        boolean flag = false;//添加的编号是否存在

        while (temp.next != null) {
            if (temp.next.no > addNode.no) {
                break;
            } else if (temp.next.no == addNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("已经存在不能添加");
        } else {
            addNode.next = temp.next;
            temp.next = addNode;
        }
    }

    //更新节点，查询功能
    public void update(Node newNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        Node temp = head.next;
        while (temp!=null) {
            if (temp.no == newNode.no) {
                break;
            }
            temp = temp.next;
        }
        if (temp!=null) {
            temp.name = newNode.name;
            temp.nickName = newNode.nickName;
        } else {
            System.out.println("没找到");
        }
    }

    //删除阶段
    public void delete(int no) {
        Node temp = head;
        boolean flag = false;
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        while((temp.next)!=null) {
            if (temp.next.no==no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        }else {
            System.out.println("没找到");
        }
    }
}

class Node {
    public int no;
    public String name;
    public String nickName;
    public Node next;

    //构造器
    public Node(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;

    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}