package linkedlist;

class DoubleLinedList {
    //初始化头节点
    private final Node2 head = new Node2(0, "", "");

    //添加节点到单向列表
    public void add(Node2 addNode) {
        Node2 temp = head;
        while (temp.next != null) {
            temp = temp.next;

        }
        temp.next = addNode;
        addNode.pre = temp;
    }

    //显示链表
    public void showList() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        Node2 temp = head.next;
        while (temp != null) {
            System.out.println(temp.toString());

            temp = temp.next;
        }
    }

    //插入节点
    public void addByOrder(Node2 addNode) {
        Node2 temp = head;
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
            if (temp.next!=null) {
                temp.next.pre = addNode;
                addNode.next = temp.next;
            }

            temp.next = addNode;
            addNode.pre = temp;

        }
    }

    //更新节点，查询功能
    public void update(Node2 newNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        Node2 temp = head.next;
        while (temp != null) {
            if (temp.no == newNode.no) {
                break;
            }
            temp = temp.next;
        }
        if (temp != null) {
            temp.name = newNode.name;
            temp.nickName = newNode.nickName;
        } else {
            System.out.println("没找到");
        }
    }

    //删除阶段,只需要找到当前相等节点的位置，不需要指向前一个。所以用temp=had.next()
    public void delete(int no) {
        Node2 temp = head.next;
        boolean flag = false;
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        while (temp != null) {
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            //区分是不是最后一个节点。否则会出现空指针异常。
            if (temp.next!=null) {
                temp.next.pre = temp.pre;
            }

        } else {
            System.out.println("没找到");
        }
    }
}

class Node2 {
    public int no;
    public String name;
    public String nickName;
    public Node2 next;
    public Node2 pre;

    //构造器
    public Node2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;

    }

    @Override
    public String toString() {
        return "Node2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}


