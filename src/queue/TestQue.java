package queue;

import queue.MyQueue;

import java.util.Scanner;

public class TestQue {
    public static void main(String[] args) {
        MyQueue mq = new MyQueue(5);
        char key = ' ';
        Scanner sc = new Scanner(System.in);
        boolean loop = true;

        while (loop) {

            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：退出队列");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：取出队列");
            System.out.println("h(head)：显示头队列");
            key = sc.next().charAt(0);

            switch (key) {
                case 's':
                    mq.showQue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = sc.nextInt();
                    mq.addQue(value);
                    break;
                case 'g':
                    try {
                        int res = mq.getQueue();
                        System.out.println(String.format("取出的数据是%d", res));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = mq.headQue();
                        System.out.println(String.format("队列头的数据是%d", res));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    sc.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

