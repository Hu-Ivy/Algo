package stack;

public class ArrayStack {
    private final int maxSize;
    private final int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        //初始化数组
        stack = new int[this.maxSize];
    }

    public boolean isFull() {
        return top==maxSize-1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top]=value;

    }

    public int pop() {
        if (isEmpty()){
            throw new RuntimeException("空了");

        }
        int result = stack[top];
        top--;
        return result;

    }

    //遍历栈
    public void list() {
        if (isEmpty()){
            System.out.println("没有数据");
            return;
        }

        for (int i = top; i >-1 ; i--) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }

    //扩展功能，返回运算符优先级
    public int priority(int oper) {
        if (oper == '*'|| oper=='/') {
            return 1;
        }else if (oper=='+'||oper=='-') {
            return 0;
        }else {
            return -1;
        }
    }

    //看栈顶
    public int pick() {
        if (isEmpty()){
            throw new RuntimeException("pick空了");

        }
        int result = stack[top];
        return result;

    }
    //判断是不是运算符
    public boolean isOper(char val) {
        return val=='+'||val=='-'||val=='*'||val=='/';
    }
    //计算方法
    public int cal(int num1,int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res=num1+num2;
                break;
            case '-':
                res=num2-num1;
                break;
            case '*':
                res=num1*num2;
                break;
            case '/':
                res=num2/num1;
                break;
            default:
                break;
        }
        return res;
    }

}
