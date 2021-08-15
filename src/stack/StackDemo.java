package stack;

import java.util.Scanner;

public class StackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);
        char key = ' ';
        Scanner sc = new Scanner(System.in);
        boolean loop = true;

        while (loop) {

            System.out.println("s(show)：显示栈");
            System.out.println("e(exit)：退出");
            System.out.println("p(push)：入栈");
            System.out.println("g(get)：出栈");

            key = sc.next().charAt(0);

            switch (key) {
                case 's':
                    arrayStack.list();
                    break;
                case 'p':
                    System.out.println("输入一个数");
                    int value = sc.nextInt();
                    arrayStack.push(value);
                    break;
                case 'g':
                    try {
                        int res = arrayStack.pop();
                        System.out.printf("取出的数据是%d%n", res);
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

