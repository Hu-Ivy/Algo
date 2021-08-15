package linkedlist;

public class RingLinkedList {
    private Boy first = null;
    private Boy curBoy = null;
    //添加
    public void addBoy(int num) {
        if (num<2) {
            return;
        }

        for (int i = 1; i <= num; i++) {
            Boy boy = new Boy(i);
            if (i==1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
            }
            curBoy = boy;
        }
    }

    public void showBoy() {
        if (first==null) {
            System.out.println("没有任何小孩");
            return;
        }
        curBoy = first;
        while (true) {
            System.out.printf("Boy %d%n", curBoy.getNo());
            if (curBoy.getNext()==first) {
                break;
            }
            curBoy = curBoy.getNext();
        }

    }

    /**
     *
     * @param startNo
     * @param countNum
     * @param nums
     */
    public void countBoy(int startNo,int countNum,int nums) {
        //先对数据进行校验合理性
        if (first==null||startNo<1||startNo>nums) {
            System.out.println("参数错误");
            return;
        }

        Boy helper = first;
        //helper指向最后一个
        while (true) {
            if (helper.getNext()==first) {
                break;
            }
            helper = helper.getNext();
        }
        //先让first移动到开始报数的那个人
        for (int i = 0; i < startNo-1; i++) {
            first = first.getNext();
            helper = helper.getNext();
            
        }
        //循环出圈
        while (true) {
            if (helper==first) {
                System.out.print(first.getNo());
                break;
            }
            //先让first移动到开始报数的那个人
            for (int i = 0; i < countNum-1; i++) {

                first = first.getNext();
                helper = helper.getNext();

            }
            System.out.print(first.getNo()+"->");
            first = first.getNext();
            helper.setNext(first);
        }
    }
}

class Boy {
    private int no;
    private Boy next;

    //构造器
    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }
}